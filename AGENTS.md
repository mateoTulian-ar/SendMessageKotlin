# AGENTS.md

## Qué es este repo

- App Android de ejemplo, **un solo módulo `:app`**, Kotlin + layouts XML (**no** Compose, **no** Fragments).
- Flujo real: `SendMessageActivity` (MAIN/LAUNCHER en `AndroidManifest.xml`) → crea un `Message` y lo envía a `ViewMessageActivity` con `Intent` + `Bundle` bajo la clave `KEY_MESSAGE`. Paquete: `com.example.sendmessage`.

## Comandos

```bash
./gradlew assembleDebug                     # build debug
./gradlew testDebugUnitTest                 # unit tests (verificado, pasa)
./gradlew testDebugUnitTest --tests "com.example.sendmessage.ExampleUnitTest"   # un solo test
./gradlew connectedAndroidTest              # instrumented: requiere dispositivo/emulador
./gradlew lintDebug                         # lint de AGP por defecto (no hay ktlint/detekt/format)
./gradlew dokkaGenerate                     # genera HTML en documentation/
```

- No hay wrapper de CI local ni task runner: estos son los únicos comandos de verificación.

## Gotchas de build (verificadas)

- `settings.gradle.kts` usa `RepositoriesMode.FAIL_ON_PROJECT_REPOS`: los repos van solo en `settings.gradle.kts` y las dependencias nuevas en `gradle/libs.versions.toml`, nunca declaradas en `app/build.gradle.kts` (solo `implementation(libs.x)`). JitPack ya está declarado.
- AGP **9.3.3 sin plugin Kotlin explícito** (Kotlin viene integrado en AGP 9). Solo se aplican `kotlin-parcelize` y `kotlin-dokka`. **No añadas** `kotlin("android")` ni subas la versión de AGP sin comprobar compatibilidad.
- `gradle/gradle-daemon-jvm.properties` fija el daemon a **Java 21** con descarga automática: `./gradlew` funciona con el Java del sistema sin tocar `JAVA_HOME` (en CI el job de Dokka usa Temurin 17).
- `org.gradle.configuration-cache=true`: es normal ver "Configuration cache entry stored/reused".
- **Borrar `first_fragment_label` / `second_fragment_label` de `res/values/strings.xml` rompe la compilación AAPT**: los referencia `res/navigation/nav_graph.xml` (ya pasó, está en `CHANGELOG.md`).

## Código no obvio / trampas

- `res/navigation/nav_graph.xml` y las dependencias `navigation-fragment-ktx` / `navigation-ui-ktx` son **restos de plantilla**: referencian `FirstFragment`/`SecondFragment`, que no existen. La navegación real es por `Intent`; no intentes "conectar" ese grafo.
- `SendMessageApplication.kt` existe pero **no está registrada** en el manifiesto (`<application>` sin `android:name`): nunca se ejecuta.
- `ViewMessageActivity.onCreate` lleva `@RequiresApi(TIRAMISU)` con `minSdk 24`, para silenciar la deprecación de `getParcelable(String)`. Si cambias el paso de datos, usa `getParcelable(key, Message::class.java)` con guarda por versión en vez de copiar esa anotación.
- Cadenas por defecto en **español** en `res/values/strings.xml` y traducción en `res/values-en/strings.xml` (ambas trackeadas). Al añadir un string, añadirlo en **ambos** ficheros.
- `Message` y `Person` son `data class` con `@Parcelize`; cualquier campo nuevo se serializa solo, pero la clave del Bundle (`KEY_MESSAGE`) es un contrato entre las dos Activities.

## Git / CI / docs

- Hacer push a `main` dispara `.github/workflows/desplegar-dokka.yml`: ejecuta `dokkaGenerate` y publica `documentation/` en GitHub Pages. **`documentation/` está trackeado en git**, así que un `dokkaGenerate` local modifica ficheros versionados.
- `app/release/` (APK de release) **no está en `.gitignore`**: no lo subas por accidente.
- `CHANGELOG.md` sigue Keep a Changelog (en español) + SemVer: actualízalo en cambios notables.
- Convención de idioma: documentación, KDoc y comentarios en **español** (`README.md`, `USER_GUIDE.md`, `CHANGELOG.md`).

## Fuentes de instrucciones locales

- `.opencode/skills/personalice-docs-generator/SKILL.md`: reglas para el `README.md` (exactamente un `#`, secciones mínimas). Validar tras tocarlo:
  ```bash
  python3 .opencode/skills/personalice-docs-generator/scripts/validate_readme.py README.md
  ```
  (`python` no existe en esta máquina: usar `python3`.)
- `.opencode/skills/generar-fichero-license/SKILL.md`: skill para generar el fichero `LICENSE`.

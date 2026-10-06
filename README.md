# SendMessage 📱

**SendMessage** es una aplicación para Android desarrollada en **Kotlin** que permite introducir un mensaje en una pantalla principal y enviarlo a una segunda pantalla mediante la transferencia de datos entre *Activities* utilizando `Intent` y `Bundle`.

---

## 🚀 Características

- **Paso de datos entre Activities:** Captura el texto introducido por el usuario y lo transmite a la Activity de destino mediante `Bundle`.
- **Interfaz de usuario:** Diseñada mediante archivos de layout XML (`LinearLayout`, `EditText`, `Button`, `TextView`, `ImageView`).
- **Soporte Edge-to-Edge:** Adaptación de insets del sistema para una experiencia visual moderna.
- **Recursos personalizados:** Integración de fuentes (`font/day_dream_demo`) y temas de diseño en Android.

---

## Captuas de pantalla
[Pantalla de envío](images/send_message.png)
[Pantalla del mensaje](images/view_message.png)

---
## 📁 Estructura del Proyecto

```text
SendMessage/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/sendmessage/
│           │   ├── SendMessageActivity.kt  # Activity principal para ingresar y enviar el mensaje
│           │   ├── ViewMessageActivity.kt  # Activity de destino para visualizar el mensaje
│           │   └── SendMessageApplication.kt
│           └── res/
│               ├── layout/                 # Archivos de diseño XML (activity_send_message.xml, activity_view_message.xml)
│               ├── values/                 # Cadenas de texto, dimensiones, colores y temas
│               └── navigation/             # Grafo de navegación (nav_graph.xml)
├── build.gradle.kts                        # Configuración Gradle a nivel de proyecto
└── README.md                               # Documentación del proyecto
```

---

## 🛠️ Tecnologías y Requisitos

- **Lenguaje:** Kotlin
- **SDK Mínimo:** Android 7.0 (API 24)
- **SDK Objetivo:** Android 16 / API 37
- **Herramientas de construcción:** Gradle (AGP 9.3+)
- **IDE Recomendado:** Android Studio (Ladybug o posterior)

---

## ⚙️ Cómo ejecutar el proyecto

1. **Clonar o abrir el proyecto** en Android Studio.
2. Esperar a que **Gradle** sincronice las dependencias del proyecto.
3. Conectar un dispositivo Android físico con depuración USB o iniciar un emulador de Android (AVD).
4. Hacer clic en el botón **Run (`Shift + F10`)** o ejecutar el comando en la terminal:

```bash
./gradlew assembleDebug
```

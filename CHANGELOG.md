# Historial de Cambios (Changelog)

Todos los cambios notables en el proyecto **SendMessage** se documentarán en este archivo.

El formato está basado en [Keep a Changelog](https://keepachangelog.com/es-ES/1.0.0/) y este proyecto se adhiere a [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

---

## [Unreleased]

### Corregido
- Solucionado error de compilación AAPT por recursos de texto faltantes (`first_fragment_label` y `second_fragment_label`) en `res/values/strings.xml`.

### Añadido
- Archivo de documentación inicial `README.md` con descripción del proyecto, arquitectura y guía de ejecución.
- Archivo `CHANGELOG.md` para el seguimiento del historial de versiones.

---

## [1.0.0] - 2026-09-28

### Añadido
- **Navegación y Transferencia de Datos:**
  - Implementación de `SendMessageActivity` como pantalla principal para la entrada de datos mediante `EditText`.
  - Envío de mensajes a la Activity de destino `ViewMessageActivity` utilizando `Intent` y `Bundle`.
  - Activity `ReceiveMessage` para la pantalla de confirmación con soporte para insets de ventana (Edge-to-Edge).
- **Diseño e Interfaz de Usuario (UI):**
  - Layouts XML para las vistas principales (`activity_send_message.xml`, `activity_view_message.xml`, `activity_receive_message.xml`).
  - Recursos de estilo, dimensiones, colores y tipografía personalizada (`day_dream_demo`).
- **Navegación Jetpack:**
  - Configuración del archivo de grafo de navegación `res/navigation/nav_graph.xml`.
- **Configuración del Proyecto:**
  - Configuración inicial de Gradle para Android con soporte para minSdk 24 y targetSdk 37.

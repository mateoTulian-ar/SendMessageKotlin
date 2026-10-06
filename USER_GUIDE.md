# Guía de Usuario - SendMessage 📱

Bienvenido a la **Guía de Usuario oficial de SendMessage**, una aplicación Android diseñada para demostrar la transferencia eficiente de datos entre pantallas (*Activities*) utilizando `Intent`, `Bundle` y objetos `Parcelable`.

---

## 🎯 Índice
1. [Introducción](#introducción)
2. [Requisitos del Sistema](#requisitos-del-sistema)
3. [Cómo Iniciar la Aplicación](#cómo-iniciar-la-aplicación)
4. [Paso a Paso: Uso de la Aplicación](#paso-a-paso-uso-de-la-aplicación)
   - [Paso 1: Pantalla Principal (Envío de Mensaje)](#paso-1-pantalla-principal-envío-de-mensaje)
   - [Paso 2: Pantalla de Destino (Visualización del Mensaje)](#paso-2-pantalla-de-destino-visualización-del-mensaje)
5. [Arquitectura y Componentes Clave](#arquitectura-y-componentes-clave)
6. [Preguntas Frecuentes (FAQ) / Solución de Problemas](#preguntas-frecuentes-faq--solución-de-problemas)

---

## 📌 Introducción

**SendMessage** permite al usuario redactar un mensaje de texto en una interfaz intuitiva y transferirlo de forma segura a una segunda pantalla. La aplicación está construida siguiendo los estándares modernos de desarrollo en Android con Kotlin, garantizando un rendimiento fluido y una experiencia de usuario agradable.

---

## 📱 Requisitos del Sistema

- **Dispositivo compatible:** Teléfono o emulador Android.
- **Versión mínima de Android:** Android 7.0 (API 24) o superior.
- **Espacio en disco:** < 50 MB.

---

## 🚀 Cómo Iniciar la Aplicación

1. **Instalación:** Instala la aplicación `SendMessage` en tu dispositivo físico o emulador desde Android Studio.
2. **Apertura:** Busca el icono de **SendMessage** en el cajón de aplicaciones y pulsa sobre él para iniciar la app.
3. Al abrirse, verás directamente la pantalla principal de envío de mensajes.

---

## 🚶‍♂️ Paso a Paso: Uso de la Aplicación

### Paso 1: Pantalla Principal (Envío de Mensaje)
En esta pantalla (`SendMessageActivity`), encontrarás un campo de texto para redactar tu mensaje y un botón para enviarlo.

1. Haz clic en el campo de texto (*EditText*).
2. Escribe el mensaje que deseas enviar (por ejemplo: *"¡Hola, mundo desde SendMessage!"*).
3. Pulsa el botón **Enviar** (*Button*).

> **Captura de referencia:**
> ![Pantalla de envío](images/send_message.png)

### Paso 2: Pantalla de Destino (Visualización del Mensaje)
Al pulsar el botón de envío, la aplicación empaqueta el texto junto con los datos del remitente y destinatario en un `Bundle` y abre la segunda actividad (`ViewMessageActivity`).

1. La pantalla cambiará automáticamente para mostrar la vista de recepción.
2. Verás el emisor del mensaje y el contenido exacto que escribiste en el paso anterior.

> **Captura de referencia:**
> ![Pantalla del mensaje](images/view_message.png)

---

## 🛠️ Arquitectura y Componentes Clave

Para usuarios avanzados y desarrolladores que deseen comprender el funcionamiento interno:

- **`SendMessageActivity.kt`**: Activity encargada de capturar la entrada del usuario (`EditText`), crear el objeto de datos `Message` (que implementa `Parcelable`) y adjuntarlo a un `Bundle` dentro del `Intent`.
- **`ViewMessageActivity.kt`**: Activity receptora que extrae los datos del `Bundle` y actualiza los elementos visuales (`TextView`) para mostrárselos al usuario.
- **Modelos (`Person`, `Message`)**: Clases de datos optimizadas con el plugin de Kotlin `Parcelize` para una transferencia rápida y segura entre componentes.

---

## ❓ Preguntas Frecuentes (FAQ) / Solución de Problemas

- **¿Qué pasa si intento enviar el mensaje con el campo vacío?**
  La aplicación enviará el contenido vacío según lo redactado. Asegúrate de escribir texto antes de pulsar el botón de envío.
- **¿Se pierden los datos si giro la pantalla?**
  La aplicación está preparada mediante el ciclo de vida estándar de Android. No obstante, el flujo principal está diseñado para la navegación directa entre la pantalla de escritura y la de lectura.
- **¿Cómo puedo ver la documentación técnica del código?**
  Puedes consultar la documentación generada automáticamente con **Dokka** en la carpeta `documentation/` o a través del sitio web de GitHub Pages del proyecto.

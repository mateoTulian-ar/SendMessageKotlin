package com.example.sendmessage.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Esta clase representa una persona dentro de la aplicación
 *
 * Los **datos** que tiene cada persona es el que envía o recibe un **mensaje**
 *
 * @property dni => **Documento nacional** de la identidad de la persona
 * @property name => **Nombre** de la persona
 * @property surname => **Apellido** de la persona
 */

@Parcelize
data class Person(
    val dni: String,
    val name: String,
    val surname: String
) : Parcelable

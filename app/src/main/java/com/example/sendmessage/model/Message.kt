package com.example.sendmessage.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Esta clase representa el mensaje de la aplicación
 *
 * @property id =>**Identificador** de cada mensaje
 * @property content => **Contenido** del mensaje envíado
 * @property sender => Persona que **envia** el mensaje
 * @property receiver => Persona que **recibe** el mesanje
 *
 */
@Parcelize
data class Message(
    val id: Int,
    val content: String,
    val sender: Person,
    val receiver: Person
) : Parcelable



package com.example.sendmessage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.sendmessage.model.Message
import com.example.sendmessage.model.Person

/**
 * Esta es la primera actividad de la aplicación que realiza la operaciones:
 * <ol>
 *     <li>Crear un componente <code>EditText</code> y <code>Button</code> en XML</li>
 *     <li>Lanzar un evento en un componente visual</li>
 *     <li>Crea el <code>Intent</code> junto con el <code>Bundle</code> para pasar a otra actividad</li>
 *     <li> El ciclo de vida de la activity </li>
 *     <li>Ver la pila de actividades</li>
 * </ol>
 *
 *
 * @author Mateo Tulian
 * @version 1.0
 * @see android.widget.Button
 * @see android.widget.EditText
 * @see android.os.Bundle
 * @see Intent
 */
class SendMessageActivity : AppCompatActivity() {
    lateinit var etMessageText: EditText
    lateinit var btSend: Button
    companion object {
        const val TAG: String = "LogSendMessageActivity"
    }


    /**
     * Método de creación de una actividad
     * @param android.os.Bundle
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            R.layout.activity_send_message
        )
        // Se obtiene el recruso widget/ objeto view de la vista que se ha inflado
        btSend = findViewById(R.id.btSend)
        etMessageText = findViewById(R.id.etMessage)

        btSend.setOnClickListener {
            sendMessage()
        }

        // Se escribe mesnajes de deouracion en la cinsola logcat
        Log.d(TAG, "SendMessageActivity -> onCreate()")
    }

    /**
     * Función que crea un mensaje con la información de la persona que envía y de la persona que debe
     * recoger el mensaje
     */
    private fun sendMessage() {
        // 1 crear el intent
        val intent = Intent(this, ViewMessageActivity::class.java)
        // 2 crear el bundle para empaquetar los datos
        val bundle = Bundle()
        // 3 Crear la información del mensaje
        val sender = Person("123456789", "Mateo", "Tulian Moses")
        val receiver = Person("987654321", "Mamá", "Moses Maino")
        val message = Message(1, etMessageText.text.toString(), sender, receiver)

        // bundle.putSerializable("KEY_MESSAGE", message)

        bundle.putParcelable("KEY_MESSAGE", message)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    // region Ciclo de vida de una actividad
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "SendMessageActivity -> onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "SendMessageActivity -> onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "SendMessageActivity -> onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "SendMessageActivity -> onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SendMessageActivity -> onDestroy()")
    }
// endregion


}

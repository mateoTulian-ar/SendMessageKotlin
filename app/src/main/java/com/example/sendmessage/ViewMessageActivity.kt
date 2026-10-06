package com.example.sendmessage

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.sendmessage.model.Message


/**
 * @author Mateo Tulian
 * @version 1.0
 * @see android.widget.EditText
 * @see android.widget.TextView
 */
class ViewMessageActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "LogViewMessageActivity"
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_message)

        // 1. Vinculamos los dos TextViews de tu XML
        val tvSenderName = findViewById<TextView>(R.id.tvSenderName)
        val tvMessage = findViewById<TextView>(R.id.textView2)
        val bundle = intent.extras
        if(bundle != null) {
            // 2. Recuperamos el objeto Message serializado completo del bundle
            //val message = intent.extras?.getSerializable("KEY_MESSAGE", Message::class.java)

            val message = bundle.getParcelable("KEY_MESSAGE") as? Message

            // 3. Pintamos los datos en la pantalla extrayéndolos del objeto message
            if (message != null) {
                tvSenderName.text = "De: ${message.receiver.name}"
                tvMessage.text =  message.content  // Muestra el texto que escribió el usuario
            }
        }

        Log.d(TAG, "ViewMessageActivity -> onCreate()")
    }

    // region Ciclo de vida de una actividad
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "ViewMessageActivity -> onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "ViewMessageActivity -> onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "ViewMessageActivity -> onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "ViewMessageActivity -> onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "ViewMessageActivity -> onDestroy()")
    }
// endregion
}

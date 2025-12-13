package com.example.proyectoprogramadoi

import Controller.UserController
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class RecoveryLinkActivity : AppCompatActivity() {
    private lateinit var editTxtEmail: EditText
    private lateinit var userController: UserController
    lateinit var myContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recovery_link)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editTxtEmail = findViewById<EditText>(R.id.editTxtEmail)
        userController = UserController(this)
        myContext = this

        val btnBack2: FloatingActionButton = findViewById<FloatingActionButton>(R.id.btnBack2)
        btnBack2.setOnClickListener {
            finish()
        }

        val btnGetRecLink: Button = findViewById<Button>(R.id.btnChangeEmailRL)
        btnGetRecLink.setOnClickListener(View.OnClickListener { view ->
            val email = editTxtEmail.text.toString().trim()
            if (email.isNotBlank()) {
                lifecycleScope.launch {
                    val email = userController.getByEmail(email)
                    if (email!=null) {
                        //AQUÍ IRÍA LA LÓGICA DE MANDAR EL CORREO Y DESDE EL CORREO ABRIR EL
                        //LINK DE RECUPERACIÓN. DE MOMENTO NO HACE NADA
                        Toast.makeText(myContext,getString(R.string.MsgLinkSent), Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(myContext,getString(R.string.ErrorMsgGetByEmail), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this,getString(R.string.MsgMissingData), Toast.LENGTH_SHORT).show()
            }
        })
    }

}
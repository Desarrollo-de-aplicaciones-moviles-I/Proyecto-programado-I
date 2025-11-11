package com.example.proyectoprogramadoi


import Controller.UserController
import Entity.User
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class LoginActivity : AppCompatActivity() {
    companion object {
        lateinit var currentUserName: String
    }
    private lateinit var txtUsername: EditText
    private lateinit var txtPassword: EditText
    private lateinit var userController: UserController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtUsername = findViewById<EditText>(R.id.editTxtUsernameSI)
        txtPassword = findViewById<EditText>(R.id.editTxtPasswordSI)
        userController = UserController(this)

        val btnLogin: Button = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener(View.OnClickListener { view ->
            val username = txtUsername.text.toString().trim()
            val password = txtPassword.text.toString().trim()
            if (username.isNotBlank() && password.isNotBlank()) {
                val usuario = userController.getByUsername(username)
                if (usuario != null) {
                    if (username == usuario.Username && password == usuario.Password) {
                        currentUserName = username
                        txtUsername.setText("")
                        txtPassword.setText("")
                        Util.Util.openActivity(this, MainActivity::class.java)
                    } else {
                        Toast.makeText(this, getString(R.string.MsgWrongPass), Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this,getString(R.string.ErrorMsgGetByUser), Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this,getString(R.string.MsgMissingData), Toast.LENGTH_SHORT).show()
            }
            //Util.Util.openActivity(this, MainActivity::class.java)
        })

        val btnSignUp: TextView = findViewById<TextView>(R.id.btnSignUp)
        btnSignUp.setOnClickListener(View.OnClickListener{ view ->
            Util.Util.openActivity(this, SignUpActivity::class.java)
        })
    }
}
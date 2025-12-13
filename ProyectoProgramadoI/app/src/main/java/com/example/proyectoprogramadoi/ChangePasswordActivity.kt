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
import java.lang.Exception

class ChangePasswordActivity : AppCompatActivity() {
    private lateinit var editTxtPass: EditText
    private lateinit var editTxtCPass: EditText
    private lateinit var userController: UserController
    lateinit var myContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_change_password)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userController = UserController(this)
        editTxtPass = findViewById<EditText>(R.id.editTxtPass)
        editTxtCPass = findViewById<EditText>(R.id.editTxtCPassword)
        myContext = this

        val btnChangePassACP: Button = findViewById<Button>(R.id.btnChangePassACP)
        btnChangePassACP.setOnClickListener(View.OnClickListener { view ->
            changePassword()
        })

        val btnBack4: FloatingActionButton = findViewById<FloatingActionButton>(R.id.btnBack4)
        btnBack4.setOnClickListener {
            finish()
        }

    }

    fun changePassword(){
        lifecycleScope.launch {
            try {
                if(isValidatedData()){
                    val currentUsername = LoginActivity.currentUserName
                    val user = userController.getByUsername(currentUsername)
                    if (user != null) {
                        val pass = editTxtPass.text.toString()
                        if (pass == editTxtCPass.text.toString()) {
                            userController.changePassword(user, pass)
                            cleanScreen()
                            Toast.makeText(myContext, R.string.MsgPasswordUpdated, Toast.LENGTH_LONG).show()
                            finish()
                        } else
                            Toast.makeText(myContext, R.string.MsgDifferentPass, Toast.LENGTH_LONG).show()
                    }
                }else
                    Toast.makeText(myContext, R.string.MsgMissingData
                        , Toast.LENGTH_LONG).show()
            }catch (e: Exception){
                Toast.makeText(myContext, e.message.toString()
                    , Toast.LENGTH_LONG).show()
            }
        }
    }

    fun isValidatedData(): Boolean{
        return editTxtPass.text.trim().isNotEmpty() && editTxtCPass.text.trim().isNotEmpty()
    }

    fun cleanScreen(){
        editTxtPass.setText("")
        editTxtCPass.setText("")
    }
}
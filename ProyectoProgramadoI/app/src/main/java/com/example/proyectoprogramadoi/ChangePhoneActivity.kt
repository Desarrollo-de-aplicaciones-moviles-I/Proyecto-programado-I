package com.example.proyectoprogramadoi

import Controller.UserController
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
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

class ChangePhoneActivity : AppCompatActivity() {
    private lateinit var editTxtPhone: EditText
    private lateinit var userController: UserController
    private lateinit var txtViewCurrentPhone: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_change_phone)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userController = UserController(this)
        editTxtPhone = findViewById<EditText>(R.id.editTxtPhone)
        txtViewCurrentPhone = findViewById<TextView>(R.id.txtViewCurrentPhone)

        loadCurrentPhone()

        val btnChangePhoneACP: Button = findViewById<Button>(R.id.btnChangePhoneACP)
        btnChangePhoneACP.setOnClickListener(View.OnClickListener { view ->
            changePhone()
        })

        val btnBack3: FloatingActionButton = findViewById<FloatingActionButton>(R.id.btnBack3)
        btnBack3.setOnClickListener {
            finish()
        }
    }

    fun changePhone(){
        try {
            if(isValidatedData()){
                val currentUsername = LoginActivity.currentUserName
                val user = userController.getByUsername(currentUsername)
                if (user != null) {
                    val phone = editTxtPhone.text.toString()
                    userController.changePhone(user, phone)
                    cleanScreen()
                    Toast.makeText(this, R.string.MsgPhoneUpdated, Toast.LENGTH_LONG).show()
                    finish()
                }
            }else
                Toast.makeText(this, R.string.MsgMissingData
                    , Toast.LENGTH_LONG).show()
        }catch (e: Exception){
            Toast.makeText(this, e.message.toString()
                , Toast.LENGTH_LONG).show()
        }
    }

    fun isValidatedData(): Boolean{
        return (editTxtPhone.text.trim().isNotEmpty() && editTxtPhone.text.trim().length >= 8
                && editTxtPhone.text.toString()?.toInt()!! != null && editTxtPhone.text.toString().trim() != "0")
    }

    fun cleanScreen(){
        editTxtPhone.setText("")
    }

    fun loadCurrentPhone(){
        try {
            val currentUsername = LoginActivity.currentUserName
            val user = userController.getByUsername(currentUsername)
            if (user != null) {
                txtViewCurrentPhone.setText(user.PhoneNumber)
            }
        }catch (e: Exception){
            Toast.makeText(this, e.message.toString()
                , Toast.LENGTH_LONG).show()
        }
    }
}
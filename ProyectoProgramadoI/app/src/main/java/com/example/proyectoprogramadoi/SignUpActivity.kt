package com.example.proyectoprogramadoi

import Controller.UserController
import Entity.User
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception
import java.time.LocalDate

class SignUpActivity : AppCompatActivity() {
    private lateinit var txtUsername: EditText
    private lateinit var txtEmail: EditText
    private lateinit var txtPhone: EditText
    private lateinit var txtPassword: EditText
    private lateinit var txtCPassword: EditText
    private lateinit var userController: UserController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userController = UserController(this)
        txtUsername = findViewById<EditText>(R.id.editTxtUsernameSU)
        txtEmail = findViewById<EditText>(R.id.editTxtEmailSU)
        txtPhone = findViewById<EditText>(R.id.editTxtPhoneSU)
        txtPassword = findViewById<EditText>(R.id.editTxtPasswordSU)
        txtCPassword = findViewById<EditText>(R.id.editTxtCPasswordSU)

        val btnBack: FloatingActionButton = findViewById<FloatingActionButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        val btnCleanScreen: ImageView = findViewById<ImageView>(R.id.btnCleanScreen)
        btnCleanScreen.setOnClickListener {
            cleanScreen()
        }

        val btnSignUpSU: Button = findViewById<Button>(R.id.btnSignUpSU)
        btnSignUpSU.setOnClickListener {
            savePerson()
        }
    }

    private fun cleanScreen(){
        txtUsername.setText("")
        txtEmail.setText("")
        txtPhone.setText("")
        txtPassword.setText("")
        txtCPassword.setText("")
    }

    fun isValidatedData(): Boolean{
        return txtUsername.text.trim().isNotEmpty() && txtEmail.text.trim().isNotEmpty()
                && txtPassword.text.trim().isNotEmpty() && txtCPassword.text.trim().isNotEmpty()
                && txtEmail.text.trim().isNotEmpty() && (txtPhone.text.trim().isNotEmpty() && txtPhone.text.trim().length >= 8
                && txtPhone.text.toString()?.toInt()!! != null && txtPhone.text.toString().trim() != "0")
    }

    fun savePerson(){
        try {
            if (isValidatedData()){
                if (userController.getByUsername(txtUsername.text.toString()) != null){
                    Toast.makeText(this, R.string.MsgUserDuplicated
                        , Toast.LENGTH_LONG).show()
                }else{
                    val user = User()
                    user.Username = txtUsername.text.toString()
                    user.Email = txtEmail.text.toString()
                    user.PhoneNumber = txtPhone.text.toString()
                    val samePass = txtPassword.text.toString()
                    if (samePass == txtCPassword.text.toString()){
                        user.Password = txtPassword.text.toString()
                        userController.addU(user)
                        cleanScreen()
                        Toast.makeText(this, R.string.MsgSaveSuccess
                            , Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this, R.string.MsgDifferentPass
                            , Toast.LENGTH_LONG).show()
                    }
                }
            }else{
                Toast.makeText(this, R.string.MsgMissingData
                    , Toast.LENGTH_LONG).show()
            }
        }catch (e: Exception){
            Toast.makeText(this, e.message.toString()
                , Toast.LENGTH_LONG).show()
        }
    }

}
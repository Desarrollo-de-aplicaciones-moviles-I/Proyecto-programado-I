package com.example.proyectoprogramadoi

import Controller.AlertController
import Controller.ContactController
import Entity.Alert
import Entity.EmergencyContact
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import java.lang.Exception
import java.time.LocalDateTime

class AlertActivity : AppCompatActivity() {
    private lateinit var alertController: AlertController
    private lateinit var contactController: ContactController
    private lateinit var txtInputCMessage: TextInputEditText
    private lateinit var txtViewNameC1: TextView
    private lateinit var txtViewNameC2: TextView
    private lateinit var txtViewNameC3: TextView
    val nombreUsuario = LoginActivity.currentUserName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alert)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        alertController = AlertController(this)
        contactController = ContactController(this)

        txtInputCMessage = findViewById<TextInputEditText>(R.id.txtInputCMessage)
        txtViewNameC1 = findViewById<TextView>(R.id.txtViewNameC1)
        txtViewNameC2 = findViewById<TextView>(R.id.txtViewNameC2)
        txtViewNameC3 = findViewById<TextView>(R.id.txtViewNameC3)

        loadContacts()

        val btnSendAlertA = findViewById<Button>(R.id.btnSendAlertA)
        btnSendAlertA.setOnClickListener(View.OnClickListener{ view ->
            saveAlert()
        })

        val btnHomeEC = findViewById<ImageButton>(R.id.btnHomeEC)
        btnHomeEC.setOnClickListener(View.OnClickListener{ view ->
            Util.Util.openActivity(this, MainActivity::class.java)
        })

        val btnSettingsEC = findViewById<ImageButton>(R.id.btnSettingsEC)
        btnSettingsEC.setOnClickListener(View.OnClickListener{ view ->
            Util.Util.openActivity(this, ConfigurationActivity::class.java)
        })
    }

    fun saveAlert(){
        try {
            val generatedID = alertController.createID()
            val alert = Alert()
            alert.DateAlert= LocalDateTime.now()
            alert.IdAlert = generatedID
            alert.Message = txtInputCMessage.text.toString()
            alert.Latitude = 1 //de momento
            alert.Longitude = 1 //de momento también
            alert.IdUser = nombreUsuario
            alertController.addA(alert)
            cleanScreen()
            finish()
            Toast.makeText(this, R.string.MsgAlertSuccessfully
                , Toast.LENGTH_LONG).show()
        }catch (e: Exception){
            Toast.makeText(this, e.message.toString()
                , Toast.LENGTH_LONG).show()
        }
    }

    private fun cleanScreen(){
        txtInputCMessage.setText("")
    }

    private fun loadContacts() {
        val contacts = contactController.getEContactsByU(nombreUsuario)

        fun showContact(contact: EmergencyContact?, textView: TextView) {
            if (contact != null) {
                textView.visibility = View.VISIBLE
                textView.text = "${contact.Name} (${contact.PhoneNumber})"
            }
        }

        showContact(contacts.getOrNull(0), txtViewNameC1)
        showContact(contacts.getOrNull(1), txtViewNameC2)
        showContact(contacts.getOrNull(2), txtViewNameC3)
    }

}
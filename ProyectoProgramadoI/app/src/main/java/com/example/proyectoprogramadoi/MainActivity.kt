package com.example.proyectoprogramadoi

import Controller.AlertController
import Controller.ContactController
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var contactController: ContactController
    private lateinit var alertController: AlertController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        contactController = ContactController(this)
        alertController = AlertController(this)
        val nombreUsuario = LoginActivity.currentUserName

        val btnSendAlert: Button = findViewById<Button>(R.id.btnSendAlert)
        btnSendAlert.setOnClickListener {
            val contacts = contactController.getEContactsByU(nombreUsuario)
            if(contacts.isEmpty())
                Toast.makeText(this, R.string.MsgAddContactFirst
                    , Toast.LENGTH_LONG).show()
            else
                Util.Util.openActivity(this, AlertActivity::class.java)
        }

        val btnEmergencyC: FloatingActionButton = findViewById<FloatingActionButton>(R.id.btnEmergencyContactsM)
        btnEmergencyC.setOnClickListener {
            Util.Util.openActivity(this, EmergencyContactActivity::class.java)
        }

        val btnAlertHistory: FloatingActionButton = findViewById<FloatingActionButton>(R.id.btnAlertHistory)
        btnAlertHistory.setOnClickListener {
            val alerts = alertController.getAlertByU(nombreUsuario)
            if(alerts.isEmpty())
                Toast.makeText(this, R.string.MsgAddAlertFirst
                    , Toast.LENGTH_LONG).show()
            else
                Util.Util.openActivity(this, AlertListActivity::class.java)
        }

        val btnSettings: ImageButton = findViewById<ImageButton>(R.id.btnSettingsEC)
        btnSettings.setOnClickListener {
            Util.Util.openActivity(this, ConfigurationActivity::class.java)
        }
    }

}
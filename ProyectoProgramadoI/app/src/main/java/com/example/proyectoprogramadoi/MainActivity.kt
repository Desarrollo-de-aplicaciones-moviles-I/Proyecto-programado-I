package com.example.proyectoprogramadoi

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSendAlert: Button = findViewById<Button>(R.id.btnSendAlert)
        btnSendAlert.setOnClickListener {
            Util.Util.openActivity(this, AlertActivity::class.java)
        }

        val btnEmergencyC: FloatingActionButton = findViewById<FloatingActionButton>(R.id.btnEmergencyContactsM)
        btnEmergencyC.setOnClickListener {
            Util.Util.openActivity(this, EmergencyContactActivity::class.java)
        }

        val btnAlertHistory: FloatingActionButton = findViewById<FloatingActionButton>(R.id.btnAlertHistory)
        btnAlertHistory.setOnClickListener {
            Util.Util.openActivity(this, AlertHistoryActivity::class.java)
        }

        val btnSettings: ImageButton = findViewById<ImageButton>(R.id.btnSettingsEC)
        btnSettings.setOnClickListener {
            Util.Util.openActivity(this, ConfigurationActivity::class.java)
        }
    }

}
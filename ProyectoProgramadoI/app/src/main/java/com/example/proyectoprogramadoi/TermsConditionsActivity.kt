package com.example.proyectoprogramadoi

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TermsConditionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_terms_conditions)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnHomeEC = findViewById<ImageButton>(R.id.btnHomeEC)
        btnHomeEC.setOnClickListener(View.OnClickListener{ view ->
            Util.Util.openActivity(this, MainActivity::class.java)
        })

        val btnSettingsEC = findViewById<ImageButton>(R.id.btnSettingsEC)
        btnSettingsEC.setOnClickListener(View.OnClickListener{ view ->
            Util.Util.openActivity(this, ConfigurationActivity::class.java)
        })
    }
}
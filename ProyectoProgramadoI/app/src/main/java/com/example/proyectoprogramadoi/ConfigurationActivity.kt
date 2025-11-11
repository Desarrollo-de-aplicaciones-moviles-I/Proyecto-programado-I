package com.example.proyectoprogramadoi

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ConfigurationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_configuration)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLogOutS: TextView = findViewById<TextView>(R.id.btnLogOutS)
        btnLogOutS.setOnClickListener(View.OnClickListener{ view ->
            Util.Util.openActivity(this, LoginActivity::class.java)
        })

        val btnHomeEC = findViewById<ImageButton>(R.id.btnHomeEC)
        btnHomeEC.setOnClickListener(View.OnClickListener{ view ->
            Util.Util.openActivity(this, MainActivity::class.java)
        })

        val btnTermsConditions: FloatingActionButton = findViewById<FloatingActionButton>(R.id.btnTermsConditions)
        btnTermsConditions.setOnClickListener(View.OnClickListener{ view ->
            Util.Util.openActivity(this, TermsConditionsActivity::class.java)
        })

        val btnAboutUs: FloatingActionButton = findViewById<FloatingActionButton>(R.id.btnAboutUs)
        btnAboutUs.setOnClickListener(View.OnClickListener{ view ->
            Util.Util.openActivity(this, AboutUsActivity::class.java)
        })

        val btnChangePass: FloatingActionButton = findViewById<FloatingActionButton>(R.id.btnChangePass)
        btnChangePass.setOnClickListener(View.OnClickListener{ view ->
            Util.Util.openActivity(this, ChangePasswordActivity::class.java)
        })

        val btnChangePhone: FloatingActionButton = findViewById<FloatingActionButton>(R.id.btnChangePhone)
        btnChangePhone.setOnClickListener(View.OnClickListener{ view ->
            Util.Util.openActivity(this, ChangePhoneActivity::class.java)
        })

    }
}
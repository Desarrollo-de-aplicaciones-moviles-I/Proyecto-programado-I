package com.example.proyectoprogramadoi

import Controller.AlertController
import Entity.Alert
import Interfaces.OnItemClickListener
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AlertListActivity : AppCompatActivity(), OnItemClickListener {
    private lateinit var alertController: AlertController
    val nombreUsuario = LoginActivity.currentUserName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alert_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        alertController = AlertController(this)
        val alerts = alertController.getAlertByU(nombreUsuario)
        val recycler =  findViewById<RecyclerView>(R.id.rvAlertH)
        val customAdapter = AlertListAdapter(alerts, this)
        val layoutManager = LinearLayoutManager(applicationContext)
        recycler.layoutManager = layoutManager
        recycler.adapter = customAdapter
        customAdapter.notifyDataSetChanged()

        val btnHomeEC = findViewById<ImageButton>(R.id.btnHomeEC)
        btnHomeEC.setOnClickListener(View.OnClickListener{ view ->
            Util.Util.openActivity(this, MainActivity::class.java)
        })

        val btnSettingsEC = findViewById<ImageButton>(R.id.btnSettingsEC)
        btnSettingsEC.setOnClickListener(View.OnClickListener{ view ->
            Util.Util.openActivity(this, ConfigurationActivity::class.java)
        })

    }

    override fun onItemClicked(alert: Alert) {
        Util.Util.openActivity(this, AlertActivity::class.java
        )
    }

}
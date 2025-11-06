package com.example.proyectoprogramadoi

import Controller.ContactController
import Entity.EmergencyContact
import Entity.User
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectoprogramadoi.LoginActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

class EmergencyContactActivity : AppCompatActivity() {
    private lateinit var editTxtNameC1: EditText
    private lateinit var editTxtNameC2: EditText
    private lateinit var editTxtNameC3: EditText
    private lateinit var editTxtPhoneC1: EditText
    private lateinit var editTxtPhoneC2: EditText
    private lateinit var editTxtPhoneC3: EditText
    private var isEditMode: Boolean = false
    private lateinit var contactController: ContactController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_emergency_contact)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        contactController = ContactController(this)

        editTxtNameC1 = findViewById<EditText>(R.id.editTxtNameC1)
        editTxtNameC2 = findViewById<EditText>(R.id.editTxtNameC2)
        editTxtNameC3 = findViewById<EditText>(R.id.editTxtNameC3)
        editTxtPhoneC1 = findViewById<EditText>(R.id.editTxtPhoneC1)
        editTxtPhoneC2 = findViewById<EditText>(R.id.editTxtPhoneC2)
        editTxtPhoneC3 = findViewById<EditText>(R.id.editTxtPhoneC3)

        val nombreUsuario = LoginActivity.currentUserName
        loadContacts(nombreUsuario)

        val btnSaveContact1 = findViewById<TextView>(R.id.btnSaveContact1)
        btnSaveContact1.setOnClickListener(View.OnClickListener{ view ->
            saveContact(editTxtNameC1, editTxtPhoneC1, nombreUsuario)
        })

        val btnSaveContact2 = findViewById<TextView>(R.id.btnSaveContact2)
        btnSaveContact2.setOnClickListener(View.OnClickListener{ view ->
            saveContact(editTxtNameC2, editTxtPhoneC2, nombreUsuario)
        })

        val btnSaveContact3 = findViewById<TextView>(R.id.btnSaveContact3)
        btnSaveContact3.setOnClickListener(View.OnClickListener{ view ->
            saveContact(editTxtNameC3, editTxtPhoneC3, nombreUsuario)

        })

        val btnDeleteContact1 = findViewById<TextView>(R.id.btnDeleteContact1)
        btnDeleteContact1.setOnClickListener(View.OnClickListener{ view ->
            deleteContact(editTxtNameC1, editTxtPhoneC1)
        })

        val btnDeleteContact2 = findViewById<TextView>(R.id.btnDeleteContact2)
        btnDeleteContact2.setOnClickListener(View.OnClickListener{ view ->
            deleteContact(editTxtNameC2, editTxtPhoneC2)
        })

        val btnDeleteContact3 = findViewById<TextView>(R.id.btnDeleteContact3)
        btnDeleteContact3.setOnClickListener(View.OnClickListener{ view ->
            deleteContact(editTxtNameC3, editTxtPhoneC3)
        })

        val btnEditContact1 = findViewById<TextView>(R.id.btnEditContact1)
        btnEditContact1.setOnClickListener(View.OnClickListener{ view ->
            editTxtPhoneC1.isEnabled=true
            isEditMode=true
        })

        val btnEditContact2 = findViewById<TextView>(R.id.btnEditContact2)
        btnEditContact2.setOnClickListener(View.OnClickListener{ view ->
            editTxtPhoneC2.isEnabled=true
            isEditMode=true
        })

        val btnEditContact3 = findViewById<TextView>(R.id.btnEditContact3)
        btnEditContact3.setOnClickListener(View.OnClickListener{ view ->
            editTxtPhoneC3.isEnabled=true
            isEditMode=true
        })

        val clContact1 = findViewById<ConstraintLayout>(R.id.clContact1)
        val btnAddContact1 = findViewById< FloatingActionButton>(R.id.btnAddContact1)
        btnAddContact1.setOnClickListener(View.OnClickListener{ view ->
            if (clContact1.visibility == View.VISIBLE) {
                clContact1.visibility = View.INVISIBLE
            } else {
                clContact1.visibility = View.VISIBLE
            }
        })

        val clContact2 = findViewById<ConstraintLayout>(R.id.clContact2)
        val btnAddContact2 = findViewById< FloatingActionButton>(R.id.btnAddContact2)
        btnAddContact2.setOnClickListener(View.OnClickListener{ view ->
            if (clContact2.visibility == View.VISIBLE) {
                clContact2.visibility = View.INVISIBLE
            } else {
                clContact2.visibility = View.VISIBLE
            }
        })

        val clContact3 = findViewById<ConstraintLayout>(R.id.clContact3)
        val btnAddContact3 = findViewById< FloatingActionButton>(R.id.btnAddContact3)
        btnAddContact3.setOnClickListener(View.OnClickListener{ view ->
            if (clContact3.visibility == View.VISIBLE) {
                clContact3.visibility = View.INVISIBLE
            } else {
                clContact3.visibility = View.VISIBLE
            }
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

    fun isValidatedData(editTxtNameC: EditText, editTxtPhoneC: EditText): Boolean{
        return editTxtNameC.text.trim().isNotEmpty()
                && (editTxtPhoneC.text.trim().isNotEmpty() && editTxtPhoneC.text.trim().length >= 8
                && editTxtPhoneC.text.toString()?.toInt()!! != null && editTxtPhoneC.text.toString().trim() != "0")
    }

    fun saveContact(editTxtNameC: EditText, editTxtPhoneC: EditText, nombreUsuario: String){
        try {
            if (isValidatedData(editTxtNameC, editTxtPhoneC)){
                if (isEditMode==false && contactController.getEContactsByN(editTxtNameC.text.toString()) != null){
                    Toast.makeText(this, R.string.MsgDuplicatedContact
                        , Toast.LENGTH_LONG).show()
                }else if(contactController.getEContactsByP(editTxtPhoneC.text.toString()) != null){
                    Toast.makeText(this, R.string.MsgDuplicatedNumberC
                        , Toast.LENGTH_LONG).show()
                } else{
                    val contact = EmergencyContact()
                    val nom = editTxtNameC.text.toString()
                    val num = editTxtPhoneC.text.toString()
                    contact.Name = nom
                    contact.PhoneNumber = num
                    contact.NameUser = nombreUsuario
                    if (!isEditMode) {
                        contactController.addC(contact)
                        editTxtNameC.setText(nom)
                        editTxtPhoneC.setText(num)
                    }else {
                        contactController.updateC(contact)
                        editTxtNameC.setText(nom)
                        editTxtPhoneC.setText(num)
                        isEditMode = false
                    }
                    editTxtNameC.isEnabled=false
                    editTxtPhoneC.isEnabled=false
                    Toast.makeText(this, R.string.MsgSaveSuccess
                        , Toast.LENGTH_LONG).show()
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

    fun deleteContact(editTxtNameC: EditText, editTxtPhoneC: EditText){
        try {
            if (editTxtNameC.text.trim().toString().isNotEmpty() && editTxtPhoneC.text.trim().toString().isNotEmpty()) {
                contactController.removeC(editTxtNameC.text.trim().toString())
                cleanScreen(editTxtNameC, editTxtPhoneC)
                editTxtNameC.isEnabled=true
                editTxtPhoneC.isEnabled=true
                Toast.makeText(
                    this, getString(R.string.MsgDeleteSuccess), Toast.LENGTH_LONG
                ).show()
            }
        }catch (e: Exception){
            Toast.makeText(this, e.message.toString()
                , Toast.LENGTH_LONG).show()
        }
    }

    fun cleanScreen(editTxtNameC: EditText, editTxtPhoneC: EditText){
        editTxtNameC.setText("")
        editTxtPhoneC.setText("")
    }

    fun loadContacts(nombreUsuario: String) {
        try {
            val contacts = contactController.getEContactsByU(nombreUsuario)

            // Contacto 1
            if (contacts.size >= 1) {
                val contact = contacts[0]
                findViewById<ConstraintLayout>(R.id.clContact1).visibility = View.VISIBLE
                editTxtNameC1.setText(contact.Name)
                editTxtPhoneC1.setText(contact.PhoneNumber)
                editTxtNameC1.isEnabled = false
                editTxtPhoneC1.isEnabled = false
            }else {
                findViewById<ConstraintLayout>(R.id.clContact1).visibility = View.INVISIBLE
            }

            // Contacto 2
            if (contacts.size >= 2) {
                val contact = contacts[1]
                findViewById<ConstraintLayout>(R.id.clContact2).visibility = View.VISIBLE
                editTxtNameC2.setText(contact.Name)
                editTxtPhoneC2.setText(contact.PhoneNumber)
                editTxtNameC2.isEnabled = false
                editTxtPhoneC2.isEnabled = false
            }else {
                findViewById<ConstraintLayout>(R.id.clContact2).visibility = View.INVISIBLE
            }

            // Contacto 3
            if (contacts.size >= 3) {
                val contact = contacts[2]
                findViewById<ConstraintLayout>(R.id.clContact3).visibility = View.VISIBLE
                editTxtNameC3.setText(contact.Name)
                editTxtPhoneC3.setText(contact.PhoneNumber)
                editTxtNameC3.isEnabled = false
                editTxtPhoneC3.isEnabled = false
            }else {
                findViewById<ConstraintLayout>(R.id.clContact3).visibility = View.INVISIBLE
            }

        } catch (e: Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }

}

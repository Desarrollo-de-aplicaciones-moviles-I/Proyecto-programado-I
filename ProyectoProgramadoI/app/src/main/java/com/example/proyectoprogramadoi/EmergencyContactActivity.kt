package com.example.proyectoprogramadoi

import Controller.ContactController
import Entity.EmergencyContact
import Entity.User
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

        val btnSaveContact1 = findViewById<TextView>(R.id.btnSaveContact1)
        btnSaveContact1.setOnClickListener(View.OnClickListener{ view ->
            try {
                if (isValidatedData(editTxtNameC1, editTxtPhoneC1)){
                    if (contactController.getEContactsByN(editTxtNameC1.text.toString()) != null){
                        Toast.makeText(this, R.string.MsgDuplicatedContact
                            , Toast.LENGTH_LONG).show()
                    }else if(contactController.getEContactsByP(editTxtPhoneC1.text.toString()) != null){
                        Toast.makeText(this, R.string.MsgDuplicatedNumberC
                            , Toast.LENGTH_LONG).show()
                    } else{
                        saveContact(editTxtNameC1, editTxtPhoneC1)
                    }
                }else{
                    Toast.makeText(this, R.string.MsgMissingData
                        , Toast.LENGTH_LONG).show()
                }
            }catch (e: Exception){
                Toast.makeText(this, e.message.toString()
                    , Toast.LENGTH_LONG).show()
            }
        })

        val btnSaveContact2 = findViewById<TextView>(R.id.btnSaveContact2)
        btnSaveContact2.setOnClickListener(View.OnClickListener{ view ->
            try {
                if (isValidatedData(editTxtNameC2, editTxtPhoneC2)){
                    if (contactController.getEContactsByN(editTxtNameC2.text.toString()) != null){
                        Toast.makeText(this, R.string.MsgDuplicatedContact
                            , Toast.LENGTH_LONG).show()
                    }else if(contactController.getEContactsByP(editTxtPhoneC2.text.toString()) != null){
                        Toast.makeText(this, R.string.MsgDuplicatedNumberC
                            , Toast.LENGTH_LONG).show()
                    } else{
                        saveContact(editTxtNameC2, editTxtPhoneC2)
                    }
                }else{
                    Toast.makeText(this, R.string.MsgMissingData
                        , Toast.LENGTH_LONG).show()
                }
            }catch (e: Exception){
                Toast.makeText(this, e.message.toString()
                    , Toast.LENGTH_LONG).show()
            }
        })

        val btnSaveContact3 = findViewById<TextView>(R.id.btnSaveContact3)
        btnSaveContact3.setOnClickListener(View.OnClickListener{ view ->
            try {
                if (isValidatedData(editTxtNameC3, editTxtPhoneC3)){
                    if (contactController.getEContactsByN(editTxtNameC3.text.toString()) != null){
                        Toast.makeText(this, R.string.MsgDuplicatedContact
                            , Toast.LENGTH_LONG).show()
                    }else if(contactController.getEContactsByP(editTxtPhoneC3.text.toString()) != null){
                        Toast.makeText(this, R.string.MsgDuplicatedNumberC
                            , Toast.LENGTH_LONG).show()
                    } else{
                        saveContact(editTxtNameC3, editTxtPhoneC3)
                    }
                }else{
                    Toast.makeText(this, R.string.MsgMissingData
                        , Toast.LENGTH_LONG).show()
                }
            }catch (e: Exception){
                Toast.makeText(this, e.message.toString()
                    , Toast.LENGTH_LONG).show()
            }
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
            editTxtNameC1.isEnabled=true
            editTxtPhoneC1.isEnabled=true

        })
/*
        val btnSaveContact3 = findViewById<TextView>(R.id.btnSaveContact3)
        btnSaveContact3.setOnClickListener(View.OnClickListener{ view ->
            try {
                if (isValidatedData(editTxtNameC3, editTxtPhoneC3)){
                    if (contactController.getEContactsByN(editTxtNameC3.text.toString()) != null){
                        Toast.makeText(this, R.string.MsgDuplicatedContact
                            , Toast.LENGTH_LONG).show()
                    }else if(contactController.getEContactsByP(editTxtPhoneC3.text.toString()) != null){
                        Toast.makeText(this, R.string.MsgDuplicatedNumberC
                            , Toast.LENGTH_LONG).show()
                    } else{
                        saveContact(editTxtNameC3, editTxtPhoneC3)
                    }
                }else{
                    Toast.makeText(this, R.string.MsgMissingData
                        , Toast.LENGTH_LONG).show()
                }
            }catch (e: Exception){
                Toast.makeText(this, e.message.toString()
                    , Toast.LENGTH_LONG).show()
            }
        })

        val btnSaveContact3 = findViewById<TextView>(R.id.btnSaveContact3)
        btnSaveContact3.setOnClickListener(View.OnClickListener{ view ->
            try {
                if (isValidatedData(editTxtNameC3, editTxtPhoneC3)){
                    if (contactController.getEContactsByN(editTxtNameC3.text.toString()) != null){
                        Toast.makeText(this, R.string.MsgDuplicatedContact
                            , Toast.LENGTH_LONG).show()
                    }else if(contactController.getEContactsByP(editTxtPhoneC3.text.toString()) != null){
                        Toast.makeText(this, R.string.MsgDuplicatedNumberC
                            , Toast.LENGTH_LONG).show()
                    } else{
                        saveContact(editTxtNameC3, editTxtPhoneC3)
                    }
                }else{
                    Toast.makeText(this, R.string.MsgMissingData
                        , Toast.LENGTH_LONG).show()
                }
            }catch (e: Exception){
                Toast.makeText(this, e.message.toString()
                    , Toast.LENGTH_LONG).show()
            }
        })*/

    }

    fun isValidatedData(editTxtNameC: EditText, editTxtPhoneC: EditText): Boolean{
        return editTxtNameC.text.trim().isNotEmpty()
                && (editTxtPhoneC.text.trim().isNotEmpty() && editTxtPhoneC.text.trim().length >= 8
                && editTxtPhoneC.text.toString()?.toInt()!! != null && editTxtPhoneC.text.toString().trim() != "0")
    }

    fun saveContact(editTxtNameC: EditText, editTxtPhoneC: EditText){
        val contact = EmergencyContact()
        val nom = editTxtNameC.text.toString()
        val num = editTxtPhoneC.text.toString()
        contact.Name = nom
        contact.PhoneNumber = num
        if (!isEditMode) {
            contactController.addC(contact)
            editTxtNameC.setText(nom)
            editTxtPhoneC.setText(num)
            editTxtNameC.isEnabled=false
            editTxtPhoneC.isEnabled=false
        }else
            contactController.updateC(contact)
        Toast.makeText(this, R.string.MsgSaveSuccess
            , Toast.LENGTH_LONG).show()
    }


    fun deleteContact(editTxtNameC: EditText, editTxtPhoneC: EditText){
        try {
            contactController.removeC(editTxtNameC.text.trim().toString())
            cleanScreen(editTxtNameC, editTxtPhoneC)
            Toast.makeText(this, getString(R.string.MsgDeleteSuccess)
                , Toast.LENGTH_LONG).show()
        }catch (e: Exception){
            Toast.makeText(this, e.message.toString()
                , Toast.LENGTH_LONG).show()
        }
    }

    fun cleanScreen(editTxtNameC: EditText, editTxtPhoneC: EditText){
        editTxtNameC.setText("")
        editTxtPhoneC.setText("")
    }

}

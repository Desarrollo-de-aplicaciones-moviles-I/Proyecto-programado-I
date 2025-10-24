package Entity

import java.util.Date

class User {
    private var id: Int=0
    private var name: String=""
    private var fLastName: String=""
    private var correo: String=""
    private var contrasena: String=""
    private var phoneNumber: String=""
    //private var eContacts = mutableListOf<EmergencyContact>()
    private lateinit var fechaRegistro: Date




    constructor(id: Int, name:String, fLastName: String
                , correo: String, contrasena: String
                , phoneNumber: String, fechaRegistro: Date){
        this.id=id
        this.name=name
        this.fLastName=fLastName
        this.correo=correo
        this.contrasena=contrasena
        this.phoneNumber=phoneNumber
        this.fechaRegistro=fechaRegistro
    }

    var Id: Int
        get() = this.id
        set(value) {this.id=value}

    var Name: String
        get() = this.name
        set(value) {this.name=value}

    var FLastName: String
        get() = this.fLastName
        set(value) {this.fLastName=value}

    var Correo: String
        get() = this.correo
        set(value) {this.correo=value}

    var Contrasena: String
        get() = this.contrasena
        set(value) {this.contrasena=value}

    var PhoneNumber: String
        get() = this.phoneNumber
        set(value) {this.phoneNumber=value}

    var FechaRegistro: Date
        get() = this.fechaRegistro
        set(value) {this.fechaRegistro=value}
}
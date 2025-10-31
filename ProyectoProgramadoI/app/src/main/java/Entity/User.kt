package Entity

import java.util.Date

class User {
    private var id: Int=0
    private var name: String=""
    private var fLastName: String=""
    private var email: String=""
    private var password: String=""
    private var phoneNumber: String=""
    //private var eContacts = mutableListOf<EmergencyContact>()
    private lateinit var dateRegister: Date

    constructor()

    constructor(id: Int, name:String, fLastName: String
                , correo: String, contrasena: String
                , phoneNumber: String, fechaRegistro: Date){
        this.id=id
        this.name=name
        this.fLastName=fLastName
        this.email=correo
        this.password=contrasena
        this.phoneNumber=phoneNumber
        this.dateRegister=fechaRegistro
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
        get() = this.email
        set(value) {this.email=value}

    var Contrasena: String
        get() = this.password
        set(value) {this.password=value}

    var PhoneNumber: String
        get() = this.phoneNumber
        set(value) {this.phoneNumber=value}

    var FechaRegistro: Date
        get() = this.dateRegister
        set(value) {this.dateRegister=value}
}
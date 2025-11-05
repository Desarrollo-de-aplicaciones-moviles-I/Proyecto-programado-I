package Entity

class User {
<<<<<<< Updated upstream
    private var id: Int=0
    private var name: String=""
    private var fLastName: String=""
    private var correo: String=""
    private var contrasena: String=""
    private var phoneNumber: String=""
    //private var eContacts = mutableListOf<EmergencyContact>()
    private lateinit var fechaRegistro: Date


=======
    private var username: String=""
    private var email: String=""
    private var password: String=""
    private var phoneNumber: String=""
    //private var eContacts = mutableListOf<EmergencyContact>()
>>>>>>> Stashed changes


<<<<<<< Updated upstream
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
=======
    constructor(username:String, correo: String
                , contrasena: String, phoneNumber: String){
        this.username=username
        this.email=correo
        this.password=contrasena
        this.phoneNumber=phoneNumber
>>>>>>> Stashed changes
    }

    var Username: String
        get() = this.username
        set(value) {this.username=value}

<<<<<<< Updated upstream
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
=======
    var Email: String
        get() = this.email
        set(value) {this.email=value}

    var Password: String
        get() = this.password
        set(value) {this.password=value}
>>>>>>> Stashed changes

    var PhoneNumber: String
        get() = this.phoneNumber
        set(value) {this.phoneNumber=value}
<<<<<<< Updated upstream

    var FechaRegistro: Date
        get() = this.fechaRegistro
        set(value) {this.fechaRegistro=value}
=======
>>>>>>> Stashed changes
}
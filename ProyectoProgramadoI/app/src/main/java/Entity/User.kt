package Entity

class User {
    private var username: String=""
    private var email: String=""
    private var password: String=""
    private var phoneNumber: String=""
    //private var eContacts = mutableListOf<EmergencyContact>()

    constructor()

    constructor(username:String, correo: String
                , contrasena: String, phoneNumber: String){
        this.username=username
        this.email=correo
        this.password=contrasena
        this.phoneNumber=phoneNumber
    }

    var Username: String
        get() = this.username
        set(value) {this.username=value}

    var Email: String
        get() = this.email
        set(value) {this.email=value}

    var Password: String
        get() = this.password
        set(value) {this.password=value}

    var PhoneNumber: String
        get() = this.phoneNumber
        set(value) {this.phoneNumber=value}
}
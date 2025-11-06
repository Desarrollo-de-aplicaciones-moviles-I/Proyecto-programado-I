package Entity

class EmergencyContact {
    private var name: String=""
    private var phoneNumber: String=""
    private var nameUser: String=""

    constructor()

    constructor(name: String, phoneNumber: String
                , nameUser: String){
        this.name=name
        this.phoneNumber=phoneNumber
        this.nameUser=nameUser
    }

    var Name: String
        get() = this.name
        set(value) {this.name=value}

    var PhoneNumber: String
        get() = this.phoneNumber
        set(value) {this.phoneNumber=value}

    var NameUser: String
        get() = this.nameUser
        set(value) {this.nameUser=value}
}
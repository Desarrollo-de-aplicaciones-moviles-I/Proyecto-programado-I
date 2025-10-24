package Entity

class EmergencyContact {
    private var id: Int=0
    private var name: String=""
    private var fLastName: String=""
    private var phoneNumber: String=""
    private var idUser: Int=0

    constructor(id: Int, name: String, fLastName: String
        , phoneNumber: String,  idUser: Int){
        this.id=id
        this.name=name
        this.fLastName=fLastName
        this.phoneNumber=phoneNumber
        this.idUser=idUser
    }

    var Id: Int
        get() = this.id
        set(value) {this.id=value}

    var Name: String
        get() = this.name
        set(value) {this.name=value}

    var FlastName: String
        get() = this.fLastName
        set(value) {this.fLastName=value}

    var PhoneNumber: String
        get() = this.phoneNumber
        set(value) {this.phoneNumber=value}

    var IdUser: Int
        get() = this.idUser
        set(value) {this.idUser=value}
}
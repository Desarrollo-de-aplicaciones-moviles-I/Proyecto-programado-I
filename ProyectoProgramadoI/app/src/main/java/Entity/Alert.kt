package Entity

import java.time.LocalDateTime

class Alert {
    private var idAlert: Int=0
    private lateinit var dateAlert: LocalDateTime
    private var message: String? = null
    private var latitude: Int=0
    private var longitude: Int=0
    private lateinit var idUser: String

    constructor()

    constructor(idAlert: Int, fechaAlerta: LocalDateTime, mensaje:String
                , latitud: Int, longitud: Int,  idUser: String){
        this.idAlert=idAlert
        this.dateAlert=fechaAlerta
        this.message=mensaje
        this.latitude=latitud
        this.longitude=longitud
        this.idUser=idUser
    }

    var IdAlert: Int
        get() = this.idAlert
        set(value) {this.idAlert=value}

    var DateAlert: LocalDateTime
        get() = this.dateAlert
        set(value) {this.dateAlert=value}

    var Message: String?
        get() = this.message
        set(value) {this.message=value}

    var Latitude: Int
        get() = this.latitude
        set(value) {this.latitude=value}

    var Longitude: Int
        get() = this.longitude
        set(value) {this.longitude=value}

    var IdUser: String
        get() = this.idUser
        set(value) {this.idUser=value}
}

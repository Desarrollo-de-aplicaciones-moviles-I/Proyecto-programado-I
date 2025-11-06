package Entity

import java.util.Date

class Alert {
    private var idAlert: Int=0
    private lateinit var dateAlert: Date
    private var message: String=""
    private var latitude: Int=0
    private var longitude: Int=0
    private var idUser: Int=0

    constructor(idAlert: Int, fechaAlerta: Date, mensaje:String
                , latitud: Int, longitud: Int,  idUser: Int){
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

    var FechaAlerta: Date
        get() = this.dateAlert
        set(value) {this.dateAlert=value}

    var Mensaje: String
        get() = this.message
        set(value) {this.message=value}

    var Latitud: Int
        get() = this.latitude
        set(value) {this.latitude=value}

    var Longitud: Int
        get() = this.longitude
        set(value) {this.longitude=value}

    var IdUser: Int
        get() = this.idUser
        set(value) {this.idUser=value}
}

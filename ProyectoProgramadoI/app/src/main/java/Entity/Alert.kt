package Entity

import java.util.Date
import kotlin.collections.mutableListOf

class Alert {
    private var idAlert: Int=0
    private lateinit var fechaAlerta: Date
    private var mensaje: String=""
    private var latitud: Int=0
    private var longitud: Int=0
    private var idUser: Int=0

    constructor(idAlert: Int, fechaAlerta: Date, mensaje:String
                , latitud: Int, longitud: Int,  idUser: Int){
        this.idAlert=idAlert
        this.fechaAlerta=fechaAlerta
        this.mensaje=mensaje
        this.latitud=latitud
        this.longitud=longitud
        this.idUser=idUser
    }

    var IdAlert: Int
        get() = this.idAlert
        set(value) {this.idAlert=value}

    var FechaAlerta: Date
        get() = this.fechaAlerta
        set(value) {this.fechaAlerta=value}

    var Mensaje: String
        get() = this.mensaje
        set(value) {this.mensaje=value}

    var Latitud: Int
        get() = this.latitud
        set(value) {this.latitud=value}

    var Longitud: Int
        get() = this.longitud
        set(value) {this.longitud=value}

    var IdUser: Int
        get() = this.idUser
        set(value) {this.idUser=value}
}

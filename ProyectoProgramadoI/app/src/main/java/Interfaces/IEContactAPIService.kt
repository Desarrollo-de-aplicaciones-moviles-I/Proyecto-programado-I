package Interfaces

import Entity.DTOEmergencyContact
import Entity.EContactGetResponse
import Entity.EContactResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface IEContactAPIService {
    @Headers("Content-Type: application/json")
    @POST("/contact")
    suspend fun postContact (@Body contact: DTOEmergencyContact): EContactResponse

    @GET("/contact/user/{username}")
    suspend fun getContactByUser(@Path("username") username: String): EContactGetResponse

    @GET("/contact/name/{contactName}")
    suspend fun getContactByCName(@Path("contactName") contactName: String): EContactGetResponse

    @GET("/contact/phone/{phoneNumber}")
    suspend fun getContactByPhone(@Path("phoneNumber") phoneNumber: String): EContactGetResponse

    @Headers("Content-Type: application/json")
    @PUT("/contact")
    suspend fun updateContact(@Body contact: DTOEmergencyContact): EContactResponse

    @Headers("Content-Type: application/json")
    @HTTP(method = "DELETE", path = "/contact/{name}")
    suspend fun deleteContact(@Path("name") name: String): EContactResponse

}
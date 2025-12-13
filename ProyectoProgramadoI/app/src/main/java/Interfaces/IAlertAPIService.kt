package Interfaces

import Entity.AlertGetResponse
import Entity.AlertResponse
import Entity.DTOAlert
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface IAlertAPIService {
    @Headers("Content-Type: application/json")
    @POST("/alerts")
    suspend fun postAlert (@Body alert: DTOAlert): AlertResponse

    @GET("/alerts/user/{userId}")
    suspend fun getAlertsByUser(@Path("userId") userId: String): AlertGetResponse

}
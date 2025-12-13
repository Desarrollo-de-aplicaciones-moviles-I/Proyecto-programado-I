package Interfaces

import Entity.DTOUser
import Entity.LoginRequest
import Entity.LogoutRequest
import Entity.PasswordRequest
import Entity.PhoneRequest
import Entity.UserGetResponse
import Entity.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface IUserAPIService {
    @GET("/user/username/{username}")
    suspend fun getByUsername(@Path("username") username: String): UserGetResponse

    @GET("/user/email/{email}")
    suspend fun getByEmail(@Path("email") email: String): UserGetResponse

    @Headers("Content-Type: application/json")
    @POST("/user")
    suspend fun postUser (@Body user: DTOUser): UserResponse

    @Headers("Content-Type: application/json")
    @POST("/user/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): UserResponse

    @Headers("Content-Type: application/json")
    @POST("/user/logout")
    suspend fun logout(
        @Body logoutRequest: LogoutRequest
    ): UserResponse

    @Headers("Content-Type: application/json")
    @PUT("/user/{username}/password")
    suspend fun updatePassword(
        @Path("username") username: String,
        @Body password: PasswordRequest
    ): UserResponse

    @Headers("Content-Type: application/json")
    @PUT("/user/{username}/phone")
    suspend fun updatePhone(
        @Path("username") username: String,
        @Body phone: PhoneRequest
    ): UserResponse

}
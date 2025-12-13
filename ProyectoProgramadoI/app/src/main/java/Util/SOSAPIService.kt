package Util

import Interfaces.IAlertAPIService
import Interfaces.IEContactAPIService
import Interfaces.IUserAPIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SOSAPIService {
    // Example Base URL
    private const val BASE_URL = "https://api-sos-bort.onrender.com"

    val apiUser: IUserAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IUserAPIService::class.java)
    }

    val apiEContact: IEContactAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IEContactAPIService::class.java)
    }

    val apiAlert: IAlertAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IAlertAPIService::class.java)
    }
}
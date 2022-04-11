package com.uni.kelani.mythirdapp.api

import com.uni.kelani.mythirdapp.model.Photos
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PhotoAPIService {

    @GET("photos")
    fun getPhotos(): Call<List<Photos>>

    companion object{
        val API_URL= "https://jsonplaceholder.typicode.com"
        fun create(): PhotoAPIService {
            val retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(PhotoAPIService::class.java)
        }
    }
}
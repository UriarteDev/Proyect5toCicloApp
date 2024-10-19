package com.example.proyect_grupo7.services

import com.example.proyect_grupo7.clases.Helado
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiServicesHelados {

    @GET("/Helados")
    fun findAll(): Call<List<Helado>>

    @POST("/Helados")
    fun saveHelado(@Body bean:Helado):Call<Void>

    @GET("/Helados/{id}")
    fun findById(@Path("cod") codigo:Int): Call<Helado>

    @PUT("/Helados/{id}")
    fun updateHelado(@Body bean:Helado):Call<Void>

    @DELETE("/Helados/{id}")
    fun deleteById(@Path("cod") codigo:Int): Call<Void>

}
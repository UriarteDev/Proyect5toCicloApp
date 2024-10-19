package com.example.proyect_grupo7.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        fun getClient(URL:String): Retrofit {
            val retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }
    }
}
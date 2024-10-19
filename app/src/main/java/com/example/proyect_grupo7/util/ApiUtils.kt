package com.example.proyect_grupo7.util

import com.example.proyect_grupo7.services.ApiServicesHelados

class ApiUtils {
    companion object {
        val BASE_URL="https://clinica-at3l.onrender.com"
        fun getAPIServiceHelados(): ApiServicesHelados {
            return RetrofitClient.getClient(BASE_URL).create(ApiServicesHelados::class.java)
        }
    }
}
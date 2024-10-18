package com.example.proyect_grupo7.util

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class appConfig: Application() {
    companion object{
        //declarar atributos globale
        lateinit var CONTEXTO: Context
    }

    override fun onCreate() {
        //inicializar
        CONTEXTO=applicationContext
        super.onCreate()
    }
}
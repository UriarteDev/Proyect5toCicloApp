package com.example.proyect_grupo7

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyect_grupo7.adapter.Producto1Adapter
import com.example.proyect_grupo7.controller.Producto1Controller
import com.example.proyect_grupo7.util.appConfig

class Producto1Activity : AppCompatActivity() {


    private lateinit var btnAdd:Button
    private lateinit var rvProducto1:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_producto1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        btnAdd=findViewById(R.id.btnAdd)
        rvProducto1=findViewById(R.id.rvProducto1)

        btnAdd.setOnClickListener { navigateToProducto1Add() }

        var adaptador=Producto1Adapter(Producto1Controller().findAll())

        rvProducto1.layoutManager=LinearLayoutManager(this)
        rvProducto1.adapter=adaptador

    }


    private fun navigateToProducto1Add() {
        val  intent = Intent(appConfig.CONTEXTO, Producto1AddActivity::class.java)
        startActivity(intent)
    }
}
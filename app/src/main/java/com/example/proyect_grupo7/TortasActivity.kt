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
import com.example.proyect_grupo7.adapter.TortasAdapter
import com.example.proyect_grupo7.controller.TortasController
import com.example.proyect_grupo7.util.appConfig

class TortasActivity : AppCompatActivity() {


    private lateinit var btnAdd:Button
    private lateinit var rvProducto1:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tortas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        btnAdd=findViewById(R.id.btnAddT)
        rvProducto1=findViewById(R.id.rvTortas)

        btnAdd.setOnClickListener { navigateToProducto1Add() }

        var adaptador=TortasAdapter(TortasController().findAll())

        rvProducto1.layoutManager=LinearLayoutManager(this)
        rvProducto1.adapter=adaptador
    }


    private fun navigateToProducto1Add() {
        val  intent = Intent(appConfig.CONTEXTO, TortasAddActivity::class.java)
        startActivity(intent)
    }
}
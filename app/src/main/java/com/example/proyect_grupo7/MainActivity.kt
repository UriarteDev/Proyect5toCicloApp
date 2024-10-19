package com.example.proyect_grupo7

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnP1 = findViewById<Button>(R.id.Mbtn1)
        val btnP2 = findViewById<Button>(R.id.Mbtn2)
        val btnP3 = findViewById<Button>(R.id.Mbtn3)

        btnP1.setOnClickListener { navigateToProducto1() }
    }

    private fun navigateToProducto1() {
        val  intent = Intent(this, TortasActivity::class.java)
        startActivity(intent)
    }
}
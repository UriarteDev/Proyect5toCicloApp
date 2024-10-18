package com.example.proyect_grupo7

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyect_grupo7.clases.Producto1
import com.example.proyect_grupo7.controller.Producto1Controller
import com.google.android.material.textfield.TextInputEditText

class Producto1AddActivity : AppCompatActivity() {

    private lateinit var txtName:TextInputEditText
    private lateinit var txtStock:TextInputEditText
    private lateinit var txtPrice:TextInputEditText
    private lateinit var btnAdd:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_producto1_add)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponent()
        initListeners()
    }

    private fun initComponent() {
        txtName = findViewById(R.id.txtName)
        txtStock =findViewById(R.id.txtStock)
        txtPrice =findViewById(R.id.txtPrice)
        btnAdd =findViewById(R.id.btnAdd)
    }
    private fun initListeners(){
        btnAdd.setOnClickListener { grabar() }
    }

    private fun grabar() {
        var name=txtName.text.toString()
        var stock=txtStock.text.toString().toInt()
        var price=txtPrice.text.toString().toDouble()

        var bean=Producto1(0,name, stock, price)

        var estado=Producto1Controller().save(bean)
        if(estado > 0)
            showAlert("Producto Registrado")
        else
            showAlert("Error en el registro")
    }

    fun showAlert(men:String){
        val builder= AlertDialog.Builder(this)
        builder.setTitle("SISTEMA")
        builder.setMessage(men)
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog =builder.create()
        dialog.show()
    }
}
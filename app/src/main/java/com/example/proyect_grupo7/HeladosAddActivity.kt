package com.example.proyect_grupo7

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyect_grupo7.clases.Helado
import com.example.proyect_grupo7.services.ApiServicesHelados
import com.example.proyect_grupo7.util.ApiUtils
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeladosAddActivity : AppCompatActivity() {

    private lateinit var txtName: TextInputEditText
    private lateinit var txtStock: TextInputEditText
    private lateinit var txtPrice: TextInputEditText
    private lateinit var btnAdd: Button

    private lateinit var apiServices:ApiServicesHelados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_helados_add)
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
        btnAdd =findViewById(R.id.btnAddH)
        apiServices=ApiUtils.getAPIServiceHelados()
    }
    private fun initListeners(){
        btnAdd.setOnClickListener { grabar() }
    }

    fun grabar(){
        //leer controles
        var nom=txtName.text.toString()
        var stock=txtStock.text.toString().toInt()
        var pre=txtPrice.text.toString().toDouble()
        //crear objeto de la clase Docente
        var m=Helado(0,nom,stock,pre)
        //invocar al metodo saveMedicamento
        apiServices.saveHelado(m).enqueue(object: Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful){
                    showAlert("Helado registrado")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                showAlert(t.localizedMessage)
            }

        })

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
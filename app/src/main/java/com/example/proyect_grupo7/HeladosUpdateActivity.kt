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
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeladosUpdateActivity : AppCompatActivity() {

    var codigo=-1
    private lateinit var txtName: TextInputEditText
    private lateinit var txtStock: TextInputEditText
    private lateinit var txtPrice: TextInputEditText
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button
    private lateinit var apiServices: ApiServicesHelados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_helados_update)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponent()
        initListeners()
        datos()
    }
    private fun initComponent() {
        txtName = findViewById(R.id.txtName)
        txtStock =findViewById(R.id.txtStock)
        txtPrice =findViewById(R.id.txtPrice)
        btnUpdate =findViewById(R.id.btnUpdate)
        btnDelete =findViewById(R.id.btnDelete)
    }
    private fun initListeners(){
        btnUpdate.setOnClickListener { actualizar() }
        btnDelete.setOnClickListener { eliminar() }
    }

    private fun actualizar() {
        var nom=txtName.text.toString()
        var stock=txtStock.text.toString().toInt()
        var pre=txtPrice.text.toString().toDouble()
        var m=Helado(codigo,nom,stock,pre)

        apiServices.updateHelado(m).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful){
                    showAlert("Helado actualizado")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                showAlert(t.localizedMessage)
            }

        })
    }

    fun datos(){
        var bundle=intent.extras!!
        var cod=bundle.getInt("codigo")
        apiServices.findById(cod).enqueue(object :Callback<Helado>{
            override fun onResponse(call: Call<Helado>, response: Response<Helado>) {
                if (response.isSuccessful){
                    var bean=response.body()!!
                    codigo=bean.code
                    txtName.setText(bean.name)
                    txtStock.setText(bean.stock.toString())
                    txtPrice.setText(bean.price.toString())
                }
            }

            override fun onFailure(call: Call<Helado>, t: Throwable) {
                showAlert(t.localizedMessage)
            }
        })
    }

    fun eliminar(){
        apiServices.deleteById(codigo).enqueue(object :Callback<Void>{
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful){
                    showAlert("Helado actualizado")
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
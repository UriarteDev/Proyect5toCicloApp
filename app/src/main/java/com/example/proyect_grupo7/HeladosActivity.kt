package com.example.proyect_grupo7

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyect_grupo7.adapter.HeladoAdapter
import com.example.proyect_grupo7.clases.Helado
import com.example.proyect_grupo7.services.ApiServicesHelados
import com.example.proyect_grupo7.util.ApiUtils
import com.example.proyect_grupo7.util.appConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeladosActivity : AppCompatActivity() {

    private lateinit var btnAddH: Button
    private lateinit var rvHelados: RecyclerView

    private lateinit var apiServices:ApiServicesHelados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_helados)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnAddH=findViewById(R.id.btnAddH)
        rvHelados=findViewById(R.id.rvHelados)

        apiServices=ApiUtils.getAPIServiceHelados()

        btnAddH.setOnClickListener {
            var intent= Intent(this,HeladosAddActivity::class.java)
            startActivity(intent)
        }
    }

    fun listado(){
        //invocar al metodo findAll
        apiServices.findAll().enqueue(object: Callback<List<Helado>> {
            override fun onResponse(
                call: Call<List<Helado>>,
                response: Response<List<Helado>>
            ) {
                if (response.isSuccessful){
                    //obtener la lista de medicamentos
                    var lista =response.body()!!
                    var adaptador=HeladoAdapter(lista)
                    rvHelados.layoutManager= LinearLayoutManager(appConfig.CONTEXTO)
                    rvHelados.adapter=adaptador

                }
            }

            override fun onFailure(call: Call<List<Helado>>, t: Throwable) {
                Toast.makeText(appConfig.CONTEXTO,t.localizedMessage, Toast.LENGTH_LONG).show()
            }
        } )
    }
}
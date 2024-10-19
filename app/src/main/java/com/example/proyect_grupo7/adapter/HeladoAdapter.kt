package com.example.proyect_grupo7.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.proyect_grupo7.HeladosUpdateActivity
import com.example.proyect_grupo7.R
import com.example.proyect_grupo7.clases.Helado
import com.example.proyect_grupo7.util.appConfig
import com.example.proyect_grupo7.vistas.VistaHelados

class HeladoAdapter(var data:List<Helado>):RecyclerView.Adapter<VistaHelados>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaHelados {
        var item= LayoutInflater.from(parent.context).inflate(R.layout.item_producto1,parent,false)
        return VistaHelados(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: VistaHelados, position: Int) {
        //mostrar datos
        holder.tvCode.setText(data.get(position).code.toString())
        holder.tvName.setText(data.get(position).name)
        holder.tvStock.setText(data.get(position).stock.toString())
        holder.tvPrice.setText(" S/. " + data.get(position).price.toString())

        holder.itemView.setOnClickListener {
            var intent=Intent(appConfig.CONTEXTO,HeladosUpdateActivity::class.java)
            //
            intent.putExtra("codigo",data.get(position).code)
            ///
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            ContextCompat.startActivity(appConfig.CONTEXTO,intent,null)
        }
    }

}
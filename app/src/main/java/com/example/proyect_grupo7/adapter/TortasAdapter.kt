package com.example.proyect_grupo7.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyect_grupo7.R
import com.example.proyect_grupo7.clases.Producto1
import com.example.proyect_grupo7.vistas.VistaTortas

class TortasAdapter (var data:ArrayList<Producto1>):RecyclerView.Adapter<VistaTortas>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaTortas {
        var row=LayoutInflater.from(parent.context).inflate(R.layout.item_producto1, parent, false)
        return VistaTortas(row)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: VistaTortas, position: Int) {
        holder.tvCode.setText(data.get(position).code.toString())
        holder.tvName.setText(data.get(position).name)
        holder.tvStock.setText(data.get(position).stock.toString())
        holder.tvPrice.setText(" S/. " + data.get(position).price.toString())
    }
}
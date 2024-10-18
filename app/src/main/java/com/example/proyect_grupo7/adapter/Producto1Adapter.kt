package com.example.proyect_grupo7.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyect_grupo7.R
import com.example.proyect_grupo7.clases.Producto1

class Producto1Adapter (var data:ArrayList<Producto1>):RecyclerView.Adapter<VistaProducto1>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaProducto1 {
        var row=LayoutInflater.from(parent.context).inflate(R.layout.item_producto1, parent, false)
        return VistaProducto1(row)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: VistaProducto1, position: Int) {
        holder.tvCode.setText(data.get(position).code.toString())
        holder.tvName.setText(data.get(position).name)
        holder.tvStock.setText(data.get(position).stock.toString())
        holder.tvPrice.setText(" S/. " + data.get(position).price.toString())
    }

}
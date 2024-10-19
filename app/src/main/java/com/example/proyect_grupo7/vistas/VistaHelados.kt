package com.example.proyect_grupo7.vistas

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyect_grupo7.R

class VistaHelados(item:View):RecyclerView.ViewHolder(item) {
    lateinit var tvCode: TextView
    lateinit var tvName: TextView
    lateinit var tvStock: TextView
    lateinit var tvPrice: TextView

    init {
        tvCode=item.findViewById(R.id.tvCode)
        tvName=item.findViewById(R.id.tvName)
        tvStock=item.findViewById(R.id.tvStock)
        tvPrice=item.findViewById(R.id.tvPrice)
    }
}
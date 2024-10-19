package com.example.proyect_grupo7.controller

import android.content.ContentValues
import com.example.proyect_grupo7.clases.Producto1
import com.example.proyect_grupo7.data.InitDB

class TortasController {

    fun findAll():ArrayList<Producto1>{
        var lista=ArrayList<Producto1>()
        var CN=InitDB().readableDatabase
        var SQL="select * from tb_producto1"
        var RS= CN.rawQuery(SQL,null)

        while (RS.moveToNext()){
            var bean = Producto1(RS.getInt(0), RS.getString(1), RS.getInt(2), RS.getDouble(3))
            lista.add(bean)
        }
        return lista
    }

    fun save(bean:Producto1):Int{
        var salida=-1
        var CN=InitDB().writableDatabase
        var content=ContentValues()

        content.put("name", bean.name)
        content.put("stock", bean.stock)
        content.put("price", bean.price)
        salida=CN.insert("tb_producto1", "cod",content).toInt()
        return salida
    }

}
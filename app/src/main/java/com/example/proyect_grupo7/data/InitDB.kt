package com.example.proyect_grupo7.data

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.proyect_grupo7.util.appConfig

class InitDB:SQLiteOpenHelper(appConfig.CONTEXTO, "tienda1.db",null, 1) {
    override fun onCreate(p0: SQLiteDatabase) {
        p0.execSQL(
            "create table tb_producto1"+
                    "("+
                    "code integer primary key autoincrement,"+
                    "name varchar(30),"+
                    "stock int,"+
                    "price double"+
                    ")"
        )

        //ingresar registro
        p0.execSQL("insert into tb_producto1 values(null,'Ana',25,20.0)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}
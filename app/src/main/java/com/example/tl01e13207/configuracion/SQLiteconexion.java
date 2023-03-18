package com.example.tl01e13207.configuracion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteconexion extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "TLE01_Agenda";
    public static final String TABLA_CONTACTOS = "T_CONTACTOS";

    public SQLiteconexion(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

            {
                //Creacion de objetos de base de datos
                sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_CONTACTOS + "(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "nombre TEXT NOT NULL," +
                        "telefono TEXT NOT NULL," +
                        "nota TEXT NOT NULL)");

            }
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("DROP TABLE  " + TABLA_CONTACTOS);
        onCreate(sqLiteDatabase);
    }
}

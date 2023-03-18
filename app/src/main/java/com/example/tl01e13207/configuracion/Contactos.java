package com.example.tl01e13207.configuracion;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class Contactos extends SQLiteconexion
{
    Context context;

    public Contactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarcontacto(String nombre, String telefono, String nota)
    {
        long id = 0;
        try {
            SQLiteconexion sqLiteconexion = new SQLiteconexion(context);
            SQLiteDatabase db = sqLiteconexion.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("nota", nota);

             id = db.insert(TABLA_CONTACTOS, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}

package com.example.tl01e13207.configuracion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.tl01e13207.tablas.Personas;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

    public ArrayList<Personas> mostrarcontacto(){

        SQLiteconexion sqLiteconexion = new SQLiteconexion(context);
        SQLiteDatabase db = sqLiteconexion.getWritableDatabase();
        ArrayList<Personas> ListaContactos = new ArrayList<>();
        Personas contacto = null;
        Cursor cursorcontacto = null;
        cursorcontacto = db.rawQuery("SELECT * FROM " + TABLA_CONTACTOS, null);

        if (cursorcontacto.moveToFirst()){
            do {
                contacto = new Personas();
                contacto.setId(cursorcontacto.getInt(0));
                contacto.setNombre(cursorcontacto.getString(1));
                contacto.setNumero(cursorcontacto.getString(2));
                contacto.setNota(cursorcontacto.getString(3));
                ListaContactos.add(contacto);
            }while (cursorcontacto.moveToNext());
        }

        cursorcontacto.close();

        return ListaContactos;

    }

}

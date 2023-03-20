package com.example.tl01e13207.configuracion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.tl01e13207.tablas.Personas;

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

        cursorcontacto = db.rawQuery("SELECT * FROM " + TABLA_CONTACTOS + " ORDER BY nombre ASC", null);

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

    public Personas verContacto(int id) {

        SQLiteconexion dbHelper = new SQLiteconexion(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Personas contacto = null;
        Cursor cursorContactos;

        cursorContactos = db.rawQuery("SELECT * FROM " + TABLA_CONTACTOS + " WHERE id = " + id + " LIMIT 1", null);

        if (cursorContactos.moveToFirst()) {
            contacto = new Personas();
            contacto.setId(cursorContactos.getInt(0));
            contacto.setNombre(cursorContactos.getString(1));
            contacto.setNumero(cursorContactos.getString(2));
            contacto.setNota(cursorContactos.getString(3));
        }

        cursorContactos.close();

        return contacto;
    }

    public boolean editarContacto(int id, String nombre, String telefono, String nota) {

        boolean correcto = false;

        SQLiteconexion dbHelper = new SQLiteconexion(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("UPDATE " + TABLA_CONTACTOS + " SET nombre = '" + nombre + "', telefono = '" + telefono + "', nota = '" + nota + "' WHERE id='" + id + "' ");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }

    public boolean eliminarContacto(int id) {

        boolean correcto = false;

        SQLiteconexion dbHelper = new SQLiteconexion(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM " + TABLA_CONTACTOS + " WHERE id = '" + id + "'");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }

}

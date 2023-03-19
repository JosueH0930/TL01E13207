package com.example.tl01e13207;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tl01e13207.configuracion.SQLiteconexion;

import java.sql.SQLData;

public class Inicio extends AppCompatActivity {

    Button BtnIngresar, BtnLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        BtnLista = findViewById(R.id.BtnLista);
        BtnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Inicio.this,Lista.class));
            }
        });

        BtnIngresar = findViewById(R.id.BtnIngresar);
        BtnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*SQLiteconexion Sqliteconexion = new SQLiteconexion(Inicio.this);
                SQLiteDatabase DataBase = Sqliteconexion.getWritableDatabase();*/
                startActivity(new Intent(Inicio.this,MainActivity.class));

            }
        });

    }
}
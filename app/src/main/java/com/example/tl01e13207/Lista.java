package com.example.tl01e13207;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tl01e13207.configuracion.Contactos;
import com.example.tl01e13207.configuracion.ListaContactosAdapter;
import com.example.tl01e13207.tablas.Personas;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {

    RecyclerView listacontactos;
    ArrayList<Contactos> listaarraycontactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listacontactos = findViewById(R.id.RVListaContacto);
        listacontactos.setLayoutManager(new LinearLayoutManager(this));
        Contactos dbcontactos = new Contactos(Lista.this);

        listaarraycontactos = new ArrayList<>();
        ListaContactosAdapter adapter = new ListaContactosAdapter(dbcontactos.mostrarcontacto());
        listacontactos.setAdapter(adapter);

    }
}
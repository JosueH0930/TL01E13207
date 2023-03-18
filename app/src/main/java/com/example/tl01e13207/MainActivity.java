package com.example.tl01e13207;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tl01e13207.configuracion.Contactos;

public class MainActivity extends AppCompatActivity {

    EditText txtnombre, texttelefono, txtnota;
    Button btnagregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombre = findViewById(R.id.Txtnombre);
        texttelefono = findViewById(R.id.Texttelefono);
        txtnota = findViewById(R.id.Textnota);

        btnagregar = findViewById(R.id.BtnAgregar);
        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contactos dbcontactos = new Contactos(MainActivity.this);
                long id = dbcontactos.insertarcontacto(txtnombre.getText().toString(), texttelefono.getText().toString(), txtnota.getText().toString());
                limpiar();

                if(id>0){
                    Toast.makeText(MainActivity.this, "Registro Guardado", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Error al guardar el registro", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    private void limpiar(){
        txtnombre.setText("");
        texttelefono.setText("");
        txtnota.setText("");

    }
}
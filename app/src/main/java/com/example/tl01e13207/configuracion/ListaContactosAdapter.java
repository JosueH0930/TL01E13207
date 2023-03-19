package com.example.tl01e13207.configuracion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tl01e13207.R;
import com.example.tl01e13207.tablas.Personas;

import java.util.ArrayList;

public class ListaContactosAdapter extends RecyclerView.Adapter<ListaContactosAdapter.ContactoViewHolder> {

    ArrayList<Personas> listacontactos;
    public ListaContactosAdapter(ArrayList<Personas> listacontactos){
        this.listacontactos = listacontactos;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_contacto,null, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {

        holder.viewNombre.setText(listacontactos.get(position).getNombre());
        holder.viewTelefono.setText(listacontactos.get(position).getNumero());
        holder.viewNota.setText(listacontactos.get(position).getNota());

    }

    @Override
    public int getItemCount() {
        return listacontactos.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewTelefono, viewNota;
        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.Viewnombre);
            viewTelefono = itemView.findViewById(R.id.Viewtelefono);
            viewNota = itemView.findViewById(R.id.Viewnota);
        }
    }
}

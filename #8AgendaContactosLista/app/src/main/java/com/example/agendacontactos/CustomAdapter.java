package com.example.agendacontactos;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<Contacto> list_contactos;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_nombre;
        private final TextView tv_apellidos;
        private final TextView tv_telefono;

        public ViewHolder(View view) {
            super(view);
            tv_nombre = (TextView) view.findViewById(R.id.tv_nombre);
            tv_apellidos = (TextView) view.findViewById(R.id.tv_apellidos);
            tv_telefono = (TextView) view.findViewById(R.id.tv_telefono);
        }
    }

    public CustomAdapter(ArrayList<Contacto> list_contactos) {
        this.list_contactos = list_contactos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_row, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.tv_nombre.setText(list_contactos.get(position).getNombre());
        viewHolder.tv_apellidos.setText(list_contactos.get(position).getApellidos());
        viewHolder.tv_telefono.setText(list_contactos.get(position).getTelefono());
    }

    @Override
    public int getItemCount() {
        return list_contactos.size();
    }
}


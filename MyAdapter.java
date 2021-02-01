package com.example.agendamovil;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {


    private List<Contacto> lista_contactos;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vista_contacto, parent, false);

        // set the view's size, margins, paddings and layout parameters

        MyViewHolder vh = new MyViewHolder(v);//Le paso la vista
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Contacto contacto=lista_contactos.get(position);


        holder.tv_nombre.setText(contacto.getNombre());
        holder.tv_telefono.setText(contacto.getTelefono());

    }

    public MyAdapter(List<Contacto> lista_contactos) {
        this.lista_contactos=lista_contactos;
    }



    @Override
    public int getItemCount() {
        return lista_contactos.size();
    }


}

package com.example.agendamovil;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView tv_nombre;
    TextView tv_telefono;
    Button btn_llamar;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_nombre=itemView.findViewById(R.id.tv_nombre);
        tv_telefono=itemView.findViewById(R.id.tv_telefono);
        btn_llamar=itemView.findViewById(R.id.btn_llamar);


    }

    @Override
    public void onClick(View v) {
        Log.v("DESDE MiViewHolder:",String.valueOf(getAdapterPosition()));
    }
}
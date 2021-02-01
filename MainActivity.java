package com.example.agendamovil;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Button btn_grabar;
Button btn_mostrar;
Button btn_volver;
Button btn_llamar;
EditText et_nombre;
EditText et_telefono;
String nombre="";
String telefono="";
RecyclerView rv_contactos;
List<Contacto> lista_contactos;
Context contexto=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_grabar=findViewById(R.id.btn_grabar);
        btn_mostrar=findViewById(R.id.btn_mostrar);
        et_nombre=findViewById(R.id.et_nombre);
        et_telefono=findViewById(R.id.et_telefono);



        btn_grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre=et_nombre.getText().toString();
                telefono=et_telefono.getText().toString();
                Thread hilo=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        accesoBD(nombre,telefono);
                    }
                });
                hilo.start();
            }
        });

        btn_mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread hilo=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        recuperarContacto();
                    }
                });

                hilo.start();
                setContentView(R.layout.activity_vista);
                btn_volver=findViewById(R.id.btn_volver);
                rv_contactos=findViewById(R.id.rv_contactos);
                rv_contactos.setLayoutManager(new LinearLayoutManager(contexto));
                MyAdapter adaptador=new MyAdapter(lista_contactos);
                rv_contactos.setAdapter(adaptador);





            }
        });






    }

    private void recuperarContacto() {
        MiDataBase db= Room.databaseBuilder(this,MiDataBase.class,"bd_contactos").build();
        DAOContacto miDAO=db.devolverDAO();
        lista_contactos=miDAO.devolverContactos();

    }

    public void accesoBD(String nombre,String telefono){
        MiDataBase db= Room.databaseBuilder(this,MiDataBase.class,"bd_contactos").build();
        DAOContacto miDAO=db.devolverDAO();
        Contacto c=new Contacto(nombre,telefono);
        miDAO.grabarContacto(c);

        Log.d("contactos",lista_contactos.toString());
    }
}
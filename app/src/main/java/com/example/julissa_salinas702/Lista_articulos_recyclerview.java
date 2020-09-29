package com.example.julissa_salinas702;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import entidades.ConexionSQLite;

public class Lista_articulos_recyclerview extends AppCompatActivity {
    private RecyclerView recycler;
    private AdaptadorArticulos adaptadorArticulos;
    ConexionSQLite datos = new ConexionSQLite(Lista_articulos_recyclerview.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_articulos_recyclerview);
        recycler = (RecyclerView)findViewById(R.id.rview);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adaptadorArticulos = new AdaptadorArticulos(Lista_articulos_recyclerview.this,
                datos.mostrarArticulos());
        recycler.setAdapter(adaptadorArticulos);
    }
}
package com.example.julissa_salinas702;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.getbase.floatingactionbutton.FloatingActionButton;

import entidades.ConexionSQLite;
import entidades.DTO;

public class activity_consulta extends AppCompatActivity {
    private Spinner espin;
    private TextView cod,dec,sueño;
    ConexionSQLite conexion = new ConexionSQLite(this);
    DTO dato = new DTO();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        //menu
        FloatingActionButton fab1 = findViewById(R.id.uno);
        FloatingActionButton fab2 = findViewById(R.id.dos);
        FloatingActionButton fab3 = findViewById(R.id.tres);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity_consulta.this,"salir ",Toast.LENGTH_SHORT).show();
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity_consulta.this,"autor",Toast.LENGTH_SHORT).show();
            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity_consulta.this,"retornar",Toast.LENGTH_SHORT).show();
            }
        });
        //menu final
        espin = (Spinner)findViewById(R.id.spinn);
        cod = (TextView) findViewById(R.id.codg);
        dec = (TextView) findViewById(R.id.descripc);
        sueño = (TextView) findViewById(R.id.pin);
        conexion.consultarListaArticulos();
        ArrayAdapter<CharSequence> adap = new ArrayAdapter(this,android.R.layout.simple_spinner_item,conexion.obtenerListaArticulos());
        espin.setAdapter(adap);
        espin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0) {
                    cod.setText("Codigo: "+conexion.consultarListaArticulos().get(i-1).getCodigo());
                    dec.setText("Descripcion: "+conexion.consultarListaArticulos().get(i-1).getDescripcion());
                    sueño.setText("Precio: "+conexion.consultarListaArticulos().get(i-1).getPrecio());
                }else
                    {
                    cod.setText("El Codigo esta Vacio");
                    dec.setText("Descripción esta Vacio");
                        sueño.setText("Precio esta Vacio");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
package com.example.julissa_salinas702;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;
import androidx.annotation.RequiresApi;
import entidades.ConexionSQLite;
import entidades.DTO;
import modal.Modal;

public class MainActivity extends AppCompatActivity {
    private EditText codju,descrips,prex;
    private Button btnguar,btncodit,btndescrit,btnmodif,btnat;
    private TextView result;
    boolean inputET = false;
    boolean inputED = false;
    boolean input1 = false;
    int resultInsert = 0;

   Modal ventanas = new Modal();
    ConexionSQLite conexion = new ConexionSQLite(this);
    DTO dato = new DTO();
    AlertDialog.Builder adios;

    public boolean onKeyDown(int KeyCode, KeyEvent event){
        if (KeyCode == KeyEvent.KEYCODE_BACK){
            new android.app.AlertDialog.Builder(this)
                    .setIcon(R.drawable.cancel)
                    .setTitle("CERRAR")
                    .setMessage("¿Desea salir?")
                    .setNegativeButton(android.R.string.cancel,null)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finishAffinity();
                        }
                    })
                    .show();
            return true;
        }
        return  super.onKeyDown(KeyCode,event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.bacl));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setTitleMargin(0,0,0,0);
        toolbar.setSubtitle("Julissa Esmeralda Salinas Melendez");
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.white));
        toolbar.setTitle("CRUD SQLite");
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comfirmacion();
            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ventanas.Search(MainActivity.this);
            }
        });
        codju = (EditText) findViewById(R.id.inc1);
        descrips = (EditText) findViewById(R.id.descp);
        prex= (EditText) findViewById(R.id.prei);
        btncodit = (Button) findViewById(R.id.btncog);
        btndescrit = (Button) findViewById(R.id.btndescripcn);
        btnguar = (Button) findViewById(R.id.btnguar);
        btnmodif = (Button) findViewById(R.id.btnmodif);
        btnat = (Button) findViewById(R.id.btnbor);
        String res = "";
        String codigo = "";
        String desc = "";
        String precio = "";
        try {
            Bundle bun = getIntent().getExtras();
            if (bun != null){
               String a = (String) bun.get("codigo");
                String b = (String) bun.get("descr");
                String c = (String) bun.get("codigo");
                res = bun.getString("yes");
                desc = bun.getString("yes");
                precio = bun.getString("yes");
                codju.setText(a);
                descrips.setText(b);
                prex.setText(c);
            }
        }catch (Exception o){
        }


    }

    private void comfirmacion(){
        String msm = "¿Desea Salir?";
        adios = new AlertDialog.Builder(MainActivity.this);
        adios.setIcon(R.drawable.cancel);
        adios.setTitle("Advertencia");
        adios.setMessage(msm);
        adios.setCancelable(false);
        adios.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });
        adios.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        adios.show();
    }
    public void limpiardat(){
        codju.setText(null);
        descrips.setText(null);
        prex.setText(null);
    }
    public void limpiardat2(View view){
        codju.setText(null);
        descrips.setText(null);
        prex.setText(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }else if (id == R.id.action_listaArt){
            Intent spinnerAct = new Intent(MainActivity.this,activity_consulta.class);
            startActivity(spinnerAct);
            return true;
        }else if (id == R.id.action_listaArt1){
            Intent listVAct = new Intent(MainActivity.this,listview_articulos.class);
            startActivity(listVAct);
            return  true;

        }else if(id == R.id.menu_5){
            Intent Recycler = new Intent(MainActivity.this, Lista_articulos_recyclerview.class);
            startActivity(Recycler);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    public void guardar (View view){
        if (codju.getText().toString().length()== 0){
            codju.setError("rellene el campo");
            inputET = false;
        }else {
            inputET = true;
        }
        if (descrips.getText().toString().length()==0){
            descrips.setError("rellene el campo");
            inputED = false;
        }else {
            inputED = true;
        }
        if (prex.getText().toString().length()== 0){
            prex.setError("rellene el campo");
            input1 = false;
        }else{
            input1 = true;
        }
        if (inputET && inputED && input1){
            try {
                dato.setCodigo(Integer.parseInt(codju.getText().toString()));
                dato.setDescripcion(descrips.getText().toString());
                dato.setPrecio(Double.parseDouble(prex.getText().toString()));
                if (conexion.InsertTradicional(dato)){
                    Toast.makeText(this,"se guardo correctamente",Toast.LENGTH_SHORT).show();
                    limpiardat();
                }else {
                    Toast.makeText(this,"Ya existen los datos"+codju.getText().toString(),Toast.LENGTH_LONG).show();
                }
            }catch (Exception o){
                Toast.makeText(this,"Existe un error",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public  void mensaje(String msm){
        Toast.makeText(this," "+msm,Toast.LENGTH_SHORT).show();
    }
    public  void consultcod (View view){
        if (codju.getText().toString().length()== 0){
            codju.setError("rellene el campo");
            inputET = false;
        }else {
            inputET = true;
        }
        if (inputET){
            String codigo = codju.getText().toString();
            dato.setCodigo(Integer.parseInt(codigo));
            if (conexion.consultArt(dato)){
                descrips.setText(dato.getDescripcion());
                prex.setText(""+dato.getPrecio());
            }else{
                Toast.makeText(this,"El producto no existe",Toast.LENGTH_SHORT).show();
                limpiardat();
            }
        }else{
            Toast.makeText(this,"Ingrese el producto",Toast.LENGTH_SHORT).show();
        }
    }
    public  void consuldesc (View view){
        if (descrips.getText().toString().length()== 0){
            descrips.setError("rellene el campo");
            inputED = false;
        }else {
            inputED = true;
        }
        if (inputED){
            String desc = descrips.getText().toString();
            dato.setDescripcion(desc);
            if (conexion.cosultDesc(dato)){
                codju.setText(""+dato.getCodigo());
                descrips.setText(dato.getDescripcion());
                prex.setText(""+dato.getPrecio());
            }else {
                Toast.makeText(this,"El producto no existe",Toast.LENGTH_SHORT).show();
                limpiardat();
            }
        }else {
            Toast.makeText(this,"ingrese la descriccion de su producto",Toast.LENGTH_SHORT).show();
        }
    }
    public  void bajacod(View view){
        if (codju.getText().toString().length()== 0){
            codju.setError("rellene el campo");
            inputET = false;
        }else {
            inputET = true;
        }
        if (inputET){
            String codj =codju.getText().toString();
            dato.setCodigo(Integer.parseInt(codj));
            if (conexion.delCod(MainActivity.this,dato)){
                limpiardat();
            }else {
                Toast.makeText(this,"Ingrese el articulo ",Toast.LENGTH_SHORT).show();
                limpiardat();
            }
        }
    }
    public void modi (View view){
        if (codju.getText().toString().length()== 0){
            codju.setError("rellene el campo");
            inputET = false;
        }else {
            inputET = true;
        }
        if (inputET){
            String cod = codju.getText().toString();
            String desc = descrips.getText().toString();
            double precio = Double.parseDouble(prex.getText().toString());
            dato.setCodigo(Integer.parseInt(cod));
            dato.setDescripcion(desc);
            dato.setPrecio(precio);
            if (conexion.mod(dato)){
                Toast.makeText(this,"exitosamente Editado",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"No se puede modificar su articulo no existe",Toast.LENGTH_SHORT).show();

            }
        }
    }
}
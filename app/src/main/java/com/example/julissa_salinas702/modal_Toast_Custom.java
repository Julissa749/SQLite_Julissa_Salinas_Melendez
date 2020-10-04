package com.example.julissa_salinas702;

import android.app.AlertDialog;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class modal_Toast_Custom extends AppCompatActivity{
    Dialog myDialog;
    androidx.appcompat.app.AlertDialog.Builder dialogo;
    AlertDialog.Builder dialogo1;

    public void julissa (final Context context){
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.ventana1);
        myDialog.setTitle("Modal");
        myDialog.setCancelable(false);

        final EditText et_cod = (EditText)myDialog.findViewById(R.id.edbusc);
        Button btn_buscar = (Button)myDialog.findViewById(R.id.busc);
        ImageButton tv_close = (ImageButton) myDialog.findViewById(R.id.cancelbusc);
        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Mensaje personalizado Modal", Toast.LENGTH_SHORT).show();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }



    public void modaltareita (final Context context){
        String mensaje = "¿Clic en Aceptar para Confirmar Accion?";
        dialogo = new androidx.appcompat.app.AlertDialog.Builder(context);
        dialogo.setIcon(R.drawable.ic_baseline_delete_24);
        dialogo.setTitle("adios");
        dialogo.setMessage(mensaje);
        dialogo.setCancelable(true);

        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo, int id) {
                Toast.makeText(context, "Clic Aceptar.", Toast.LENGTH_LONG).show();
            }
        });

        dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo, int id) {
                Toast.makeText(context, "Clic Cancelar.", Toast.LENGTH_LONG).show();
            }
        });
        dialogo.show();
    }
    public void tareita1 (final Context context) {
        new androidx.appcompat.app.AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Warning")
                .setMessage("¿Clic en Aceptar para Confirmar Accion?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Clic en Boton SI.", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Clic en Boton NO.", Toast.LENGTH_LONG).show();
                        finish();
                    }
                })
                .show();
    }

    public void tareita2 (final Context context){

        new AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Salir")
                .setMessage("¿Esta seguro?\n\nClic para confirmar")
                .setNegativeButton(android.R.string.cancel, null)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {//un listener que al pulsar, cierre la aplicacion
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "chi...", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                })
                .show();
    }
    public void tengomuchosueño(final Context context){

        dialogo1 = new AlertDialog.Builder(context);
        dialogo1.setIcon(android.R.drawable.ic_dialog_alert);
        dialogo1.setTitle("INFORMACION");
        dialogo1.setMessage("Contenido del mensaje");
        dialogo1.setCancelable(false);

        dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo, int id) {
                Toast toast = Toast.makeText(getApplicationContext(), "Aceptado.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo, int id) {
                Toast toast = Toast.makeText(getApplicationContext(), "Cancelado.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
        dialogo1.show();
    }

    public void tareita3 (final Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.drawable.ic_error);
        builder.setMessage(getString(R.string.mensaje));
        builder.setCancelable(false);
        builder.setNeutralButton(R.string.ok, null);
        builder.setTitle(getString(R.string.error));
        builder.create().show();
    }
    public void tareas1 (final Context context) {
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.confirmcustom);
        ImageView ivClose = (ImageView)myDialog.findViewById(R.id.ivClose);
        Button btnAccept = (Button)myDialog.findViewById(R.id.btnAccept);

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clic en Aceptar.", Toast.LENGTH_SHORT).show();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void tareas2 (final Context context) {

        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.confirmcustom1);
        myDialog.setCancelable(false);

        ImageView ivClose = (ImageView)myDialog.findViewById(R.id.ivClose);
        Button btnAccept = (Button)myDialog.findViewById(R.id.btnAccept);
        Button btnCancel = myDialog.findViewById(R.id.btnCancel);
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void dialogAbout(final Context context) {
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.dialog_autor);
        myDialog.setCancelable(false);
        ImageView BtnCerrarAutor = myDialog.findViewById(R.id.BtnCerrarAutor);
        BtnCerrarAutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void tareas(final Context context) {
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.modalogin);
        myDialog.setCancelable(false);
        final EditText etEmail = myDialog.findViewById(R.id.etEmail);
        final EditText etPassword = myDialog.findViewById(R.id.etPassword);
        Button btnAccept = myDialog.findViewById(R.id.btnAccept);
        ImageView BtnCerrar = myDialog.findViewById(R.id.BtnCerrar);
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dato1 = etEmail.getText().toString();
                String dato2 = etPassword.getText().toString();
                Toast toast = Toast.makeText(context, "Datos: \n" + dato1 + "\n"+dato2, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });

        BtnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}
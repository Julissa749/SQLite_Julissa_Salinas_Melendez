package com.example.julissa_salinas702;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
//import com.example.julissa_salinas702.entidades.DTO;
//ya no aguanto tengo sueño
import  entidades.DTO;
public class activity_detalle_articulos extends AppCompatActivity {
    private TextView codg, descr, ins;
    private TextView codg1,desc1,mas1, fecha1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_articulos);
        codg = (TextView) findViewById(R.id.tv_cod);
        descr = (TextView) findViewById(R.id.tv_desc);
        ins = (TextView) findViewById(R.id.tv_precio);
        codg1 = (TextView) findViewById(R.id.tv_cod);
        desc1 = (TextView) findViewById(R.id.tv_desc1);
        mas1 = (TextView) findViewById(R.id.tv_precioc1);
        fecha1 = (TextView) findViewById(R.id.tv_fecha);
        Bundle obj = getIntent().getExtras();
        DTO dto = null;
        if (obj != null){
            dto = (DTO) obj.getSerializable("articulo");
            codg.setText(""+dto.getCodigo());
            descr.setText(dto.getDescripcion());
            ins.setText(""+dto.getPrecio());

            codg1.setText(""+dto.getCodigo());
            desc1.setText(dto.getDescripcion());
            mas1.setText(String.valueOf(dto.getPrecio()));
            fecha1.setText("Fecha: "+getDateTime());
        }
    }
    private String getDateTime(){
        SimpleDateFormat dates = new SimpleDateFormat(
                "yyyy-MM-dd-HH:mm:ss a", Locale.getDefault());
        Date day = new Date();
        return dates.format(day);
    }
    public  void  vol (View view){
        onBackPressed();
    }
}

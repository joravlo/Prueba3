package com.example.jordi.prueba3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Pantalla3 extends AppCompatActivity {
    private TextView textView3,textView4,textView5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);

        ImageView imageView = (ImageView)findViewById(R.id.imageView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
        textView5 = (TextView)findViewById(R.id.textView5);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            String datoNombre = (String)bundle.get("NOMBRE");
            String datoGenero = (String)bundle.get("GENERO");
            Integer datonumero = (Integer)bundle.get("NUMERO");
            textView3.setText(datoNombre);
            textView4.setText(datoGenero);
            textView5.setText(datonumero+"");

            if(datoGenero.equals("Hombre")){
                imageView.setImageResource(R.mipmap.hombre);
            }else{
                imageView.setImageResource(R.mipmap.mujer);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.opcion2) {

        }
        if (id == R.id.opcion3) {

        }
        return super.onOptionsItemSelected(item);
    }
}

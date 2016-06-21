package com.example.jordi.prueba3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pantalla3 extends AppCompatActivity {
    private TextView textView3,textView4,textView5;
    String datoNombre;
    String datoGenero;
    Integer datonumero;
    Pantalla2 p2;


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
             datoNombre = (String)bundle.get("NOMBRE");
             datoGenero = (String)bundle.get("GENERO");
             datonumero = (Integer)bundle.get("NUMERO");
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
            dialogModificarContacto();
        }
        if (id == R.id.opcion3) {

        }
        return super.onOptionsItemSelected(item);
    }

    public void dialogModificarContacto() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog, null);

        final EditText editNombre = (EditText) v.findViewById(R.id.editNombre);
        final EditText editNumero = (EditText) v.findViewById(R.id.editNumero);
        final RadioButton radioButtonHombre = (RadioButton) v.findViewById(R.id.radioButtonHombre);
        RadioButton radioButtonMujer = (RadioButton) v.findViewById(R.id.radioButtonMujer);

        editNombre.setText(datoNombre);
        editNumero.setText(datonumero+"");
        if(datoGenero.equals("Hombre")){
            radioButtonHombre.setSelected(true);
        }else{
            radioButtonMujer.setSelected(true);
        }

        builder.setView(v).setPositiveButton("Enviar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (!editNombre.getText().toString().isEmpty() && !editNumero.getText().toString().isEmpty()) {
                    if(radioButtonHombre.isChecked()==true){

                        int numero = Integer.parseInt(editNumero.getText().toString());
                        p2.getListapersonas().add(new Persona(editNombre.getText().toString(),"Hombre",numero));

                    }else {

                        int numero = Integer.parseInt(editNumero.getText().toString());
                       p2.getListapersonas().add(new Persona(editNombre.getText().toString(),"Mujer",numero));
                    }
                }else {
                    Toast.makeText(Pantalla3.this, "Faltan campos por rellenar", Toast.LENGTH_LONG).show();
                }
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });


        AlertDialog alert = builder.create();
        alert.show();


    }
}

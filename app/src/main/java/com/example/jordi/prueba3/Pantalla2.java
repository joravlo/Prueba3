package com.example.jordi.prueba3;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pantalla2 extends AppCompatActivity {
    private ArrayList<Persona> listapersonas;
    ArrayList<Persona> array_busqueda = new ArrayList<Persona>();
    AdaptadorPersonas adaptador;


    public ArrayList<Persona> getListapersonas() {
        return listapersonas;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        listapersonas = new ArrayList<Persona>();
        listapersonas.add(new Persona("Juan", "Hombre", 99192912));
        listapersonas.add(new Persona("pedro", "Hombre", 99122912));
        listapersonas.add(new Persona("luis", "Hombre", 92192912));
        listapersonas.add(new Persona("ana", "Mujer", 32192912));
        listapersonas.add(new Persona("carla", "Mujer", 62192912));
        listapersonas.add(new Persona("maria", "Mujer", 12192912));
        listapersonas.add(new Persona("gustavo", "Hombre", 92192111));
        listapersonas.add(new Persona("carlos", "Mujer", 32112912));
        listapersonas.add(new Persona("marta", "Mujer", 43192912));
        listapersonas.add(new Persona("luisa", "Mujer", 72192912));
        listapersonas.add(new Persona("fernanda", "Mujer", 1292912));
        listapersonas.add(new Persona("jose", "Hombre", 21192912));


        adaptador = new AdaptadorPersonas(this, listapersonas);
        final ListView lv1 = (ListView) findViewById(R.id.listView);
        lv1.setTextFilterEnabled(true);
        lv1.setAdapter(adaptador);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Pantalla2.this, Pantalla3.class);
                i.putExtra("NOMBRE", listapersonas.get(position).getNombre());
                i.putExtra("GENERO", listapersonas.get(position).getGenero());
                i.putExtra("NUMERO", listapersonas.get(position).getNumero());
                startActivity(i);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.opcion1) {
            dialogCrearContacto();
        }
        return super.onOptionsItemSelected(item);
    }

    public void dialogCrearContacto() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog, null);

        final EditText editNombre = (EditText) v.findViewById(R.id.editNombre);
        final EditText editNumero = (EditText) v.findViewById(R.id.editNumero);
        final RadioButton radioButtonHombre = (RadioButton) v.findViewById(R.id.radioButtonHombre);
        RadioButton radioButtonMujer = (RadioButton) v.findViewById(R.id.radioButtonMujer);

        builder.setView(v).setPositiveButton("Enviar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (!editNombre.getText().toString().isEmpty() && !editNumero.getText().toString().isEmpty()) {
                    if(radioButtonHombre.isChecked()==true){
                        int numero = Integer.parseInt(editNumero.getText().toString());
                        listapersonas.add(new Persona(editNombre.getText().toString(),"Hombre",numero));
                    }else {
                        int numero = Integer.parseInt(editNumero.getText().toString());
                        listapersonas.add(new Persona(editNombre.getText().toString(),"Mujer",numero));
                    }
                }else {
                    Toast.makeText(Pantalla2.this, "Faltan campos por rellenar", Toast.LENGTH_LONG).show();
                }
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });


        AlertDialog alert = builder.create();
        alert.getWindow().getAttributes().windowAnimations= R.style.DialogAnimation;
        alert.show();


    }
}

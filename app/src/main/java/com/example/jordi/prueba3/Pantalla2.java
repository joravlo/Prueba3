package com.example.jordi.prueba3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pantalla2 extends AppCompatActivity {
    private ArrayList<Persona> listapersonas;
    AdaptadorPersonas adaptador;
    private ArrayList<Persona> array_sort = new ArrayList<Persona>();
    private EditText editText;
    int textlenght = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        listapersonas = new ArrayList<Persona>();
        listapersonas.add(new Persona("Juan", "Hombre",99192912));
        listapersonas.add(new Persona("pedro","Hombre",99122912));
        listapersonas.add(new Persona("luis","Hombre",92192912));
        listapersonas.add(new Persona("ana","Mujer",32192912));
        listapersonas.add(new Persona("carla","Mujer",62192912));
        listapersonas.add(new Persona("maria","Mujer",12192912));
        listapersonas.add(new Persona("gustavo","Hombre",92192111));
        listapersonas.add(new Persona("carlos","Mujer",32112912));
        listapersonas.add(new Persona("marta","Mujer",43192912));
        listapersonas.add(new Persona("luisa","Mujer",72192912));
        listapersonas.add(new Persona("fernanda","Mujer",1292912));
        listapersonas.add(new Persona("jose","Hombre",21192912));

        final EditText editText = (EditText)findViewById(R.id.editText);
         adaptador = new AdaptadorPersonas(this, listapersonas);
        final ListView lv1 = (ListView)findViewById(R.id.listView);
        lv1.setTextFilterEnabled(true);
        lv1.setAdapter(adaptador);
        //comentario

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Pantalla2.this, Pantalla3.class);
                i.putExtra("NOMBRE",listapersonas.get(position).getNombre());
                i.putExtra("GENERO",listapersonas.get(position).getGenero());
                i.putExtra("NUMERO",listapersonas.get(position).getNumero());
                startActivity(i);
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               Pantalla2.this.adaptador.getFilter().filter(s);
                /* textlenght = editText.getText().length();
                array_sort.clear();

                for(int i=0;i<listapersonas.size();i++){
                    if(textlenght <= listapersonas.get(i).getNombre().length()){
                        if (editText.getText().toString().equalsIgnoreCase((String) listapersonas.get(i).getNombre().subSequence(0,textlenght))){
                            array_sort.add(listapersonas.get(i));
                        }
                    }
                }
                AdaptadorPersonas adaptador2 = new AdaptadorPersonas(this, array_sort);
                lv1.setAdapter(adaptador2);*/
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.opcion1) {
            Toast.makeText(this,"Se seleccionó la primer opción",Toast.LENGTH_LONG).show();
        }
        if (id==R.id.opcion2) {
            Toast.makeText(this,"Se seleccionó la segunda opción",Toast.LENGTH_LONG).show();
        }
        if (id==R.id.opcion3) {
            Toast.makeText(this,"Se seleccionó la tercer opción",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}

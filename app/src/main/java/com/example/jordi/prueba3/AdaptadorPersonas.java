package com.example.jordi.prueba3;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jordi on 17/06/2016.
 */
public class AdaptadorPersonas extends ArrayAdapter<Persona> {
    AppCompatActivity appCompatActivity;
    private ArrayList<Persona> listapersonas;

    public AdaptadorPersonas(AppCompatActivity context, ArrayList<Persona> listapersonas){
        super(context, R.layout.persona, listapersonas);
        appCompatActivity = context;
        this.listapersonas = listapersonas;
    }

    public View getView(int posicion, View convertview, ViewGroup parent) {
        LayoutInflater inflater = appCompatActivity.getLayoutInflater();
        View item = inflater.inflate(R.layout.persona, null);

        TextView textView = (TextView) item.findViewById(R.id.textView2);
        textView.setText(listapersonas.get(posicion).getNombre());

        ImageView imageView = (ImageView) item.findViewById(R.id.imageView);
        if (listapersonas.get(posicion).getGenero().equals("Hombre")) {
            imageView.setImageResource(R.mipmap.hombre);
        } else {
            imageView.setImageResource(R.mipmap.mujer);
        }
        return (item);
    }
}

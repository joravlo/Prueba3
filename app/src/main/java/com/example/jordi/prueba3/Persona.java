package com.example.jordi.prueba3;

/**
 * Created by Jordi on 16/06/2016.
 */
public class Persona {
    private String nombre,genero;
    private int numero;

    public Persona(String nombre, String genero, int numero){
        this.nombre=nombre;
        this.genero=genero;
        this.numero=numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public int getNumero() {
        return numero;
    }
}

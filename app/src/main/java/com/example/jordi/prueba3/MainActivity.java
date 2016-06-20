package com.example.jordi.prueba3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usu, con;
    Button ingresar;
    String pass = "1234";
    String user = "usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usu = (EditText) findViewById(R.id.usuario);
        con = (EditText) findViewById(R.id.contrasena);
        ingresar = (Button) findViewById(R.id.button);
        pulsado();
    }

    private void pulsado() {
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = usu.getText().toString();
                String contrasena = con.getText().toString();

                if (usuario.equals(user) && contrasena.equals(pass)) {
                    Intent i = new Intent(MainActivity.this, Pantalla2.class);
                    startActivity(i);
                    finish();

                } else {
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}

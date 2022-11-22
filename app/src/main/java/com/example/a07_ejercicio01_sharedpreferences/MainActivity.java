package com.example.a07_ejercicio01_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtCorreo;
    private EditText txtPassword;
    private Button btnCrear;

    private SharedPreferences sharedPreferencesUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCorreo = findViewById(R.id.txtCorreoMain);
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnCrear = findViewById(R.id.btnCrear);

        sharedPreferencesUsuarios = getSharedPreferences(Constantes.USUARIO, MODE_PRIVATE);
        cargarDatos();

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = txtCorreo.getText().toString();
                String password = txtPassword.getText().toString();

                SharedPreferences.Editor editor = sharedPreferencesUsuarios.edit();
                editor.putString(Constantes.CORREOUSUARIO, correo);
                editor.putString(Constantes.PASSWORD, password);
                editor.apply();
            }
        });
    }

    private void cargarDatos() {
        String usuario = sharedPreferencesUsuarios.getString(Constantes.CORREOUSUARIO, "");
        String password = sharedPreferencesUsuarios.getString(Constantes.PASSWORD, "");
        if (!usuario.isEmpty() && !password.isEmpty()) {
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
        }
    }
}


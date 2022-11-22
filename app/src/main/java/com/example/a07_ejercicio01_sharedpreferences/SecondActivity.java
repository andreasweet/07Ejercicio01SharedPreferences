package com.example.a07_ejercicio01_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button btnEliminar;
    private SharedPreferences sharedPreferencesUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnEliminar = findViewById(R.id.btneliminar);

        sharedPreferencesUsuario = getSharedPreferences(Constantes.USUARIO,MODE_PRIVATE);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferencesUsuario.edit();
                editor.clear();
                editor.apply();
            }
        });
    }
}
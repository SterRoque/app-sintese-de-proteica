package com.cursodeandroid.sintesedeproteina.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cursodeandroid.sintesedeproteina.R;

public class TelaInicial extends AppCompatActivity {

    private Button buttonSintese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_SinteseDeProteina);
        setContentView(R.layout.activity_tela_inicial);
        buttonSintese = findViewById(R.id.buttonSintese);
    }
    public void conteudo(View view){
        Intent intent = new Intent(getApplicationContext(), TelaConteudo.class);
        startActivity(intent);
    }
    public void SinteseProteica(View view){
        Intent intent = new Intent(getApplicationContext(), TelaPrincipal.class);

        startActivity(intent);
    }

}
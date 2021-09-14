package com.cursodeandroid.sintesedeproteina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TelaInicial extends AppCompatActivity {

    private Button buttonSintese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        buttonSintese = findViewById(R.id.buttonSintese);

    }
    public void SinteseProteica(View view){
        Intent intent = new Intent(getApplicationContext(), TelaPrincipal.class);

        startActivity(intent);
    }

}
package com.cursodeandroid.sintesedeproteina.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.cursodeandroid.sintesedeproteina.R;

public class Exercicios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicios);

        RadioGroup questao1 = findViewById(R.id.opcaoResposta01);
        RadioGroup questao2 = findViewById(R.id.opcaoResposta02);
        RadioGroup questao3 = findViewById(R.id.opcaoResposta03);
        RadioGroup questao4 = findViewById(R.id.opcaoResposta04);
        RadioGroup questao5 = findViewById(R.id.opcaoResposta05);
        RadioGroup questao6 = findViewById(R.id.opcaoResposta06);

        RadioButton correta1 = findViewById(R.id.correta1);
        RadioButton correta2 = findViewById(R.id.correta2);
        RadioButton correta3 = findViewById(R.id.correta3);
        RadioButton correta4 = findViewById(R.id.correta4);
        RadioButton correta5 = findViewById(R.id.correta5);
        RadioButton correta6 = findViewById(R.id.correta6);



        Button finalizar = findViewById(R.id.btnFinalizar);



        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int acertos = 0;
                int erros = 0;
                float nota = 0;

                if (correta1.isChecked()){
                    acertos += 1;
                } else {
                    erros += 1;
                }
                if (correta2.isChecked()){
                    acertos += 1;
                } else {
                    erros += 1;
                }
                if (correta3.isChecked()){
                    acertos += 1;
                } else {
                    erros += 1;
                }
                if (correta4.isChecked()){
                    acertos += 1;
                } else {
                    erros += 1;
                }
                if (correta5.isChecked()){
                    acertos += 1;
                } else {
                    erros += 1;
                }
                if (correta6.isChecked()){
                    acertos += 1;
                } else {
                    erros += 1;
                }

                nota = (float) (acertos * 1.667);

                Intent intent = new Intent(getApplicationContext(), TelaQuestionarioResultado.class);
                intent.putExtra("acertos", acertos);
                intent.putExtra("erros", erros);
                intent.putExtra("nota", nota);
                startActivity(intent);

            }
        });

    }
}
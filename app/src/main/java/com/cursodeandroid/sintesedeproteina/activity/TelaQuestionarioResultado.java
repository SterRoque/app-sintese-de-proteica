package com.cursodeandroid.sintesedeproteina.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cursodeandroid.sintesedeproteina.R;

public class TelaQuestionarioResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_resultado);
        getSupportActionBar().setTitle("Questionário");

        TextView textNota = findViewById(R.id.textNota);
        TextView textAcertos = findViewById(R.id.textAcertos);
        TextView textErros = findViewById(R.id.textErros);
        TextView msg = findViewById(R.id.textMensagem);
        ImageView setaVoltar = findViewById(R.id.setaVoltar);


        Bundle dados = getIntent().getExtras();
        float nota = dados.getFloat("nota");
        int acertos = dados.getInt("acertos");
        int erros = dados.getInt("erros");
        textAcertos.setText("Acertos: " + acertos);
        textErros.setText("Erros: " + erros);
        textNota.setText("Nota: " + String.format("%.2f", nota));

        if (nota >= 8.0){
            msg.setText("Parabens! você foi otimo");
        } else if (nota >= 6.0  && nota < 8.0){
            msg.setText("Você foi bem");
        } else {
            msg.setText("Você foi mal!! estude mais");
        }

        setaVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

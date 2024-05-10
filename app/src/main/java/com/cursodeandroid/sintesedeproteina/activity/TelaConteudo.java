package com.cursodeandroid.sintesedeproteina.activity;
import android.content.Intent;
import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.cursodeandroid.sintesedeproteina.R;
public class TelaConteudo extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteudo);
        Button prot = findViewById(R.id.bt_prot);
        Button acid = findViewById(R.id.bt_acid);
        Button dup = findViewById(R.id.bt_dup);
        Button trasc = findViewById(R.id.bt_trasc);
        Button trad = findViewById(R.id.bt_trad);
        Button exercicios = findViewById(R.id.bt_ex);

        prot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ConteudoProteina.class);
                startActivity(intent);
            }
        });
        acid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ConteudoAcidos.class);
                startActivity(intent);
            }
        });
        dup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ConteudoDuplicacao.class);
                startActivity(intent);
            }
        });
        trasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ConteudoTranscricao.class);
                startActivity(intent);
            }
        });
        trad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ConteudoTraducao.class);
                startActivity(intent);
            }
        });
        exercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Exercicios.class);
                startActivity(intent);
            }
        });

    }
}

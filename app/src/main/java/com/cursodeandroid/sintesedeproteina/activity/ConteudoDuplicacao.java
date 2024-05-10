package com.cursodeandroid.sintesedeproteina.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cursodeandroid.sintesedeproteina.R;

public class ConteudoDuplicacao extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conteudo_duplicacao);
        TextView textDup = findViewById(R.id.textDup);
        Button voltar = findViewById(R.id.bt_voltar3);
        String text = "O DNA é capaz de fazer cópias de si mesmo, " +
                "esse processo se chama duplicação ou replicação. " +
                "Que se inicia com as quebras das ligações de " +
                "hidrogênio e o afastamento das duas hélices que " +
                "compõem o DNA. A complementaridade das bases " +
                "nitrogenadas faz com que as duas moléculas formadas " +
                "sejam idênticas entre si e à molécula original. " +
                "Assim, na mitose, cada nova célula apresenta a mesma " +
                "informação genética daquela que lhe deu origem.";

        textDup.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        textDup.setText(text);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
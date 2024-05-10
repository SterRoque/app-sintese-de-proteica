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

public class ConteudoTranscricao extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conteudo_transcricao);
        TextView textTrans = findViewById(R.id.textTransc);
        Button voltar = findViewById(R.id.bt_voltar4);
        String text = "É o processo que dá origem a síntese de uma molécula de RNA. " +
                "E é realizada por um complexo de enzimas, onde o mais importante é o " +
                "RNA-polimerase. No princípio, a enzima RNA-polimerase reconhece no " +
                "DNA a região promotora, uma determinada sequência de bases que sinaliza" +
                " o início da transcrição. São conhecidas diferentes sequências de bases" +
                " com essa função. Em seguida, a RNA-polimerase orienta o emparelhamento" +
                " das bases dos ribonucleotídios às bases da fita de DNA: ribonucleotídios" +
                " cuja base é a uracila emparelham-se às adeninas da fita molde do DNA " +
                "(U-A); da mesma forma, os ribonucleotídios com adenina emparelham-se às" +
                " timinas do DNA (A-T), os com citosina às guaninas do DNA (C-G), e as " +
                "guaninas às citosinas do DNA (G-C).\nÀ medida que ocorre o emparelhamento, " +
                "os ribonucleotídios ligam-se entre " +
                "si por meio de ligações entre as suas moléculas de açúcar e entre as de " +
                "fosfato. Forma-se, assim, uma cadeia de ribonucleotídios cuja sequência " +
                "de bases nitrogenadas é complementar à da fita molde de DNA: se um trecho " +
                "da fita molde do DNA leva uma sequência CGTAA, ela produz um RNA com a " +
                "sequência GCAUU.\n";
        textTrans.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        textTrans.setText(text);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
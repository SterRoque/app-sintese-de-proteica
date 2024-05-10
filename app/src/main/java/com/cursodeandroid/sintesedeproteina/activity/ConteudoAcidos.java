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

public class ConteudoAcidos extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conteudo_acidos);

        TextView textAcido = findViewById(R.id.textAcido);
        Button voltar = findViewById(R.id.bt_voltar2);
        String text = "São polímeros formados por nucleotídeos e por sua vez " +
                "formados por um fosfato, uma pentose (Ribose ou Desoxirribose) " +
                "e uma base nitrogenada, sendo elas Adenina (A), Timina (T) ou " +
                "Uracila (U) Citosina (C) e Guanina (G). Os nucleotídeos se conectam " +
                "por uma ligação fosfodiester. Os ácidos nucleicos são:\n\n" +
                "  DNA (Ácido Desoxirribonucleico) é uma fita dupla hélice responsável " +
                "por guardar as informações genéticas dos seres vivos. Formado por " +
                "nucleotídeos com pentose Desoxirribonucleico e bases nitrogenadas " +
                "Adenina (A), Timina (T), Citosina (C) e Guanina (G). Suas fitas estão " +
                "ligadas por ligações de hidrogênio, que liga combinações de bases " +
                "nitrogenadas, adenina se liga a timina e citosina se liga a guanina. \n\n" +
                "  RNA (Ácido Ribonucleico) é uma fita única formada por nucleotídeos " +
                "com pentose Ribose e bases nitrogenadas Adenina (A), Uracila (U), " +
                "Citosina (C) e Guanina (G). O RNA tem algumas funções na síntese de " +
                "proteínas como o RNAm (RNA mensageiro) que" +
                "tem função de levar o código genético ao citoplasma para a ser traduzido" +
                " em proteínas; o RNAt (RNA transportador) que tem função de transportar" +
                " os aminoácidos para a tradução; RNAr (RNA ribossômico) que combinado " +
                "com proteínas atua na tradução.\n";

        textAcido.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        textAcido.setText(text);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
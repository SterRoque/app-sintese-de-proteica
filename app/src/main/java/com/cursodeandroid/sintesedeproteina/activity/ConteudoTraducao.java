package com.cursodeandroid.sintesedeproteina.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cursodeandroid.sintesedeproteina.R;

public class ConteudoTraducao extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conteudo_traducao);
        TextView textTrad = findViewById(R.id.textTrad);
        Button voltar = findViewById(R.id.bt_voltar5);
        String text = "Com o final da transcrição, o RNAm se desloca do núcleo " +
                "até o citoplasma até encontar um ou vários ribossomos. O ribossomo " +
                "se conecta a fita de RNAm e inicia uma busca pelo codon(uma trinca " +
                "de bases nitrogenadas) de iniciação (AUG que codifica o aminoácido " +
                "metionina). Após encontrar o codon de inicialização e iniciar a " +
                "tradução, o ribossomo avança pela fita conectando os codons aos " +
                "anticodons (uma trinca de bases nitrogenadas que se conecta ao " +
                "codon) dos RNA's transportadores presentes no citoplasma,  " +
                "ligando sues aminoácidos por ligação peptídica. Assim esse " +
                "processo continua até que o ribossomo encontre um codon de t" +
                "erminação ( UAA; UAG; UGA) que interrompe a tradução. \n" +
                "Observação: mais de um ribossomo pode traduzir a mesma fita " +
                "de RNAm ao mesmo tempo.";

        textTrad.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        textTrad.setText(text);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
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

public class ConteudoProteina extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conteudo_proteina);

        TextView text = findViewById(R.id.textProt);
        Button voltar = findViewById(R.id.bt_voltar1);

        String textProteina = "As proteínas são um importante constituinte celular. " +
                "Além de ser fundamentais no metabolismo celular e são compostos orgânicos " +
                "essenciais para a vida, formados basicamente por átomos de carbono (C), " +
                "Oxigênio (O), hidrogênio (H), nitrogênio (N) e podem também apresentar " +
                "enxofre (S). As proteínas estão presentes na estrutura das características " +
                "dos seres vivos. E participa de quase todas as reações químicas vitais. " +
                "Há uma variedade de tipos de proteínas que realizam diferentes funções. " +
                "As proteínas são sintetizadas pelas próprias células por meio de processos " +
                "que envolvem informações contidas no DNA, diferentes tipos de RNA, aminoácidos " +
                "e várias outras moléculas presentes na célula. ";

        text.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        text.setText(textProteina);
        /*escolha.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.opcao3){
                    textResposta.setVisibility(View.VISIBLE);
                    textResposta.setText("Resposta correta! :)");
                } else {

                    textResposta.setVisibility(View.VISIBLE);
                    textResposta.setText("Incorreta! a resposta certa é a (C)");
                }
            }
        });*/
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
package com.cursodeandroid.sintesedeproteina;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TelaDuplicação extends TelaPrincipal {

    private Button autoDup, fazerDup;
    private EditText dna;
    private Button buttonDuplicar;
    private String fita;
    private String fitaDuplicada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_duplicacao);

        autoDup = findViewById(R.id.buttonAutoDup);
        fazerDup = findViewById(R.id.buttonFazerDup);
        TextView fitaDNA = findViewById(R.id.textDna);
        TextView resultado = findViewById(R.id.resposta);
        dna = findViewById(R.id.fazerDup);
        buttonDuplicar = findViewById(R.id.buttonDuplicar);

        fitaDNA.setVisibility(View.GONE);
        dna.setVisibility(View.GONE);
        buttonDuplicar.setVisibility(View.GONE);
        resultado.setVisibility(View.GONE);

        autoDup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dna.setVisibility(View.GONE);
                buttonDuplicar.setVisibility(View.GONE);
                resultado.setVisibility(View.GONE);

                Bundle dados = getIntent().getExtras();
                fitaDuplicada = dados.getString("dup");
                fitaDNA.setText(fitaDuplicada);
                fitaDNA.setVisibility(View.VISIBLE);

            }
        });
        fazerDup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle dados = getIntent().getExtras();
                fitaDuplicada = dados.getString("dup");
                fitaDNA.setText(dados.getString("fazerDup"));
                fitaDNA.setVisibility(View.VISIBLE);
                dna.setVisibility(View.VISIBLE);
                buttonDuplicar.setVisibility(View.VISIBLE);

                buttonDuplicar.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        fita = dna.getText().toString();
                        String resposta = "";
                        if (fita.equals("")){
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Faça a duplicação da fita acima",
                                    Toast.LENGTH_LONG
                            ).show();
                        } else{

                            if (fita.equals(fitaDuplicada)){
                                resposta = "Correto, você acertou!!";
                                resultado.setTextColor(Color.parseColor("#008807"));
                            } else {
                                resposta = "Você errou :(";
                                resultado.setTextColor(Color.parseColor("#B00020"));
                            }
                            resultado.setText(resposta);
                            resultado.setVisibility(View.VISIBLE);

                        }

                    }
                });

            }
        });




    }
}
package com.cursodeandroid.sintesedeproteina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TelaTranscricao extends TelaPrincipal{


    private TextView textFitaDna, textFitaRna, resultado;
    private EditText editFazerTrans;
    private Button buttonTranscrever;
    private String fitaAutoTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_transcricao);
        textFitaDna = findViewById(R.id.textFitaDNA);
        textFitaRna = findViewById(R.id.textFitaRNA);
        editFazerTrans = findViewById(R.id.editFazerTrans);
        buttonTranscrever = findViewById(R.id.buttonTranscrever);
        resultado = findViewById(R.id.textResultado);
        buttonTranscrever.setVisibility(View.GONE);
        editFazerTrans.setVisibility(View.GONE);
        textFitaRna.setVisibility(View.GONE);
        textFitaDna.setVisibility(View.GONE);
        resultado.setVisibility(View.GONE);
        
    }
    public void autoTrans(View view){
        editFazerTrans.setVisibility(View.GONE);
        buttonTranscrever.setVisibility(View.GONE);
        resultado.setVisibility(View.GONE);
        Bundle dados = getIntent().getExtras();
        String fitaDnaSep = dados.getString("DNASep");
        fitaAutoTrans = dados.getString("Transc");
        textFitaDna.setText(fitaDnaSep);
        textFitaRna.setText(fitaAutoTrans);
        textFitaDna.setVisibility(View.VISIBLE);
        textFitaRna.setVisibility(View.VISIBLE);

    }
    public void fazerTrans(View view){
        textFitaRna.setVisibility(View.GONE);
        Bundle dados = getIntent().getExtras();
        String fitaDnaSep = dados.getString("DNASep");
        textFitaDna.setText(fitaDnaSep);
        textFitaDna.setVisibility(View.VISIBLE);
        editFazerTrans.setVisibility(View.VISIBLE);
        buttonTranscrever.setVisibility(View.VISIBLE);

        buttonTranscrever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fita = editFazerTrans.getText().toString().toUpperCase();
                String resposta = "";
                if (fita.equals("")){
                    Toast.makeText(
                            getApplicationContext(),
                            "Transcreva a fita de DNA acima",
                            Toast.LENGTH_LONG
                    ).show();
                }else{
                    if ((!(fita.contains(" ")))){
                        fita = sp.addEspaco(fita, 3, " ").trim();
                        if (fita.equals(fitaAutoTrans)){
                            resposta = "Correto, você acertou!!";
                        } else{
                            resposta = "Você errou :(";
                        }
                    } else if (fita.contains(" ")){
                        if (fita.equals(fitaAutoTrans)){
                            resposta = "Correto, você acertou!!";
                        } else{
                            resposta = "Você errou :(";
                        }

                    }
                    textFitaRna.setText(fita);
                    resultado.setText(resposta);
                    textFitaRna.setVisibility(View.VISIBLE);
                    resultado.setVisibility(View.VISIBLE);
                }
            }

        });

    }


}
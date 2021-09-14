package com.cursodeandroid.sintesedeproteina;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import java.util.Arrays;
import java.util.Random;

public class TelaPrincipal extends TelaInicial {

    protected char[] fitaDna;
    protected char[] fitaRna;
    protected EditText dna;
    protected TextView resultado, resultadoAmino;
    protected Integer qtd;
    protected String fita;
    protected Button dup;
    protected String dnaDuplicado;
    protected String fitinha;

    SinteseProteica sp = new SinteseProteica();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        dna = findViewById(R.id.dna);
        resultado = findViewById(R.id.fita);
        resultadoAmino = findViewById(R.id.textAmino);
        dup = findViewById(R.id.buttonDup);

    }

    public void buttonDuplicacao(View view){
        fita = dna.getText().toString();
        if (fita.equals("") || fita == null) {
            Toast.makeText(
                    getApplicationContext(),
                    "Digite a fita de DNA",
                    Toast.LENGTH_SHORT
            ).show();
        }else {
                Intent intent = new Intent(getApplicationContext(), TelaDuplicação.class);
                String duplicacao = sp.duplicacao(fita, fita.length());
                intent.putExtra("dup", duplicacao);
                intent.putExtra("fazerDup", this.fita);
                startActivity(intent);
        }


    }


    public void buttonTranscricao(View view){
        fita = dna.getText().toString();
        if (fita.equals("") || fita == null) {
            Toast.makeText(
                    getApplicationContext(),
                    "Digite a fita de DNA",
                    Toast.LENGTH_SHORT
            ).show();
        }else {
            Intent intent = new Intent(getApplicationContext(), TelaTranscricao.class);
            String transcricao = sp.transcricao2(fitinha);
            intent.putExtra("Transc", transcricao.trim());
            intent.putExtra("DNASep", sp.addEspaco(fitinha, 3, " "));

            // intent.putExtra("fazerDup", this.fitinha);
            startActivity(intent);
        }

    }



    public void limpar(View view){
        dna.setText("");
        resultado.setText("");
        resultadoAmino.setText("");
    }
    public void gerarFita(View view){
        char[] dnaFita = {'A', 'T', 'C', 'G'};
        char[] fitaGerada = new char[9];
        fitaGerada[0] = 'T';
        fitaGerada[1] = 'A';
        fitaGerada[2] = 'C';
        for (int i = 3; i < fitaGerada.length; i++){
            int indice = new Random().nextInt(4);
            fitaGerada[i] = dnaFita[indice];
        }
        fitinha = String.valueOf(fitaGerada);
        dna.setText(fitinha);
    }


}

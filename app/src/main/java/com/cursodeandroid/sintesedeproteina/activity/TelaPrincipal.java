package com.cursodeandroid.sintesedeproteina.activity;

//import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//import java.util.Arrays;
import androidx.appcompat.app.AlertDialog;

import com.bumptech.glide.Glide;
import com.cursodeandroid.sintesedeproteina.R;

import java.util.ArrayList;
import java.util.List;
        import java.util.Random;

public class TelaPrincipal extends TelaInicial {


    protected EditText dna;
    protected TextView resultado;
    protected Integer qtd;
    protected String fita;
    protected Button dup;


    SinteseProteica sp = new SinteseProteica();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        dna = findViewById(R.id.dna);
        resultado = findViewById(R.id.fita);
        dup = findViewById(R.id.buttonDup);

        ImageView logo = findViewById(R.id.logo);
        Glide.with(this).asGif().load(R.drawable.animalogo).into(logo);

    }

    public void buttonDuplicacao(View view){
        fita = dna.getText().toString().toUpperCase();
        if (fita.equals("")){
            Toast.makeText(
                    getApplicationContext(),
                    "Digite uma fita de DNA",
                    Toast.LENGTH_SHORT
            ).show();
        } else if ((fita.contains("TAC")) &&
                ((fita.contains("ATT")) ||
                (fita.contains("ATC")) ||
                (fita.contains("ACT"))))
        {
            Intent intent = new Intent(getApplicationContext(), TelaDuplicação.class);
            String duplicacao = sp.duplicacao(fita, fita.length());
            intent.putExtra("dup", duplicacao);
            intent.putExtra("dna", this.fita);
            startActivity(intent);


        } else if (!(fita.contains("TAC") || fita.contains("TAC")) &&
                (!(fita.contains("ATT")) ||
                 !(fita.contains("ATC")) ||
                 !(fita.contains("ACT")))
                 ||(fita.contains("TAC"))){
            AlertDialog.Builder alert = new AlertDialog.Builder(TelaPrincipal.this);
            View v = getLayoutInflater().inflate(R.layout.dialog_alert_fita, null);
            Button fechar = v.findViewById(R.id.btnFechar);
            alert.setView(v);
            AlertDialog dialog = alert.create();
            dialog.show();
            fechar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.hide();
                }
            });
        }


    }

    public void buttonTranscricao(View view){
        fita = dna.getText().toString().toUpperCase();
        if (fita.equals("")){
            Toast.makeText(
                    getApplicationContext(),
                    "Digite uma fita de DNA",
                    Toast.LENGTH_SHORT
            ).show();
        } else if ((fita.contains("TAC")) &&
                ((fita.contains("ATT")) ||
                (fita.contains("ATC")) ||
                (fita.contains("ACT"))))
        {
            Intent intent = new Intent(getApplicationContext(), TelaTranscricao.class);
            intent.putExtra("RnaM", sp.transcricao2(fita));
            intent.putExtra("DNASep", fita);
            startActivity(intent);
        } else  if (!(fita.contains("TAC") || fita.contains("TAC")) &&
                (!(fita.contains("ATT")) ||
                !(fita.contains("ATC")) ||
                !(fita.contains("ACT")))
                ||(fita.contains("TAC"))){

            AlertDialog.Builder alert = new AlertDialog.Builder(TelaPrincipal.this);
            View v = getLayoutInflater().inflate(R.layout.dialog_alert_fita, null);
            Button fechar = v.findViewById(R.id.btnFechar);
            alert.setView(v);
            AlertDialog dialog = alert.create();
            dialog.show();
            fechar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.hide();
                }
            });
        }

    }

    public void buttonTraducao(View view) {
        fita = dna.getText().toString().toUpperCase();

        if (fita.equals("")) {
            Toast.makeText(
                    getApplicationContext(),
                    "Digite uma fita de DNA",
                    Toast.LENGTH_SHORT
            ).show();
        } else if ((fita.contains("TAC")) &&
                ((fita.contains("ATT")) ||
                (fita.contains("ATC")) ||
                (fita.contains("ACT")))) {
            Intent intent = new Intent(getApplicationContext(), TelaTraducao.class);

            intent.putExtra("RnaM", sp.transcricao2(fita));
            intent.putExtra("Trad", sp.traducao(fita));
            startActivity(intent);

        } else  if (!(fita.contains("TAC") || fita.contains("TAC")) &&
                (!(fita.contains("ATT")) ||
                !(fita.contains("ATC")) ||
                !(fita.contains("ACT")))
                ||(fita.contains("TAC"))){

            AlertDialog.Builder alert = new AlertDialog.Builder(TelaPrincipal.this);
            View v = getLayoutInflater().inflate(R.layout.dialog_alert_fita, null);
            Button fechar = v.findViewById(R.id.btnFechar);
            alert.setView(v);
            AlertDialog dialog = alert.create();
            dialog.show();
            fechar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.hide();
                }
            });
        }
    }

    public void limpar(View view){
        dna.setText("");
    }

    public void gerarFita(View view){
        List<String> fitasCadastradas = new ArrayList<>();
        fitasCadastradas.add("TTACTAAACGACGACAGGAAAACCGTCATAAATTAACGCC");
        fitasCadastradas.add("CGTACTGGATGGCCGTTTAAAGTAACGAGATTTCTGCATT");
        fitasCadastradas.add("CTACTTTCCTGCCGCCGGTCTTATTGCGTAATCCG");
        fitasCadastradas.add("CGTACCAATCGAGTTGGTACACGCGAACTGCGATA");
        fitasCadastradas.add("GGCAGTACAATCGACGAATTGCTCGGGGGTAAGAC");
        fitasCadastradas.add("AGGTACACGACCGCCCGATGCTCGCGAATAATTAC");
        fitasCadastradas.add("CTGTTGTTTACGAGATTGAGTTTAGTTGTACAGCT");
        fitasCadastradas.add("CTACAGCGTATCTCGTATAACTCGATCTAC");
        fitasCadastradas.add("GTACGATGTTTCGACATGTATTTATGCCTC");
        fitasCadastradas.add("TACACAGGGACTTGCGTGTGCCAGCTGGAT");
        fitasCadastradas.add("ATCTACATTATCCAGTGATACAAAAGGACA");
        fitasCadastradas.add("TACTTTCGACACATTACCTGCTTCAGACCG");
        fitasCadastradas.add("ATACTTGTACAGTTTCCGCGGCGTTATTAC");
        fitasCadastradas.add("TGATACGTATACGCGTCATGGACTATGTAA");
        fitasCadastradas.add("TACCCGTATAAAGAACGGCTAGCCATTGTA");
        fitasCadastradas.add("GTACGTGTGAGTAATTTCGGTCCTT");
        fitasCadastradas.add("GCGCTACAATACAATCGTTGTAATG");
        fitasCadastradas.add("AGTATACTCTATTGAGTAATGCTCG");
        fitasCadastradas.add("TACCTTAGCCCAAGCGGGGTGATTA");
        fitasCadastradas.add("TATACCCATACACAACTGCATA");
        fitasCadastradas.add("ATACTGAATTTCCGCAAGTG");
        fitasCadastradas.add("CTACCCTAAAACTAGTAGTT");
        fitasCadastradas.add("TACTGAAGCATTCGCATAGC");

        int indice = new Random().nextInt(fitasCadastradas.size());
        fita = fitasCadastradas.get(indice);
        dna.setText(fita);
    }

    public void validarFita(){
        fita = dna.getText().toString();

        if (fita.equals("")){
            Toast.makeText(
                    getApplicationContext(),
                    "Digite uma fita de DNA",
                    Toast.LENGTH_SHORT
            ).show();
        } else if (!(fita.contains("TAC")) &&
                !(fita.contains("ATT")) ||
                !(fita.contains("ATC")) ||
                !(fita.contains("ACT")))
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
            View view = getLayoutInflater().inflate(R.layout.dialog_alert_fita, null);
            Button fechar = view.findViewById(R.id.btnFechar);
            alert.setView(view);
            AlertDialog dialog = alert.create();
            dialog.show();
            fechar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.hide();
                }
            });
        } else {

        }
    }
}

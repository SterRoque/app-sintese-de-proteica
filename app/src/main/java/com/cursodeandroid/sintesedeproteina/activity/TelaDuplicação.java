package com.cursodeandroid.sintesedeproteina.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.cursodeandroid.sintesedeproteina.R;

import java.util.ArrayList;
import java.util.List;

public class TelaDuplicação extends TelaPrincipal {

    private Button autoDup, fazerDup;
    private EditText editText;
    private Button buttonDuplicar, ajuda;
    private String digitado;
    private String fitaDuplicada, dna, fita;
    private TextView fitaDNA, resultado,fitaDup,textLimpar;
    private List<String> bases = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_duplicacao);
        getSupportActionBar().setTitle("Duplicação");

        ajuda = findViewById(R.id.button4);
        autoDup = findViewById(R.id.buttonAutoDup);
        fazerDup = findViewById(R.id.buttonFazerDup);
        fitaDNA = findViewById(R.id.textDna);
        fitaDup = findViewById(R.id.textFitaDup);
        textLimpar= findViewById(R.id.textLimpar3);
        resultado = findViewById(R.id.radioGroupEscolha);
        editText = findViewById(R.id.fazerDup);
        buttonDuplicar = findViewById(R.id.buttonDuplicar);
        Button a = findViewById(R.id.btnA);
        Button t = findViewById(R.id.btnT);
        Button c = findViewById(R.id.btnC);
        Button g = findViewById(R.id.btnG);
        Button remover = findViewById(R.id.btnRemover);
        ConstraintLayout teclado = findViewById(R.id.tecladoDup);


        Bundle dados = getIntent().getExtras();
        dna = dados.getString("dna");
        fitaDuplicada = dados.getString("dup");

        fitaDNA.setVisibility(View.GONE);
        fitaDup.setVisibility(View.GONE);
        textLimpar.setVisibility(View.GONE);
        editText.setVisibility(View.GONE);
        buttonDuplicar.setVisibility(View.GONE);
        resultado.setVisibility(View.GONE);
        teclado.setVisibility(View.GONE);
        ajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(TelaDuplicação.this);
                View v = getLayoutInflater().inflate(R.layout.dialog_duplicacao, null);
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
        });

        autoDup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setVisibility(View.GONE);
                buttonDuplicar.setVisibility(View.GONE);
                textLimpar.setVisibility(View.GONE);
                resultado.setVisibility(View.GONE);
                teclado.setVisibility(View.GONE);
                fitaDNA.setGravity(Gravity.CENTER);
                fitaDNA.setText("DNA\n\n" +
                        dna + "\n\n\n DNA duplicado\n\n" + fitaDuplicada);
                fitaDNA.setVisibility(View.VISIBLE);
            }
        });
        fazerDup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fitaDNA.setGravity(Gravity.LEFT);
                fitaDNA.setText(dna);
                fitaDNA.setVisibility(View.VISIBLE);
                textLimpar.setVisibility(View.VISIBLE);
                editText.setVisibility(View.VISIBLE);
                teclado.setVisibility(View.VISIBLE);
                buttonDuplicar.setVisibility(View.VISIBLE);

                a.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bases.add("A");
                        fita = bases.toString();
                        fita = fita.replace("[", "")
                                .replace("]", "")
                                .replace(",","")
                                .replace(" ", "");
                        editText.setText(fita);

                    }
                });
                t.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bases.add("T");
                        fita = bases.toString();
                        fita = fita.replace("[", "")
                                .replace("]", "")
                                .replace(",","")
                                .replace(" ", "");
                        editText.setText(fita);

                    }
                });
                c.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bases.add("C");
                        fita = bases.toString();
                        fita = fita.replace("[", "")
                                .replace("]", "")
                                .replace(",","")
                                .replace(" ","");
                        editText.setText(fita);
                    }
                });
                g.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bases.add("G");
                        fita = bases.toString();
                        fita = fita.replace("[", "")
                                .replace("]", "")
                                .replace(",","")
                                .replace(" ","");
                        editText.setText(fita);

                    }
                });
                remover.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!bases.isEmpty()){
                            bases.remove(bases.size()-1);
                            fita = bases.toString();
                            fita = fita.replace("[", "")
                                    .replace("]", "")
                                    .replace(",", "")
                                    .replace(" ","");
                            editText.setText(fita);
                        }else if (bases.isEmpty()){
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Faça a duplicação da fita acima",
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                    }
                });

                buttonDuplicar.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        digitado = editText.getText().toString();
                        String resposta = "";
                        if (digitado.equals("")){
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Faça a duplicação da fita acima",
                                    Toast.LENGTH_LONG
                            ).show();
                        } else{

                            if (digitado.equals(fitaDuplicada)){
                                fitaDup.setText(fitaDuplicada);
                                fitaDup.setVisibility(View.VISIBLE);
                                resposta = "Você completou a transcrição corretamente!";
                                resultado.setTextColor(Color.parseColor("#008807"));
                            } else {
                                fitaDup.setGravity(Gravity.CENTER);
                                fitaDup.setText("Dupliação correta: " + fitaDuplicada);
                                fitaDup.setVisibility(View.VISIBLE);
                                resposta = "Você errou :(\n\n" +
                                        "Na duplicação do DNA o emparelhamento \n" +
                                        "das bases ocorre da seguinte maneira:\n" +
                                        "A - T\n" +
                                        "T - A\n" +
                                        "C - G\n" +
                                        "G - C\n" +
                                        "Verifique sua resposta novamente!";
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


    @Override
    public void limpar(View view){
        editText.setText("");
        fitaDup.setText("");
        resultado.setText("");
        bases.clear();
    }

}
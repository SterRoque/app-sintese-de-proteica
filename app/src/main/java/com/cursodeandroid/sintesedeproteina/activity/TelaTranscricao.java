package com.cursodeandroid.sintesedeproteina.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
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

public class TelaTranscricao extends TelaPrincipal{

    private TextView textFitaDna, textFitaRna, resultado, textLimpar;
    private EditText editFazerTrans;
    private Button transcrever;
    private Button buttonFazerTrans;
    private Button u, a, c, g, remover, ajuda;
    private ConstraintLayout teclado;
    private String fitaAutoTrans, fitaDnaSep;
    private final List<String> bases = new ArrayList<>();


    public Spanned getFitaAutoTransCustom() {
        return fitaAutoTransCustom;
    }

    private Spanned fitaAutoTransCustom, fitaDnaSepCustom;
    private Bundle dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_transcricao);

        textFitaDna = findViewById(R.id.textFitaDNA);
        textFitaRna = findViewById(R.id.textFitaRNA);
        textLimpar = findViewById(R.id.textLimpar2);
        editFazerTrans = findViewById(R.id.editFazerTrans);
        Button buttonAutoTrans = findViewById(R.id.buttonAutoTrans);
        transcrever = findViewById(R.id.btnTranscrever);
        u = findViewById(R.id.btnU);
        a = findViewById(R.id.btA);
        c = findViewById(R.id.btnC);
        g = findViewById(R.id.btnG);
        remover = findViewById(R.id.btnRemover);
        teclado = findViewById(R.id.tecladoDup);
        resultado = findViewById(R.id.textResultado);
        ajuda = findViewById(R.id.button3);


        dados = getIntent().getExtras();
        fitaDnaSep = dados.getString("DNASep");
        fitaAutoTrans = dados.getString("RnaM");
        fitaAutoTrans = fitaAutoTrans.replace(" ", "");
        transcrever.setVisibility(View.GONE);
        editFazerTrans.setVisibility(View.GONE);
        textFitaRna.setVisibility(View.GONE);
        textFitaDna.setVisibility(View.GONE);
        textLimpar.setVisibility(View.GONE);
        resultado.setVisibility(View.GONE);
        teclado.setVisibility(View.GONE);

        ajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(TelaTranscricao.this);
                View v = getLayoutInflater().inflate(R.layout.dialog_transcricao, null);
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


    }
    public void autoTrans(View view){
        editFazerTrans.setVisibility(View.GONE);
        transcrever.setVisibility(View.GONE);
        resultado.setVisibility(View.GONE);
        textLimpar.setVisibility(View.GONE);
        teclado.setVisibility(View.GONE);

        textFitaDna.setGravity(Gravity.CENTER);

        textFitaDna.setText(fitaDnaSep);
        textFitaRna.setText(fitaAutoTrans);
        textFitaDna.setVisibility(View.VISIBLE);
        textFitaRna.setVisibility(View.VISIBLE);
    }

    @Override
    public void limpar(View view){
        editFazerTrans.setText("");
        textFitaRna.setText("");
        resultado.setText("");
        bases.clear();
    }

    public void fazerTrans(View view){
        textFitaDna.setGravity(Gravity.LEFT);
        textFitaDna.setText(fitaDnaSep);
        textFitaRna.setVisibility(View.GONE);
        textFitaDna.setVisibility(View.VISIBLE);
        textLimpar.setVisibility(View.VISIBLE);
        editFazerTrans.setVisibility(View.VISIBLE);
        teclado.setVisibility(View.VISIBLE);
        transcrever.setVisibility(View.VISIBLE);

        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bases.add("U");
                fita = bases.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",","")
                        .replace(" ", "");
                editFazerTrans.setText(fita);

            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bases.add("A");
                fita = bases.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",","")
                        .replace(" ", "");
                editFazerTrans.setText(fita);

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
                editFazerTrans.setText(fita);
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
                editFazerTrans.setText(fita);

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
                    editFazerTrans.setText(fita);
                }else if (bases.isEmpty()){
                    Toast.makeText(
                            getApplicationContext(),
                            "Faça a duplicação da fita acima",
                            Toast.LENGTH_SHORT
                    ).show();
                }

            }
        });

        transcrever.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String digitado = editFazerTrans.getText().toString();
                String resposta = "";
                if (digitado.equals("")){
                    Toast.makeText(
                            getApplicationContext(),
                            "Transcreva a fita de DNA acima",
                            Toast.LENGTH_SHORT
                    ).show();
                }else{
                    if (digitado.equalsIgnoreCase(fitaAutoTrans)
                            || digitado.equalsIgnoreCase(fitaAutoTrans.replace(" ", ""))){
                        resultado.setTextColor(Color.parseColor("#008807"));
                        textFitaRna.setText(fitaAutoTrans);
                        resultado.setText("Você completou a transcrição corretamente!");
                        textFitaRna.setVisibility(View.VISIBLE);
                        resultado.setVisibility(View.VISIBLE);
                    } else {
                        resultado.setTextColor(Color.parseColor("#B00020"));
                        textFitaRna.setText(fitaAutoTrans);
                        resultado.setText("Você errou :(\n" +
                                "\n" +
                                "Na transcrição do DNA o emparelhamento \n" +
                                "das bases ocorre da seguinte maneira:\n" +
                                "A - U\n" +
                                "T - A\n" +
                                "C - G\n" +
                                "G - C\n" +
                                "Verifique sua resposta novamente!");
                        textFitaRna.setVisibility(View.VISIBLE);
                        resultado.setVisibility(View.VISIBLE);
                    }

                }
            }
        });
    }

    public static Spannable colorized(final String text, final String word, final int color) {
        final Spannable spannable = new SpannableString(text);
        int substringStart=0;
        int start;
        while((start=text.indexOf(word,substringStart))>=0){
            spannable.setSpan(
                    new ForegroundColorSpan(color),start,start+word.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            );
            substringStart = start+word.length();
        }
        return spannable;
    }
}
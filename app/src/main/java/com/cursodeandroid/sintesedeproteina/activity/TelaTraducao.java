package com.cursodeandroid.sintesedeproteina.activity;

import static android.widget.Toast.makeText;

import android.graphics.Color;
import android.os.Build;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;

import com.cursodeandroid.sintesedeproteina.R;

import java.util.*;

public class TelaTraducao extends TelaPrincipal  {

    private FrameLayout teclado;
    private TextView textFita, textAmino, textFitaCorreta, resultado, textLimpar;
    private EditText editText;
    private ImageView tabela;
    private Button ala, arg, ans, asp, glu, cis, fen, gli, gln, his, ile;
    private Button leu, lis, met, pro, ser, tir, tre, trp, val,remove, hifen, fim, ajuda;
    private String rna;
    private Spanned rnaCustom;
    private String ligPeptidica;
    private String digitado = "";
    private String fita = "";
    private String[] fitaTrincas;
    private Bundle dados;
    private List<String> resposta = new ArrayList<String>();
    private static Map<String, String> aminoacidos = new HashMap<>();
    private List<String> rnaList = new ArrayList<>();
    private static int CONTROLE = 0;
    String inicioFita;
    String fimFita;
    String fitaMeio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_traducao2);

        getSupportActionBar().hide();



        aminoacidos.put("UUU", "Fen");
        aminoacidos.put("UUC", "Fen");
        aminoacidos.put("UUA", "Leu");
        aminoacidos.put("UUG", "Leu");
        aminoacidos.put("UCU", "Ser");
        aminoacidos.put("UCC", "Ser");
        aminoacidos.put("UCA", "Ser");
        aminoacidos.put("UCG", "Ser");
        aminoacidos.put("UAU", "Tir");
        aminoacidos.put("UAC", "Tir");
        aminoacidos.put("UAA", "Fim");
        aminoacidos.put("UAG", "Fim");
        aminoacidos.put("UGU", "Cis");
        aminoacidos.put("UGC", "Cis");
        aminoacidos.put("UGA", "Fim");
        aminoacidos.put("UGG", "Trp");

        aminoacidos.put("CUU", "Leu");
        aminoacidos.put("CUC", "Leu");
        aminoacidos.put("CUA", "Leu");
        aminoacidos.put("CUG", "Leu");
        aminoacidos.put("CCU", "Pro");
        aminoacidos.put("CCC", "Pro");
        aminoacidos.put("CCA", "Pro");
        aminoacidos.put("CCG", "Pro");
        aminoacidos.put("CAU", "His");
        aminoacidos.put("CAC", "His");
        aminoacidos.put("CAA", "Gln");
        aminoacidos.put("CAG", "Gln");
        aminoacidos.put("CGU", "Arg");
        aminoacidos.put("CGC", "Arg");
        aminoacidos.put("CGA", "Arg");
        aminoacidos.put("CGG", "Arg");

        aminoacidos.put("AUU", "Ile");
        aminoacidos.put("AUC", "Ile");
        aminoacidos.put("AUA", "Ile");
        aminoacidos.put("AUG", "Met");
        aminoacidos.put("ACU", "Tre");
        aminoacidos.put("ACC", "Tre");
        aminoacidos.put("ACA", "Tre");
        aminoacidos.put("ACG", "Tre");
        aminoacidos.put("AAU", "Ans");
        aminoacidos.put("AAC", "Ans");
        aminoacidos.put("AAA", "Lis");
        aminoacidos.put("AAG", "Lis");
        aminoacidos.put("AGU", "Ser");
        aminoacidos.put("AGC", "Ser");
        aminoacidos.put("AGA", "Arg");
        aminoacidos.put("AGG", "Arg");

        aminoacidos.put("GUU", "Val");
        aminoacidos.put("GUC", "Val");
        aminoacidos.put("GUA", "Val");
        aminoacidos.put("GUG", "Val");
        aminoacidos.put("GCU", "Ala");
        aminoacidos.put("GCC", "Ala");
        aminoacidos.put("GCA", "Ala");
        aminoacidos.put("GCG", "Ala");
        aminoacidos.put("GAU", "Asp");
        aminoacidos.put("GAC", "Asp");
        aminoacidos.put("GAA", "Glu");
        aminoacidos.put("GAG", "Glu");
        aminoacidos.put("GGU", "Gli");
        aminoacidos.put("GGC", "Gli");
        aminoacidos.put("GGA", "Gli");
        aminoacidos.put("GGG", "Gli");


        textFita = findViewById(R.id.textFita);
        textAmino = findViewById(R.id.textAmino);
        textFitaCorreta = findViewById(R.id.textFitaCorreta);
        textLimpar = findViewById(R.id.textLimpar);
        resultado = findViewById(R.id.resultado);
        editText = findViewById(R.id.editText);
        tabela = findViewById(R.id.tabela);
        fim = findViewById(R.id.btnFim);
        teclado = findViewById(R.id.teclado);
        ala = findViewById(R.id.ala);
        arg = findViewById(R.id.arg);
        ans = findViewById(R.id.ans);
        asp = findViewById(R.id.asp);
        glu = findViewById(R.id.glu);
        cis = findViewById(R.id.cis);
        fen = findViewById(R.id.fen);
        gli = findViewById(R.id.gli);
        gln = findViewById(R.id.gln);
        his = findViewById(R.id.his);
        ile = findViewById(R.id.ile);
        leu = findViewById(R.id.leu);
        lis = findViewById(R.id.lis);
        met = findViewById(R.id.met);
        pro = findViewById(R.id.pro);
        ser = findViewById(R.id.ser);
        tir = findViewById(R.id.tir);
        tre = findViewById(R.id.tre);
        trp = findViewById(R.id.trp);
        val = findViewById(R.id.val);
        remove = findViewById(R.id.remove);
        hifen = findViewById(R.id.hifen);
        ajuda = findViewById(R.id.button2);


        dados = getIntent().getExtras();
        rna = dados.getString("RnaM");
        ligPeptidica = dados.getString("Trad");
        fitaTrincas = rna.split(" ");

        textFita.setVisibility(View.INVISIBLE);
        textAmino.setVisibility(View.INVISIBLE);
        textFitaCorreta.setVisibility(View.INVISIBLE);
        textLimpar.setVisibility(View.INVISIBLE);
        tabela.setVisibility(View.GONE);
        resultado.setVisibility(View.INVISIBLE);
        editText.setVisibility(View.INVISIBLE);
        fim.setVisibility(View.INVISIBLE);
        teclado.setVisibility(View.INVISIBLE);

        int indiceAUG = rna.indexOf("AUG");
        int indiceFIM = 0;
        if (rna.contains("UAA")){
            int fim = rna.indexOf("UAA");
            indiceFIM = fim+3;
        } else if (rna.contains("UGA")){
            int fim = rna.indexOf("UGA");
            indiceFIM = fim+3;
        } else if (rna.contains("UAG")){
            int fim= rna.indexOf("UAG");
            indiceFIM = fim+3;
        }


        inicioFita = rna.substring(0, indiceAUG);
        fimFita = rna.substring(indiceFIM);
        fitaMeio = rna.substring(indiceAUG, indiceFIM);

        /*String inicioFita = rna.substring(0, indiceAUG);
        String fimFita = rna.substring(indiceFIM);
        String fitaMeio = rna.substring(indiceAUG, indiceFIM);*/
       /* if(CONTROLE == 0){
            iniciaFita(fitaMeio);
            CONTROLE++;
        }else{
        }*/

       /* rnaCustom = Html.fromHtml("<font color=gray>" + inicioFita + "</font>"
                + colorir().toString()+
                "<font color=gray>" + fimFita +"</font>");
        System.out.println(colorir().toString());*/
        rnaCustom = Html.fromHtml("<font color=gray>" + inicioFita
                +"</font>" + fitaMeio + "<font " +
                "color=gray>" + fimFita +"</font>");


        ajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(TelaTraducao.this);
                View v = getLayoutInflater().inflate(R.layout.dialog_traducao, null);
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

    List<FitaRna> listaFita;
public void reimprimir() {
    rnaCustom = Html.fromHtml("<font color=gray>" + inicioFita + "</font>"
            + colorir().toString()+
            "<font color=gray>" + fimFita +"</font>");
}
    public StringBuilder colorir() {
        StringBuilder sbHTML = new StringBuilder();
        String seila;
        for (FitaRna f : listaFita) {
            if (f.getCor() == null) {
                seila = "<font color=\"#D52973\">" + f.codon + "</font>";
            } else {
                seila = "<font color=\"" + f.cor + "\">" + f.codon + "</font>";
            }

            sbHTML.append(seila);
            seila = "";
        }
        return sbHTML;


    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    static List<String> getKeyByValue(Map<String, String> map, String value){
        List<String> lstCodon = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (Objects.equals(entry.getValue(), value)) {
                lstCodon.add(entry.getKey());
            }
        }
        return lstCodon;

    }
    public void defineCor(List<FitaRna> listaFita, String fita){
        int posicao = 0;
        for(FitaRna f : listaFita){
            System.out.println(f.codon + " == " + fita);

            if(f.codon.compareTo(fita) == 0){
                System.out.println("Definiu a cor ");
                f.setCor("#12D445");
                listaFita.add(posicao, f);
                break;
            }

            System.out.println("Definiu NADA ");
            posicao++;
        }

    }
    public void iniciaFita(String fitaMeio){
        listaFita = new ArrayList<>();

        for(String valor : fitaMeio.split(" ")){

            listaFita.add(new FitaRna(valor, false,true));
        }
        CONTROLE++;

    }

    @Override
    public void limpar(View view){
        editText.setText("");
        textFitaCorreta.setText("");
        resultado.setText("");
        textFita.setText(rnaCustom);
        resposta.clear();
    }

    public void limpar(){
        editText.setText("");
        textFitaCorreta.setText("");
        resultado.setText("");
        resposta.clear();
    }

    public void buttonAutoTrad(View view){

        editText.setVisibility(View.GONE);
        tabela.setVisibility(View.GONE);
        textLimpar.setVisibility(View.GONE);
        fim.setVisibility(View.GONE);
        textFitaCorreta.setVisibility(View.GONE);
        resultado.setVisibility(View.GONE);
        teclado.setVisibility(View.GONE);
        textFita.setGravity(Gravity.CENTER);
        textFita.setTranslationY(100);
        textFita.setText(rnaCustom);
        if (rna.contains("UAA") || rna.contains("UGA") || rna.contains("UAG")){
            makeText(
                    this,
                    "Tradução finalizada",
                    Toast.LENGTH_SHORT
            ).show();
        }
        textFita.setVisibility(View.VISIBLE);
        textAmino.setTranslationY(200);
        textAmino.setText(ligPeptidica);


        textAmino.setVisibility(View.VISIBLE);
    }
    public void buttonFazerTrad(View view){
        textFita.setVisibility(View.INVISIBLE);
        tabela.setVisibility(View.VISIBLE);
        editText.setVisibility(View.VISIBLE);
        textLimpar.setVisibility(View.VISIBLE);
        fim.setVisibility(View.VISIBLE);
        textAmino.setVisibility(View.GONE);
        teclado.setVisibility(View.VISIBLE);
        textFita.setTranslationY(-30);
        textFita.setGravity(Gravity.LEFT);
        textFita.setText(rnaCustom);
        textFita.setVisibility(View.VISIBLE);

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!resposta.isEmpty()){
                    resposta.remove(resposta.size()-1);
                    fita = resposta.toString();
                    fita = fita.replace("[", "")
                                .replace("]", "")
                                .replace(",", "");


                    editText.setText(fita);
                }else if (resposta.isEmpty()){
                    Toast.makeText(
                            getApplicationContext(),
                            "Traduza o gene",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
        hifen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resposta.add("-");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",","");
                editText.setText(fita);
            }
        });
        ala.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Ala");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                            .replace("]", "")
                            .replace(",", "");
                editText.setText(fita);

            }
        });
        arg.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Arg");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");

                editText.setText(fita);
            }
        });
        ans.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Ans");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");
                editText.setText(fita);
            }
        });
        asp.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Asp");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");
                editText.setText(fita);
            }
        });
        glu.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Glu");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");
                editText.setText(fita);
            }
        });
        cis.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Cis");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");
                editText.setText(fita);
            }
        });
        fen.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Fen");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");
                editText.setText(fita);
            }
        });
        gli.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Gli");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");
                editText.setText(fita);
            }
        });
        gln.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Gln");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");
                editText.setText(fita);
            }
        });
        his.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("His");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");
                editText.setText(fita);
            }
        });
        ile.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Ile");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");
                editText.setText(fita);
            }
        });
        leu.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Leu");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");
                editText.setText(fita);
            }
        });
        lis.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Lis");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");
                editText.setText(fita);
            }
        });
        met.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Met");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");
                editText.setText(fita);
            }
        });
        pro.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Pro");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");
                editText.setText(fita);
            }
        });
        ser.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Ser");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");
                editText.setText(fita);
            }
        });
        tir.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Tir");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");
                editText.setText(fita);
            }
        });
        tre.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Tre");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");
                editText.setText(fita);
            }
        });
        trp.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Trp");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");
                editText.setText(fita);
            }
        });
        val.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                resposta.add("Val");
                fita = resposta.toString();
                fita = fita.replace("[", "")
                        .replace("]", "")
                        .replace(",", "");
                editText.setText(fita);
            }
        });


    }
    public void btnFim(View view){
        fita = editText.getText().toString();

        if (fita.equalsIgnoreCase(ligPeptidica) || fita.equalsIgnoreCase(ligPeptidica.replace(" - ", " "))) {
            textFitaCorreta.setText(fita);
            resultado.setText("Correto, você acertou!!");
            textFitaCorreta.setVisibility(View.VISIBLE);
            resultado.setTextColor(Color.parseColor("#008807"));
            resultado.setVisibility(View.VISIBLE);
            makeText(this, "Tradução Finalizada", Toast.LENGTH_SHORT).show();

        }    else {
            textFitaCorreta.setText("Tradução correta: " + ligPeptidica);
            resultado.setText("Você errou :(");
            textFitaCorreta.setVisibility(View.VISIBLE);
            resultado.setTextColor(Color.parseColor("#B00020"));
            resultado.setVisibility(View.VISIBLE);

        }
        if (fita.isEmpty()) {
            textFitaCorreta.setVisibility(View.INVISIBLE);
            resultado.setVisibility(View.INVISIBLE);
            makeText(this, "Traduza o gene", Toast.LENGTH_SHORT).show();
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static Spannable colorir(final String fita, String amino, final int color) {
        final Spannable spannable = new SpannableString(fita);
        List<String> cod = getKeyByValue(aminoacidos, amino);
        String codon = "";
        int i = 0;
        for (String c : cod){
            if (fita.contains(cod.get(i))){
                codon = cod.get(i);
            }
            i++;
        }

        int substringStart=0;
        int start;
        while((start=fita.indexOf(codon,substringStart))>=0){
            spannable.setSpan(
                    new ForegroundColorSpan(color),start,start+codon.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            );
            substringStart = start+codon.length();
        }
        return spannable;
    }
}


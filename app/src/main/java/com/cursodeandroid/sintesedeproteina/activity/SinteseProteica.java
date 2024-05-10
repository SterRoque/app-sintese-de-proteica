package com.cursodeandroid.sintesedeproteina.activity;

import android.annotation.SuppressLint;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class SinteseProteica{

    private char[] fitaDna;
    private int tam;
    private String dnaDuplicado;
    private String fitaDnaSep;
    private char[] fitaRna;
    private String fita;
    private String fitaRnaFinal;
    private String msg;

    public String getFitaRnaFinal() {
        return fitaRnaFinal;
    }



    public String getDnaDuplicado() {
        return dnaDuplicado;
    }

    public void setDnaDuplicado(String dnaDuplicado) {
        this.dnaDuplicado = dnaDuplicado;
    }

    public String getFitaDnaSep() {
        return fitaDnaSep;
    }

    public void setFitaDnaSep(String fitaDnaSep) {
        this.fitaDnaSep = fitaDnaSep;
    }

    public String duplicacao(String fit, int tam){

        this.tam = tam;
        fitaDna = new char[tam];
        char []fitaDna2 = new char[tam];
        fitaDna = fit.toUpperCase().toCharArray();
        for (int i = 0; i < fitaDna.length; i++){
            if (fitaDna[i] == 'A'){
                fitaDna2[i] = 'T';
            } else if (fitaDna[i] == 'T'){
                fitaDna2[i] = 'A';
            } else if (fitaDna[i] == 'G'){
                fitaDna2[i] = 'C';
            } else if (fitaDna[i] == 'C'){
                fitaDna2[i] = 'G';
            }
        }
        dnaDuplicado = String.valueOf(fitaDna2);
        return dnaDuplicado;
    }



    @SuppressLint("SetTextI18n")
    public String transcricao2(String fita) {
        tam = fita.length();
        fitaDna = fita.toUpperCase().toCharArray();
        char[] fitaRna = new char[tam];

        for (int i = 0; i < fitaDna.length; i++) {
            if (fitaDna[i] == 'A') {
                fitaRna[i] = 'U';
            } else if (fitaDna[i] == 'T') {
                fitaRna[i] = 'A';
            } else if (fitaDna[i] == 'G') {
                fitaRna[i] = 'C';
            } else if (fitaDna[i] == 'C') {
                fitaRna[i] = 'G';
            }
        }

        String rnaF = "";
        for (char c: fitaRna) {
            rnaF += c;
        }
        int indiceAUG = rnaF.indexOf("AUG");
        int indiceFIM = 0;
        if (rnaF.contains("UAA")){
            int fim = rnaF.indexOf("UAA");
            indiceFIM = fim+3;
        } else if (rnaF.contains("UGA")){
            int fim = rnaF.indexOf("UGA");
            indiceFIM = fim+3;
        } else if (rnaF.contains("UAG")){
            int fim= rnaF.indexOf("UAG");
            indiceFIM = fim+3;
        }
        String inicioFita = rnaF.substring(0, indiceAUG);
        String fimFita = rnaF.substring(indiceFIM);
        rnaF = rnaF.substring(indiceAUG, indiceFIM);

        String fitaRnaConcat = inicioFita + " " +
                (addEspaco(rnaF, 3, " ").trim()) + " " + fimFita;
        return fitaRnaConcat;
    }

    public String traducao(String fita) {

        String fitaRnaTranscrita = transcricao2(fita);
        Map<String, String> aminoacidos = new HashMap<>();

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

        int indiceAUG = fitaRnaTranscrita.indexOf("AUG");
        fitaRnaTranscrita = fitaRnaTranscrita.substring(indiceAUG);

        String[] trincas = fitaRnaTranscrita.split(" ");

        String ligacaoPeptidica = "";
        for (int i = 0; i <trincas.length; i++){
            if (aminoacidos.containsKey(trincas[i]) && !(ligacaoPeptidica.contains("Fim"))){
                ligacaoPeptidica += aminoacidos.get(trincas[i]) + " - ";
            } else {
                break;
            }
        }
        ligacaoPeptidica = ligacaoPeptidica.replace(" - Fim -", "").trim();
        return ligacaoPeptidica;
    }
    public String addEspaco(String f, int intervalo, String caract){
        String fitaR = "";
        for (int i = 0; i < ((f.length()/intervalo)); i++){
            fitaR += f.substring(i*intervalo, ((i+1))*intervalo) + caract;
        }
        return fitaR.trim();
    }
}

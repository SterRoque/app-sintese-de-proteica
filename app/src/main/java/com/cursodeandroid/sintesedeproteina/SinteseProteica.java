package com.cursodeandroid.sintesedeproteina;

import android.annotation.SuppressLint;

public class SinteseProteica {

    private char[] fitaDna;
    private int qtd;
    private String dnaDuplicado;
    private String fitaDnaSep;
    //private String fita;


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

    public String duplicacao(String fit, int qtd){

        this.qtd = qtd;
        fitaDna = new char[qtd];
        char []fitaDna2 = new char[qtd];

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
    public String transcricao2(String fita){

        qtd = fita.length();
        fitaDna = new char[qtd];
        char[] fitaRna = new char[qtd];

        fitaDna = fita.toUpperCase().toCharArray();
        for (int i = 0; i < fitaDna.length; i++){
            if (fitaDna[i] == 'A'){
                fitaRna[i] = 'U';
            } else if (fitaDna[i] == 'T'){
                fitaRna[i] = 'A';
            } else if (fitaDna[i] == 'G'){
                fitaRna[i] = 'C';
            } else if (fitaDna[i] == 'C'){
                fitaRna[i] = 'G';
            }
        }
        String rnaF = String.valueOf(fitaRna);
        String fitaRna2 = addEspaco(rnaF, 3, " ");
        //fitaDnaSep = addEspaco(fita, 3, " ");

        return fitaRna2;
    }





    /*public void traducao(View view) {
        fita = dna.getText().toString();

        if (fita.equals("")) {
            Toast.makeText(
                    getApplicationContext(),
                    "Digite a fita de DNA",
                    Toast.LENGTH_SHORT
            ).show();
        } else {
            transcricao2(fita);
            int aux = 0;
            char[] aminoAcidos = new char[fitaRna.length];
            for (int i = 0; i < fitaRna.length; i = i + 3) {
                if (fitaRna[i] == 'A' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'G') {
                    aminoAcidos[i] = 'M';
                    aminoAcidos[i + 1] = 'e';
                    aminoAcidos[i + 2] = 't';
                    aux = i;
                    break;

                }
            }
            for (int i = aux; i < fitaRna.length; i = i + 3) {
                if (fitaRna[i] == 'A' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'G') {
                    aminoAcidos[i] = 'M';
                    aminoAcidos[i + 1] = 'e';
                    aminoAcidos[i + 2] = 't';

                } else if (
                        (fitaRna[i] == 'U' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'U') ||
                                (fitaRna[i] == 'U' && fitaRna[i + 1] == 'C' && fitaRna[i + 2] == 'C')
                ) {
                    aminoAcidos[i] = 'P';
                    aminoAcidos[i + 1] = 'h';
                    aminoAcidos[i + 2] = 'e';
                } else if (
                        (fitaRna[i] == 'U' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'A') ||
                                (fitaRna[i] == 'U' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'G') ||
                                (fitaRna[i] == 'C' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'U') ||
                                (fitaRna[i] == 'C' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'C') ||
                                (fitaRna[i] == 'C' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'A') ||
                                (fitaRna[i] == 'C' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'G')
                ) {
                    aminoAcidos[i] = 'L';
                    aminoAcidos[i + 1] = 'e';
                    aminoAcidos[i + 2] = 'e';
                } else if (
                        (fitaRna[i] == 'U' && fitaRna[i + 1] == 'C' && fitaRna[i + 2] == 'U') ||
                                (fitaRna[i] == 'U' && fitaRna[i + 1] == 'C' && fitaRna[i + 2] == 'C') ||
                                (fitaRna[i] == 'U' && fitaRna[i + 1] == 'C' && fitaRna[i + 2] == 'A') ||
                                (fitaRna[i] == 'U' && fitaRna[i + 1] == 'C' && fitaRna[i + 2] == 'G') ||
                                (fitaRna[i] == 'A' && fitaRna[i + 1] == 'G' && fitaRna[i + 2] == 'U') ||
                                (fitaRna[i] == 'A' && fitaRna[i + 1] == 'G' && fitaRna[i + 2] == 'C')
                ) {
                    aminoAcidos[i] = 'S';
                    aminoAcidos[i + 1] = 'e';
                    aminoAcidos[i + 2] = 'r';
                } else if (
                        (fitaRna[i] == 'U' && fitaRna[i + 1] == 'A' && fitaRna[i + 2] == 'U') ||
                                (fitaRna[i] == 'U' && fitaRna[i + 1] == 'A' && fitaRna[i + 2] == 'C')
                ) {
                    aminoAcidos[i] = 'T';
                    aminoAcidos[i + 1] = 'y';
                    aminoAcidos[i + 2] = 'r';
                } else if (
                        (fitaRna[i] == 'U' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'G') ||
                                (fitaRna[i] == 'U' && fitaRna[i + 1] == 'G' && fitaRna[i + 2] == 'C')
                ) {
                    aminoAcidos[i] = 'C';
                    aminoAcidos[i + 1] = 'y';
                    aminoAcidos[i + 2] = 's';
                } else if (
                        (fitaRna[i] == 'C' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'U') ||
                                (fitaRna[i] == 'C' && fitaRna[i + 1] == 'C' && fitaRna[i + 2] == 'C') ||
                                (fitaRna[i] == 'C' && fitaRna[i + 1] == 'C' && fitaRna[i + 2] == 'A') ||
                                (fitaRna[i] == 'C' && fitaRna[i + 1] == 'C' && fitaRna[i + 2] == 'G')
                ) {
                    aminoAcidos[i] = 'P';
                    aminoAcidos[i + 1] = 'r';
                    aminoAcidos[i + 2] = 'o';
                } else if (
                        (fitaRna[i] == 'C' && fitaRna[i + 1] == 'A' && fitaRna[i + 2] == 'U') ||
                                (fitaRna[i] == 'C' && fitaRna[i + 1] == 'A' && fitaRna[i + 2] == 'C')
                ) {
                    aminoAcidos[i] = 'H';
                    aminoAcidos[i + 1] = 'i';
                    aminoAcidos[i + 2] = 's';
                } else if (
                        (fitaRna[i] == 'C' && fitaRna[i + 1] == 'A' && fitaRna[i + 2] == 'A') ||
                                (fitaRna[i] == 'C' && fitaRna[i + 1] == 'A' && fitaRna[i + 2] == 'G')
                ) {
                    aminoAcidos[i] = 'G';
                    aminoAcidos[i + 1] = 'l';
                    aminoAcidos[i + 2] = 'n';
                } else if (
                        (fitaRna[i] == 'C' && fitaRna[i + 1] == 'G' && fitaRna[i + 2] == 'U') ||
                                (fitaRna[i] == 'C' && fitaRna[i + 1] == 'G' && fitaRna[i + 2] == 'C') ||
                                (fitaRna[i] == 'C' && fitaRna[i + 1] == 'G' && fitaRna[i + 2] == 'A') ||
                                (fitaRna[i] == 'C' && fitaRna[i + 1] == 'G' && fitaRna[i + 2] == 'G') ||
                                (fitaRna[i] == 'A' && fitaRna[i + 1] == 'G' && fitaRna[i + 2] == 'A') ||
                                (fitaRna[i] == 'A' && fitaRna[i + 1] == 'G' && fitaRna[i + 2] == 'C')
                ) {
                    aminoAcidos[i] = 'A';
                    aminoAcidos[i + 1] = 'r';
                    aminoAcidos[i + 2] = 'g';
                } else if (
                        (fitaRna[i] == 'A' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'U') ||
                                (fitaRna[i] == 'A' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'C') ||
                                (fitaRna[i] == 'A' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'A')
                ) {
                    aminoAcidos[i] = 'I';
                    aminoAcidos[i + 1] = 'l';
                    aminoAcidos[i + 2] = 'e';
                } else if (
                        (fitaRna[i] == 'A' && fitaRna[i + 1] == 'C' && fitaRna[i + 2] == 'U') ||
                                (fitaRna[i] == 'A' && fitaRna[i + 1] == 'C' && fitaRna[i + 2] == 'C') ||
                                (fitaRna[i] == 'A' && fitaRna[i + 1] == 'C' && fitaRna[i + 2] == 'A') ||
                                (fitaRna[i] == 'A' && fitaRna[i + 1] == 'C' && fitaRna[i + 2] == 'G')
                ) {
                    aminoAcidos[i] = 'T';
                    aminoAcidos[i + 1] = 'h';
                    aminoAcidos[i + 2] = 'r';
                } else if (
                        (fitaRna[i] == 'A' && fitaRna[i + 1] == 'A' && fitaRna[i + 2] == 'U') ||
                                (fitaRna[i] == 'A' && fitaRna[i + 1] == 'A' && fitaRna[i + 2] == 'C')
                ) {
                    aminoAcidos[i] = 'A';
                    aminoAcidos[i + 1] = 's';
                    aminoAcidos[i + 2] = 'n';
                } else if (
                        (fitaRna[i] == 'A' && fitaRna[i + 1] == 'A' && fitaRna[i + 2] == 'A') ||
                                (fitaRna[i] == 'A' && fitaRna[i + 1] == 'A' && fitaRna[i + 2] == 'G')
                ) {
                    aminoAcidos[i] = 'L';
                    aminoAcidos[i + 1] = 'y';
                    aminoAcidos[i + 2] = 's';
                } else if (
                        (fitaRna[i] == 'G' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'U') ||
                                (fitaRna[i] == 'G' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'C') ||
                                (fitaRna[i] == 'G' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'A') ||
                                (fitaRna[i] == 'G' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'G')
                ) {
                    aminoAcidos[i] = 'V';
                    aminoAcidos[i + 1] = 'a';
                    aminoAcidos[i + 2] = 'l';
                } else if (
                        (fitaRna[i] == 'G' && fitaRna[i + 1] == 'C' && fitaRna[i + 2] == 'U') ||
                                (fitaRna[i] == 'G' && fitaRna[i + 1] == 'C' && fitaRna[i + 2] == 'C') ||
                                (fitaRna[i] == 'G' && fitaRna[i + 1] == 'C' && fitaRna[i + 2] == 'A') ||
                                (fitaRna[i] == 'G' && fitaRna[i + 1] == 'C' && fitaRna[i + 2] == 'G')
                ) {
                    aminoAcidos[i] = 'A';
                    aminoAcidos[i + 1] = 'l';
                    aminoAcidos[i + 2] = 'a';
                } else if (
                        (fitaRna[i] == 'G' && fitaRna[i + 1] == 'A' && fitaRna[i + 2] == 'U') ||
                                (fitaRna[i] == 'G' && fitaRna[i + 1] == 'A' && fitaRna[i + 2] == 'C')
                ) {
                    aminoAcidos[i] = 'A';
                    aminoAcidos[i + 1] = 's';
                    aminoAcidos[i + 2] = 'p';
                } else if (
                        (fitaRna[i] == 'G' && fitaRna[i + 1] == 'A' && fitaRna[i + 2] == 'A') ||
                                (fitaRna[i] == 'G' && fitaRna[i + 1] == 'A' && fitaRna[i + 2] == 'G')
                ) {
                    aminoAcidos[i] = 'G';
                    aminoAcidos[i + 1] = 'l';
                    aminoAcidos[i + 2] = 'u';
                } else if (
                        (fitaRna[i] == 'G' && fitaRna[i + 1] == 'U' && fitaRna[i + 2] == 'U') ||
                                (fitaRna[i] == 'G' && fitaRna[i + 1] == 'G' && fitaRna[i + 2] == 'C') ||
                                (fitaRna[i] == 'G' && fitaRna[i + 1] == 'G' && fitaRna[i + 2] == 'A') ||
                                (fitaRna[i] == 'G' && fitaRna[i + 1] == 'G' && fitaRna[i + 2] == 'G')
                ) {
                    aminoAcidos[i] = 'G';
                    aminoAcidos[i + 1] = 'l';
                    aminoAcidos[i + 2] = 'y';
                } else if (
                        (fitaRna[i] == 'U' && fitaRna[i + 1] == 'A' && fitaRna[i + 2] == 'A') ||
                                (fitaRna[i] == 'U' && fitaRna[i + 1] == 'A' && fitaRna[i + 2] == 'G') ||
                                (fitaRna[i] == 'U' && fitaRna[i + 1] == 'G' && fitaRna[i + 2] == 'A')
                ) {
                    break;
                }
            }

            String amino = String.valueOf(aminoAcidos);
            amino = addEspaco(amino, 3, " ");

            resultadoAmino.setText(amino);
            resultadoAmino.setVisibility(View.VISIBLE);
        }
    }*/
    public String addEspaco(String f, int intervalo, String caract){
        String fitaR = "";
        for (int i = 0; i < ((f.length()/intervalo)); i++){
            fitaR += f.substring(i*intervalo, ((i+1))*intervalo) + caract;
        }
        return fitaR;
    }
}

package com.cursodeandroid.sintesedeproteina.activity;

public class FitaRna {

    String codon;
    boolean status;
    boolean descarte;
    String cor;

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public FitaRna(String codon, boolean status, boolean descarte) {
        this.codon = codon;
        this.status = status;
        this.descarte = descarte;
    }

    public FitaRna( ){

    }

    public String getCodon() {
        return codon;
    }

    public void setCodon(String codon) {
        this.codon = codon;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isDescarte() {
        return descarte;
    }

    public void setDescarte(boolean descarte) {
        this.descarte = descarte;
    }
}

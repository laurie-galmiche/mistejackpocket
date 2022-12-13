package com.company;

public class Alibi
{

    private String nom;
    private int sablier;

    public String getNom() {
        return nom;
    }
    public int getSablier() {
        return sablier;
    }

    public Alibi(String unNom, int nbSabliers) {
        this.nom = unNom;
        this.sablier = nbSabliers;
    }

    public String toString() {
        StringBuilder affichage = new StringBuilder();
        affichage.append(this.getNom());
        affichage.append("(" + this.getSablier() + ")");
        return affichage.toString();
    }

}

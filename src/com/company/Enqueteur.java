package com.company;

public class Enqueteur {

    int position;

    public Enqueteur(int p) {
        this.position= p;
    }
    public Enqueteur() {
    }
    public int getposition()
    {
        return position;
    }

    public void avancer(int nombrecase)
    {
        position=position+nombrecase;
        position=(position % 12);
    }
}

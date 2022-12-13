package com.company;

public class JoueurJack {

    int sablier;
    String jack;

    public void setJoueurJack(int s,String j)
    {
        this.jack= j;
        this.sablier=s;
    }

    public JoueurJack(int s,String j) {
        this.jack= j;
        this.sablier=s;
    }

    public String getJack() {
        return jack;
    }
    public int getSablier() {
        return sablier;
    }

    public void addsablier(int s)
    {
        sablier=sablier+s;
    }

    public boolean verifier()
    {
        if (sablier>=6)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void affichesablier()
    {
        System.out.println("le joueur jack a " + sablier + " sabliers");
    }
}

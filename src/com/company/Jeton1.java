package com.company;

import java.util.Deque;
import java.util.Random;

public class Jeton1 extends Jeton {


	/*
	@Override
	public int getAction() {
		if (recto==true)
		{
			return 1;
		}
		else
		{
			return 2;
		}
	}
	*/

    //Alibi
    //@Override
    public void action1(String tourjoueur,Deque<Alibi> pioche,JoueurJack joueurJ,JoueurEnqueteur joueurE, District[][] plateau) {
        Alibi carte = pioche.pollFirst();
        if (tourjoueur.equals("J")) {
            joueurJ.addsablier(carte.getSablier());
            System.out.println("c'est : " + carte.getNom() + " avec " + carte.getSablier() + " sabliers");
            System.out.println("vous avez maintenant " + joueurJ.getSablier() + " sabliers");

        } else {
            joueurE.innocenter(carte.getNom());
            System.out.println("c'est : " + carte.getNom());

            for (int l = 0; l < 3; l++) {
                for (int c = 0; c < 3; c++) {
                    if (plateau[l][c].getNom().equals(carte.getNom())) {
                        plateau[l][c].changervide();
                    }
                }

            }

    }
    }

    //Sherlock
    //@Override
    public void action2(Enqueteur sherlock,int nombrecase)
    {
        sherlock.avancer(nombrecase);
    }
    @Override
    public String nom()
    {
        if (recto)
        {
            return ("Alibi");
        }
        else
        {
            return ("Sherlock");
        }
    }
}

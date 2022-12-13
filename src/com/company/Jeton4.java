package com.company;


import java.util.Random;

public class Jeton4  extends Jeton {

	/*@Override
	public int getAction() {
		if (recto==true)
		{
			return 7;
		}
		else
		{
			return 8;
		}
	}*/

    //Rotation
    //@Override
    public void action1(District[][] plateau,int ligne , int colonne,int nvmur)
    {
        plateau[ligne-1][colonne-1].changermur(nvmur);
    }

    //Joker
    //@Override
    public void action2(Enqueteur x,int nombrecase)
    {
        x.avancer(nombrecase);

    }
    @Override
    public String nom()
    {
        if (recto)
        {
            return ("Rotation");
        }
        else
        {
            return ("Joker");
        }
    }
}

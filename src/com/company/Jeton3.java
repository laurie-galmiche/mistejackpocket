package com.company;


import java.util.Random;

public class Jeton3 extends Jeton  {

/*	@Override
	public int getAction() {
		if (recto==true)
		{
			return 5;
		}
		else
		{
			return 6;
		}
	}*/


    //Rotation
    //@Override
    public void action1(District[][] plateau,int ligne , int colonne,int nvmur)
    {
        plateau[ligne-1][colonne-1].changermur(nvmur);
    }

    //Echange
    //@Override
    public void action2(District[][] plateau,int i , int j , int k , int l)
    {
        District a =plateau[i-1][j-1];

        District b =plateau[k-1][l-1];
        District retenue = b;

        plateau[k-1][l-1]=a;
        plateau[i-1][j-1]=retenue;

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
            return ("Echange");
        }
    }
}

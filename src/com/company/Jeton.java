package com.company;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Random;

public abstract class Jeton {

    boolean recto ;
    int nombre;

    public void setnombre(int a)
    {
        nombre=a;
    }
    public int getnombre()
    {
        return nombre;
    }
    public abstract String nom();
    public void lancer()
    {
        Random r = new Random();
        recto = r.nextBoolean();
    }
    public void retourner()
    {
        recto = !recto;
    }

    public int getrecto()
    {
        if (recto==true)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    public void setrecto(boolean r)
    {
        this.recto=r;
    }

    // public abstract int getAction() ;

	 /*public abstract void action1(District[][] plateau,String tourjoueur,Enqueteur toby,Enqueteur sherlock,Enqueteur watson,Deque<Alibi> pioche);
	 public abstract void action2(District[][] plateau,String tourjoueur,Enqueteur toby,Enqueteur sherlock,Enqueteur watson,Deque<Alibi> pioche);

	 public void action(District[][] plateau,String tourjoueur,Enqueteur toby,Enqueteur sherlock,Enqueteur watson,Deque<Alibi> pioche)
	 {
		 if (recto==true)
		 {
			 action1(plateau,tourjoueur,toby,sherlock,watson,pioche);
		 }
		 else
		 {
			 action2(plateau,tourjoueur,toby,sherlock,watson,pioche);
		 }
	 }*/
}

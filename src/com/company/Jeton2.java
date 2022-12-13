package com.company;

import java.util.Deque;
import java.util.Random;

public class Jeton2 extends Jeton {

	/*
	@Override
	public int getAction() {
		if (recto==true)
		{
			return 3;
		}
		else
		{
			return 4;
		}
	}
	*/

    //Toby
    //@Override
    public void action1(Enqueteur toby,int nombrecase)
    {

        toby.avancer(nombrecase);
    }

    //Watson
    //@Override
    public void action2(Enqueteur watson,int nombrecase)
    {
        watson.avancer(nombrecase);
    }
    @Override
    public String nom()
    {
        if (recto)
        {
            return ("Toby");
        }
        else
        {
            return ("Watson");
        }
    }
}

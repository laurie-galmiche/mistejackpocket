package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JoueurEnqueteur {

    ArrayList<String> suspect;


    public void initsuspect()
    {
        this.suspect=new ArrayList<String>();
        suspect.add("Inspecteur Lestrade");
        suspect.add("Miss Stealthy");
        suspect.add("Jeremy Bert");
        suspect.add("John Pizer");
        suspect.add("John Smith");
        suspect.add("Joseph Lane");
        suspect.add("Madame");
        suspect.add("Sgt Goodley");
        suspect.add("William Gull");


    }

    public void majlistesuspect(ArrayList<String> j)
    {
        suspect.clear();
        for (int i =0;i<j.size();i++)
        {
            if(suspect.contains(j.get(i))==false)
            {
                suspect.add(j.get(i));
            }
        }
    }

    public void innocenter(String nom)
    {
        suspect.remove(nom);
    }

    public boolean verifier()
    {
        if (suspect.size()==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void affichesuspect()
    {
        System.out.println ("suspects encore en liste =");

        for ( int i =0;i<suspect.size();i++)
        {
            System.out.println(suspect.get(i));
        }
    }
}


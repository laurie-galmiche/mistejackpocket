package com.company;
import java.util.List;
public class District {



    public String suspect;
    public String id;
    public boolean vide;
    public int mur;



    public District(String suspect) {
        this.suspect = suspect;
        this.id = suspect.substring(0,1);
        this.vide = false;
        this.mur = 0;
    }

    public District(String suspect, String id) {
        this.suspect = suspect;
        this.id = id;
        this.vide = false;
        this.mur = 0;
    }

    public District(boolean vide, int mur) {
        this.suspect = "x";
        this.id = "x";
        this.vide = vide;
        this.mur = mur;
    }

    public void changermur(int nvmur)
    {
        mur=nvmur;
    }

    public void changervide()
    {
        vide=true;
        if (suspect.equals("Joseph Lane"))
        {
            changermur(5);
        }
    }


    public String getNom()
    {
        return suspect;
    }
    public boolean getVide()
    {
        return vide;
    }



    @Override
    public String toString() {
        return suspect;
    }


}

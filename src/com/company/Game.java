package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    District[][] plateau;
    Enqueteur watson;
    Enqueteur sherlock;
    Enqueteur toby;
    LinkedList<Alibi> pioche;
    JoueurJack joueurJ;
    JoueurEnqueteur joueurE;

    public void play() {

        boolean findujeu =false;

        sherlock = new Enqueteur(11);
        watson = new Enqueteur(3);
        toby = new Enqueteur(7);
        pioche = new LinkedList<Alibi>();

        Scanner scanner = new Scanner(System.in);
        // Initialisation du jeu
        List<District> lesDistricts = this.initDistricts();


        initpioche(pioche);

        plateau = new District[3][3];
        initplateau(plateau,lesDistricts);




        Alibi coupable = pioche.peek();
        joueurJ= new JoueurJack(0,coupable.getNom());
        pioche.removeFirst();
        System.out.println("Jack est :"+joueurJ.getJack());


        joueurE = new JoueurEnqueteur();
        joueurE.initsuspect();


        String tourjoueur = "";

        ArrayList<Jeton> jeton = new ArrayList<>();
        ArrayList<Jeton> jetonbis = new ArrayList<Jeton>(4);

        boolean egalite = false;

        for (int tour=1;tour<9;tour++)
        {
            if (!findujeu) {
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("-----------------------------------------------");
                System.out.println("tour : " + tour);

                affichePlateau(plateau);

                Jeton1 j1 = new Jeton1();
                j1.setnombre(1);
                Jeton2 j2 = new Jeton2();
                j2.setnombre(2);
                Jeton3 j3 = new Jeton3();
                j3.setnombre(3);
                Jeton4 j4 = new Jeton4();
                j4.setnombre(4);


                if (tour % 2 == 1) {
                    jetonbis.clear();
                    jeton.add(j1);
                    jeton.add(j2);
                    jeton.add(j3);
                    jeton.add(j4);
                    for (int a = 0; a < jeton.size(); a++) {
                        jeton.get(a).lancer();
                        jetonbis.add(jeton.get(a));
                    }
                } else {
                    for (int a = 0; a < jetonbis.size(); a++) {
                        jetonbis.get(a).retourner();
                        jeton.add(jetonbis.get(a));

                    }
                    jetonbis.clear();
                }


                jeu(jeton, tourjoueur, j1, j2, j3, j4, tour);

                // appel à temoin

                System.out.println();
                System.out.println();
                System.out.println("appel à temoin");
                affichePlateau(plateau);


                List<District> temoin = new ArrayList<District>();
                temoin = appelatemoin(sherlock);
                List<District> temoin1 = new ArrayList<District>();
                temoin1 = appelatemoin(watson);
                for (int b = 0; b < temoin1.size(); b++) {
                    if (!temoin.contains(temoin1.get(b))) {
                        temoin.add(temoin1.get(b));
                    }
                }

                List<District> temoin2 = new ArrayList<District>();
                temoin2 = appelatemoin(toby);
                for (int b = 0; b < temoin2.size(); b++) {
                    if (!temoin.contains(temoin2.get(b))) {
                        temoin.add(temoin2.get(b));
                    }
                }

                ArrayList<String> listetemoin = new ArrayList<String>();
                System.out.println("personnes vues =");
                for (int i = 0; i < temoin.size(); i++) {
                    listetemoin.add(temoin.get(i).getNom());
                    System.out.println(listetemoin.get(i));
                }


                boolean jackvu = false;
                for (int i = 0; i < listetemoin.size(); i++) {
                    if (joueurJ.getJack().equals(listetemoin.get(i))) {
                        jackvu = true;
                    }
                }

                if (jackvu == true) {
                    if (egalite == false) {
                        joueurE.majlistesuspect(listetemoin);
                        majplateauvu(temoin);
                    } else {
                        System.out.println(" joueur E a gagné");
                        findujeu=true;
                    }
                } else {
                    if (egalite == false) {
                        for (int i = 0; i < listetemoin.size(); i++) {
                            joueurE.innocenter(listetemoin.get(i));
                        }
                        joueurJ.addsablier(1);
                        majplateaunonvu(temoin);
                    }

                }

                joueurE.affichesuspect();
                joueurJ.affichesablier();

                if (egalite == false) {

                    if (joueurE.verifier() == true && joueurJ.verifier() == true) {
                        System.out.println(" il y a egalité pour les 2 joueurs");
                        egalite = true;

                    } else if (joueurJ.verifier() == true) {
                        System.out.println(" joueur J a gagné");
                        findujeu=true;
                    } else if (joueurE.verifier() == true) {
                        System.out.println(" joueur E a gagné");
                        findujeu=true;
                    }
                }
                if (tour == 8) {
                    System.out.println(" joueur J a gagné");
                    findujeu=true;
                }


            }

        }

    }
public void jeu(ArrayList<Jeton> jeton,String tourjoueur,Jeton1 j1,Jeton2 j2,Jeton3 j3,Jeton4 j4,int tour)
{
    Scanner scanner = new Scanner(System.in);
    for (int action=0;action<4;action++)
    {


        for ( int a=0;a<jeton.size();a++)
        {
            System.out.print(jeton.get(a).nom() +" ");
        }
        System.out.println();



        if (action==0 || action ==3)
        {
            if (tour%2==1){tourjoueur = "E";}
            else {tourjoueur="J";}
        }
        else
        {
            if (tour%2==1){tourjoueur = "J";}
            else {tourjoueur="E";}
        }

        System.out.println("tourjoueur = "+tourjoueur);

        System.out.println("quel jeton voulez vous choisir ");
        int choix = scanner.nextInt();

        if (jeton.get(choix-1).getnombre()==1)
        {
            if (jeton.get(choix-1).getrecto() == 1)
            {
                j1.action1(tourjoueur, pioche, joueurJ, joueurE,plateau);
                affichePlateau(plateau);
            }
            if (jeton.get(choix-1).getrecto() == 2)
            {
                System.out.println("1 ou 2 cases ?");
                int n = scanner.nextInt();
                j1.action2(sherlock,n);
                System.out.println("position de sherlock = "+sherlock.getposition());
            }
        }
        if (jeton.get(choix-1).getnombre()==2)
        {
            if (jeton.get(choix-1).getrecto() == 1)
            {
                System.out.println("1 ou 2 cases ?");
                int n = scanner.nextInt();
                j2.action1(toby, n);
                System.out.println("position de toby = "+toby.getposition());
            }
            if (jeton.get(choix-1).getrecto() == 2)
            {
                System.out.println("1 ou 2 cases ?");
                int n = scanner.nextInt();
                j2.action2(watson, n);
                System.out.println("position de watson = "+watson.getposition());
            }
        }
        if (jeton.get(choix-1).getnombre()==3)
        {
            if (jeton.get(choix-1).getrecto() == 1)
            {
                System.out.println("quelle ligne ?");
                int ligne = scanner.nextInt();
                System.out.println("quelle colonne ?");
                int colonne = scanner.nextInt();
                System.out.println("où mettre le mur (0,1,2 ou 3)");
                int nvmur = scanner.nextInt();
                j3.action1(plateau, ligne, colonne, nvmur);
                affichePlateau(plateau);

            }
            if (jeton.get(choix-1).getrecto() == 2)
            {
                System.out.println("quelle ligne ?");
                int i = scanner.nextInt();
                System.out.println("quelle colonne ?");
                int j = scanner.nextInt();


                System.out.println("quelle ligne ?");
                int k = scanner.nextInt();
                System.out.println("quelle colonne ?");
                int l = scanner.nextInt();


                j3.action2(plateau,i,j,k,l);
                affichePlateau(plateau);
            }
        }
        if (jeton.get(choix-1).getnombre()==4)
        {
            if (jeton.get(choix-1).getrecto() == 1)
            {
                System.out.println("quelle ligne ?");
                int ligne = scanner.nextInt();
                System.out.println("quelle colonne ?");
                int colonne = scanner.nextInt();
                System.out.println("où mettre le mur (0,1,2 ou 3)");
                int nvmur = scanner.nextInt();
                j4.action1(plateau, ligne, colonne, nvmur);
            }
            if (jeton.get(choix-1).getrecto() == 2)
            {
                System.out.println("quel enqueteur ?");
                String nom = scanner.next();
                Enqueteur x = new Enqueteur();
                if (nom.contentEquals("sherlock"))
                {
                    x = sherlock;
                }
                if (nom.contentEquals("watson"))
                {
                    x = watson;
                }
                if (nom.contentEquals("toby"))
                {
                    x = toby;
                }
                System.out.println("combien de cases ?");
                int n = scanner.nextInt();
                j4.action2(x, n);
            }
        }
        jeton.remove(choix-1);

    }
}

    public void initplateau(District[][] plateau,List<District> lesDistricts) {
        Random rand = new Random();
        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                int index = rand.nextInt(lesDistricts.size());
                District carte = lesDistricts.remove(index);
                this.plateau[l][c] = carte;
                if (l == 0 && c == 0) {
                    carte.mur = 3;
                } else if (l == 0 && c == 2) {
                    carte.mur = 1;
                } else if (l == 2 && c == 1) {
                    carte.mur = 2;
                } else {
                    carte.mur = rand.nextInt(4);
                }
            }
        }
    }
    public void initpioche(LinkedList<Alibi> pioche) {
        pioche.addFirst(new Alibi("Inspecteur Lestrade", 0));
        pioche.addFirst(new Alibi("Miss Stealthy", 1));
        pioche.addFirst(new Alibi("Jeremy Bert", 1));
        pioche.addFirst(new Alibi("John Pizer", 1));
        pioche.addFirst(new Alibi("John Smith", 1));
        pioche.addFirst(new Alibi("Joseph Lane", 1));
        pioche.addFirst(new Alibi("Madame", 2));
        pioche.addFirst(new Alibi("Sgt Goodley", 0));
        pioche.addFirst(new Alibi("William Gull", 1));
        Collections.shuffle(pioche);
    }

    public void affichePlateau( District[][] plateau) {
        for (int l=0;l<3;l++) {
            for (int c=0;c<3;c++) {
                District carte = plateau[l][c];
                if (carte.mur == 0) {
                    System.out.print("   ");
                } else {
                    System.out.print(" # ");
                }
            }
            System.out.println();
            for (int c=0;c<3;c++) {
                District carte = plateau[l][c];
                // Ouest est vide si Nord = 1(230)
                if (carte.mur == 3) {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
                // centre de la carte: suspect ou vide
                if (carte.vide) {
                    System.out.print("#");
                }
                else
                {
                    System.out.print(carte.id);
                }

                // Est est vide si Nord = 3(012)
                if (carte.mur == 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }

            }
            System.out.println();
            for (int c=0;c<3;c++) {
                District carte = plateau[l][c];
                // Sud est vide si Nord = 2(301)
                if (carte.mur == 2) {
                    System.out.print("   ");
                } else {
                    System.out.print(" # ");
                }
            }
            System.out.println();
        }
        System.out.println("emplacement de sherlock = "+sherlock.getposition());
        System.out.println("emplacement de watson = "+watson.getposition());
        System.out.println("emplacement de toby = "+toby.getposition());
        System.out.println(" ");
    }

    public List initDistricts() {
        List<District> listDistricts = new LinkedList<>();
        listDistricts.add( new District("Inspecteur Lestrade", "I") );
        listDistricts.add( new District("Miss Stealthy", "S") );
        listDistricts.add( new District("Jeremy Bert", "B") );
        listDistricts.add( new District("John Pizer", "P") );
        listDistricts.add( new District("John Smith", "J") );
        listDistricts.add( new District("Joseph Lane", "L") );
        listDistricts.add( new District("Madame", "M") );
        listDistricts.add( new District("Sgt Goodley", "G") );
        listDistricts.add( new District("William Gull", "W") );
        return listDistricts;
    }



    public District getDistrict(int a, int b)
    {
        return plateau[a][b];
    }






    //appel à temoin
    public List<District> appelatemoin(Enqueteur enqueteur) {

        int position =enqueteur.getposition();
        List<District> visibles = new ArrayList<District>();

        if (position==0||position==1||position ==2)
        {
            for (int i = 0; i < 3; i++) {
                int nord = this.plateau[i][position].mur;
                if (nord == 0) {
                    break;
                } else if (nord == 2) {
                    if (this.plateau[i][position].vide==false) {visibles.add(this.plateau[i][position]);}
                    break;
                } else {
                    if (this.plateau[i][position].vide==false) {visibles.add(this.plateau[i][position]);}
                }
            }
            return visibles;
        }


        if (position==3||position==4||position ==5)
        {
            for (int i = 3; i > 0; i--) {
                int nord = this.plateau[position-3][i-1].mur;
                if (nord == 1) {
                    break;
                } else if (nord == 3) {
                    if (this.plateau[position-3][i-1].vide==false) {visibles.add(this.plateau[position-3][i-1]);}
                    break;
                } else {
                    if (this.plateau[position-3][i-1].vide==false) {visibles.add(this.plateau[position-3][i-1]);}
                }
            }
            return visibles;

        }

        if (position==6||position==7||position ==8)
        {
            for (int i = 3; i > 0; i--) {
                int nord = this.plateau[i-1][-position+8].mur;
                if (nord == 2) {
                    break;
                } else if (nord == 0) {
                    if (this.plateau[i-1][-position+8].vide==false) {visibles.add(this.plateau[i-1][-position+8]);}
                    break;
                } else {
                    if (this.plateau[i-1][-position+8].vide==false) {visibles.add(this.plateau[i-1][-position+8]);}
                }
            }
            return visibles;
        }

        if (position==9||position==10||position ==11)
        {
            for (int i = 0; i < 3; i++) {
                int nord = this.plateau[-position+11][i].mur;
                if (nord == 3) {
                    break;
                } else if (nord == 1) {
                    if (this.plateau[-position+11][i].vide==false) {visibles.add(this.plateau[-position+11][i]);}
                    break;
                } else {
                    if (this.plateau[-position+11][i].vide==false) {visibles.add(this.plateau[-position+11][i]);}
                }
            }
            return visibles;
        }

        else
        {
            return visibles;
        }
    }

    public void majplateaunonvu(List<District> temoin)

    {
        for (int l=0;l<3;l++)
        {
            for (int c=0;c<3;c++)
            {
                for (int i=0;i<temoin.size();i++)
                {
                    if (plateau[l][c].equals(temoin.get(i)))
                    {
                        plateau[l][c].changervide();
                    }
                }
            }
        }
    }

    public void majplateauvu(List<District> temoin)
    {
        for (int l=0;l<3;l++)
        {
            for (int c=0;c<3;c++)
            {
                for (int i=0;i<temoin.size();i++)
                {
                    if (!temoin.contains(plateau[l][c]))
                    {
                        plateau[l][c].changervide();
                    }
                }

            }
        }
    }

}




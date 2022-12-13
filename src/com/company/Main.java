package com.company;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while(true)
        {
            System.out.println("Voulez-vous jouer ? (y/n)");
            String reponse = scanner.next();

            if (reponse.equals("y")) {
                Game leJeu = new Game();
                leJeu.play();
            } else if (reponse.equals("n")) {
                break;
            } else {
                System.out.println("la réponse n'est pas valide");
            }
        }
    }
}





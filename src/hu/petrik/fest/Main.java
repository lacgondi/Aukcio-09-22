package hu.petrik.fest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File fileN = new File("festmenyek.csv");
        Scanner sc = new Scanner(System.in);
        try {
            Scanner scR = new Scanner(fileN);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Festmeny f1 = new Festmeny("Picasso's paiting", "Picasso", "oil");
        f1.bid(300);
        System.out.println(f1);

        List<Festmeny> fList = new ArrayList<>();
        fList.add(f1);
        fList.add(new Festmeny("Drip", "Drake", "hotline bling"));

        System.out.print("Adja meg, hogy hány festmény adatait adjuk hozzá a listához: ");
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            fList.add(new Festmeny("Festmeny"+i,"Festo"+i,"Stilus"+i));
        }

        for (int i = 0; i < 20; i++) {
            fList.get((int) Math.random()*fList.size()-1).bid((int)(Math.random()*100)+10);
        }

    }
}

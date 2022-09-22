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
        Scanner scR;
        try {
            scR = new Scanner(fileN);
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
            fList.add(new Festmeny("Festmeny" + i, "Festo" + i, "Stilus" + i));
        }
        for (int i = 0; i < 20; i++) {
            fList.get((int) (Math.random() * fList.size())).bid((int) (Math.random() * 100) + 10);
        }

        while (scR.hasNextLine()) {
            String[] temp = scR.nextLine().split(";");
            fList.add(new Festmeny(temp[0], temp[1], temp[2]));
        }

        int paintingID = -1;
        while (paintingID > fList.size() || paintingID < 0) {
            System.out.print("Adja meg melyik festményre szeretne licitálni: ");
            paintingID = sc.nextInt();
            System.out.print("\n");
            if (fList.get(paintingID).isSold() == true) {
                System.out.println("Ez a festmény már elkelt");
            }
        }
        int bid = -1;
        while (bid < 0) {
            System.out.print("Mennyit szertne licitálni: ");
            bid = sc.nextInt();
            System.out.print("\n");
            if (bid == 0) {
                fList.get(paintingID).bid();
            } else {
                fList.get(paintingID).bid(bid);
            }
        }

        for (int i = 0; i < fList.size(); i++) {
            if (fList.get(i).getNumberOfBids() > 0) {
                fList.get(i).setSold(true);
            }
            System.out.println(fList.get(i));
        }

    }
}

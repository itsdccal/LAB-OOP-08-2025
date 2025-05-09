package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hero hero = null;

        System.out.println("Pilih");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");
        System.out.println("--------------");
        System.out.print("Masukkan pilihan: ");

        try {
            int pilihHero = sc.nextInt();
            sc.nextLine();

            String name1 = "Archer";
            String name2 = "Wizard";
            String name3 = "Fighter";
    
            switch (pilihHero) {
                case 1:
                    hero = new Archer(name1);
                    break;
    
                case 2:
                    hero = new Wizard(name2);
                    break;
    
                case 3:
                    hero = new Fighter(name3);
                    break;
    
                default:
                    System.out.println("Input tidak valid.");
                }

                int menu;
                do {
                    System.out.println("\nMenu:");
                    System.out.println("1. Serang");
                    System.out.println("2. Keluar");
                    System.out.print("Pilih aksi: ");
                    menu = sc.nextInt();
        
                    if (menu == 1) {
                        hero.attack();
                    } else if (menu == 2) {
                        System.out.println("Game Selesai!");
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                    
                } 
                while (menu != 2);
        } catch (InputMismatchException e) {
            System.out.println("Mohon masukkan angka yang valid.");
        }
        sc.close();
    }
}
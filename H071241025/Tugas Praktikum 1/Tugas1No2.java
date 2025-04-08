import java.util.Scanner;
import java.util.Random;

public class Tugas1No2 {
    public static void main(String[] args) {
        Scanner a = new Scanner (System.in);
        Random random = new Random();
        
        int baris = 3, kolom = 3;
        int [][] nomor = new int[baris][kolom];

        for (int i = 0; i < baris; i++) {
          for (int j = 0; j < kolom; j++) {
            nomor[i][j] = random.nextInt(100) + 1;
          }
        }

        System.out.println("Array : ");
        for (int i = 0; i < baris; i++) {
          for (int j = 0; j < kolom; j++) {
            System.out.print(nomor[i][j] + " ");
          }
          System.out.println();
        }

        try {
            System.out.print("Masukkan angka : ");
            int angka = a.nextInt();
            boolean found = false;

            
            for (int i = 0; i < nomor.length; i++) { 
                for (int j = 0; j < nomor[i].length; j++) { 
                    if (nomor[i][j] == angka) {
                        System.out.println("Found " + angka + " at [" + i + "][" + j + "]");
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println(angka + " not found.");
            }

        } catch (Exception e) {
            System.out.println("Mohon masukkan angka yang valid.");
        } finally {
            a.close();
            System.out.println("end");
        }
    }
}

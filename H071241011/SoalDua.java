import java.util.Random;
import java.util.Scanner;

public class SoalDua {
    public static void main(String[] args) {
        int[][] matriks = new int[3][3];
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[i].length; j++) {
                matriks[i][j] = rand.nextInt(100) + 1;
            }
        }

        System.out.println("Matriks:");
        for (int[] row : matriks) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }

        try {
            System.out.print("Masukkan angka yang ingin dicari: ");
            int target = scanner.nextInt();

            for (int i = 0; i < matriks.length; i++) {
                for (int j = 0; j < matriks[i].length; j++) {
                    if (matriks[i][j] == target) {
                        System.out.println("Found " + target + " at [" + i + "][" + j + "]");
                        return;
                    }
                }
            }

            System.out.println("Angka tidak ditemukan.");
        } catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
        } finally {
            scanner.close();
        }
    }
}

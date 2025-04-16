import java.util.Random;
import java.util.Scanner;

public class Tugas02 {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        int[][] nums = new int[rows][cols];
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nums[i][j] = rand.nextInt(9) + 1; 
            }
        }

        System.out.println("Array 2D:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan angka yang ingin dicari: ");

        try {
            int target = scanner.nextInt();
            boolean found = false;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (nums[i][j] == target) {
                        System.out.println("Found " + target + " at [" + i + "][" + j + "]");
                        found = true;
                    }
                }
            }

            if (!found) {
                System.out.println(target + " tidak ditemukan dalam array.");
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan bilangan bulat.");
        } finally {
            scanner.close(); 
        }
    }
}
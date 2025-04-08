// import java.util.Scanner;

// public class No2 {
//     public static void main(String[] args) {
//         int[][] nums = {
//             {1, 2, 3},
//             {4, 5, 6},
//             {7, 8, 9}
//         };

//         Scanner scanner = new Scanner(System.in);

//         try {
//             System.out.print("Masukkan angka yang ingin dicari: ");
//             int target = scanner.nextInt();

//             boolean found = false;
//             for (int i = 0; i < nums.length; i++) {
//                 for (int j = 0; j < nums[i].length; j++) {
//                     if (nums[i][j] == target) {
//                         System.out.println("Found " + target + " at [" + i + "][" + j + "]");
//                         found = true;
//                         break; 
//                     }
//                 }
//                 if (found) break; 
//             }
//             if (!found) {
//                 System.out.println(target + " not found in array.");
//             }

//         } catch (Exception e) {
//             System.out.println("Input tidak valid! Masukkan angka bulat.");
//         } finally {
//             scanner.close();
//         }
//     }
// }




import java.util.Random;
import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        int[][] nums = new int[3][3];
        Random randomGenerator = new Random();
        fillArrayWithRandomNumbers(nums, randomGenerator);
        displayArray(nums);
        searchForNumberInArray(nums);
    }

    private static void fillArrayWithRandomNumbers(int[][] array, Random random) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(100);
            }
        }
    }

    private static void displayArray(int[][] array) {
        System.out.println("Array 2D:");
        for (int[] row : array) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    private static void searchForNumberInArray(int[][] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan angka yang ingin dicari: ");

        try {
            int target = scanner.nextInt();
            boolean found = false;

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] == target) {
                        System.out.println("Found " + target + " at [" + i + "][" + j + "]");
                        found = true;
                        break; 
                    }
                }
                if (found) {
                    break;
                }
            }

            if (!found) {
                System.out.println(target + " tidak ada dalam array.");
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid. Masukkan bilangan bulat.");
        } finally {
            scanner.close();
        }
    }
}
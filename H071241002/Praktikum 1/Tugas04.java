import java.util.Scanner;

public class Tugas04 {
    public static int faktorial(int n) {
        if (n == 0 || n == 1) {
            return 1; 
        } else {
            return n * faktorial(n - 1); 
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan bilangan n: ");
        
        try {
            int n = scanner.nextInt();
            if (n < 0) {
                System.out.println("Faktorial tidak terdefinisi untuk bilangan negatif.");
            } else {
                int hasil = faktorial(n);
                System.out.println("Faktorial dari " + n + " adalah " + hasil);
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan bilangan bulat.");
        } finally {
            scanner.close(); 
        }
    }
}

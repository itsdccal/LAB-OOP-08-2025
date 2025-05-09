import java.util.Scanner;

public class Tugas1No4 {
    public static void main(String[] args) {
      
        Scanner a = new Scanner (System.in);
        System.out.print("Masukkan bilangan n : ");
        int n = a.nextInt(); 

        if (n > 0){
            System.out.println("Hasil faktorial : " + factorial(n));
        } else {
            System.out.println("Input tidak valid. Hanya bisa memfaktorialkan bilangan positif.");
        }

        a.close();
        
    }

    public static int factorial(int n){
        if (n == 1 | n == 0){
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
}
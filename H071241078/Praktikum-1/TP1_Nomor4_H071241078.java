import java.util.Scanner;

public class No4 {
    public static int faktorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * faktorial(n - 1); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukkan bilangan n: ");
            int n = scanner.nextInt(); 
            if (n < 0) {
                System.out.println("Faktorial tidak terdefinisi untuk bilangan negatif!");
            } else {
                System.out.println("Output : " + faktorial(n));
            }
        } catch (Exception e) {
            System.out.println("Input harus berupa bilangan bulat!");
        } finally {
            scanner.close(); 
        }
    }
}

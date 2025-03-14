import java.util.Scanner;

public class Faktorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan bilangan n: ");
        int n = scanner.nextInt();
        scanner.close();

        int hasil = 1;
        for (int i = 2; i <= n; i++) {
            hasil *= i;
        }

        System.out.println("Faktorial dari " + n + " adalah: " + hasil);
    }
}

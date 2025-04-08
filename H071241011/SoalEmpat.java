import java.util.Scanner;

public class SoalEmpat {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        obj.close();
        System.out.println(factorial(n));
    }
    public static int factorial(int n) {
        if (n==0 || n==1) {
            return 1;
        } else {
            return n*factorial(n-1);
        }
    }
}
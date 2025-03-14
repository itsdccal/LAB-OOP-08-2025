import java.util.Scanner;

public class password {
    public static boolean CekPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean adaHurufBesar = false;
        boolean adaHurufKecil = false;
        boolean adaAngka = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                adaHurufBesar = true;
            } else if (Character.isLowerCase(c)) {
                adaHurufKecil = true;
            } else if (Character.isDigit(c)) {
                adaAngka = true;
            }

            if (adaHurufBesar && adaHurufKecil && adaAngka) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String password = input.nextLine();
        input.close();

        if (CekPassword(password)) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }
    }
}

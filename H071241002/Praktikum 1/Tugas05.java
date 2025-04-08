import java.util.Scanner;

public class Tugas05 {

    public static boolean validasiPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasUpperCase && hasLowerCase && hasDigit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (validasiPassword(password)) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid. Pastikan password memiliki minimal 8 karakter, "
                    + "mengandung huruf besar, huruf kecil, dan angka.");
        }

        scanner.close(); 
    }
}
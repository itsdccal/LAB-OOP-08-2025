import java.util.Scanner;

public class CapitalizeTitle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Judul Film: ");
        String input = scanner.nextLine();
        scanner.close();

        String[] words = input.split(" ");
        String result = "";

        for (String word : words) {
            {
                result += Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase() + " ";
            }
        }

        System.out.println("Hasil: " + result.trim());
    }
}

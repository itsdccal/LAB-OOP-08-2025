import java.util.Scanner;

public class Tugas01 {
    
    public static String kapitalisasiKata(String input) {
        String[] kata = input.split(" ");
        String hasil = "";
        
        for (String word : kata) {
            if (word.length() > 0) {
                String kataKapitalisasi = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
                hasil += kataKapitalisasi + " ";
            }
        }
        
        return hasil.trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Masukkan Judul Film:");
        String input = scanner.nextLine();
        
        String hasil = kapitalisasiKata(input);
        
        System.out.println(hasil);
        
        scanner.close();
    }
}
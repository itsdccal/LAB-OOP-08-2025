import java.util.Scanner;

public class Tugas1No1 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);

        System.out.println("Masukkan judul film : ");
        System.out.print("> ");
        String inputan = a.nextLine();  

        String[] kata = inputan.split(" ");

        for (int i = 0; i < kata.length; i++) {
            if (kata[i].length() > 0) {
                kata[i] = kata[i].substring(0,1).toUpperCase() + kata[i].substring(1).toLowerCase();
            }
        }

        String hasil = String.join(" ", kata);
        System.out.println(hasil);

        a.close();

    }
}

import java.util.Scanner;

public class SoalSatu {
    public static String kapitalisaString(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;

        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) { 
                if (!found) { 
                    chars[i] = Character.toUpperCase(chars[i]); 
                } 
                found = true;   
            } else { 
                found = false; 
            }            
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.print("Masukkan Judul Film : ");
        String judulFilm = obj.nextLine();

        String judulKapital = kapitalisaString(judulFilm);
        System.out.println(judulKapital);

        obj.close();
    }
}
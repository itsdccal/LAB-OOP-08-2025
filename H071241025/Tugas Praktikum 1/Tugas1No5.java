import java.util.Scanner;

public class Tugas1No5 {
    public static void main(String[] args) {
        
        Scanner a = new Scanner (System.in);
        System.out.print("Masukkan password : ");
        String pass = a.nextLine();

        boolean hurufBesar = false;
        boolean hurufKecil = false;
        boolean angka = false;

        for (int i = 0; i < pass.length(); i++){
            char karakter = pass.charAt(i);
            if (Character.isUpperCase(karakter)) {
                hurufBesar = true;
            } else if (Character.isLowerCase(karakter)){
                hurufKecil = true;
            } else if (Character.isDigit(karakter)){
                angka = true;
            }
        }

        if (pass.length() >= 8 && hurufBesar && hurufKecil && angka){
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }

        a.close();
    }
}

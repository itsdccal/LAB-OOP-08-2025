import java.util.Scanner;

public class Tugas1No3 {
    public static void main(String[] args) {
        Scanner a = new Scanner (System.in);

        try {
            System.out.print("Inputan (dd-mm-yy) : ");
            String inputan = a.nextLine();

            String[] bagian = inputan.split("-");
            int day = Integer.parseInt(bagian[0]);
            int month = Integer.parseInt(bagian[1]);
            int year = Integer.parseInt(bagian[2]);

            if (year <= 25) {
                year += 2000;
            } else {
                year += 1900;
            }
            
            String[] bulan = {
                "", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"
            };
    
            System.out.println(day + " " + bulan[month] + " " + year);

        } catch (Exception e) {
            System.out.println("Input tidak valid.");
        } finally {
            a.close();
            System.out.println();
        }
    }
}

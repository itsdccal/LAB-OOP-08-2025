import java.util.Scanner;

public class DateConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String input = scanner.nextLine();
        scanner.close();
        
        String[] bulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni",
                          "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

        String[] parts = input.split("-");  
        int day = Integer.parseInt(parts[0]);  
        int month = Integer.parseInt(parts[1]); 
        int year = Integer.parseInt(parts[2]);  

        year += (year < 50) ? 2000 : 1900; 

        System.out.println(day + " " + bulan[month - 1] + " " + year);
    }
}

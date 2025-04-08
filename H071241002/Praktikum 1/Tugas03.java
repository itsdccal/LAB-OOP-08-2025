import java.util.Scanner;

public class Tugas03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] namaBulan = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        System.out.print("Masukkan tanggal dalam format dd-mm-yy: ");
        String input = scanner.nextLine();

        try {
            String[] parts = input.split("-");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Format tanggal tidak valid.");
            }

            int hari = Integer.parseInt(parts[0]);
            int bulan = Integer.parseInt(parts[1]) - 1; 
            int tahun = Integer.parseInt(parts[2]) + 2000; 

            System.out.println(hari + " " + namaBulan[bulan] + " " + tahun);
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan tanggal dalam format dd-mm-yy.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bulan tidak valid. Harap masukkan bulan antara 01 hingga 12.");
        } finally {
            scanner.close();
        }
    }
}
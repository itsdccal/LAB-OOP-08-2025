// import java.util.Scanner;

// public class No3 {
//     public static String convertDate(String date) {
//         try {
//             String[] parts = date.split("-");
//             int day = Integer.parseInt(parts[0]);
//             int month = Integer.parseInt(parts[1]);
//             int year = Integer.parseInt(parts[2]);

//             year = (year < 26) ? (2000 + year) : (1900 + year);

//             String[] months = {
//                 "Januari", "Februari", "Maret", "April", "Mei", "Juni",
//                 "Juli", "Agustus", "September", "Oktober", "November", "Desember"
//             };

//             if (month < 1 || month > 12) {
//                 return "Bulan tidak valid!";
//             }

//             return day + " " + months[month - 1] + " " + year;

//         } catch (Exception e) {
//             return "Format tanggal salah! Gunakan format dd-mm-yy.";
//         }
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Masukkan tanggal (dd-mm-yy): ");
//         String inputDate = scanner.nextLine();
//         scanner.close();

//         String formattedDate = convertDate(inputDate);
//         System.out.println("Output : " + formattedDate);
//     }
// }



import java.util.Scanner;

public class No3 {
    public static String convertDate(String date) {
        try {
            int day = Integer.parseInt(date.substring(0, 2));
            int month = Integer.parseInt(date.substring(3, 5));
            int year = Integer.parseInt(date.substring(6, 8));

            year = (year < 26) ? (2000 + year) : (1900 + year);

            String[] months = {
                "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"
            };

            if (month < 1 || month > 12) {
                return "Bulan tidak valid!";
            }

            return day + " " + months[month - 1] + " " + year;

        } catch (Exception e) {
            return "Format tanggal salah! Gunakan format dd-mm-yy.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String inputDate = scanner.nextLine();
        scanner.close();

        String formattedDate = convertDate(inputDate);
        System.out.println("Output : " + formattedDate);
    }
}

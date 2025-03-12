import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.Locale;

class SoalTiga {
    public static void main(String[] args) {
        String inputPattern = "dd-MM-yy";
        String outputPattern = "d MMMM yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, new Locale("id", "ID"));
        
        Scanner obj = new Scanner(System.in);
        String tanggal = obj.nextLine();
        obj.close();

        try {
            Date date = inputFormat.parse(tanggal);
            String formatDate = outputFormat.format(date);
            System.out.println(formatDate);
        } catch (ParseException e) {
            System.out.println("Format tanggal tidak valid: " + tanggal);
        }
    }
}
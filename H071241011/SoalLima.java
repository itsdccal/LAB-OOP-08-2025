import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SoalLima {

    public static boolean validPassword(String password) {
        if (password == null) {
            return false;
        }
        
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        Pattern passPattern = Pattern.compile(regex);
        Matcher matcher = passPattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.print("Masukkan Password: ");
        String passString = obj.nextLine();
        
        if (validPassword(passString)) {
            System.out.println("Password Valid");
        } else {
            System.out.println("Password Tidak Valid");
        }
        
        obj.close();
    }
}
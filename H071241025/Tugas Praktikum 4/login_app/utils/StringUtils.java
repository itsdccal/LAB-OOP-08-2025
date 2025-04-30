package login_app.utils;

public class StringUtils {
     public static String getnamapanggilan(String fullName) {
        String[] bagian = fullName.split(" ");
        if (bagian.length == 1) { 
            return bagian[0];
        } else {
            return bagian[bagian.length - 1];
        }
     }
}

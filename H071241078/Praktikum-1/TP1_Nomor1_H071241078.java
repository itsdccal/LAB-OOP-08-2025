// import java.util.Scanner;

// public class No1 {
//     public static String capitalizeWords(String str) {
//         String[] words = str.toLowerCase().split("\\s+"); 
        
//         StringBuilder capitalizedSentence = new StringBuilder();

//         for (String word : words) {
//             if (!word.isEmpty()) {
//                 capitalizedSentence.append(Character.toUpperCase(word.charAt(0)))
//                                    .append(word.substring(1))
//                                    .append(" ");
//             }
//         }
//         return capitalizedSentence.toString().trim();
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.print("Masukkan Judul Film: ");
//         String input = scanner.nextLine();
//         scanner.close();

//         String output = capitalizeWords(input);
//         System.out.println(output);
//     }
// }


import java.util.Scanner;

public class No1 {
    public static String capitalizeWords(String str) {
        StringBuilder capitalizedSentence = new StringBuilder();
        boolean capitalizeNext = true;

        for (char c : str.toLowerCase().toCharArray()) {
            if (capitalizeNext && Character.isLetter(c)) {
                capitalizedSentence.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                capitalizedSentence.append(c);
            }
            if (c == ' ') {
                capitalizeNext = true;
            }
        }
        return capitalizedSentence.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Judul Film: ");
        String input = scanner.nextLine();
        scanner.close();

        String output = capitalizeWords(input);
        System.out.println(output);
    }
}

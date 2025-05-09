import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hero hero = null;

        System.out.println("Pilih Karakter:");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");
        System.out.print("Masukkan pilihan: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                hero = new Archer("Pemanah", 100, 15);
                break;
            case 2:
                hero = new Wizard("Penyihir", 80, 20);
                break;
            case 3:
                hero = new Fighter("Petarung", 120, 25);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                System.exit(0);
        }

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilih aksi: ");
            int action = scanner.nextInt();

            if (action == 1) {
                hero.attack();
            } else if (action == 2) {
                System.out.println("Program berhenti.");
                break;
            } else {
                System.out.println("Aksi tidak valid.");
            }
        }

        scanner.close();
    }
}

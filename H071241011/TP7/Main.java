package TP7;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: addItem(); break;
                case 2: addMember(); break;
                case 3: borrowItem(); break;
                case 4: returnItem(); break;
                case 5: viewLibraryStatus(); break;
                case 6: viewLogs(); break;
                case 7: viewMemberBorrowedItems(); break;
                case 8: exit = true; break;
                default: System.out.println("Pilihan tidak valid");
            }
        }
        scanner.close();
        System.out.println("Terima kasih!");
    }

    private static void printMenu() {
        System.out.println("=== Sistem Manajemen Perpustakaan ===");
        System.out.println("1. Tambah Item");
        System.out.println("2. Tambah Anggota");
        System.out.println("3. Pinjam Item");
        System.out.println("4. Kembalikan Item");
        System.out.println("5. Lihat Status Perpustakaan");
        System.out.println("6. Lihat Log Aktivitas");
        System.out.println("7. Lihat Item yang Dipinjam Anggota");
        System.out.println("8. Keluar");
        System.out.print("Pilihan: ");
    }

    private static void addItem() {
        System.out.print("Jenis item (1. Buku, 2. DVD): ");
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Judul: ");
        String title = scanner.nextLine();
        System.out.print("ID Item: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();
        LibraryItem item;
        if (type == 1) {
            System.out.print("Penulis: ");
            String author = scanner.nextLine();
            item = new Book(title, itemId, author);
        } else {
            System.out.print("Durasi (menit): ");
            int duration = scanner.nextInt();
            scanner.nextLine();
            item = new DVD(title, itemId, duration);
        }
        System.out.println(library.addItem(item));
    }

    private static void addMember() {
        System.out.print("Nama anggota: ");
        String name = scanner.nextLine();
        System.out.print("ID Anggota: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        Member member = new Member(name, memberId);
        library.addMember(member);
        System.out.println("Anggota " + name + " berhasil ditambahkan");
    }

    private static void borrowItem() {
        System.out.print("ID Anggota: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID Item: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Durasi pinjam (hari): ");
        int days = scanner.nextInt();
        scanner.nextLine();

        try {
            Member member = library.findMemberById(memberId);
            LibraryItem item = library.findItemById(itemId);
            String result = member.borrow(item, days);
            System.out.println(result);
            String itemType = (item instanceof Book) ? "Buku" : "DVD";
            String activity = String.format("%s dipinjam oleh %s", itemType, member.getName());
            library.getLogger().logActivity(activity);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Item tidak tersedia untuk dipinjam");
        } catch (IllegalArgumentException e) {
            System.out.println("Durasi pinjam melebihi batas");
        }
    }

    private static void returnItem() {
        System.out.print("ID Anggota: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID Item: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Keterlambatan (hari): ");
        int daysLate = scanner.nextInt();
        scanner.nextLine();

        try {
            Member member = library.findMemberById(memberId);
            LibraryItem item = library.findItemById(itemId);
            String result = member.returnItem(item, daysLate);
            System.out.println(result);
            String itemType = (item instanceof Book) ? "Buku" : "DVD";
            String activity = String.format("%s dikembalikan oleh %s", itemType, member.getName());
            library.getLogger().logActivity(activity);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewLibraryStatus() {
        System.out.println(library.getLibraryStatus());
    }

    private static void viewLogs() {
        System.out.println(library.getAllLogs());
    }

    private static void viewMemberBorrowedItems() {
        System.out.print("ID Anggota: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        try {
            Member member = library.findMemberById(memberId);
            System.out.println(member.getBorrowedItems());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}

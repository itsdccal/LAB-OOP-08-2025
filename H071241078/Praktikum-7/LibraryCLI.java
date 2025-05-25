import java.util.Scanner;
public class LibraryCLI {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item Yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih opsi: ");

            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1:
                        addItemMenu();
                        break;
                    case 2:
                        addMemberMenu();
                        break;
                    case 3:
                        borrowItemMenu();
                        break;
                    case 4:
                        returnItemMenu();
                        break;
                    case 5:
                        System.out.println(library.getLibraryStatus());
                        break;
                    case 6:
                        System.out.println(library.getAllLogs());
                        break;
                    case 7:
                        showBorrowedItemsByMember();
                        break;
                    case 8:
                        exit = true;
                        System.out.println("Terima kasih.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }


    private static void addItemMenu() {
        System.out.print("Jenis item (1: Buku, 2: DVD): ");
        String type = scanner.nextLine().toUpperCase();
        System.out.print("Masukkan judul: ");
        String title = scanner.nextLine();
        System.out.print("Masukkan ID item: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (type.equals("1")) {
            System.out.print("Masukkan nama author: ");
            String author = scanner.nextLine();
            Book book = new Book(title, id, author);
            System.out.println(library.addItem(book));
            library.getLogger().logActivity(String.format("%s berhasil ditambahkan", title));
        } else if (type.equals("2")) {
            System.out.print("Masukkan durasi (menit): ");
            int duration = Integer.parseInt(scanner.nextLine());
            DVD dvd = new DVD(title, id, duration);
            System.out.println(library.addItem(dvd));
            library.getLogger().logActivity(String.format(" %s berhasil ditambahkan", title));
        } else {
            System.out.println("Tipe tidak dikenali");
        }
    }

    private static void addMemberMenu() {
        System.out.print("Masukkan nama Anggota: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan ID Anggota: ");
        int id = Integer.parseInt(scanner.nextLine());
        Member member = new Member(name, id);
        library.addMember(member);
        System.out.println("Anggota berhasil ditambahkan");
        library.getLogger().logActivity(String.format("Anggota %s ditambahkan", name));
    }

    private static void borrowItemMenu() {
        System.out.print("Masukkan ID Anggota: ");
        int memberId = Integer.parseInt(scanner.nextLine());
        Member member = library.findMemberById(memberId);

        System.out.print("Masukkan ID item yang ingin dipinjam: ");
        int itemId = Integer.parseInt(scanner.nextLine());
        LibraryItem item = library.findItemById(itemId);

        System.out.print("Masukkan lama pinjam: ");
        int days = Integer.parseInt(scanner.nextLine());

        String result = member.borrow(item, days);
        String logMsg;
        if (item instanceof Book) {
            String author = ((Book) item).getAuthor();
            logMsg = String.format("Buku: %s oleh %s, ID %d dipinjam oleh %s", item.getTitle(), author, item.getItemId(), member.getName());
        } else {
            logMsg = String.format("Item: %s, ID %d dipinjam oleh %s", item.getTitle(), item.getItemId(), member.getName());
        }

        library.getLogger().logActivity(logMsg);
        System.out.println(result);

        }


    private static void returnItemMenu() {
        System.out.print("Masukkan ID Anggota: ");
        int memberId = Integer.parseInt(scanner.nextLine());
        Member member = library.findMemberById(memberId);

        System.out.print("Masukkan ID item yang ingin dikembalikan: ");
        int itemId = Integer.parseInt(scanner.nextLine());
        LibraryItem item = library.findItemById(itemId);

        System.out.print("Masukkan hari keterlambatan: ");
        int daysLate = Integer.parseInt(scanner.nextLine());

        String result = member.returnItem(item, daysLate);
        String logMsg;
        if (item instanceof Book) {
            String author = ((Book) item).getAuthor();
            logMsg = String.format("Buku: %s oleh %s dikembalikan oleh %s", item.getTitle(), author, member.getName());
        } else {
            logMsg = String.format("Item: %s dikembalikan oleh %s", item.getTitle(), member.getName());
        }

        library.getLogger().logActivity(logMsg);
        System.out.println(result);

    }

    private static void showBorrowedItemsByMember() {
    System.out.print("Masukkan ID Anggota: ");
    int memberId = Integer.parseInt(scanner.nextLine());
    Member member = library.findMemberById(memberId);

    System.out.println("Item yang sedang dipinjam oleh " + member.getName() + ":");
    System.out.println(member.getBorrowedItems());
}


}

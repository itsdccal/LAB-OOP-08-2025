import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Pilihan harus berupa angka.");
                continue;
            }

            try {
                switch (pilihan) {
                    case 1 -> {
                        System.out.println("Pilih tipe item:");
                        System.out.println("1. Book");
                        System.out.println("2. DVD");
                        System.out.print("Masukkan pilihan (1/2): ");
                        String tipeInput = scanner.nextLine().trim();

                        if (!tipeInput.equals("1") && !tipeInput.equals("2")) {
                            System.out.println("Pilihan hanya boleh 1 (Book) atau 2 (DVD).");
                            continue;
                        }
                        System.out.print("Judul: ");
                        String judul = scanner.nextLine();

                        System.out.print("ID Item (angka unik): ");
                        int itemId;
                        try {
                            itemId = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("ID Item harus berupa angka.");
                            continue;
                        }

                        boolean exists = library.getItems().stream().anyMatch(i -> i.getItemId() == itemId);
                        if (exists) {
                            System.out.println("ID Item sudah digunakan.");
                            continue;
                        }

                        if (tipeInput.equals("1")) { 
                            System.out.print("Penulis: ");
                            String author = scanner.nextLine();
                            Book book = new Book(judul, itemId, author);
                            System.out.println(library.addItem(book));
                            library.getLogger().logActivity(judul + " Ditambahkan");
                        } else { // DVD
                            System.out.print("Durasi (menit): ");
                            try {
                                int durasi = Integer.parseInt(scanner.nextLine());
                                DVD dvd = new DVD(judul, itemId, durasi);
                                System.out.println(library.addItem(dvd));
                                library.getLogger().logActivity(judul + " Ditambahkan");
                            } catch (NumberFormatException e) {
                                System.out.println("Durasi harus berupa angka.");
                            }
                        }
                    }

                    case 2 -> {
                        System.out.print("Nama Anggota: ");
                        String nama = scanner.nextLine();

                        System.out.print("ID Anggota (angka unik): ");
                        int memberId;
                        try {
                            memberId = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("ID Anggota harus berupa angka.");
                            continue;
                        }

                        boolean exists = library.getMembers().stream().anyMatch(m -> m.getMemberId() == memberId);
                        if (exists) {
                            System.out.println("ID Anggota sudah digunakan.");
                            continue;
                        }

                        Member member = new Member(nama, memberId);
                        library.addMember(member);
                        System.out.println("Anggota berhasil ditambahkan.");
                        library.getLogger().logActivity("Anggota " + nama + " Ditambahkan");
                    }

                    case 3 -> {
                        try {
                            System.out.print("ID Anggota: ");
                            int memberId = Integer.parseInt(scanner.nextLine());
                            Member member = library.getMemberById(memberId);

                            System.out.print("ID Item: ");
                            int itemId = Integer.parseInt(scanner.nextLine());
                            LibraryItem item = library.findItemById(itemId);

                            System.out.print("Jumlah hari pinjam: ");
                            int days = Integer.parseInt(scanner.nextLine());

                            String result = member.borrow(item, days);
                            System.out.println(result);
                            library.getLogger().logActivity(item.getTitle() + " dipinjam oleh " + member.getName());
                        } catch (Exception e) {
                            System.out.println("Terjadi kesalahan: " + e.getMessage());
                        }
                    }

                    case 4 -> {
                        try {
                            System.out.print("ID Anggota: ");
                            int memberId = Integer.parseInt(scanner.nextLine());
                            Member member = library.getMemberById(memberId);

                            System.out.print("ID Item: ");
                            int itemId = Integer.parseInt(scanner.nextLine());
                            LibraryItem item = library.findItemById(itemId);

                            System.out.print("Hari keterlambatan: ");
                            int lateDays = Integer.parseInt(scanner.nextLine());

                            String result = member.returnItem(item, lateDays);
                            System.out.println(result);
                            library.getLogger().logActivity(item.getTitle() + " dikembalikan oleh " + member.getName());
                        } catch (Exception e) {
                            System.out.println("Terjadi kesalahan: " + e.getMessage());
                        }
                    }

                    case 5 -> System.out.println(library.getLibraryStatus());

                    case 6 -> {
                        System.out.println("=== Log Aktivitas ===");
                        System.out.println(library.getAllLogs());
                    }

                    case 7 -> {
                        System.out.print("ID Anggota: ");
                        try {
                            int memberId = Integer.parseInt(scanner.nextLine());
                            Member member = library.getMemberById(memberId);
                            member.getBorrowedItems();
                        } catch (Exception e) {
                            System.out.println("Terjadi kesalahan: " + e.getMessage());
                        }
                    }

                    case 8 -> {
                        System.out.println("Keluar dari sistem. Terima kasih.");
                        scanner.close();
                        return;
                    }

                    default -> System.out.println("Pilihan menu tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan tak terduga: " + e.getMessage());
            }

            System.out.println();
        }
    }
}

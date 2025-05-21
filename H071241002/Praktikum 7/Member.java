import java.util.*;

public class Member {
    
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed())
            throw new IllegalStateException("Item tidak tersedia.");
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item))
            throw new IllegalStateException("Item ini tidak dipinjam oleh anggota ini.");
        item.returnItem();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);
        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + String.format("%,.0f", fine);
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam.");
        } else {
            System.out.println("+----------+-------------------------+");
            System.out.println("| ID Item  | Judul                   |");
            System.out.println("+----------+-------------------------+");
            for (LibraryItem item : borrowedItems) {
                System.out.printf("| %-8d | %-23s |\n", item.getItemId(), item.getTitle());
            }
            System.out.println("+----------+-------------------------+");
        }
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }
}

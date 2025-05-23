import java.util.ArrayList;
import java.util.List;

class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems = new ArrayList<>();

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Belum meminjam item apa pun.");
            return;
        }

        System.out.println("+------------+----------------------+");
        System.out.println("|  ID Item   |        Judul         |");
        System.out.println("+------------+----------------------+");
        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-10s | %-20s |\n", item.getItemId(), item.getTitle());
        }
        System.out.println("+------------+----------------------+");
    }
    
    public String getName() {
        return name;
    }

    public String borrow(LibraryItem item, int days) {
        if (item.getIsBorrowed()) {
            throw new IllegalStateException("Item tidak tersedia.");
        } 
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result; 
        
    }

    public String returnItem(LibraryItem item, int daysLate) {
        borrowedItems.remove(item);
        item.returnItem();
        double fine = item.calculateFine(daysLate);
        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + (int) fine;
    } 
}

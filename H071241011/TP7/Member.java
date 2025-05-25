package TP7;

import java.util.ArrayList;
import java.util.List;

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
        if (item.isBorrowed()) {
            throw new IllegalStateException("Item tidak tersedia");
        }
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return String.format("Item %s berhasil dipinjam selama %d hari", item.getTitle(), days);
    }

    public String returnItem(LibraryItem item, int daysLate) {
        String returnMessage = item.returnItem();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);
        return String.format("Item %s berhasil dikembalikan dengan denda: Rp %,.2f", item.getTitle(), fine);
    }

    public String getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            return "Tidak ada item yang dipinjam";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("+---+---+\n");
        sb.append("| ID | Judul |\n");
        sb.append("+---+---+\n");
        for (LibraryItem item : borrowedItems) {
            sb.append(String.format("| %d | %s |\n", item.getItemId(), item.getTitle()));
        }
        sb.append("+---+---+\n");
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }
}
import java.util.*;

public class Library {
    private List<LibraryItem> items; 
    private List<Member> members; 
    private LibraryLogger logger;

    public Library() {
        items = new ArrayList<>(); 
        members = new ArrayList<>();
        logger = new LibraryLogger(); 
    }

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Member getMemberById(int id) { 
        return members.stream()
                .filter(m -> m.getMemberId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Anggota tidak ditemukan."));
    }

    public LibraryItem findItemById(int itemId) {
        return items.stream()
                .filter(item -> item.getItemId() == itemId)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item tidak ditemukan."));
    }

    public String getLibraryStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("+------+-------------------------+----------+\n");
        sb.append("| ID   | Judul                   | Status   |\n");
        sb.append("+------+-------------------------+----------+\n");

        for (LibraryItem item : items) {
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";
            sb.append(String.format("| %-4d | %-23s | %-8s |\n", item.getItemId(), item.getTitle(), status));
        }

        sb.append("+------+-------------------------+----------+\n");
        return sb.toString(); 
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public LibraryLogger getLogger() {
        return logger; 
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<LibraryItem> getItems() { 
        return items;
    }
}

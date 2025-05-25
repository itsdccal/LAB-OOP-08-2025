import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LibraryLogger {
    private List<String> logs = new ArrayList<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(formatter);
        String logEntry = timestamp + " " + activity;
        logs.add(logEntry);
        return logEntry;
    }

    public String getLogs() {
        if (logs.isEmpty()) {
            return "Tidak ada log aktivitas.";
        }
        StringBuilder sb = new StringBuilder();
        for (String log : logs) {
            sb.append(log).append("\n");
        }
        return sb.toString();
    }

    public void clearLogs() {
        logs.clear();
    }
}

    class Library {
    private List<LibraryItem> items;
    private List<Member> members;
    private LibraryLogger logger;

    public Library() {
        items = new ArrayList<>();
        members = new ArrayList<>();
        logger = new LibraryLogger();
    }

    public LibraryLogger getLogger() {
        return logger;
    }

    public String addItem(LibraryItem item) {
        items.add(item);
        return "Item berhasil ditambahkan";
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Member findMemberById(int id) {
        for (Member m : members) {
            if (m.getMemberId() == id) return m;
        }
        throw new NoSuchElementException("Member tidak ditemukan");
    }

    public LibraryItem findItemById(int id) {
        for (LibraryItem i : items) {
            if (i.getItemId() == id) return i;
        }
        throw new NoSuchElementException("Item tidak ditemukan");
    }

    public String getLibraryStatus() {
    StringBuilder sb = new StringBuilder();
    sb.append("+---------+----------------------+-----------+\n");
    sb.append("| ID Item | Judul                | Status    |\n");
    sb.append("+---------+----------------------+-----------+\n");

    for (LibraryItem item : items) {
        sb.append(String.format("| %-7d | %-20s | %-9s |\n",
                item.getItemId(),
                truncate(item.getTitle(), 20),
                item.isBorrowed() ? "Dipinjam" : "Tersedia"));
    }

    sb.append("+---------+----------------------+-----------+");
    return sb.toString();
}


    private String truncate(String text, int maxLength) {
        return text.length() <= maxLength ? text : text.substring(0, maxLength - 3) + "...";
    }


    public String getAllLogs() {
        return logger.getLogs();
    }
}


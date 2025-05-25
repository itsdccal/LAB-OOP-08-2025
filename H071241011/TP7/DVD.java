package TP7;

public class DVD extends LibraryItem {
    private int duration;
    private static final double FINE_PER_DAY = 25000;
    private static final int MAX_DAYS = 7;

    public DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return "Buku: " + title + ", durasi " + duration + " menit, ID: " + itemId;
    }
    
    @Override
    public String borrowItem(int days) {
        if (days > MAX_DAYS || isBorrowed) {
            throw new IllegalArgumentException();
        }
        isBorrowed = true;
        return "DVD " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * FINE_PER_DAY;
    }
}
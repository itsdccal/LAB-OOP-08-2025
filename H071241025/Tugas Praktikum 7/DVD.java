public class DVD extends LibraryItem{
    int duration;

    public DVD(String title, int itemld, int duration) {
        super(title, itemld);
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return "DVD: [" + title + "] durasi [" + duration + "], ID: [" + itemId + "]";
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed) throw new IllegalArgumentException("DVD telah dipinjam.");
        if (days > 7) throw new IllegalArgumentException("Batas pinjam DVD hanya 7 hari.");
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";        
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 25000;
    }

}

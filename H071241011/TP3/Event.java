public class Event {
    private String namaEvent;
    private int durasiEvent;
    private double pengaruhStamina;

    public Event() {
        this.namaEvent = "Konser";
        this.durasiEvent = 60;
        this.pengaruhStamina = 2.8;
    }
    
    public Event(String namaEvent, int durasiEvent, double pengaruhStamina) {
        this.namaEvent = namaEvent;
        this.durasiEvent = durasiEvent;
        this.pengaruhStamina = pengaruhStamina;
    }

    public void startEvent(Member member) {
        double staminaLoss = durasiEvent * pengaruhStamina;
        member.setStamina(member.getStamina() - (int) staminaLoss);
        System.out.println(member.getNama() + " sedang tampil dalam " + namaEvent + ". Staminanya berkurang: " + staminaLoss);
    }

    public String getNamaEvent() {
        return namaEvent;
    }

    public void setNamaEvent(String namaEvent) {
        this.namaEvent = namaEvent;
    }

    public int getDurasi() {
        return durasiEvent;
    }

    public void setDurasi(int durasiEvent) {
        this.durasiEvent = durasiEvent;
    }

    public double getPengaruhStamina() {
        return pengaruhStamina;
    }

    public void setPengaruhStamina(double pengaruhStamina) {
        this.pengaruhStamina = pengaruhStamina;
    }
}

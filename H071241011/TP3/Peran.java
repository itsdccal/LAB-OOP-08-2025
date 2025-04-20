public class Peran {
    private String namaPeran;
    private double faktorStamina;

    public Peran() {
        this.namaPeran = "Dancer";
        this.faktorStamina = 1.5;
    }

    public Peran(String namaPeran, double faktorStamina) {
        this.namaPeran = namaPeran;
        this.faktorStamina = faktorStamina;
    }

    public String getNamaPeran() {
        return namaPeran;
    }

    public double getFaktorStamina() {
        return faktorStamina;
    }
}
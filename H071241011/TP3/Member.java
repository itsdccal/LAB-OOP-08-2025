public class Member {
    private String  nama;
    private int stamina;
    private Peran peran;

    public Member() {
        this.nama = "Zee";
        this.stamina = 100;
        this.peran = new Peran("Center", 1.2);
    }
    
    public Member(String nama, Peran peran) {
        this.nama = nama;
        this.stamina = 100;
        this.peran = peran;
    }

    public void perform() {
        double factor = peran.getFaktorStamina();
        stamina -= factor * 10;
        System.out.println(nama + " sedang tampil sebagai : " + peran.getNamaPeran() + ", stamina sekarang : " + stamina);
    } 

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}

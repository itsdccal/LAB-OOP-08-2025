import java.util.Calendar;
import java.util.Date;

public class Mobil extends Kendaraan implements IBergerak, IServiceable{
    int jumlahPintu;
    double kapasitasMesin;
    int jumlahKursi;
    String bahanBakar;

    double kecepatan;
    Date waktuServisBerikutnya;

    public Mobil (String merek, String model) {
        super(merek, model);
    }

    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlah) {
        this.jumlahPintu = jumlah;
    }

    public double getKapasitasMesin() {
        return kapasitasMesin;
    }

    public void setKapasitasMesin(double kapasitas) {
        this.kapasitasMesin = kapasitas;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlah) {
        this.jumlahKursi = jumlah;
    }

    public String getBahanBakar() {
        return bahanBakar;
    }

    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }

    @Override
    public double hitungPajak() {
        return kapasitasMesin * 1.5;
    }

    @Override
    public String getTipeKendaraan() {
        return "Mobil";
    }

    @Override
    public boolean mulai() {
        System.out.println("Mobil menyala");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Mobil berhenti");
        return false;
    }

    public double getKecepatan() {
        return kecepatan;
    }

    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    @Override
    public boolean periksaKondisi() {
        System.out.println("Memeriksa kondisi mobil.");
        return true;
    }

    @Override
    public void lakukanService() {
        System.out.println("Mobil sedang diservice");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 3);
        waktuServisBerikutnya = calendar.getTime();
    }


    @Override
    public Date getWaktuServisBerikutnya() {
        return waktuServisBerikutnya;
    }

    @Override
    public double hitungBiayaServis() {
        return 500000;
    }
}

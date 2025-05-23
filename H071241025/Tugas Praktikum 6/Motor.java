import java.util.Calendar;
import java.util.Date;

public class Motor extends Kendaraan implements IBergerak, IServiceable{
    String jenisMotor;
    double kapasitasTangki;
    String tipeSuspensi;

    double kecepatan;
    Date waktuServisBerikutnya;

    public Motor (String merek, String model) {
        super(merek, model);
    }

    public String getJenisMotor() {
        return jenisMotor;
    }

    public void setJenisMotor(String jenis) {
        this.jenisMotor = jenis;
    }

    public double getKapasitasTangki() {
        return kapasitasTangki;
    }

    public void setKapasitasTangki(double kapasitas) {
        this.kapasitasTangki = kapasitas;
    }

    public String getTipeSuspensi() {
        return tipeSuspensi;
    }

    public void setTipeSuspensi(String tipe) {
        this.tipeSuspensi = tipe;
    }

    @Override
    public double hitungPajak() {
        return kapasitasTangki * 1.2;
    }

    @Override
    public String getTipeKendaraan() {
        return "Motor";
    }

    @Override
    public boolean mulai() {
        System.out.println("Motor menyala");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Motor berhenti");
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
        System.out.println("Memeriksa kondisi motor");
        return true;
    }

    @Override
    public void lakukanService() {
        System.out.println("Motor sedang diservice");
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
        return 300000;
    }

}

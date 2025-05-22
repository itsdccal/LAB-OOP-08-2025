public class KarpetAladdin extends Kendaraan implements IBergerak{
    String jenisKarpet;
    double luasKarpet;
    double kecepatan;

    public KarpetAladdin(String merek, String model) {
        super(merek, model);
    }

    public String getJenisKarpet() {
        return jenisKarpet;
    }

    public void setJenisKarpet(String jenis) {
        this.jenisKarpet = jenis;
    }

    public double getLuasKarpet() {
        return luasKarpet;
    }

    public void setLuasKarpet(double luas) {
        this.luasKarpet = luas;
    }

    public double getKecepatan() {
        return kecepatan;
    }

    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    @Override
    public double hitungPajak() {
        return 0;
    }

    @Override
    public String getTipeKendaraan() {
        return "Karpet Aladdin";
    }

    @Override
    public boolean mulai() {
        System.out.println("Karpet Aladdin diterbangkan");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Karpet Aladdin berhenti");
        return false;
    }
}

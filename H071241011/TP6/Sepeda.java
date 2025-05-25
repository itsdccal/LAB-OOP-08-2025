package TP6;

import java.util.Date;

public class Sepeda extends Kendaraan implements IBergerak, IServiceable {
    protected String jenisSepeda;
    protected int jumlahGear, ukuranRoda;
    protected double kecepatan, totalJarakTempuh;

    private long servisTerbaruTimestamp = System.currentTimeMillis();
    private static final long SERVIS_INTERVAL_MS = 1000L * 60 * 60 * 24 * 180;

    public Sepeda(String merek, String model, int hargaJual) {
        super(merek, model, hargaJual);
    }

    public String getJenisSepeda() {
        return jenisSepeda;
    }

    public void setJenisSepeda(String jenisSepeda) {
        this.jenisSepeda = jenisSepeda;
    }

    public int getJumlahGear() {
        return jumlahGear;
    }

    public void setJumlahGear(int jumlahGear) {
        this.jumlahGear = jumlahGear;
    }

    public int getUkuranRoda() {
        return ukuranRoda;
    }

    public void setUkuranRoda(int ukuranRoda) {
        this.ukuranRoda = ukuranRoda;
    }

    public void setTotalJarakTempuh(double totalJarakTempuh) {
        this.totalJarakTempuh = totalJarakTempuh;
    }

    public double getTotaJarakTempuh() {
        return totalJarakTempuh;
    }
    
    @Override
    public boolean mulai() {
        kecepatan = 5;
        return true;
    }

    @Override
    public boolean berhenti() {
        kecepatan = 0;
        return true;
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    @Override
    public boolean periksaKondisi() {
        return true;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Sepeda diservis. Rantai dikencangkan, rem dicek, pelumas ditambah. Infokan ajang balap terdekat.");
        totalJarakTempuh = 0;
        servisTerbaruTimestamp = System.currentTimeMillis();
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date(servisTerbaruTimestamp + SERVIS_INTERVAL_MS);
    }

    @Override
    public double hitungBiayaServis() {
        return 100_000 + (totalJarakTempuh / 10);
    }

    @Override
    public double hitungPajak() {
        return 0;
    }

    @Override
    public String getTipeKendaraan() {
        return "Sepeda";
    }

}

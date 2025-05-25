package TP6;

import java.util.Date;

public class Motor extends Kendaraan implements IBergerak, IServiceable {
    protected String jenisMotor, tipeSuspensi;
    protected double kapasitasTangki, kapasitasMesin, kecepatan, hargaJual;

    private boolean mesinMenyala = false;
    private long servisTerbaruTimestamp = System.currentTimeMillis();
    private static final long SERVIS_INTERVAL_MS = 1000L * 60 * 60 * 24 * 180;

    public Motor(String merek, String model, double hargaJual) {
        super(merek, model, hargaJual);
    }
    public String getJenisMotor() {
        return jenisMotor;
    }

    public void setJenisMotor(String jenisMotor) {
        this.jenisMotor = jenisMotor;
    }

    public double getKapasitasTangki() {
        return kapasitasTangki;
    }

    public void setKapasitasTangki(double kapasitasTangki) {
        this.kapasitasTangki = kapasitasTangki;
    }

    public String getTipeSuspensi() {
        return tipeSuspensi;
    }

    public void setTipeSuspensi(String tipeSuspensi) {
        this.tipeSuspensi = tipeSuspensi;
    }
    
    public String getTipeKendaraan() {
        return "Motor";
    }
    
    @Override
    public boolean mulai() {
        return mesinMenyala = true;
    }
    
    @Override
    public boolean berhenti() {
        return mesinMenyala = false;
    }
    
    @Override
    public double getKecepatan() {
        return mesinMenyala ? kecepatan : 0;
    }
    
    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    @Override
    public double hitungPajak() {
        double totalPkb = hargaJual * 0.012 * (1 + 0.66);
        double totalBbnkb = hargaJual * 0.12 * (1 + 0.66);
        return totalPkb + totalBbnkb + 300000;
    }

    @Override
    public boolean periksaKondisi() {
        long umurServis = System.currentTimeMillis() - servisTerbaruTimestamp;
        boolean butuhServis = umurServis > SERVIS_INTERVAL_MS;
        return !butuhServis;
    }
    
    @Override
    public void lakukanServis() {
        servisTerbaruTimestamp = System.currentTimeMillis();
        if (mesinMenyala) {
            kecepatan += 2;
        }
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date(servisTerbaruTimestamp + SERVIS_INTERVAL_MS);
    }
    
    @Override
    public double hitungBiayaServis() {
    double dasar = 300_000;
    double faktorAcak = Math.random() * 100_000;
    return dasar + faktorAcak;
}
}

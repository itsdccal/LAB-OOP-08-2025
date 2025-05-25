package TP6;

import java.util.Date;

public class Mobil extends Kendaraan implements IBergerak, IServiceable {
    protected int jumlahPintu, jumlahKursi;
    protected double kapasitasMesin, kecepatan, hargaJual;
    protected String bahanBakar;

    private boolean mesinMenyala = false;
    private long lastServisTimestamp = System.currentTimeMillis();
    private static final long SERVIS_INTERVAL_MS = 1000L * 60 * 60 * 24 * 180;

    public Mobil(String merek, String model, double hargaJual) {
        super(merek, model, hargaJual);
    }

    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
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
    public boolean mulai() {
        if (!mesinMenyala) {
            mesinMenyala = true;
            kecepatan = kapasitasMesin * 0.3 + 25;
            return true;
        }
        return false;
    }

    @Override
    public boolean berhenti() {
        if (mesinMenyala) {
            mesinMenyala = false;
            kecepatan = 0;
            return true;
        }
        return false;
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
    public boolean periksaKondisi() {
        long umurServis = System.currentTimeMillis() - lastServisTimestamp;
        return umurServis <= SERVIS_INTERVAL_MS;
    }
    
    @Override
    public double hitungPajak() {
        double totalPkb = hargaJual * 0.012 * (1 + 0.66);
        double totalBbnkb = hargaJual * 0.12 * (1 + 0.66);
        return totalPkb + totalBbnkb + 300000;
    }

    @Override
    public void lakukanServis() {
        lastServisTimestamp = System.currentTimeMillis();
        if (mesinMenyala) {
            kecepatan += 8;
        }
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date(lastServisTimestamp + SERVIS_INTERVAL_MS);
    }

    @Override
    public double hitungBiayaServis() {
        double dasar = 500_000;
        double faktorBahanBakar = 0;
        if ("Bensin".equalsIgnoreCase(bahanBakar)) {
            faktorBahanBakar = 200_000;
        } else if ("Listrik".equalsIgnoreCase(bahanBakar)) {
            faktorBahanBakar = -150_000;
        }
        double faktorAcak = Math.random() * 100_000;
        return dasar + faktorBahanBakar + faktorAcak;
    }

    @Override
    public String getTipeKendaraan() {
        return "Mobil";
    }
}

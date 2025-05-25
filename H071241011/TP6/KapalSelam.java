package TP6;

import java.util.Date;

public class KapalSelam extends Kendaraan implements IBergerak, IServiceable{
    protected double kecepatan, kedalaman;
    protected boolean modeSelam;
    protected String namaKapal, namaKapten;
    protected final double P_MAX = 700;

    private int jumlahPenyelaman = 0;
    private long lastServisTimestamp = System.currentTimeMillis();
    private static final long SERVIS_INTERVAL = 1000L * 60 * 60 * 24 * 90;

    public KapalSelam(String merek, String model, double hargaJual) {
        super(merek, model, hargaJual);
    }
    
    public void setKedalaman(double kedalaman) {
        if (!modeSelam) {
            System.out.println("Tidak dapat menyelam jika modeSelam tidak aktif.");
            return;
        }

        if (kedalaman > P_MAX) {
            System.out.println("PERINGATAN: Kedalaman melebihi batas maksimal! Mau menyusul penumpang titanic kah maniez?");
            this.kedalaman = P_MAX;
        } else {
            this.kedalaman = kedalaman;
        }
    }

    public double getKedalaman() {
        return kedalaman;
    }


    public void aktifkanModeSelam() {
        if (!modeSelam) {
            modeSelam = true;
            jumlahPenyelaman++;
        }
    }

    public void nonAktifkanModeSelam() {
        modeSelam = false;
        kedalaman = 0;
    }


    @Override
    public boolean mulai() {
        kecepatan = 10;
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
        if (modeSelam && kedalaman > 0) {
            double faktor = 1 - (kedalaman / (P_MAX * 1.5));
            this.kecepatan = kecepatan * faktor;
        }
    }

    @Override
    public boolean periksaKondisi() {
        boolean terlaluDalam = kedalaman > P_MAX;
        boolean perluServis = System.currentTimeMillis() - lastServisTimestamp > SERVIS_INTERVAL;
        return !terlaluDalam && !perluServis;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Kapal selam diservis.");
        lastServisTimestamp = System.currentTimeMillis();
        jumlahPenyelaman = 0;
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date(lastServisTimestamp + SERVIS_INTERVAL);
    }

    @Override
    public double hitungBiayaServis() {
        double biayaDasar = 100_000_000;
        double tambahanPerPenyelaman = 1_000_000 * jumlahPenyelaman;
        return biayaDasar + tambahanPerPenyelaman;
    }

    @Override
    public String getTipeKendaraan() {
        return "Kapal Selam";
    }

    @Override
    public double hitungPajak() {
        double totalPkb = hargaJual * 0.012 * (1 + 0.66);
        double totalBbnkb = hargaJual * 0.12 * (1 + 0.66);
        return totalPkb + totalBbnkb + 300000;
    }

}

package kendaraan.model;

import kendaraan.interfaces.Ibergerak;
import kendaraan.interfaces.Iserviceable;
import java.util.Date;

public class Speedboat extends Kendaraan implements Ibergerak, Iserviceable {
    private int dayaMesin; // horsepower of the engine
    private double kecepatan; // speed of the speedboat

    public Speedboat(String merek, String model) {
        super(merek, model);
    }

    public void setDayaMesin(int daya) {
        this.dayaMesin = daya;
    }

    @Override
    public double hitungPajak() {
        return dayaMesin * 2000; // Pajak dihitung berdasarkan tenaga mesin
    }

    @Override
    public String getTipeKendaraan() {
        return "Speedboat";
    }

    @Override
    public boolean mulai() {
        kecepatan = 30; // Speedboat starts at 30 km/h
        return true;
    }

    @Override
    public boolean berhenti() {
        kecepatan = 0; // Speedboat stops
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

    // Implementasi untuk Iserviceable
    @Override
    public boolean periksaKondisi() {
        return true; // Misalnya kondisi kendaraan selalu baik
    }

    @Override
    public void lakukanServis() {
        System.out.println("Speedboat diservis.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date(); // Mengembalikan waktu servis berikutnya (untuk contoh ini, waktu sekarang)
    }

    @Override
    public double hitungBiayaServis() {
        return 500000; // Biaya servis (contoh)
    }
}

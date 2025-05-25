package TP6;

public abstract class Kendaraan {
    protected String id, merek, model, warna;
    protected int tahunProduksi;
    protected double hargaJual;


    public Kendaraan(String merek, String model, double hargaJual) {
        this.merek = merek;
        this.model = model;
        this.hargaJual = hargaJual;
    }

    public String getId() {
        return id;
    }

    public String getMerek() {
        return merek;
    }

    public String getModel() {
        return model;
    }

    public int getTahunProduksi() {
        return tahunProduksi;
    }
    

    public void setTahunProduksi(int tahunProduksi) {
        this.tahunProduksi = tahunProduksi;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setHargaJual(int harga) {
        this.hargaJual = harga;
    }

    public abstract double hitungPajak();
    
    public abstract String getTipeKendaraan();

}

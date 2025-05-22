abstract class Kendaraan {
    String id;
    String merek;
    String model;
    int tahunProduksi;
    String warna;

    public Kendaraan (String merek, String model) {
        this.merek = merek;
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public String getMerek() {
        return merek;
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

    public void setWarna (String warna) {
        this.warna = warna;
    }

    abstract double hitungPajak();
    abstract String getTipeKendaraan();
    
}
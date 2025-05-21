public class Tugas2No2 {
    public static void main(String[] args) {
        CekProduk produk = new CekProduk("KUDAPAN250816", "Ayam Rebus", 100, 5560);

        produk.info();

        System.out.println("Produk tersedia? " + (produk.ketersediaan() ? "Ya" : "Tidak") + "\n");
    }
}

class CekProduk {
    public String id;
    public String nama;
    public int stok;
    public double harga;

    public CekProduk(String id, String nama, int stok, double harga) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public void info() {
        System.out.println("ID Produk : " + id);
        System.out.println("Nama Produk : " + nama);
        System.out.println("Stok : " + stok);
        System.out.println("Harga : Rp. " + harga);
    }

    public boolean ketersediaan() {
        return stok > 0;
    }

    public int getStok() {
        return stok;
    }
}

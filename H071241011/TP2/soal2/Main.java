package TP2.soal2;

class Produk {
    String id;
    String nama;
    int stok;
    float harga;

    public Produk (String id, String nama, int stok, float harga) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public void infoProduk() {
        System.out.printf("ID: %s, Nama: %s, Stok: %d, Harga: %.2f%n", id, nama, stok, harga);
    }

    public boolean cekStok() {
        return stok > 0;
    }
 }

public class Main{
    public static void main(String[] args) {
        Produk produk1 = new Produk("A016", "RB19B", 10, 15000);
        Produk produk2 = new Produk("M009", "Mercedes W11", 0, 5000);

        produk1.infoProduk();
        produk2.infoProduk();

        System.out.println("Stok Mobil: " + (produk1.cekStok() ? "Tersedia" : "Habis"));
        System.out.println("Stok Mobil: " + (produk2.cekStok() ? "Tersedia" : "Habis"));
    }
}
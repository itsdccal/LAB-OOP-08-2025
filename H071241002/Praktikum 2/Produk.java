public class Produk {
    public String id;
    public String nama;
    public int stok;
    public double harga;

    public Produk(String id, String nama, int stok, double harga) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public boolean isTersedia() {
        return stok > 0;
    }

    public void tampilkanInfoProduk() {
        System.out.println("ID Produk: " +  id);
        System.out.println("Nama Produk: " + nama);
        System.out.println("Stok: " + stok);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Tersedia: " + (isTersedia() ? "Ya" : "Tidak"));
    }

    public static void main(String[] args) {
        Produk produk = new Produk("P001", "Laptop", 10, 999999);
        produk.tampilkanInfoProduk();
    }
}
class produk {
    String id;
    String nama;
    int stok;
    int harga;

    public produk(String id, String nama, int stok, int harga) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public boolean isTersedia() {
        return stok > 0;
    }

    public void cekProduk () {
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Stok: " + stok);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Tersedia: " + (isTersedia() ? "Ya" : "Tidak"));
    }
}   

public class soal2 {
    public static void main(String[] args) {
        produk p1 = new produk("P001", "Laptop", 10, 7500000);
        produk p2 = new produk("P002", "Mouse", 0, 150000);
    
        p1.cekProduk();
        System.out.println();
        p2.cekProduk();
    }
}

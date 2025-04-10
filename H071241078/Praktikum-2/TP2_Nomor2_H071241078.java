public class TP2_Nomor2_H071241078 {
    String id;
    String nama;
    int stok;
    double harga;

    
    public TP2_Nomor2_H071241078(String id, String nama, int stok, double harga) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

 
    public void tampilkanInfoProduk() {
        System.out.println("ID Produk: " + id);
        System.out.println("Nama Produk: " + nama);
        System.out.println("Stok: " + stok);
        System.out.println("Harga: Rp " + harga);
    }


    public boolean isTersedia() {
        return stok > 0;
    }


    public static void main(String[] args) {
        TP2_Nomor2_H071241078 produk1 = new TP2_Nomor2_H071241078("P001", "Buku Tulis", 10, 5000);
       
        produk1.tampilkanInfoProduk();
        System.out.println("Tersedia di stok? " + (produk1.isTersedia() ? "Ya" : "Tidak"));

        System.out.println();
    }
}


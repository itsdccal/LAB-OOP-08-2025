public class No2Produk {
    String id;
    String nama;
    int stok;
    double harga;

    
    public No2Produk(String id, String nama, int stok, double harga) {
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
        No2Produk produk1 = new No2Produk("P001", "Buku Tulis", 10, 5000);
       
        produk1.tampilkanInfoProduk();
        System.out.println("Tersedia di stok? " + (produk1.isTersedia() ? "Ya" : "Tidak"));

        System.out.println();
    }
}












// import java.util.Scanner;

// public class No2Produk {
//     private String id;
//     private String nama;
//     private int stok;
//     private double harga;

//     public No2Produk(String id, String nama, int stok, double harga) {
//         this.id = id;
//         this.nama = nama;
//         this.stok = stok;
//         this.harga = harga;
//     }

//     public void tampilkanInfoProduk() {
//         System.out.println("ID Produk: " + id);
//         System.out.println("Nama Produk: " + nama);
//         System.out.println("Stok: " + stok);
//         System.out.println("Harga: Rp " + harga);
//     }

//     public boolean isTersedia() {
//         return stok > 0;
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

       
//         System.out.println("Masukkan ID Produk:");
//         String id = scanner.nextLine();
//         System.out.println("Masukkan Nama Produk:");
//         String nama = scanner.nextLine();
//         System.out.println("Masukkan Stok Produk:");
//         int stok = scanner.nextInt();
//         System.out.println("Masukkan Harga Produk:");
//         double harga = scanner.nextDouble();
//         scanner.nextLine();

       
//         No2Produk produk = new No2Produk(id, nama, stok, harga);

    
//         System.out.println("\nInformasi Produk:");
//         produk.tampilkanInfoProduk();
//         System.out.println("Tersedia di stok? " + (produk.isTersedia() ? "Ya" : "Tidak"));

//         scanner.close();
//     }
// }
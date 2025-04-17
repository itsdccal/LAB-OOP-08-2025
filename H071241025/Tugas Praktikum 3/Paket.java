public class Paket {
    String resi;
    double berat;
    Kurir kurir;

    public Paket() {
        this.resi = "Tidak diketahui";
        this.berat = 0.0;
        this.kurir = new Kurir();
    }

    public Paket (String resi, double berat, Kurir kurir) {
        this.resi = resi;
        this.berat = berat;
        this.kurir = kurir;
    }

    public void InfoKurir(){
        System.out.println("Paket dengan resi " + resi + " diantar oleh " + kurir.namaKurir + " dari " + kurir.alamat + "\nNomor telepon Kurir: " + kurir.nomortelp);
    }

    public void bandingkanBerat (Paket paketLain) {
        if (this.berat > paketLain.berat) {
            System.out.println("\nPaket resi " + this.resi + " lebih berat dari paket resi " + paketLain.resi);
        } else if (this.berat < paketLain.berat) {
            System.out.println("\nPaket resi " + this.resi + " lebih ringan dari paket resi " + paketLain.resi);
        } else {
            System.out.println("\nKedua paket memiliki berat yang sama.");
        }
    }
}
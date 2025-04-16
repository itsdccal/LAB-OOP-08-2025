public class Main {
    public static void main(String[] args) {
        HewanPendamping heiHei = new HewanPendamping("Hei hei", "Ayam");
        PenjelajahLaut moana = new PenjelajahLaut("Moana", "kapal Laut Ajaib,", heiHei);

        HewanPendamping pua = new HewanPendamping("pua", "Babi");
        PenjelajahLaut teman = new PenjelajahLaut("lani","Perahu dayung", pua);

        moana.berlayar();
        teman.berlayar();

        moana.temui(teman);


    }
}

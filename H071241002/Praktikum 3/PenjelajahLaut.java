public class PenjelajahLaut {
    String nama;
    String kapal;
    HewanPendamping pendamping;

    public PenjelajahLaut(){
        this.nama = "Tidak diketahui";
        this.kapal = "Perahu biasa";
        this.pendamping = new HewanPendamping();

    }

    public PenjelajahLaut(String nama, String kapal, HewanPendamping pendamping){
        this.nama = nama;
        this.kapal = kapal;
        this.pendamping = pendamping;

    }

    public void berlayar(){
        System.out.println(nama + " sedang berlayar dengan kapal " + kapal + ".");
        pendamping.bersuara();

    }

    public void temui(PenjelajahLaut lain){
        System.out.println(nama + " bertemu dengan " + lain.nama + " di tengan samudra.");
        
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getKapal(){
        return kapal;
    }

    public void setKapal(String kapal){
        this.kapal = kapal;
    }

    public HewanPendamping getPendamping(){
        return pendamping;
    }

    public void setPendamping(HewanPendamping pendamping){
        this.pendamping = pendamping;
    }
}

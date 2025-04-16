public class HewanPendamping {
    String nama;
    String jenis;


    public HewanPendamping(){
        this.nama = "Tidak diketahui";
        this.jenis = "Tidak diketahui";
    }

    public HewanPendamping(String nama,String jenis){
        this.nama = nama;
        this.jenis = jenis;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getJenis(){
        return jenis;
    }

    public void setJenis(String jenis){
        this.jenis = jenis;
    }

    public void bersuara(){
        System.out.println( nama + " si " + jenis + " Mengeluarkan suara unik " );
    }
}

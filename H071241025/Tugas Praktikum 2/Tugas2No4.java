public class Tugas2No4 {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Daya";
        alamat.kota = "Makassar";

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Zahra";
        mahasiswa.nim = "H071241025";

        System.out.println("Nama : " + mahasiswa.getNama());
        System.out.println("Nim : " + mahasiswa.getNim());
        System.out.println("Alamat : " + mahasiswa.getAlamat());
    }
}

class Alamat {
    public String jalan;
    public String kota;
}

class Mahasiswa {
    public Alamat alamat;
    public String nama;
    public String nim;

    public void setAlamat(Alamat alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat.jalan + ", " + alamat.kota;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNim (String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }
}

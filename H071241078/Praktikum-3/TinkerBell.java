public class TinkerBell {
    String nama;
    String musim;
    Karakteristik karakteristik;

    TinkerBell() {
        this.nama = "Peri lain";
        this.musim = "Salju";
        this.karakteristik = new Karakteristik();
    }

    TinkerBell(String nama, String musim, Karakteristik karakteristik) {
        this.nama = nama;
        this.musim = musim;
        this.karakteristik = karakteristik;
    }


    public void tampilkanDataDiri() {
        System.out.println("Nama: " + nama);
        System.out.println("Musim: " + musim);
        karakteristik.tampilkanKarakteristik();
    }

    public void bertukarMusim(TinkerBell teman) {
        System.out.println(nama + " ingin bertukar musim dengan " + teman.nama);
    
        if (!this.musim.equals(teman.musim)) {
            String musimSementara = this.musim;
            this.musim = teman.musim;
            teman.musim = musimSementara;
            System.out.println(nama + " dan " + teman.nama + " akhirnya bertukar musim. ");
        } else {
            System.out.println(nama + " dan " + teman.nama + " tidak jadi tukar musim karena meraka sudah tinggal di musim yang sama.");
        }        
            System.out.println(nama + " sekarang tinggal di musim " + this.musim);
            System.out.println(teman.nama + " sekarang tinggal di musim " + teman.musim);
    }
    
}



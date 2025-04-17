public class Karakteristik {
    String warnaBaju;
    String kelebihan;
    String kepribadian;

    Karakteristik() {
        this.warnaBaju = "Biru";
        this.kelebihan = "Dapat mengendalikan air";
        this.kepribadian= "ceroboh";
    }

    Karakteristik(String warnaBaju, String kelebihan, String kepribadian) {
        this.warnaBaju = warnaBaju;
        this.kelebihan = kelebihan;
        this.kepribadian = kepribadian;
    }

    public void tampilkanKarakteristik() {
        System.out.println("Warna Baju: " + warnaBaju);
        System.out.println("Kelebihan: " + kelebihan);
        System.out.println("Kepribadian: " + kepribadian);
    }
}



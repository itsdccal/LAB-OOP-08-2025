public class Main {
    public static void main(String[] args) {
        Karakteristik karakteristikTinkerBell = new Karakteristik("Hijau", "Dapat Memuat alat-alat canggih", "Suka membersihkan");
        TinkerBell tinkerBell = new TinkerBell("Tinker Bell", "Panas", karakteristikTinkerBell);
       
        TinkerBell periLain = new TinkerBell ();
        
        tinkerBell.tampilkanDataDiri();
        System.out.println();

        periLain.tampilkanDataDiri();
        System.out.println();

        tinkerBell.bertukarMusim(periLain);
    }
}


public class Main {
    public static void main(String[] args) {
        Kurir jnt = new Kurir ("Pak Tarno", "DC Cakung", "+62 812-3456-7890");
        Paket paket1 = new Paket("JNT1234567", 1.0, jnt);
        Paket paket2 = new Paket("JNT1234568", 2.0, jnt);

        paket1.InfoKurir();
        paket2.InfoKurir();

        paket1.bandingkanBerat(paket2);
    }
}



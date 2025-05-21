// public class Main {
//     public static void main(String[] args) {
//         Mobil mobil = new Mobil("Toyota", "Avanza");
//         mobil.setKapasitasMesin(1.5);
//         mobil.setJumlahPintu(4);
//         mobil.setBahanBakar("Bensin");
//         mobil.setKecepatan(100);
//         mobil.mulai();
//         System.out.println("Pajak Mobil: " + mobil.hitungPajak());

//         Motor motor = new Motor("Honda", "Beat");
//         motor.setKapasitasTangki(5);
//         motor.setKecepatan(80);
//         motor.mulai();
//         System.out.println("Pajak Motor: " + motor.hitungPajak());

//         Sepeda sepeda = new Sepeda("Polygon", "Premier 4");
//         sepeda.setJumlahGear(21);
//         sepeda.setKecepatan(25);
//         sepeda.mulai();
//         System.out.println("Pajak Sepeda: " + sepeda.hitungPajak());

//         Truk truk = new Truk("Hino", "500 Series");
//         truk.setKapasitasMuatan(10); // 10 ton
//         truk.setKecepatan(60);
//         truk.mulai();
//         System.out.println("Pajak Truk: " + truk.hitungPajak());
//     }
// }




import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create the vehicles
        Mobil mobil = new Mobil("Toyota", "Avanza");
        mobil.setKapasitasMesin(1.5);
        mobil.setJumlahPintu(4);
        mobil.setBahanBakar("Bensin");
        mobil.setKecepatan(100);

        Motor motor = new Motor("Honda", "Beat");
        motor.setKapasitasTangki(5);
        motor.setKecepatan(80);

        Sepeda sepeda = new Sepeda("Polygon", "Premier 4");
        sepeda.setJumlahGear(21);
        sepeda.setKecepatan(25);

        Truk truk = new Truk("Hino", "500 Series");
        truk.setKapasitasMuatan(10); // 10 ton
        truk.setKecepatan(60);

        while (true) {
            System.out.println("\n=== Pilih Kendaraan ===");
            System.out.println("1. Mobil");
            System.out.println("2. Motor");
            System.out.println("3. Sepeda");
            System.out.println("4. Truk");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan (1-5): ");
            int pilihan = scanner.nextInt();

            Kendaraan kendaraan = null;

            switch (pilihan) {
                case 1:
                    kendaraan = mobil;
                    break;
                case 2:
                    kendaraan = motor;
                    break;
                case 3:
                    kendaraan = sepeda;
                    break;
                case 4:
                    kendaraan = truk;
                    break;
                case 5:
                    System.out.println("Terima kasih! Program selesai.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
                    continue;
            }

            System.out.println("\n=== Kendaraan: " + kendaraan.getTipeKendaraan() + " ===");
            System.out.println("Merek: " + kendaraan.getMerek());
            System.out.println("Model: " + kendaraan.getModel());

            if (kendaraan instanceof IBergerak) {
                IBergerak bergerak = (IBergerak) kendaraan;
                System.out.println("Kecepatan saat ini: " + bergerak.getKecepatan() + " km/jam");
            } else {
                System.out.println("Kendaraan ini tidak memiliki kecepatan (tidak dapat bergerak).");
            }

            System.out.println("Pilih aksi:");
            System.out.println("1. Mulai");
            System.out.println("2. Berhenti");
            System.out.println("3. Lihat Pajak");
            System.out.println("4. Servis");
            System.out.println("5. Kembali ke Menu");
            System.out.print("Masukkan pilihan (1-5): ");

            int aksi = scanner.nextInt();

            switch (aksi) {
                case 1:
                    if (kendaraan instanceof IBergerak) {
                        ((IBergerak) kendaraan).mulai();
                    } else {
                        System.out.println("Kendaraan ini tidak dapat mulai bergerak.");
                    }
                    break;
                case 2:
                    if (kendaraan instanceof IBergerak) {
                        ((IBergerak) kendaraan).berhenti();
                    } else {
                        System.out.println("Kendaraan ini tidak dapat berhenti karena tidak bergerak.");
                    }
                    break;
                case 3:
                    System.out.println("Pajak Kendaraan: " + kendaraan.hitungPajak());
                    break;
                case 4:
                    if (kendaraan instanceof IServicable) {
                        IServicable servicable = (IServicable) kendaraan;
                        System.out.println("Servis Kendaraan: ");
                        servicable.lakukanServis();
                        System.out.println("Waktu Servis Berikutnya: " + servicable.getWaktuServisBerikutnya());
                        System.out.println("Biaya Servis: Rp " + servicable.hitungBiayaServis());
                    } else {
                        System.out.println("Kendaraan ini tidak membutuhkan servis.");
                    }
                    break;
                case 5:
                    continue;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
                    break;
            }
        }
    }
}


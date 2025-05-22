import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Ingin mengecek data apa hari ini?");
            System.out.println("1. Mobil \n2. Motor \n3. Sepeda \n4. Karpet Aladdin");
            System.out.println("> ");
            int cekData = sc.nextInt();

            if (cekData == 1) {
                Mobil mobil = new Mobil("Toyota", "camry");
                System.out.println("=== DATA MOBIL ===");
                System.out.print("Masukkan jumlah pintu: ");
                int jumlahPintu = sc.nextInt();
                mobil.setJumlahPintu(jumlahPintu);
                //
                System.out.print("Masukkan kapasitas mesin: ");
                double kapasitasMesin = sc.nextDouble();
                mobil.setKapasitasMesin(kapasitasMesin);
                //
                System.out.print("Masukkan jumlah kursi: ");
                int jumlahKursi = sc.nextInt();
                mobil.setJumlahKursi(jumlahKursi);
                //
                System.out.print("Masukkan jenis bahan bakar: ");
                String bahanBakar = sc.next();
                mobil.setBahanBakar(bahanBakar);
                //
                System.out.print("Masukkan kecepatan: ");
                double kecepatanMobil = sc.nextDouble();
                mobil.setKecepatan(kecepatanMobil);
                //
                System.out.println("=== DETAIL DATA MOBIL ===");
                System.out.println("Tipe Kendaraan: " + mobil.getTipeKendaraan());
                System.out.println("Merek: " + mobil.merek);
                System.out.println("Model: " + mobil.model);
                System.out.println("Jumlah pintu: " + mobil.getJumlahPintu());
                System.out.println("Kapasitas mesin: " + mobil.getKapasitasMesin());
                System.out.println("Jumlah Kursi: " + mobil.getJumlahKursi());
                System.out.println("Jenis Bahan Bakar: " + mobil.getBahanBakar());
                System.out.println("Kecepatan: " + mobil.getKecepatan());
        
                System.out.print("\nTampilkan pajak? (Y/N) : ");
                String pajakMobil = sc.next();
                if (pajakMobil.equalsIgnoreCase("y")) {
                    System.out.print("Pajak Mobil: " + mobil.hitungPajak());
                }
        
                System.out.print("\nNyalakan mobil? (Y/N) : ");
                String nyalakan = sc.next();
                if (nyalakan.equalsIgnoreCase("y")) {
                    mobil.mulai();
                    System.out.print("\nHentikan mobil? (Y/N) : ");
                    String matikanMobil = sc.next();
                    if (matikanMobil.equalsIgnoreCase("y")) {
                        mobil.berhenti();
                    }
                }
        
                System.out.print("\nPeriksa Kondisi Mobil? (Y/N) : ");
                String periksaMobil = sc.next();
                if (periksaMobil.equalsIgnoreCase("y")) {
                    mobil.periksaKondisi();
                }
        
                System.out.print("\nService Mobil? (Y/N) : ");
                String serviceMobil = sc.next();
                if (serviceMobil.equalsIgnoreCase("y")){
                    mobil.lakukanService();
                    System.out.println("\nBiaya service: " + mobil.hitungBiayaServis());
                    System.out.println("\nWaktu Service berikutnya: " + mobil.getWaktuServisBerikutnya());
                }

            } else if (cekData == 2) {
                Motor motor = new Motor("Yamaha", "Aerox");
                System.out.println("=== DATA MOTOR ===");
                System.out.print("Masukkan jenis motor: ");
                String jenisMotor = sc.next();
                motor.setJenisMotor(jenisMotor);
                //
                System.out.println("Masukkan kapasitas tangki: ");
                double kapasitas = sc.nextDouble();
                motor.setKapasitasTangki(kapasitas);
                //
                System.out.println("Masukkan tipe suspensi: ");
                String suspensi = sc.next();
                motor.setTipeSuspensi(suspensi);
                //
                System.out.println("Masukkan Kecepatan: ");
                double kecepatanMotor = sc.nextDouble();
                motor.setKecepatan(kecepatanMotor);
                //

                System.out.println("=== DETAIL DATA MOTOR ===");
                System.out.println("Tipe Kendaraan: " + motor.getTipeKendaraan());
                System.out.println("Merek motor: " + motor.merek);
                System.out.println("Model motor: " + motor.model);
                System.out.println("Jenis motor: " + motor.getJenisMotor());
                System.out.println("Kapasitas Tangki: " + motor.getKapasitasTangki());
                System.out.println("Tipe Suspensi: " + motor.getTipeSuspensi());
                System.out.println("Kecepatan: " + motor.getKecepatan());

                System.out.print("\nTampilkan pajak? (Y/N) : ");
                String pajakMotor = sc.next();
                if (pajakMotor.equalsIgnoreCase("y")) {
                    System.out.print("Pajak Motor: " + motor.hitungPajak());
                }
        
                System.out.print("\nNyalakan motor? (Y/N) : ");
                String nyalakan = sc.next();
                if (nyalakan.equalsIgnoreCase("y")) {
                    motor.mulai();
                    System.out.print("\nHentikan motor? (Y/N) : ");
                    String matikanMotor = sc.next();
                    if (matikanMotor.equalsIgnoreCase("y")) {
                        motor.berhenti();
                    }
                }
        
                System.out.print("\nPeriksa Kondisi motor? (Y/N) : ");
                String periksaMotor = sc.next();
                if (periksaMotor.equalsIgnoreCase("y")) {
                    motor.periksaKondisi();
                }
        
                System.out.print("\nService motor? (Y/N) : ");
                String serviceMotor = sc.next();
                if (serviceMotor.equalsIgnoreCase("y")){
                    motor.lakukanService();
                    System.out.println("\nBiaya service: " + motor.hitungBiayaServis());
                    System.out.println("\nWaktu Service berikutnya: " + motor.getWaktuServisBerikutnya());
                }

            } else if (cekData == 3) {
                Sepeda sepeda = new Sepeda("Polygon", "Sepeda lipat");
                System.out.println("=== DATA SEPEDA ===");
                System.out.println("Masukkan jenis sepeda: ");
                String jenisSepeda = sc.next();
                sepeda.setJenisSepeda(jenisSepeda);
                //
                System.out.println("Masukkan jumlah gear: ");
                int gear = sc.nextInt();
                sepeda.setJumlahGear(gear);
                //
                System.out.println("Masukkan ukuran roda: ");
                int roda = sc.nextInt();
                sepeda.setUkuranRoda(roda);
                //
                System.out.println("Masukkan kecepatan: ");
                double kecepatanSepeda = sc.nextDouble();
                sepeda.setKecepatan(kecepatanSepeda);
                //
                System.out.println("=== DETAIL DATA SEPEDA ===");
                System.out.println("Tipe Kendaraan: " + sepeda.getTipeKendaraan());
                System.out.println("Merek sepeda: " + sepeda.merek);
                System.out.println("Model sepeda: " + sepeda.model);
                System.out.println("Jenis sepeda: " + sepeda.getJenisSepeda());
                System.out.println("Jumlah gear: " + sepeda.getJumlahGear());
                System.out.println("Ukuran roda: " + sepeda.getUkuranRoda());
                System.out.println("Kecepatan: " + sepeda.getKecepatan());

                System.out.print("\nTampilkan pajak? (Y/N) : ");
                String pajakSepeda = sc.next();
                if (pajakSepeda.equalsIgnoreCase("y")) {
                    System.out.print("Pajak Sepeda: " + sepeda.hitungPajak());
                }
        
                System.out.print("\nNyalakan sepeda? (Y/N) : ");
                String nyalakanSepeda = sc.next();
                if (nyalakanSepeda.equalsIgnoreCase("y")) {
                    sepeda.mulai();
                    System.out.print("\nHentikan sepeda? (Y/N) : ");
                    String matikanSepeda = sc.next();
                    if (matikanSepeda.equalsIgnoreCase("y")) {
                        sepeda.berhenti();
                    }
                }
        
                System.out.print("\nPeriksa Kondisi sepeda? (Y/N) : ");
                String periksaSepeda = sc.next();
                if (periksaSepeda.equalsIgnoreCase("y")) {
                    sepeda.periksaKondisi();
                }
        
                System.out.print("\nService sepeda? (Y/N) : ");
                String serviceSepeda = sc.next();
                if (serviceSepeda.equalsIgnoreCase("y")){
                    sepeda.lakukanService();
                    System.out.println("\nBiaya service: " + sepeda.hitungBiayaServis());
                    System.out.println("\nWaktu Service berikutnya: " + sepeda.getWaktuServisBerikutnya());
                }

            } else if (cekData == 4) {
                KarpetAladdin karpetaladdin = new KarpetAladdin("Aladdin", "karpet turbo");
                System.out.println("=== DATA KARPET ALADDIN ===");
                System.out.print("Masukkan jenis karpet: ");
                String jenisKarpet = sc.next();
                karpetaladdin.setJenisKarpet(jenisKarpet);
                //
                System.out.print("Masukkan luas karpet: ");
                double luas = sc.nextInt();
                karpetaladdin.setLuasKarpet(luas);
                //
                System.out.print("Masukkan kecepatan: ");
                double kecepatanKarpet = sc.nextDouble();
                karpetaladdin.setKecepatan(kecepatanKarpet);
                //
                System.out.print("\nTampilkan pajak? (Y/N) : ");
                String pajakKarpetAladdin = sc.next();
                if (pajakKarpetAladdin.equalsIgnoreCase("y")) {
                    System.out.print("Pajak Karpet Aladdin: " + karpetaladdin.hitungPajak());
                }
        
                System.out.print("\nNyalakan Karpet Aladdin? (Y/N) : ");
                String nyalakanKarpetAladdin = sc.next();
                if (nyalakanKarpetAladdin.equalsIgnoreCase("y")) {
                    karpetaladdin.mulai();
                    System.out.print("\nHentikan Karpet Aladdin? (Y/N) : ");
                    String matikanKarpetAladdin = sc.next();
                    if (matikanKarpetAladdin.equalsIgnoreCase("y")) {
                        karpetaladdin.berhenti();
                    }
                }
            } else {
                System.out.println("Mohon masukkan angka yang valid (1/2/3/4).");
            }
        } catch (InputMismatchException e){
            System.out.println("Mohon masukkan angka yang valid.");
            return;
        } finally {
            sc.close();
        }
    }
}

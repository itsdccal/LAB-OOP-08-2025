package TP6;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        // Mobil
        Mobil mobil = new Mobil("Mclaren", "Senna GTR", 750_000_000);
        mobil.setJumlahPintu(2);
        mobil.setJumlahKursi(2);
        mobil.setKapasitasMesin(4);
        mobil.setBahanBakar("Bensin");
        mobil.mulai();
        mobil.setKecepatan(340);
        System.out.println("Mobil kecepatan: " + mobil.getKecepatan() + " km/h");
        System.out.println("Periksa kondisi mobil: " + (mobil.periksaKondisi() ? "OK" : "Butuh Servis"));
        System.out.println("Biaya servis mobil: Rp " + mobil.hitungBiayaServis());
        mobil.lakukanServis();
        System.out.println("Waktu servis berikutnya: " + sdf.format(mobil.getWaktuServisBerikutnya()));
        System.out.println("Pajak mobil: Rp " + mobil.hitungPajak());
        System.out.println();
        
        // Motor
        Motor motor = new Motor("Ducati", "Panigale V4", 150_000_000);
        motor.setJenisMotor("Sport");
        motor.setKapasitasTangki(15);
        motor.setTipeSuspensi("Original Ducati");
        motor.setKecepatan(289);
        motor.mulai();
        System.out.println("Kecepatan motor: " + motor.getKecepatan() + " km/h");
        System.out.println("Periksa kondisi motor: " + (motor.periksaKondisi() ? "OK" : "Butuh Servis"));
        System.out.println("Biaya servis motor: Rp " + motor.hitungBiayaServis());
        System.out.println("Waktu servis berikutnya: " + sdf.format(motor.getWaktuServisBerikutnya()));
        System.out.println("Pajak motor: Rp " + motor.hitungPajak());
        System.out.println();
        
        // Sepeda
        Sepeda sepeda = new Sepeda("Pinarelo", "Dogma F12", 5_000_000);
        sepeda.setJenisSepeda("Balap");
        sepeda.setJumlahGear(24);
        sepeda.setUkuranRoda(27);
        sepeda.setKecepatan(70);
        sepeda.setTotalJarakTempuh(200);
        sepeda.mulai();
        System.out.println("Sepeda kecepatan: " + sepeda.getKecepatan() + " km/h");
        System.out.println("Periksa kondisi sepeda: " + (sepeda.periksaKondisi() ? "OK" : "Butuh Servis"));
        System.out.println("Biaya servis sepeda: Rp " + sepeda.hitungBiayaServis());
        System.out.println("Waktu servis berikutnya: " + sdf.format(sepeda.getWaktuServisBerikutnya()));
        System.out.println("Pajak sepeda: Rp " + sepeda.hitungPajak());
        System.out.println();
        
        // KapalSelam
        KapalSelam ks = new KapalSelam("Naughty Dog", "SF-1000", 2_000_000_000);
        ks.aktifkanModeSelam();
        ks.setKedalaman(650);
        ks.setKecepatan(70);
        ks.mulai();
        System.out.println("Kapal Selam kecepatan: " + ks.getKecepatan() + " km/h");
        System.out.println("Kapal Selam kedalaman: " + ks.getKedalaman() + " m");
        System.out.println("Periksa kondisi kapal selam: " + (ks.periksaKondisi() ? "OK" : "Butuh Servis"));
        System.out.println("Biaya servis kapal selam: Rp " + ks.hitungBiayaServis());
        System.out.println("Waktu servis berikutnya: " + ks.getWaktuServisBerikutnya());
        System.out.println("Pajak kapal selam: Rp " + ks.hitungPajak());
        System.out.println();
    }

    public void tampilkanInfo() {
        
    }
}

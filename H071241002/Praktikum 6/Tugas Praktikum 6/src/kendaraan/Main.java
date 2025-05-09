package kendaraan;

import kendaraan.model.*;
import java.util.Scanner;
import java.util.Random;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        // Membuat kendaraan
        Mobil mobil = new Mobil("Toyota", "Avanza");
        mobil.setKapasitasMesin(1.5);
        mobil.setJumlahPintu(4);
        mobil.setJumlahKursi(5);

        Motor motor = new Motor("Yamaha", "Nmax");
        motor.setKapasitasTangki(5);
        motor.setJenisMotor("Sport");

        Sepeda sepeda = new Sepeda("Polygon", "Mountain");
        sepeda.setJumlahGear(6);
        sepeda.setUkuranRoda(26);

        Speedboat speedboat = new Speedboat("Yamaha", "VXR");
        speedboat.setDayaMesin(180);

        System.out.println("Selamat datang di Petualangan Dimensi Kendaraan!");
        System.out.println("Pilih kendaraanmu:");
        System.out.println("1. Mobil (Toyota Avanza)");
        System.out.println("2. Motor (Yamaha Nmax)");
        System.out.println("3. Sepeda (Polygon Mountain)");
        System.out.println("4. Speedboat (Yamaha VXR)");
        System.out.print("Masukkan jawaban : ");

        int pilihan = scanner.nextInt();
        scanner.nextLine();  

        Kendaraan kendaraan = pilihKendaraan(pilihan);

        double jarak = rand.nextInt(800) + 1; 
        System.out.println("Medan Dimensi yang dipilih: " + pilihDimensi());

        perjalanan(kendaraan, jarak);
    }

    public static Kendaraan pilihKendaraan(int pilihan) {
        switch (pilihan) {
            case 1:
                return new Mobil("Toyota", "Avanza");
            case 2:
                return new Motor("Yamaha", "Nmax");
            case 3:
                return new Sepeda("Polygon", "Mountain");
            case 4:
                return new Speedboat("Yamaha", "VXR");
            default:
                return null;
        }
    }

    public static String pilihDimensi() {
        String[] dimensi = {"Dimensi Cermin (Refleksi Dunia Lain)", 
                            "Dimensi Waktu (Perjalanan Masa Lalu dan Masa Depan)", 
                            "Dimensi Hampa (Keberadaan dan Ketidakhadiran)", 
                            "Dimensi Pikiran (Kendaraan dengan Jiwa Sendiri)"};
        return dimensi[rand.nextInt(dimensi.length)];
    }

    public static void perjalanan(Kendaraan kendaraan, double jarak) {
        double waktu = 0; 
        double kecepatan = rand.nextInt(10) + 1; 
        double energiKendaraan = 100; 

        String dimensi = pilihDimensi();
        if (dimensi.equals("Dimensi Cermin")) {
            System.out.println("\nDunia terbalik! Setiap langkahmu, bayanganmu mencoba mengambil alih.");
        } else if (dimensi.equals("Dimensi Waktu")) {
            System.out.println("\nPerjalanan waktu dimulai! Hati-hati, kamu bisa melompat ke masa depan atau masa lalu.");
        } else if (dimensi.equals("Dimensi Hampa")) {
            System.out.println("\nTidak ada yang pasti di sini. Hanya ada gelap dan cahaya yang bersifat sementara.");
        } else if (dimensi.equals("Dimensi Pikiran")) {
            System.out.println("\nKendaraanmu mulai berbicara denganmu... Apa yang akan kamu lakukan?");
        }

        int tekaTekiCounter = 0;  
        while (jarak > 0) {
            System.out.println("\nMelaju dengan kecepatan " + kecepatan + " km/jam... Dimensi ini mulai mengubahmu.");
            waktu += 2; 
            jarak -= kecepatan;

            System.out.println("Waktu yang telah berlalu: " + waktu + " jam");

            if (dimensi.equals("Dimensi Cermin")) {
                energiKendaraan -= rand.nextInt(5); 
            } else if (dimensi.equals("Dimensi Waktu")) {
                energiKendaraan -= rand.nextInt(2); 
            } else if (dimensi.equals("Dimensi Hampa")) {
                energiKendaraan -= rand.nextInt(8); 
            } else if (dimensi.equals("Dimensi Pikiran")) {
                energiKendaraan -= rand.nextInt(4); 
            }

            if (tekaTekiCounter < 2 && rand.nextInt(10) < 2) {
                tekaTekiCounter++; 
                String tekaTeki = pilihTekaTeki();
                String jawabanBenar = jawabannya(tekaTeki); 
                System.out.println("\nTeka-teki dimensi muncul: " + tekaTeki);
                System.out.print("Masukkan jawaban dalam 5 menit: ");
                
                long startTime = System.currentTimeMillis();
                String jawaban = scanner.nextLine();
                long endTime = System.currentTimeMillis();

                
                if ((endTime - startTime) > 300000) { 
                    System.out.println("Waktu habis! Anda gagal.");
                    break; 
                } else if (jawaban.equalsIgnoreCase(jawabanBenar)) {
                    System.out.println("Jawaban benar! Perjalanan dilanjutkan.");
                } else {
                    System.out.println("Jawaban salah! Perjalanan gagal.");
                    break;  
                }
            }

            if (energiKendaraan <= 0) {
                System.out.println("\nEnergi kendaraan habis! Kendaraanmu berhenti di tengah dimensi.");
                break;
            }

            System.out.println("\nSisa jarak: " + jarak + " km, Energi Kendaraan: " + energiKendaraan + "%");

            if (rand.nextInt(10) < 3) {
                System.out.println("\nMedan berubah drastis! Dimensi baru muncul di hadapanmu...");
                dimensi = pilihDimensi();  
            }
        }

        if (jarak <= 0) {
            System.out.println("\nAnda berhasil melewati batas dimensi dan sampai di tujuan!");
        } else {
            System.out.println("\nPerjalanan gagal, terjebak dalam dimensi tak berujung.");
        }
    }

    public static String pilihTekaTeki() {
        String[] tekaTekiArray = {
            "Apa yang lebih berat dari berat, namun tidak bisa dipahami oleh otak?",
            "Saya bisa terbang tanpa sayap, saya bisa menangis tanpa mata. Dimana saya berada?",
            "Saya memiliki kunci, tetapi tidak ada pintu. Apa saya?",
            "Apa yang bisa dilihat tetapi tidak bisa disentuh, ada di luar sana, tetapi tak bisa digapai?",
            "Apa yang selalu datang tetapi tidak pernah tiba?",
            "Saya memiliki wajah, tetapi tidak ada mulut. Siapakah saya?",
            "Jika saya memiliki dua tangan, namun saya tidak bisa bergerak. Siapakah saya?",
            "Saya semakin banyak, semakin ringan saya. Apa saya?",
            "Apa yang memiliki banyak lubang, tetapi tetap dapat menampung banyak air?",
            "Apa yang bisa berjalan tanpa kaki, tapi selalu bergerak?"
        };
        return tekaTekiArray[rand.nextInt(tekaTekiArray.length)];
    }

    public static String jawabannya(String tekaTeki) {
        switch (tekaTeki) {
            case "Apa yang lebih berat dari berat, namun tidak bisa dipahami oleh otak?":
                return "Waktu";
            case "Saya bisa terbang tanpa sayap, saya bisa menangis tanpa mata. Dimana saya berada?":
                return "Awan";
            case "Saya memiliki kunci, tetapi tidak ada pintu. Apa saya?":
                return "Piano";
            case "Apa yang bisa dilihat tetapi tidak bisa disentuh, ada di luar sana, tetapi tak bisa digapai?":
                return "Cahaya";
            case "Apa yang selalu datang tetapi tidak pernah tiba?":
                return "Besok";
            case "Saya memiliki wajah, tetapi tidak ada mulut. Siapakah saya?":
                return "Jam";
            case "Jika saya memiliki dua tangan, namun saya tidak bisa bergerak. Siapakah saya?":
                return "Jam Dinding";
            case "Saya semakin banyak, semakin ringan saya. Apa saya?":
                return "Lubang";
            case "Apa yang memiliki banyak lubang, tetapi tetap dapat menampung banyak air?":
                return "Spons";
            case "Apa yang bisa berjalan tanpa kaki, tapi selalu bergerak?":
                return "Waktu";
            default:
                return "";
        }
    }
}

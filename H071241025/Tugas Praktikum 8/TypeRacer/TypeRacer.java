package TypeRacer;

import java.util.ArrayList;
import java.util.Random;

public class TypeRacer {
    private String wordsToType;
    private ArrayList<Typer> rareContestant = new ArrayList<>();
    private ArrayList<Result> rareStanding = new ArrayList<>();

    public String getWordsToType() {
        return wordsToType;
    }

    public ArrayList<Typer> getRareContestant() {
        return rareContestant;
    }

    // Bisa diganti sesuai keinginan masing-masing
    private String[] wordsToTypeList = {
            "Di Bikini Bottom ada Spongebob Squarepants, dia memang keren suka main drumband",
            "Dia jadi koki masaknya krabby patty, menjalani hari hidup bersama Garry",
            "Ayo sama-sama sebutkan nama-nama makhluk dalam sana di Bikini Bottom jaya",
            "Namun ada juga namanya Patrick Star, walau dia cetar tapi hidupnya liar",
            "Tinggal dalam batu tapi suka membantu, sayang hanya satu otaknya itu buntu"
    };

    public void setNewWordsToType() {
        Random random = new Random();
        int angkaRandom = random.nextInt(wordsToTypeList.length);
        wordsToType = wordsToTypeList[angkaRandom];
    }

    // Buat method addResult yang mana digunakan untuk menambahkan typer yang
    // telah selesai (mengetik semua kata), ke dalam list race standing.
    public synchronized void addResult(Result result) {
        rareStanding.add(result);
    }

    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("=========================");

        // Tampilkan klasemen akhir dari kompetisi, dengan format
        // {posisi}. {nama} = {waktu penyelesaian dalam detik} detik
        int posisi = 1;
        rareStanding.sort((a, b) -> Integer.compare(a.getFinishTime(), b.getFinishTime()));
        for (Result result : rareStanding) {
            System.out.println(posisi + ". " + result.getName() + " = " + result.getFinishTime() + " detik");
            posisi += 1;
        }
    }

    public void startRace() {
        // Jalankan kompetisi untuk tiap kontestan
        for (Typer t : rareContestant) {
            t.start();
        }
    }

    // selama semua peserta belum selesai maka tampilkan typing progress-nya setiap
    // 2 detik, dengan format:
    // Typing Progress ...
    // ===================
    // {nama kontestan} => {text yang telah dia ketik}
    // {nama kontestan} => {text yang telah dia ketik}
    // {nama kontestan} => {text yang telah dia ketik}
    public void displayRaceStandingPeriodically() throws InterruptedException {
        while (rareStanding.size() < rareContestant.size()) {
            System.out.println("Typing Progress ...");
            System.out.println("===================");
            for (Typer t : rareContestant) {
                System.out.println(t.getBotName() + " => " + t.getWordsTyped());
            }
            Thread.sleep(2000);
        }
        
        // Setelah semua typer selesai, tampilkan race standing setelah semua typer
        // selesai
        printRaceStanding();
    }
}
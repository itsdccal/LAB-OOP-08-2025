package TypeRacer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public ArrayList<Result> getTypeRaceTable() {
        return rareStanding;
    }

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

    public synchronized void addResult(Result result) {
        rareStanding.add(result);
    }

    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("=========================\n");

        Collections.sort(rareStanding, Comparator.comparingLong(Result::getFinishTime));
        int posisi = 1;
        for (Result result : rareStanding) {
            System.out.printf("%d. %s = %.2f detik%n", posisi++,
                    result.getName(), result.getFinishTime() / 1000.0);
        }
    }

    public void startRace() {
        for (Typer typer : rareContestant) {
            typer.start();
        }
    }

    public void displayRaceStandingPeriodically() throws InterruptedException {
        while (rareStanding.size() < rareContestant.size()) {
            System.out.println("\nTyping Progress ...");
            System.out.println("===================");
            for (Typer typer : rareContestant) {
                System.out.printf("%s => %s%n", typer.getBotName(), typer.getWordsTyped());
            }
            Thread.sleep(2000);
        }


        printRaceStanding();
    }
}

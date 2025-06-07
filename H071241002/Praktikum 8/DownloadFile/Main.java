package DownloadFile;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    static int successfulDownloads = 0;
    static int completedDownloads = 0;
    static int totalFiles;
    static boolean allDone = false;
    static ArrayList<Result> results = new ArrayList<>();

    public static synchronized void recordResult(int fileId, int duration, String threadName) {
        completedDownloads++;
        String status = (duration <= 2) ? "Success" : "Timeout";
        if (status.equals("Success")) {
            successfulDownloads++;
        }
        results.add(new Result(fileId, threadName, duration, status));
    }

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of files to download: ");
        totalFiles = scanner.nextInt();
        scanner.close(); 

        
        ExecutorService downloadExecutor = Executors.newFixedThreadPool(3);
        ExecutorService uiExecutor = Executors.newSingleThreadExecutor();

        long startTime = System.currentTimeMillis();

        uiExecutor.submit(() -> {
            int elapsedTime = 1;
            while (!allDone) {
                try {
                    System.out.println("Downloading files... (" + elapsedTime + "s)");
                    Thread.sleep(1000);
                    elapsedTime++;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        for (int i = 1; i <= totalFiles; i++) {
            int fileId = i;
            downloadExecutor.submit(() -> {
                Random rand = new Random();
                int duration = rand.nextInt(3) + 1; // durasi 1-3 detik
                try {
                    Thread.sleep(duration * 1000L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                String threadName = Thread.currentThread().getName();
                recordResult(fileId, duration, threadName);
            });
        }


        downloadExecutor.shutdown();

        try {
            downloadExecutor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        allDone = true;
        uiExecutor.shutdown();
        
        try {
            uiExecutor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        int totalTime = (int) ((endTime - startTime) / 1000);

        System.out.println("--------------------------------------------------");
        System.out.println("                  Detailed Report                 ");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-8s | %-18s | %-8s | %-8s%n",
                "File ID", "Thread", "Duration", "Status");
        System.out.println("--------------------------------------------------");

        results.sort(Comparator.comparingInt(r -> r.fileId));

        for (Result r : results) {
            System.out.printf("%-8d | %-18s | %-8s | %-8s%n",
                    r.fileId, r.threadName, r.duration + "s", r.status);
        }

        System.out.println("--------------------------------------------------");
        System.out.println("                     Summary                      ");
        System.out.println("--------------------------------------------------");
        System.out.println("Successful downloads : " + successfulDownloads);
        System.out.println("Failed downloads     : " + (totalFiles - successfulDownloads));
        System.out.printf("Total time           : %ds%n", totalTime);
    }
}

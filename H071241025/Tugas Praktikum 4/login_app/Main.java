package login_app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import login_app.models.Profile;
import login_app.models.User;
import login_app.utils.StringUtils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Memanggil method runApp();
        runApp();
    }

    private static void runApp() {
        // Menu Utama Aplikasi
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("> ");
        
        int selectMenu = 0;
        // Menginput pilihan menu
        try {
            selectMenu = sc.nextInt();
            sc.nextLine();
            if (selectMenu <= 0 || selectMenu > 2) {
                System.out.println("Harap masukkan angka yang valid (1 atau 2).");
            }
        } catch (InputMismatchException e){
            sc.nextLine();
            System.out.println("\nHarap masukkan angka yang valid (1 atau 2)");
            runApp();
            return;
        }

        switch (selectMenu) {
            case 1:
            // Membuka Halaman Login
            showLoginMenu();
            break;
            case 2:
            // Membuka Halaman Register
            showRegisterMenu();
            default:
            // Mengulang Pemanggilan Menu Utama
            runApp();
        }
    }

    private static void showLoginMenu() {
        // Halaman Login
        System.out.println("-------------------------");
        System.out.println("Login");
        
        // Menginput Username dan Menyimpannya di attribute username;
        System.out.println("Masukkan Username");
        System.out.print("> ");
        String username = sc.next();

        
        // Membuat variabel userIndex yang mana nanti akan menampung index dari user
        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break;
            }
        }

        if (userIndex == -1) {
            System.out.println("Username tidak terdaftar. Harap registrasi terlebih dahulu.");
            runApp();
            return;
        } 

        // Saat userIndex tidak sama dengan -1 atau userIndexnya ditemukan
        System.out.println("Password");
        System.out.print("> ");
        String password = sc.next();
        
        User user = listUser.get(userIndex);
        if (userIndex != -1) {
            // Menginput Password
            boolean passwordCocok = password.equals(user.getPassword());
            
            // Jika passwordnya sama maka berhasil login
            while (true) {
                if (passwordCocok) {
                System.out.println("Berhasil Login");
                showDetailUser(listUserProfile.get(userIndex));
                System.exit(0);
            } else {
                // saat password salah akan menampikan password salah
                System.out.println("Password Salah");
            }
            runApp();
            }
        }
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        // Menginput username dan password
        String username = "";
        while (true) {
            System.out.println("Username");
            System.out.print("> ");
            username = sc.nextLine();
            if (username.isEmpty()) {
                System.out.println("Input tidak boleh kosong.");
                continue;
            } 

            boolean usernameExist = false;
            for (User user : listUser) {
                if (user.getUsername().equals(username)) {
                    usernameExist = true;
                    break;
                }
            }
            
            if (usernameExist) {
                System.out.println("Username telah digunakan. Silahkan masukkan username lain.");
            } else {
                break;
            }
        } 
        
        String password = "";
        while (true){
            System.out.println("Password");
            System.out.print("> ");
            password = sc.nextLine();
            if (password.isEmpty()) {
                System.out.println("Input tidak boleh kosong.");
                continue;
            } else if (password.length() < 8) {
                System.out.println("Password minimal 8 karakter.");
                continue;
            } else {
                break;
            }
        }
        
    
        // Menginput Data Profile
        String fullName = "";
        while (true) {
            System.out.println("Nama Lengkap");
            System.out.print("> ");
            fullName = sc.nextLine();
            if (fullName.isEmpty()) {
                System.out.println("Input tidak boleh kosong.");
                continue;
            } else {
                break;
            }
        }

        int age = 0;
        while (true) {
            System.out.println("Umur");
            System.out.print("> ");
            try {
                age = sc.nextInt();
                sc.nextLine();
                if (age < 0) {
                    System.out.println("Input tidak valid.");
                    continue;
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka.");
                sc.nextLine();
            }
        }
        
        
        String hobby = "";
        while (true) {
            System.out.println("Hobby");
            System.out.print("> ");
            hobby = sc.nextLine();
            if (hobby.isEmpty()) {
                System.out.println("Input tidak boleh kosong.");
                continue;
            } else {
                break;
            }
        }

        String status = "";
        while (true) {
            System.out.println("Status: ");
            System.out.print("> ");
            status = sc.nextLine();

            
            if (status.equalsIgnoreCase("menikah") || status.equalsIgnoreCase("belum menikah") || status.equalsIgnoreCase("tidak mau menikah")) {
            } else {
                System.out.println("Input tidak valid.");
                continue;
            }
            
            if (status.isEmpty()) {
                System.out.println("Input tidak boleh kosong.");
            } else {
                break;
            }
        }
            
        User user = new User(username, password);
        
        String nickName = StringUtils.getnamapanggilan(fullName);
        Profile profile = new Profile(fullName, nickName, age, hobby, status);

        // Menambahkan user yang dibuat ke list user
        listUser.add(user);
        // Menambahkan profile user yang dibuat ke list profile
        listUserProfile.add(profile);
        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }


        
    private static void showDetailUser(Profile profile) {
        System.out.println("-------------------------");
        System.out.println("Detail Profil Pengguna");
        System.out.println("Nama Lengkap: " + profile.getfullName());
        System.out.println("Nama Panggilan: " + profile.getnickName());
        System.out.println("Umur: " + profile.getAge());
        System.out.println("Hobby: " + profile.gethobby());
        System.out.println("Status : " + profile.getStatus());
        System.out.println("-------------------------");
    }  
}

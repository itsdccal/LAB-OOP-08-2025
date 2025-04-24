package login_app;

import java.util.ArrayList;
import java.util.Scanner;
import login_app.models.Profile;
import login_app.models.User;
import login_app.utils.StringUtils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("Aplikasi Login Sederhana");
            System.out.println("-----------------------------------");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.print("> ");

            String input = sc.nextLine();
            switch (input) {
                case "1":
                    showLoginMenu();
                    break;
                case "2":
                    showRegisterMenu();
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Ulangi.");
                    break;
            }
        }
    }

    private static void showLoginMenu() {
        System.out.println("----------------------------------");
        System.out.println("Login");
        System.out.println("Masukkan Username");
        System.out.print("> ");
        String username = sc.nextLine();
        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break;
            }
        }

        if (userIndex != -1) {
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.nextLine();

            boolean isPasswordMatch = listUser.get(userIndex).getPassword().equals(password);

            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                showDetailUser(listUserProfile.get(userIndex));
            } else {
                System.out.println("Password Salah");
            }
        } else {
            System.out.println("Username tidak ditemukan");
        }
    }

    private static void showRegisterMenu() {
        System.out.println("----------------------------------");
        System.out.println("REGISTER");

        String username;
        while (true) {
            System.out.println("Username");
            System.out.print("> ");
            username = sc.nextLine().trim();
            if (username.isEmpty()) {
                System.out.println("Username tidak boleh kosong.");
                continue;
            }
            boolean isDuplicate = false;
            for (User u : listUser) {
                if (u.getUsername().equals(username)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                System.out.println("Username sudah digunakan. Silakan coba username lain.");
            } else {
                break;
            }
        }

        String password;
        while (true) {
            System.out.println("Password");
            System.out.print("> ");
            password = sc.nextLine();
            if (password.isEmpty()) {
                System.out.println("Password tidak boleh kosong.");
            } else if (password.length() < 8) {
                System.out.println("Password harus terdiri dari minimal 8 karakter.");
            } else {
                break;
            }
        }

        User user = new User(username, password);
        Profile profile = new Profile();

        String fullName;
        while (true) {
            System.out.println("Nama Lengkap");
            System.out.print("> ");
            fullName = sc.nextLine();
            if (fullName.trim().isEmpty()) {
                System.out.println("Nama lengkap tidak boleh kosong.");
            } else {
                break;
            }
        }

        int age = -1;
        while (true) {
            try {
                System.out.println("Umur");
                System.out.print("> ");
                age = Integer.parseInt(sc.nextLine());
                if (age <= 0) {
                    System.out.println("Umur harus lebih dari 0.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input umur harus berupa angka.");
            }
        }

        String hobby;
        while (true) {
            System.out.println("Hobby");
            System.out.print("> ");
            hobby = sc.nextLine();
            if (hobby.trim().isEmpty()) {
                System.out.println("Hobby tidak boleh kosong.");
            } else {
                break;
            }
        }

        String gender;
        while (true){
            System.out.println("Gender");
            System.out.print(">");
            gender = sc.nextLine();
            if (gender.trim().isEmpty()){
                System.out.println("gender tidak boleh kosong");
            } else{
                continue;
            }
            
            if (gender.equals("laki laki") || gender.equals("perempuan")){
                break;
            } else {
                System.out.println("input tidak valid");
            }

        }

        profile.setFullName(fullName);
        profile.setAge(age);
        profile.setHobby(hobby);
        profile.setGender(gender);
        profile.setNickName(StringUtils.generateNickName(fullName));
        listUser.add(user);
        listUserProfile.add(profile);
        System.out.println("----------------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        System.out.println("----------------------------------");
    }

    private static void showDetailUser(Profile profile) {
        System.out.println("=================");
        System.out.println("SELAMAT DATANG !!");
        System.out.println("=================");
        System.out.println("Nama Lengkap : " + profile.getFullName());
        System.out.println("Nama Panggilan : " + profile.getNickName());
        System.out.println("Umur : " + profile.getAge());
        System.out.println("Hobby : " + profile.getHobby());
        System.out.println("Gender : " + profile.getGender());
    }
}


package TP2.soal1;

class Orang {
    String name;
    int age;
    boolean isMale;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setGender(boolean isMale) {
        this.isMale = isMale;
    }
    public String getGender() {
        return isMale ? "Male" : "Female";
    }
    public void infoOrang() {
        System.out.printf("Nama: %s, Umur: %s%n", name, age);
    }
}

public class Main{
    public static void main(String[] args) {
        Orang orang1 = new Orang();
        Orang orang2 = new Orang();

        orang1.setName("Fadhil");
        orang2.setName("Marsha");

        orang1.setAge(20);
        orang2.setAge(18);

        orang1.setGender(true);
        orang2.setGender(false);

        orang1.infoOrang();
        System.out.println("Gender Reveal: " + (orang1.getGender()));

        orang2.infoOrang();
        System.out.println("Gender Reveal: " + (orang2.getGender()));

    }
}
public class Tugas2No1 {
    public static void main(String[] args) {
        Person orang = new Person();
        orang.setName("Jaemin");
        orang.setAge(25);
        orang.setGender(true);

        System.out.println("Name : " + orang.getName());
        System.out.println("Age : " + orang.getAge());
        System.out.println("Gender : " + orang.getGender());
    }
}

class Person {
    public String name;
    public int age;
    public boolean isMale;

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
}
public class TP2_Nomor1_H071241078 {
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
        return isMale ? "Laki-laki" : "Perempuan";
    }

    public static void main(String[] args) {
  
        TP2_Nomor1_H071241078 person1 = new TP2_Nomor1_H071241078();
        

        person1.setName("Baco");
        person1.setAge(25);
        person1.setGender(true);

        System.out.println("Nama: " + person1.getName());
        System.out.println("Usia: " + person1.getAge());
        System.out.println("Jenis Kelamin: " + person1.getGender());
    }
}

public class No1Person {
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
  
        No1Person person1 = new No1Person();
        

        person1.setName("Baco");
        person1.setAge(25);
        person1.setGender(true);

        System.out.println("Nama: " + person1.getName());
        System.out.println("Usia: " + person1.getAge());
        System.out.println("Jenis Kelamin: " + person1.getGender());
    }
}

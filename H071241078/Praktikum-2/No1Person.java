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













// import java.util.Scanner;

// public class No1Person {
//     private String name;
//     private int age;
//     private boolean isMale;

//     public void setName(String name) {
//         this.name = name;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setAge(int age) {
//         this.age = age;
//     }

//     public int getAge() {
//         return age;
//     }

//     public void setGender(boolean isMale) {
//         this.isMale = isMale;
//     }

//     public String getGender() {
//         return isMale ? "Laki-laki" : "Perempuan";
//     }


//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         No1Person person1 = new No1Person();

//         System.out.print("Masukkan nama: ");
//         String name = scanner.nextLine();
//         person1.setName(name);

//         System.out.print("Masukkan usia: ");
//         int age = scanner.nextInt();
//         person1.setAge(age);

//         System.out.print("Apakah laki-laki? (true/false): ");
//         boolean isMale = scanner.nextBoolean();
//         person1.setGender(isMale);

//         System.out.println("\n=== Informasi Person ===");
//         System.out.println("Nama: " + person1.getName());
//         System.out.println("Usia: " + person1.getAge());
//         System.out.println("Jenis Kelamin: " + person1.getGender());

//         scanner.close();
//     }
// }

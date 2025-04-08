public class Soal1 {
    public static class Person {
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
            Person p = new Person();
            p.setName("Rein");
            p.setAge(20);
            p.setGender(true); // true = Laki-laki

            System.out.println("Name   : " + p.getName());
            System.out.println("Age    : " + p.getAge());
            System.out.println("Gender : " + p.getGender());
        }
    }
}
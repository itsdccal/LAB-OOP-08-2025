class Cuboid {
    double height;
    double widht;
    double length;

    double getVolume() {
        return length * widht * height;
    }
}

public class Tugas2No3 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();

        cuboid.height = 30;
        cuboid.widht = 30;
        cuboid.length = 5;

        System.out.printf("Volume = %.2f%n", cuboid.getVolume());
    }
}


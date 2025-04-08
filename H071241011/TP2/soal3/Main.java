package TP2.soal3;

class Cuboid {
    double length;
    double width;
    double height;

    double getVolume() {
        return length * width * height;
    }
}

public class Main {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        cuboid.length = 10.0;
        cuboid.width = 15.0;
        cuboid.height = 30.0;

        System.out.printf("Volume = %.2f", cuboid.getVolume());
    }
}
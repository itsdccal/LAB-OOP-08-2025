class Cuboid {
    double height;
    double width;
    double length;

    double getVolume() {
        return height * width * length; 
    }
}

public class soal3 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();

        cuboid.height = 10;
        cuboid.width = 15;
        cuboid.length = 30;

        System.out.println(String.format("Volume = %2.2f", cuboid.getVolume()));
    }
}

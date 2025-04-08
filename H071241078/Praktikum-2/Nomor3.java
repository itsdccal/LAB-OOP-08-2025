class Cuboid {
    double height;
    double width;
    double length;

    double getVolume() {
        // Lengkapi
        return height * width * length;
    }
}

public class Nomor3 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        
        // Lengkapi
        cuboid.height = 10;  
        cuboid.width = 15;   
        cuboid.length = 30;  
        System.out.printf("Volume = %.2f%n", cuboid.getVolume());
    }
}

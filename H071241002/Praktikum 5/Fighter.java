
public class Fighter extends Hero {
    public Fighter(String name, int health, int attackPower) {
        this(name, health, attackPower, "Pedang"); 
    }

    public Fighter(String name, int health, int attackPower, String weapon) {
        super(name, health, attackPower); 
        System.out.println(name + " menggunakan " + weapon + " untuk menyerang!");
    }

    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower + " menggunakan senjata!");
    }
}

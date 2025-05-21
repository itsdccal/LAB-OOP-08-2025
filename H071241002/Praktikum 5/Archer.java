public class Archer extends Hero {
    public Archer(String name, int health, int attackPower) {
        super(name, health, attackPower); 
    }

    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan panah dan kekuatan " + attackPower + "!");
    }
}

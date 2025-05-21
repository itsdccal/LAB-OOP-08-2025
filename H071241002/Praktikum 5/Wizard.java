public class Wizard extends Hero {
    public Wizard(String name, int health, int attackPower) {
        super(name, health, attackPower); 
    }

    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan sihir dan kekuatan " + attackPower + "!");
    }
}

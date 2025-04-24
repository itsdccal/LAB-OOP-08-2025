public class Main {
    public static void main(String[] args) {
        Peran dancerPeran = new Peran("Dancer", 1.2);
        Peran centerPeran = new Peran("Center", 1.5);

        Member member1 = new Member("Marsha", centerPeran);
        Member member2 = new Member("Anin", dancerPeran);

        Event event1 = new Event("Konser", 60, 1.1);
        Event event2 = new Event("Meet And Greet", 30, 0.8);

        System.out.println(member1.getNama() + " mempunyai stamina awal : " + member1.getStamina());
        System.out.println(member2.getNama() + " mempunyai stamina  awal : " + member2.getStamina());

        member1.perform();

        event1.startEvent(member1);
        event2.startEvent(member2);

        System.out.println(member1.getNama() + " staminanya tinggal : " + member1.getStamina());
        System.out.println(member2.getNama() + " staminanya tinggal : " + member2.getStamina());
    }
}

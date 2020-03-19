package week2.WarMachine;
/*
The reason why this pattern is so good for this scenario, is that you can easily create factories which can specifically
create certain things.
 */
public class WarEffortDemo {
    public static void main(String[] args) {
        Factory Factory = new Aviation();
        WarMachine warmachine = Factory.buildArms();
        warmachine.toWar();

        Factory = new ShipYard();
        warmachine = Factory.buildArms();
        warmachine.toWar();
    }
}
package week2.WarMachine;

public class Aviation extends Factory {
    public WarMachine buildArms() {
        return new Plane();
    }
}

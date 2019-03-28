package week2.WarMachine;

public class SteelWorks extends Factory {
    public WarMachine buildArms() {
        return new Tank();
    }
}

package week2.WarMachine;

public class ShipYard extends Factory {
        public WarMachine buildArms() {
            return new Ship();
        }
    }

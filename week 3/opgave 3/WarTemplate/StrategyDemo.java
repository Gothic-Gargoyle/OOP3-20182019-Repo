package week3.WarTemplate;

public class StrategyDemo {
    public static void main(String[] args) {
    Strategy strategy = new ArtilleryBarrage();
    strategy.attack();

    strategy = new HumanWaveAttack();
    strategy.attack();

    }
}

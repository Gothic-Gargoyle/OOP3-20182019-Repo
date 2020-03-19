package week3.WarTemplate;

public class HumanWaveAttack extends Strategy {

    @Override
    void initialize(){
        System.out.println("The men are ready");
    }

    @Override
    void execute(){
        System.out.println("The men are charging! ");
    }

    @Override
    void finish(){
        System.out.println("The forlorn hope is done.");
    }
}
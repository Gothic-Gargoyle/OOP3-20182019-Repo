package week3.WarTemplate;

public class CavalryCharge extends Strategy {

    @Override
    void  initialize(){
        System.out.println("The Winged Hussars are ready!");
    }

    @Override
    void execute(){
        System.out.println("They are charging!");
    }

    @Override
    void finish(){
        System.out.println("The charge has been finished");
    }
}
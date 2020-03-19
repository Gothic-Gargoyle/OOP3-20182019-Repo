package week3.WarTemplate;

public class ArtilleryBarrage extends Strategy {

    @Override
    void  initialize(){
    System.out.println("The Howtizers are ready!");
    }

    @Override
    void execute(){
        System.out.println("The Barrage is creeping!");
    }

    @Override
    void finish(){
        System.out.println("The guns fell silent!");
    }
}

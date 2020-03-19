package week3.WarTemplate;

public abstract class Strategy {
    abstract void initialize();
    abstract void execute();
    abstract void finish();

    public final void attack(){
        initialize();
        execute();
        finish();
    }
}

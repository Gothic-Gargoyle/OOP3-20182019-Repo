import java.util.ArrayList;

public class StockGrabber implements Subject {
    private ArrayList<Observer> observers;
    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;

    public StockGrabber() {
        // a list to hold all observers
        observers = new ArrayList<Observer>();
    }

    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    public void unregister(Observer newObserver) {
        observers.remove(newObserver);
    }

    public void notifyObserver() {

        for(Observer observer : observers){
            observer.update(ibmPrice, aaplPrice, googPrice);
        }
    }

    public void setIBMPrice(double newIBMPrice) {
        this.ibmPrice = newIBMPrice;
        notifyObserver();
    }

    public void setAAPLPrice(double newAAPLPrice) {
        this.aaplPrice = newAAPLPrice;
        notifyObserver();
    }

    public void setGOOGPrice(double newGOOGPrice) {
        this.googPrice = newGOOGPrice;
        notifyObserver();
    }
}

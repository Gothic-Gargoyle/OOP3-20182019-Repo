abstract class Truck {}

class FastTruck extends Truck {}

class SlowTruck extends Truck {}

abstract class Car {}

class SlowCar extends Car {}

class FastCar extends Car {}

// Concrete Fast Factory
class FastFactory extends AbstractFactory {
  @Override
  public Car createCar() {
    return new FastCar();
  }

  @Override
  public Truck createTruck() {
    return new FastTruck();
  }
}

// Concrete Slow Factory
class SlowFactory extends AbstractFactory {
  @Override
  public Car createCar() {
    return new SlowCar();
  }

  @Override
  public Truck createTruck() {
    return new SlowTruck();
  }
}

enum Vehicle {
  FAST, SLOW
}

abstract class AbstractFactory {
  private static final SlowFactory SLOW_FACTORY = new SlowFactory();
  private static final FastFactory FAST_FACTORY = new FastFactory();

  // Geeft een concretefactory terug voor het gewenste type voertuig

  static AbstractFactory getFactory(Vehicle vehicle) {
    AbstractFactory factory = null;
    switch (vehicle) {
      case SLOW:
        factory = SLOW_FACTORY;
        break;
      case FAST:
        factory = FAST_FACTORY;
        break;
    }
    return factory;
  }
  public abstract Truck createTruck();

  public abstract Car createCar();
}


public class demo {
  public static void main(String[] args) {
    AbstractFactory factory = AbstractFactory.getFactory(Vehicle.FAST);
    Truck truck = factory.createTruck();
    Car car = factory.createCar();
    System.out.println(car);
    System.out.println(truck);
  }
}


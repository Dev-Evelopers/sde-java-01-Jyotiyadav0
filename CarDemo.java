abstract class Car {
    abstract boolean getIsSedan();
    abstract int getSeats();
    abstract String getMileage();
}

class WagonR extends Car {
    private int mileage;

    WagonR(int mileage) { this.mileage = mileage; }

    @Override
    boolean getIsSedan() { return false; }

    @Override
    int getSeats() { return 4; }

    @Override
    String getMileage() { return mileage + " kmpl"; }
}

class HondaCity extends Car {
    private int mileage;

    HondaCity(int mileage) { this.mileage = mileage; }

    @Override
    boolean getIsSedan() { return true; }

    @Override
    int getSeats() { return 4; }

    @Override
    String getMileage() { return mileage + " kmpl"; }
}

class InnovaCrysta extends Car {
    private int mileage;

    InnovaCrysta(int mileage) { this.mileage = mileage; }

    @Override
    boolean getIsSedan() { return false; }

    @Override
    int getSeats() { return 6; }

    @Override
    String getMileage() { return mileage + " kmpl"; }
}

public class CarDemo {
    public static void main(String[] args) {
        int type = 1; // 0 = WagonR, 1 = HondaCity, 2 = InnovaCrysta
        int mileage = 12;
        Car car;

        if (type == 0) car = new WagonR(mileage);
        else if (type == 1) car = new HondaCity(mileage);
        else car = new InnovaCrysta(mileage);

        String carName = car.getClass().getSimpleName();
        System.out.println("A " + carName + " is " + 
                           (car.getIsSedan() ? "" : "not ") + "Sedan, " +
                           "is " + car.getSeats() + "-seater, " +
                           "and has a mileage of around " + car.getMileage() + ".");
    }
}



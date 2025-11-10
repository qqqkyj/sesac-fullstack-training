package d.inheritance.practice;

class Vehicle{
    String model;
    int dailyRate;

    public Vehicle(String model, int dailyRate) {
        this.model = model;
        this.dailyRate = dailyRate;
    }

    int calculateRentalCost(int days){
        return dailyRate*days;
    }
}

class Car extends Vehicle{
    boolean hasGPS;

    public Car(String model, int dailyRate, boolean hasGPS) {
        super(model, dailyRate);
        this.hasGPS = hasGPS;
    }

    @Override
    int calculateRentalCost(int days) {
        int baseCost = super.calculateRentalCost(days);
        if(hasGPS) baseCost += 10000 * days;
        return baseCost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model=" + model +
                ", dailyRate='" + dailyRate + '\'' +
                ", hasGPS=" + hasGPS +
                '}';
    }
}

class Truck extends Vehicle{
    double capacity;

    public Truck(String model, int dailyRate, double capacity) {
        super(model, dailyRate);
        this.capacity = capacity;
    }

    @Override
    int calculateRentalCost(int days) {
        int baseCost = super.calculateRentalCost(days);
        if(capacity > 0) return baseCost += 5000 * capacity * days;
        else return baseCost;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "model=" + model +
                ", dailyRate='" + dailyRate + '\'' +
                ", capacity=" + capacity + "톤" +
                '}';
    }
}

public class VehicleMain {
    public static void main(String[] args) {
        Car car = new Car("소나타", 50000, true);
        Truck truck = new Truck("포터", 70000, 1.5);

        System.out.println(car);
        System.out.println("3일 대여료: " + car.calculateRentalCost(3) + "원");

        System.out.println(truck);
        System.out.println("5일 대여료: " + truck.calculateRentalCost(5) + "원");
    }
}

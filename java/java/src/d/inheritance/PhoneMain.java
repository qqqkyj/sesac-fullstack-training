package d.inheritance;

class Phone{
    String brand;
    String model;
    int batteryLevel;

    public Phone(String brand, String model, int batteryLevel) {
        this.brand = brand;
        this.model = model;
        this.batteryLevel = batteryLevel;
    }

    void powerOn(){
        System.out.println(model + " is powering on!");
    }

    void charge(){
        batteryLevel = 100;
        System.out.println("finish!");
    }
}

class Iphone extends Phone{
    String ios;

    public Iphone(String brand, String model, int batteryLevel, String ios) {
        super(brand, model, batteryLevel);
        this.ios = ios;
    }

    void useFaceID(){
        System.out.println("using FaceID");
    }
}

class Galaxy extends Phone{
    String android;

    public Galaxy(String brand, String model, int batteryLevel, String android) {
        super(brand, model, batteryLevel);
        this.android = android;
    }

    void useSPen(){
        System.out.println("using SPen");
    }
}

public class PhoneMain {
    public static void main(String[] args) {
        Iphone i = new Iphone("apple", "16 pro", 0, "26.1");
        Galaxy g = new Galaxy("samsung", "s25", 0, "25");
        i.powerOn();
        i.charge();
        i.useFaceID();
        g.powerOn();
        g.charge();
        g.useSPen();
    }
}

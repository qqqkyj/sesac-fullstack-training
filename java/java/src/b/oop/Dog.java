package b.oop;

public class Dog {
    String name;
    int age;
    String bread;
    String color;

    public Dog() {

    }

    public Dog(String name, int age, String bread) {
        this.name = name;
        this.age = age;
        this.bread = bread;
    }

    void bark(){
        System.out.println("Barking...");
    }
}

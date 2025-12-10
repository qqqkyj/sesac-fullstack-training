package d.inheritance;

class Animal{
    String name;
    int age;

    void eat(){
        System.out.println("eat!!!");
    }
}

class Dog  extends Animal{
//    String name;
//    int age;
//
//    void eat(){
//        System.out.println("eat!!!");
//    }
    String bread;
    void bark(){
        System.out.println("bark!!!");
    }
}

class Cat extends Animal{
//    String name;
//    int age;
//
//    void eat(){
//        System.out.println("eat!!!");
//    }
    int life;
    void meow(){
        System.out.println("meow!!!");
    }
}

public class Basic {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.bark();
        Cat c = new Cat();
        c.eat();
        c.meow();
    }
}

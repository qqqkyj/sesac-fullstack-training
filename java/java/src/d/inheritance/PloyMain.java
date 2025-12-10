package d.inheritance;

class Animal3{
    void makeSound(){
        System.out.println("소리를 냅니다.");
    }
}

class Dog3 extends Animal3{
    @Override
    void makeSound(){
        System.out.println("멍멍!");
    }

    void bark(){
        System.out.println("왈왈!!");
    }
}

class Cat3 extends Animal3{
    @Override
    void makeSound(){
        System.out.println("야옹!");
    }

    void meow(){
        System.out.println("미야오!");
    }
}

class Bird3 extends Animal3{
    @Override
    void makeSound(){
        System.out.println("짹짹!");
    }
}

class Rabbit3 extends Animal3{
    @Override
    void makeSound(){
        System.out.println("깡총!");
    }
}

public class PloyMain {
    public static void main(String[] args) {
        Animal3[] animals = {new Dog3(), new Cat3(), new Bird3(), new Rabbit3()};
        for(Animal3 animal : animals){
            soundAnimal(animal);
            System.out.println(animal instanceof Animal3);
            System.out.println(animal instanceof Dog3);
            System.out.println(animal instanceof Cat3);
            System.out.println(animal instanceof Bird3);
            System.out.println(animal instanceof Rabbit3);
        }

        Animal3 a = new Dog3();//업캐스팅
        a.makeSound();
        ((Dog3)a).bark(); // 다운 캐스팅

        Animal3 c1 = new Cat3();
        Cat3 c2 = (Cat3) c1; // 다운 캐스팅
        c2.meow();
    }

    static void soundAnimal(Animal3 animal){
        animal.makeSound();
    }
}

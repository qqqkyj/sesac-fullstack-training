package d.inheritance;

interface Swimmable{
    void swim();
}

interface Flyable{
    void fly();
}

interface Walkable{
    void walk();
}

class Animal7{
    void eat(){System.out.println("eating");}
}

// 여러 인터페이스는 다중 구현이 가능, 클래스는 단일 상속만 가능
class Duck extends Animal7 implements Swimmable,Flyable,Walkable{
    @Override
    public void fly() {}

    @Override
    public void swim() {}

    @Override
    public void walk() {}
}

class Fish extends Animal7 implements Swimmable{
    @Override
    public void swim() {}
}

public class MultiInterfaceMain {
    public static void main(String[] args) {
        Duck duck = new Duck();
        Fish fish = new Fish();
    }
}

package d.inheritance;

abstract class Animal4{
    String name; // 필드

    public Animal4(String name) {
        this.name = name;
    }

    // 메서드
    void sleep(){
        System.out.println("sleep~!");
    }

    // 추상 메서드 : 자식 클래스에서 반드시 구현
    abstract void makeSound();
}

abstract class Shape4{
    String color;

    public Shape4(String color) {
        this.color = color;
    }

    void display(){
        System.out.println(color);
    }

    abstract double getArea();
    abstract double getPerimeter();
}

abstract class ShapChild4 extends Shape4{
    public ShapChild4(String color) {
        super(color);
    }
}

class Circle4 extends Shape4{
    int radius;

    public Circle4(String color, int radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.round(radius * radius * Math.PI * 100.0)/100.0;
    }

    @Override
    double getPerimeter() {
        return Math.round(radius * 2 * Math.PI * 100.0)/100.0;
    }
}

class Rectangle4 extends Shape4{
    double width;
    double height;

    public Rectangle4(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    double getArea() {
        return width * height;
    }

    @Override
    double getPerimeter() {
        return 2 * (width + height);
    }
}

abstract class Vehicle4{
    abstract void start();
    abstract void stop();
    abstract int getSpeed();
}

class Car4 extends Vehicle4{
    int speed;
    @Override
    void start() {
        speed = 30;
        System.out.println("차가 출발했습니다.");
    }

    @Override
    void stop() {
        speed = 0;
        System.out.println("차가 멈췄습니다.");
    }

    @Override
    int getSpeed() {
        return speed;
    }
}

class Bicycle4 extends Vehicle4{
    int speed;
    @Override
    void start() {
        speed = 10;
        System.out.println("자전거가 출발했습니다.");
    }

    @Override
    void stop() {
        speed = 0;
        System.out.println("자전거가 멈췄습니다.");
    }

    @Override
    int getSpeed() {
        return speed;
    }
}

public class AbstractMain {
    public static void main(String[] args) {
        // Animal4 a = new Animal4(); // 추상 클래스는 인스턴스 생성 불가
        Circle4 circle = new Circle4("red", 5);
        Rectangle4 rectangle = new Rectangle4("blue", 10, 15);
        circle.display();
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
        rectangle.display();
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
    }
}

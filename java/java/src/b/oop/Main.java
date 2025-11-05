package b.oop;

public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10,20);
        Rectangle r2 = new Rectangle(20,20);

        System.out.println(r1);
        System.out.println(r2);

        System.out.println(r1.height);
        System.out.println(r1.area());

        Circle c1 = new Circle(10);
        Circle c2 = new Circle(20);
        Circle c3 = c2; // c3는 c2와 동일한 주소를 가리킴

        c1.radius = 100;
        c2.radius = 200;

        System.out.println(c1.radius);
        System.out.println(c2.radius);
        System.out.println(c3.radius);

        Dog d1 = new Dog();
        System.out.println(d1.name);
        System.out.println(d1.age);

        Dog d2 = new Dog("뽀삐", 20, "말티즈");
        System.out.println(d2.name);
        System.out.println(d2.age);
    }
}

package c.oop2;

public class Main {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.printResult(cal.add(2, 3));
        cal.printResult(cal.add(4, 5, 6));
        cal.printResult(cal.add(9));
        cal.printResult(cal.add(2, 3, 4, 5, 6, 7, 8));

        Person person = new Person();
        Person person2 = new Person("kim", 20);
        Person person3 = new Person("Lee", 30, "seoul");

        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(10);
        Rectangle r3 = new Rectangle(10, 30);

        User u = new User("홍길동", 30);
        u.setName("김길동");
        u.setAge(27);
        System.out.println(u.getName() + " " + u.getAge());
    }
}

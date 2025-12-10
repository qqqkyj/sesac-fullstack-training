package c.oop2;

public class Person {
    String name;
    int age;
    String address;

    public Person() {
        this.name = "noname";
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String address) {
//        this.name = name;
//        this.age = age;
        this(name , age); //this는 생성자의 첫 줄에만 올 수 있다.
        this.address = address;
    }
}

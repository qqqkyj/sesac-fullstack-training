package d.inheritance;

class Animal2{
    String name;
    int age;
    String bread;

    Animal2(String name, int age){
        this.name = name;
        this.age = age;
    }

    void introduce(){
        System.out.println("hello " + this.name + " " + this.age);
    }
}

class Dog2 extends Animal2{
    String bread;

    Dog2(String name, int age, String bread){
        super(name, age);// 부모클래스(Animal2)의 생성자 메서드 호출
        this.bread = bread;
    }

    void display(){
        System.out.println(this.bread);//자식 클래스의 bread
        System.out.println(super.bread);//부모 클래스의 bread 필드
    }

    void introduce(){
        super.introduce();//부모 클래스의 introduce 메서드 호출
        System.out.println("멍멍");
    }
}

public class SuperMain {
    public static void main(String[] args) {
        Animal2 a = new Animal2("동물", 0);
        Dog2 d = new Dog2("강아지", 3, "진돗개");

        System.out.println(a.bread);
        System.out.println(d.bread);
        d.display();
        d.introduce();
        a.introduce();
    }
}

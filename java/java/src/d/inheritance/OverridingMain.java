package d.inheritance;

class Parent{
    void show(){
        System.out.println("parent!");
    }
}

class Child extends Parent{
    @Override
    void show(){
        System.out.println("child!");
    }
}

public class OverridingMain {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c = new Child();
        p.show();
        c.show();
    }
}

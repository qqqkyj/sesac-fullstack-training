package d.inheritance;

class Parent{
    void show(){
        System.out.println("parent!");
    }

    final void display(){
        System.out.println("display!");
    }
}

class Child extends Parent{
    @Override
    void show(){
        System.out.println("child!");
    }

//    @Override
//    void display(){
//        System.out.println("child display!");
//    }
}

public class OverridingMain {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c = new Child();
        p.show();
        c.show();
    }
}

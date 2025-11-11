package d.inheritance;

abstract class Animal5{
    abstract void run();
    abstract void sleep();
    abstract void eat();
}

class Dog5 extends Animal5{
    @Override
    void run() {

    }

    @Override
    void sleep() {

    }

    @Override
    void eat() {

    }
}

// 인터페이스는 추상메서드만 가질 수 있음
//앞에 public abstract는 생략
interface Animal6{
    void run();
    void sleep();
    void eat();
}

class Dog6 implements Animal6{
    @Override
    public void run() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void eat() {

    }
}

public class InterfaceMain {
    public static void main(String[] args) {

    }
}

package e.generic;

class Container<T>{
    private T value;

    public Container(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

public class SingleType {
    public static void main(String[] args) {
        Container<String> c1 = new Container<>("hello");
        // Integer : wrapper class
        Container<Integer> c2 = new Container<>(123);
        Box2<String> b1 = new Box2<>();
        b1.setItem("qwer");
        Container<Box2> c3 = new Container<>(new Box2());
        System.out.println(c1.getValue());
        System.out.println(c2.getValue());
        System.out.println(c3.getValue().getItem());
    }
}

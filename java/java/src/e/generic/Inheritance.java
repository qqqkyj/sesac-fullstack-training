package e.generic;

class Parent<T>{
    private T value;

    public Parent(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

class Child<T> extends Parent<T>{
    public Child(T value) {
        super(value);
    }
}

class StringChild  extends Child<String>{
    public StringChild(String value) {
        super(value);
    }
}

class IntegerChild  extends Child<Integer>{
    public IntegerChild(Integer value) {
        super(value);
    }
}

class ExtendChild<T, U> extends Child<T>{
    private U value2;

    public ExtendChild(T value, U value2) {
        super(value);
        this.value2 = value2;
    }

    public U getValue2() {
        return value2;
    }
}


public class Inheritance {
    public static void main(String[] args) {
        Parent<String> stringParent = new Parent<>("hello");
        Child<String> c1 = new Child<>("hi");
        StringChild stringChild = new StringChild("hihi");
        IntegerChild integerChild = new IntegerChild(20);
        ExtendChild<String, Integer> ec1 = new ExtendChild<>("kim", 10);
        System.out.println(stringParent.getValue());
        System.out.println(c1.getValue());
        System.out.println(stringChild.getValue());
        System.out.println(integerChild.getValue());
        System.out.println(ec1.getValue() + " " + ec1.getValue2());
    }
}

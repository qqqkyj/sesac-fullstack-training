package d.inheritance;

import java.util.Objects;

class MyObject /*extends Object*/ {
    String name;
    int value;

    public MyObject(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyObject myObject = (MyObject) o;
        return value == myObject.value && Objects.equals(name, myObject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}

public class ObjectMain {
    public static void main(String[] args) {
        MyObject obj = new MyObject("test", 100);
        System.out.println(obj);// MyObject{name='test', value=100}

        MyObject obj2 = new MyObject("test", 101);
        System.out.println(obj.equals(obj2));//값이 같은지 비교
    }
}

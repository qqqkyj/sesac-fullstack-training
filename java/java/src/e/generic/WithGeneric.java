package e.generic;
// T: Type
class Box2<T>{
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

public class WithGeneric {
    public static void main(String[] args) {
        Box2<String> b1 = new Box2<>();
        b1.setItem("hello");
        String str = b1.getItem();

        Box2<Integer> b2 = new Box2<>();
        b2.setItem(123);
        int i = b2.getItem();
    }
}

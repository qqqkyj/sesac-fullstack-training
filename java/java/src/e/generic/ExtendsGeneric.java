package e.generic;
// Number와 그 하위 타입만 허용
class NumberBox<T extends Number>{
    private T value;

    public NumberBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

class SortedBox<T extends Comparable<T>>{
    private T value;

    public SortedBox(T value) {
        this.value = value;
    }
    /*
    음수 → 현재 객체(this)가 비교 대상 객체(o)보다 작음
    0 → 두 객체가 같음
    양수 → 현재 객체(this)가 비교 대상 객체(o)보다 큼
    */
    public boolean isGreaterThan(T other){
        return value.compareTo(other) > 0;
    }
}

public class ExtendsGeneric {
    public static void main(String[] args) {
        NumberBox<Integer> intBox = new NumberBox<>(100);
        NumberBox<Double> doubleBox = new NumberBox<>(10.25);
//        NumberBox<String> stringBox = new NumberBox<>("hello"); // Number와 그 하위 타입만 가능
        System.out.println(intBox.getValue());
        System.out.println(doubleBox.getValue());

        SortedBox<Integer> b1 = new SortedBox<>(10);
        System.out.println(b1.isGreaterThan(5));
    }
}

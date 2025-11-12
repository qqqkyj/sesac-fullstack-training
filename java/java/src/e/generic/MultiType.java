package e.generic;

class Pair<K, V>{
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

public class MultiType {
    public static void main(String[] args) {
        Pair<String, Integer> p1 = new Pair<>("gildong", 20);
        System.out.println(p1);

        Pair<String, String> p2 = new Pair<>("hi", "my name is gilja");
        System.out.println(p2);
    }
}

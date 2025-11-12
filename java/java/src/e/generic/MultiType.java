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
}

public class MultiType {
    public static void main(String[] args) {
        Pair<String, Integer> p = new Pair<>("gildong", 20);
        System.out.println(p.getKey());
    }
}

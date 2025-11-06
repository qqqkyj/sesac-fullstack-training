package c.oop2;

public class PrivateClass {
    private int value;
    public String value2;

    public PrivateClass(int value) {this.value = value;}

    public int getValue() {
        return value;
    }

    public void resetValue() {
        this.value = 0;
    }
}

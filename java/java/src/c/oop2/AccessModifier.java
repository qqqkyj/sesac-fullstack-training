package c.oop2;

public class AccessModifier {
    public static void main(String[] args) {
        PrivateClass pc = new PrivateClass(10);
        pc.resetValue();
        pc.value2 = "test msg";//public - 접근 가능
        System.out.println(pc.getValue());//private = 접근 불가
        System.out.println(pc.value2);
    }
}

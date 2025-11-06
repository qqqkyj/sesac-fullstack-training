package c.oop2;

public class MethodType {
    int instanceField = 10;
    static int staticField = 20;

    void instanceMethod(){
        System.out.println("instanceMethod");
        System.out.println("instanceField = " + instanceField);
        System.out.println("staticField = " + staticField);
    }

    static void staticMethod(){
        System.out.println("staticMethod");
        System.out.println("staticField = " + staticField);
    }

    public static void main(String[] args) {
        MethodType mt = new MethodType();//인스턴스화
        mt.instanceMethod();// 객체 생성 필요
        MethodType.staticMethod();//객체생성 없이 불필요
    }
}

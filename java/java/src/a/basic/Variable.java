package a.basic;

public class Variable {
    public static void main(String[] args){
        // 선언
        // 타입 변수명;
        int age;

        // 할당
        // 변수명 = 값;
        age = 20;

        System.out.printf("나이: %d%n", age);

        // 선언과 동시에 초기화
        // 타입 변수명 = 값;
        String name = "kim";
        System.out.printf("이름 : %s%n", name);

        // 기본형 타입
        // 정수형(byte, short, int, long)
        byte b = 100;
        short s = 10000;
        int i = 10000000;
        long l = 10000000000L;

        System.out.println(b);

        // 실수형(float, doble)
        float f = 3.14f;
        double d = 3.14;

        System.out.println(d);

        // 문자형(char - 한 글자)
        char c = 'A';
        System.out.println(c);

        // 논리형(boolean - true/false)
        boolean bool = true;
        System.out.println(bool);

        // 참조형 타입
        // String(문자열 타입 - 여러 문자의 조합): 클래스(가장 앞의 문자S는 대문자)
        String str = "Hello";
        System.out.println(str);

        String str2 = "world";
        String msg = String.join(" ", str, str2);
        System.out.println(msg);

        // null
        // 참조형 데이터만 null을 넣을 수 있다.
        String str3 = null;
        System.out.println(str3);

        // 형변환
        int iA = 100;
        double dA = iA;

        double dB = 3.14;
        // 자동 형변환 X
        //int iB = dB;(X)

        // 강제 형변환 O
        int iB = (int) dB;
        System.out.println(iB);

        // var (타입 추론)
        var myData = true; //boolean myData = true;
        var myData2 = 100;
        var myData3 = "hello";
    }
}

package a.basic;

public class Operator {
    public static void main(String[] args){
        //산술 연산자
        int a = 10;
        int b = 20;

        System.out.println(a + b);
        System.out.println(a % b);

        int x = 10;
        int y = 3;
        System.out.println(x / y); //정수
        System.out.println((double) x / y); //실수

        //증감연산자
        System.out.println("x = " + x); // 10
        System.out.println("x = " + x++); // 10 => 출력 후 증가
        System.out.println("x = " + x); // 11
        System.out.println("x = " + ++x); // 12 => 증가 후 출력
        System.out.println("_______________");

        System.out.println("x = " + x--); // 12
        System.out.println("x = " + x); // 11 => 출력 후 감수
        System.out.println("x = " + --x); // 10 => 감소 후 출력

        // 복합연산자( +, -, *, %, / 등 모두 가능)
        // x += 5 => x = x + 5;
        x += 5;
        System.out.println("x += 5 => " + x); // 15
        
        // 비교 연산자
        int bigNum = 999;
        int smallNum = 1;

        System.out.println(bigNum == smallNum); //false
        System.out.println(bigNum != smallNum); //true
        System.out.println(bigNum < smallNum); //false
        System.out.println(bigNum > smallNum); //true

        String strA = "hello";
        String strB = "hello";
        String strC = new String("hello");

        // 객체가 같은지(즉, 동일한 주소의 동일한 값을 가졌는지 비교)
        System.out.println("strA == strB => " + (strA == strB)); // true
        System.out.println("strA == strC => " + (strA == strC)); //false

        // 값만 비교하고 싶다면
        System.out.println("strA.equals(strC) => " + strA.equals(strC)); // true

        // 논리 연산자
        boolean boolA = true;
        boolean boolB = false;

        System.out.println("!boolA => " + (!boolA)); // false (NOT)
        System.out.println("boolA && boolB => " + (boolA && boolB)); // false (AND - 모두 true)
        System.out.println("boolA || boolB => " + (boolA || boolB)); // true (OR - 하나라도 true)

        // 단락평가
        // && => 앞이 false이면 뒤에 값 상관없이 무조건 false
        // || => 앞이 true이면 뒤에 값 상관없이 무조건 true
        int myX = 0;
        if(myX != 0 && x > -1){
            System.out.println("실행되나요?"); // 실행 X
        }

        // 삼항 연산자
        int age = 30;
        String adult = (age > 20) ? "성인" : "청소년";
        System.out.println(adult); // 성인

        // 비트 연산자
        // 컴퓨터는 0과 1로만 이루어짐
        int intA = 14; // 1110
        int intB = 6;  // 0110
        int result = intA & intB ; // 0110 =>6
        System.out.println(intA & intB); //6

        // ex. num = 10; (1010)
        // num << 2 : 왼쪽으로 2칸 이동 => 40 (101000)
        // num >> 1 : 오른쪽으로 1칸 이동 => 5(101)
        int num = 10;
        System.out.println("num << 2 : " + (num << 2)); // 40
        System.out.println("num >> 1 : " + (num >> 1)); // 5

        int intC = -123456;
        System.out.println(intC << 1); // -246912
        System.out.println(intC >> 1); // -61728
        System.out.println(intC >>> 1); // 2147421920
    }
}

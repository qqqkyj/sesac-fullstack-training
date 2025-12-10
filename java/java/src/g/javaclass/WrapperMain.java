package g.javaclass;

public class WrapperMain {
    public static void main(String[] args) {
        int primitive = 10;
        //primitive = null;// 컴파일 오류
        //박싱
        Integer wrapper = Integer.valueOf(primitive);
        //wrapper = null;// NullPointException 발생
        //언박싱
        Integer wrapper2 = Integer.valueOf(20);
        int primitive2 = wrapper.intValue();
        System.out.println(primitive2);

        //오토 박싱(컴파일러가 자동으로 변환)
        Integer wrapper3 = 10;

        // == 비교 문제 (-128 ~ 127까지는 캐싱되어 같은 객체를 참조)
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);//true
        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);//false

        //문자열 파싱
        int parsed = Integer.parseInt("123");
        System.out.println(parsed);

        //상수
        System.out.println(Integer.MAX_VALUE);//2147483647
        System.out.println(Integer.MIN_VALUE);//-2147483648

        //비교
        Integer e = 10;
        Integer f = 20;
        System.out.println(e.compareTo(f));//-1: f가 더 큼, 같으면: 0, 크면:1
        System.out.println(Integer.compare(100,200));//-1
    }
}

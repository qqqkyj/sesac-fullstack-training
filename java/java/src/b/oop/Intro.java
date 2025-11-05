package b.oop;

public class Intro {
    public static void main(String[] args) {
        //첫 번째 사각형
//        int width = 100;
//        int height = 200;
//        int area = width * height;
//        System.out.println(area);
//
//        //두 번째 사각형
//        int width2 = 10;
//        int height2 = 20;
//        int area2 = width2 * height2;
//        System.out.println(area2);

        // 동일 로직 발생
        // 개선 방법
        // 1. 메서드 (클래스 내부의 함수)
        // 여전히 문제 : 관련있는 데이터(속성)와 기능(메서드)이 분리
        int rec1 = calArea(10,10);
        int rec2 = calArea(20,20);
        int rec3 = calArea(30,30);

        // 2. 클래스
        // 비슷한 속성(데이터)과 기능(동작)을 하나로 묶어 새로운 타입을 정의하는 설계도
        // 클래스는 객체의 속성(필드)과 행동(메서드)을 정의

    }

    public static int calArea(int width, int height) {
        return width * height;
    }
}

package b.oop.practice;
// 문제 5: Counter 클래스
/*
요구사항:
필드: count (int)
생성자: 기본값 0으로 초기화
메서드:
    increment(): count 1 증가
    decrement(): count 1 감소
    getCount(): count 반환
    reset(): count를 0으로 리셋
 */
public class Counter {
    private int count;

    public void increment(){
        this.count++;
        System.out.println(this.count);
    }

    public void decrement(){
        this.count--;
        System.out.println(this.count);
    }

    public void getCount(){
        System.out.println(this.count);
    }

    public void reset(){
        this.count = 0;
        System.out.println(this.count);
    }
}

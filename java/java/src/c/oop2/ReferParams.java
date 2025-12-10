package c.oop2;

class Data{
    int value;
}

public class ReferParams {
    // 5. A객체를 가지고 (같은 주소를 참조)와서 value를 99로 변경
    void changeValue(Data d){
        d.value = 99;
        // 6. 출력
        System.out.println(d.value);
    }

    public static void main(String[] args) {
        // 1. Refer 인스턴스화
        ReferParams ref = new ReferParams();
        // 2. Data 인스턴스화
        Data d = new Data();
        // 3. Data 객체(A)에 데이터 10할당
        d.value = 10;
        // 4. changeValue에 A대입
        ref.changeValue(d);
        System.out.println(d.value);
    }
}

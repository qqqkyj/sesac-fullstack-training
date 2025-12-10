package b.oop.practice;
// 문제 3: Car 클래스
/*
속성:
모델명(model)
속도(speed)

기능:
accelerate(): 속도 10 증가
brake(): 속도 10 감소
printInfo(): 모델명과 현재 속도 출력
 */
public class Car {
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public void accelerate(){
        this.speed += 10;
        System.out.println(speed);
    }

    public void brake(){
        if(this.speed > 10){this.speed -= 10;}
        else{this.speed = 0;}
        System.out.println(speed);
    }

    public void printInfo(){
        System.out.println("모델: "+this.model+", 속도: "+this.speed+"km/h");
    }
}

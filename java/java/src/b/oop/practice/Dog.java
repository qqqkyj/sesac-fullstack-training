package b.oop.practice;
// 문제 2: Dog 클래스 만들기
// 견종(breed), 이름(name)을 속성으로 가지고, "앉아"(sit()), "손"(hand()) 기능을 가진 Dog 클래스를 구현하세요.
public class Dog {
    private String name;
    private String breed;

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public void sit(){
        System.out.println(this.breed + " " + this.name +"가 앉았습니다.");
    }

    public void hand(){
        System.out.println(this.breed + " " + this.name + "가 손을 내밀었습니다.");
    }
}

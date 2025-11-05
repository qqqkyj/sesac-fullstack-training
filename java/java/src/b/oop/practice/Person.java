package b.oop.practice;
// 문제 1: Person 클래스 만들기
// 이름(name), 나이(age)를 속성으로 가지는 Person 클래스를 구현하세요.
/*
요구사항:
생성자로 이름과 나이 초기화
정보를 출력하는 printInfo() 메서드 작성
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printInfo(){
        System.out.println("이름: "+ this.name +", 나이: "+this.age);
    }
}

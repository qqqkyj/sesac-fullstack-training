package d.inheritance.practice;

class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void introduce(){
        System.out.println("안녕하세요, 저는 "+name+"이고 나이는 "+ age+"입니다.");
    }
}

class Student extends Person{
    int  studentId;
    String major;

    public Student(String name, int age, int studentId, String major) {
        super(name, age);
        this.studentId = studentId;
        this.major = major;
    }

    @Override
    void introduce() {
        System.out.printf("안녕하세요, 저는 %s입니다.%n나이는 %d살이고, 학번은 %d이며, %s을 전공합니다.%n",name, age, studentId, major);
    }
}

public class PersonMain {
    public static void main(String[] args) {
        Student s = new Student("김철수", 20, 2024001, "컴퓨터공학");
        s.introduce();
    }
}

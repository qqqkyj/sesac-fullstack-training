package c.oop2;

public class StudentMain {
    public static void main(String[] args) {
        Student s1 = new Student("kim", 100);
        Student s2 = new Student("lee", 30);
        Student s3 = new Student("jack", 70);

        System.out.println(s1.getName());
        System.out.println(Student.getTotalStudent()); //static 필드(클래스 직접 접근 가능)
        System.out.println(Student.getAverageScore()); ////static 메서드(클래스 직접 접근 가능)
    }
}

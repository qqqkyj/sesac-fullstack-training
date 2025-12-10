package e.generic;

class Student<T>{
    private String name;
    private T score;

    public Student(String name, T score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getScore() {
        return score;
    }

    public void setScore(T score) {
        this.score = score;
    }

    public boolean isPassing(double passingScore){
        if(score instanceof Number){
            return ((Number)score).doubleValue() >= passingScore;
        }
        return false;
    }
}

public class StudentMain {
    public static void main(String[] args) {
        Student<Integer> s1 = new Student<>("kim", 100);
        Student<Double> s2 = new Student<>("lee", 95.5);
        Student<String> s3 = new Student<>("kang", "A");
        System.out.println(s1.isPassing(70));
        System.out.println(s2.isPassing(80.0));

        Student<Integer>[] students = new Student[3];
        students[0] = new Student<>("A",100);
        students[1] = new Student<>("B", 90);
    }
}

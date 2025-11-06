package c.oop2;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        setAge(age);
    }

    //getter
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    //setter
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        if(age < 0 || age > 100){
            throw new IllegalArgumentException("!!!!");
        }
        this.age = age;
    }
}

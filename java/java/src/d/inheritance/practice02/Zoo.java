package d.inheritance.practice02;

class Animal{
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String makeSound(){
        return "소리를 냅니다.";
    }
}

class Lion extends Animal{
    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "어흥!";
    }
}

class Elephant extends Animal{
    public Elephant(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "뿌우우!";
    }
}

class Monkey extends Animal{
    public Monkey(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "끼끼!";
    }
}

public class Zoo {
    public static void main(String[] args) {
        Animal[] animals = {new Lion("심바", 10), new Elephant("덤보", 5), new Monkey("조조", 7)};
        System.out.println("=== 먹이 시간 ===");
        for (Animal animal : animals) {
            feedingTime(animal);
        }
    }

    public static void feedingTime(Animal animal){
        if(animal instanceof Lion){
            System.out.println("사자 " + animal.name + ": " + animal.makeSound());
        }
        else if(animal instanceof Elephant){
            System.out.println("코끼리 " + animal.name + ": " + animal.makeSound());
        }
        else if(animal instanceof Monkey){
            System.out.println("원숭이 " + animal.name + ": " + animal.makeSound());
        }
        else{
            animal.makeSound();
        }
    }
}

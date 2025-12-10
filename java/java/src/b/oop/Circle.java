package b.oop;

public class Circle {
    public int radius;

    public Circle(int radius){
        this.radius = radius;
    }

    public double area(){
        return this.radius * this.radius * 3.14;
    }
}

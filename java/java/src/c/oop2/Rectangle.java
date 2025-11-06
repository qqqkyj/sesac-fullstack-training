package c.oop2;

public class Rectangle {
    int width;
    int height;

    public Rectangle() {
//        this.width = 1;
//        this.height = 1;
        this(1,1);
    }

    public Rectangle(int size) {
//        this.width = size;
//        this.height = size;
        this(size, size);
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

}

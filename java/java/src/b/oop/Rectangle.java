package b.oop;

public class Rectangle {
    int width;
    int height;

    // 생성자
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // 메서드
    public int area(){
        return this.width * this.height;
    }
}

package d.inheritance.practice04;

interface Drawable {
    void draw();
}

class Circle implements Drawable {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.printf( "반지름 [%d]인 원을 그립니다%n", radius );
    }
}

class Rectangle implements Drawable {
    private int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.printf("[%d]x[%d] 사각형을 그립니다%n", width, height);
    }
}

class Triangle implements Drawable {
    private int base, height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.printf("밑변 [%d], 높이 [%d]인 삼각형을 그립니다%n", base, height);
    }
}

public class ShapeMain {
    public static void main(String[] args) {
        Drawable[] shapes = {
                new Circle(5),
                new Rectangle(4, 6),
                new Triangle(3, 4)
        };

        for (Drawable shape : shapes) {
            shape.draw();
        }
    }
}

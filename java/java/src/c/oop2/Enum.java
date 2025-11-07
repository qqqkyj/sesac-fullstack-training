package c.oop2;

import java.util.Arrays;

public class Enum {
    public static void main(String[] args) {
        Direction direction = Direction.WEST;
        System.out.println(direction);
        System.out.println(direction.name());
        System.out.println(direction.ordinal()); //배열의 index
        System.out.println(Arrays.toString(direction.values()));//[NORTH, EAST, SOUTH, WEST]
        System.out.println(direction.valueOf("NORTH"));//NORTH
    }
}

package c.oop2;

public class Util {
    String concat(String... strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {sb.append(s).append(" ");}
        return sb.toString();
    }

    public static void main(String[] args) {
        Util u = new Util();
        String result = u.concat("사과","바나나","포도","망고","배");
        System.out.println(result);
    }
}

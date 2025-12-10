package a.basic.practice2;
// 문제 12: 역순 숫자 출력
public class Practice12 {
    public static void main(String[] args) {
        int num = 12345;
        String strNum = String.valueOf(num);
        String revStrNum = new StringBuilder(strNum).reverse().toString();
        int revNum = Integer.parseInt(revStrNum);
        System.out.println(revNum);
    }
}

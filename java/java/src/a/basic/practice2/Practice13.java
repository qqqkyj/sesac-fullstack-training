package a.basic.practice2;
// 문제 13: 숫자 자릿수 합
public class Practice13 {
    public static void main(String[] args) {
        //방법 1.
        int num = 12345;
        String strNum = String.valueOf(num);
        String[] arrStrNum = strNum.split("");
        int total = 0;
        for(String s: arrStrNum){
            total +=  Integer.parseInt(s);
        }
        System.out.println(total);

        //방법 2.
        int num2 = 12345;
        int result = 0;
        while (num2 != 0){
            result += num2%10;
            num2 = num2/10;
        }
        System.out.println(result);
    }
}

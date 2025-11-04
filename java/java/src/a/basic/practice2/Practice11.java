package a.basic.practice2;
// 문제 11: 팩토리얼
public class Practice11 {
    public static void main(String[] args) {
        int n = 5;
        int result = 1;
        for(int i=1; i<=n; i++){
            result *= i;
        }
        System.out.println(result);
    }
}

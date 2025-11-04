package a.basic.practice2;
// 문제 8: 최대공약수 (GCD)
public class Practice8 {
    public static void main(String[] args) {
        int a = 48, b = 18;
        while(b != 0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        System.out.println("최대공약수:" + a);
    }
}

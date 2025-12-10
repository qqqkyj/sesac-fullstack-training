package a.basic.practice2;
// 문제 9: 최소공배수 (LCM)
public class Practice9 {
    public static void main(String[] args) {
        int a = 12, b = 18;
        Practice9 p = new Practice9();

//        System.out.println("최소공배수: " + a*b/p.gcd(a,b));
    }

    public int gcd(int a, int b) {
        while(b != 0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
}

package a.basic.practice2;
// 문제 10: 피보나치 수열
public class Practice10 {
    public static void main(String[] args) {
        int n = 10;
        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;
        for(int i = 2; i < n; i++){
            array[i] = array[i-1] + array[i-2];
        }
        System.out.printf("%d번째 피보나치 수: %d",n,array[n-1]);
    }
}

package a.basic.practice2;

// 문제 5: 약수 구하기
public class Practice5 {
    public static void main(String[] args) {
        int num = 24;
        for(int i = 1; i<=num; i++){
            if(num%i==0)
                System.out.printf("%d ",i);
        }
    }
}

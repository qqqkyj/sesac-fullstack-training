package a.basic.practice2;

public class Practice1 {
    public static void main(String[] args) {
        // 문제 1: 구구단
        // 2단부터 9단까지 구구단을 출력하세요.
        for(int i = 2; i < 10; i++){
            System.out.printf("*****%d단*****%n",i);
            for(int j = 2; j < 10; j++){
                System.out.printf("%d X %d = %d%n",i,j,i*j);
            }
        }
    }
}

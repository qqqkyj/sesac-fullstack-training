package a.basic.practice2;
// 문제 14: 구구단 특정 단 건너뛰기
public class Practice14 {
    public static void main(String[] args) {
        for(int i=2;i<=9;i++){
            if(i == 5) continue;
            System.out.printf("*****%d단*****%n",i);
            for(int j=1;j<=9;j++){
                System.out.printf("%d X %d = %d%n",i,j,i*j);
            }
        }
    }
}

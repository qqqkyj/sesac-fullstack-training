package a.basic.practice2;

// 문제 3: 별 찍기 패턴 2
/*
 *****
 ****
 ***
 **
 *
 */
public class Practice3 {
    public static void main(String[] args) {
        for(int i=5;i>=1;i--){
            for(int j=i;j>0;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

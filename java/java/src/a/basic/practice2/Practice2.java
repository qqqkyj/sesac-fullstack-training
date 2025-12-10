package a.basic.practice2;

//문제 2: 별 찍기 패턴 1
/*
 *
 **
 ***
 ****
 *****
 */
public class Practice2 {
    public static void main(String[] args) {
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}

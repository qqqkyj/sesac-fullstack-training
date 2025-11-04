package a.basic.practice2;
// 문제 4: 별 찍기 패턴 3
/*
     *
    ***
   *****
  *******
 *********
 */
public class Practice4 {
    public static void main(String[] args) {
        for(int i=1; i<=5; i++){
            for(int j=5; j > i; j--){
                System.out.print(" ");
            }
            for(int x=1; x<=2*i-1; x++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

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
        for(int i=5; i>0; i--){
            for(int j=i; j>1; j--){
                System.out.print(" ");
            }
            for(int j=1; j<10; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

package a.basic.practice2;

// 문제 6: 소수 판별
public class Practice6 {
    public static void main(String[] args) {
        int num = 17;
        boolean flag = true;
        for(int x=2; x<num; x++){
            if(num%x==0){
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "소수입니다." : "소수가 아닙니다.");
    }
}

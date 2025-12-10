package a.basic.practice2;

// 문제 7: 소수 판별 최적화
public class Practice7 {
    public static void main(String[] args) {
        int num = 17;
        boolean flag = true;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0){
                flag = false;
                break;
            }
        }
        System.out.println(flag?"소수입니다.":"소수가 아닙니다.");
    }
}

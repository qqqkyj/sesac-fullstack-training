package a.basic.practice2;

// 문제 6: 소수 판별
public class Practice6 {
    public static void main(String[] args) {
        int num = 100;
        boolean flag = true;
        for(int x=2; x<num; x++){
            if(num%x==0){
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "소수입니다." : "소수가 아닙니다.");

        // 추가: 1~num까지 소수 구하기 및 소수의 개수
        int[] primeArr = new int[num+1];
        primeArr[0] = 1;
        primeArr[1] = 1;
        int cnt = 0;
        for(int i=2; i<=num; i++){
            if(primeArr[i]!=1){
                cnt++;
                System.out.println(i);
                for(int j=i; j<=num; j+=i){
                    primeArr[j] = 1;
                }
            }
        }
        System.out.println("1~"+num+"까지 소수의 개수: "+cnt);
    }
}

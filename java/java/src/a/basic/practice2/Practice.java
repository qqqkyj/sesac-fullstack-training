package a.basic.practice2;

public class Practice {
    public static void main(String[] args) {
        // 문제 1: 구구단
        // 2단부터 9단까지 구구단을 출력하세요.
        for(int i = 2; i < 10; i++){
            System.out.printf("*****%d단*****%n",i);
            for(int j = 2; j < 10; j++){
                System.out.printf("%d X %d = %d%n",i,j,i*j);
            }
        }

        //문제 2: 별 찍기 패턴 1
        /*
         *
         **
         ***
         ****
         *****
         */
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.printf("*");
            }
            System.out.println();
        }

        // 문제 3: 별 찍기 패턴 2
        /*
         *****
         ****
         ***
         **
         *
         */
        for(int i=5;i>=1;i--){
            for(int j=i;j>0;j--){
                System.out.print("*");
            }
            System.out.println();
        }

        // 문제 4: 별 찍기 패턴 3
        /*
             *
            ***
           *****
          *******
         *********
         */
        for(int i=1; i<=5; i++){
            for(int j=5; j > i; j--){
                System.out.print(" ");
            }
            for(int x=1; x<=2*i-1; x++){
                System.out.print("*");
            }
            System.out.println();
        }

        // 문제 5: 약수 구하기
        int num = 24;
        for(int i = 1; i<=num; i++){
            if(num%i==0)
                System.out.printf("%d ",i);
        }
        System.out.println();

        // 문제 6: 소수 판별
        num = 17;
        boolean flag = true;
        for(int x=2; x<num; x++){
            if(num%x==0){
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "소수입니다." : "소수가 아닙니다.");

        // 문제 7: 소수 판별 최적화
        num = 17;
        flag = true;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0){
                flag = false;
                break;
            }
        }
        System.out.println(flag?"소수입니다.":"소수가 아닙니다.");

        // 번외 문제: 1~num까지의 소수와 소수의 개수
        int[] isPrimeArr = new int[num+1];
        isPrimeArr[0] = 1;
        isPrimeArr[1] = 1;
        int cnt = 0;
        for(int i=2; i<=num; i++){
            if(isPrimeArr[i]!=1){
                cnt++;
                System.out.println(i);
                for(int j=i; j<=num; j+=i){
                    isPrimeArr[j] = 1;
                }
            }
        }
        System.out.println("1~"+num+"까지 소수의 개수: "+cnt);

        // 문제 8: 최대공약수 (GCD)
        int a = 48, b = 18;
        while(b != 0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        System.out.println("최대공약수:" + a);

        // 문제 9: 최소공배수 (LCM)
        a = 12;
        b = 18;
        Practice p = new Practice();
        System.out.println("최소공배수: " + a*b/p.gcd(a,b));

        // 문제 10: 피보나치 수열
        int n = 10;
        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;
        for(int i = 2; i < n; i++){
            array[i] = array[i-1] + array[i-2];
        }
        System.out.printf("%d번째 피보나치 수: %d%n",n,array[n-1]);

        // 문제 11: 팩토리얼
        n = 5;
        long result = 1;
        for(int i=1; i<=n; i++){
            result *= i;
        }
        System.out.println(result);

        // 문제 12: 역순 숫자 출력
        num = 12345;
        String strNum = String.valueOf(num);
        String revStrNum = new StringBuilder(strNum).reverse().toString();
        int revNum = Integer.parseInt(revStrNum);
        System.out.println(revNum);

        // 문제 13: 숫자 자릿수 합
        //방법 1.
        num = 12345;
        strNum = String.valueOf(num);
        String[] arrStrNum = strNum.split("");
        int total = 0;
        for(String s: arrStrNum){
            total +=  Integer.parseInt(s);
        }
        System.out.println(total);

        //방법 2.
        int num2 = 12345;
        result = 0;
        while (num2 != 0){
            result += num2%10;
            num2 = num2/10;
        }
        System.out.println(result);

        // 문제 14: 구구단 특정 단 건너뛰기
        for(int i=2;i<=9;i++){
            if(i == 5) continue;
            System.out.printf("*****%d단*****%n",i);
            for(int j=1;j<=9;j++){
                System.out.printf("%d X %d = %d%n",i,j,i*j);
            }
        }
    }

    public int gcd(int a, int b) {
        while(b != 0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
}

package a.basic;

public class For {
    public static void main(String[] args) {
        // 기본 for문
        for(int i = 0; i < 10 ; i++){
            System.out.println(i);
        }
        System.out.println();

        // 역순
        for(int i = 10; i >=1 ; i--){
            System.out.println(i);
        }
        System.out.println();

        // 2씩 증가
        for(int i = 0; i <10 ; i+=2){
            System.out.println(i);
        }
        System.out.println();

        // 중첩 for문
        // 구구단 2단 ~ 9단
        for(int i=2; i<10; i++){
            System.out.printf("****%d단****%n",i);
            for(int j=1; j<10; j++){
                System.out.printf("%d X %d = %d%n",i,j,i*j);
            }
        }
        System.out.println();

        // while문
        // for: 반복횟수가 명확할 때 (특정 횟수 명확)
        // while: 조건이 만족할 때까지(조건이 중요)
        int i = 0;

        while(i < 10){
            System.out.println(i);
            i++;
        }
        System.out.println();

        // do-while문
        // 최소 1회는 실행
        int j=1;

        do{
            System.out.println(j);
            j++;
        }while (j < 10);
        System.out.println();

        //enhanced for
        // javascript : let numbers = [1,2,3,4,5];
        int[] numbers = {10,11,12,13,14,15};
        // index 직접 접근 가능
        for(i=0; i<numbers.length; i++){
            System.out.println(numbers[i]);
        }
        System.out.println();

        //index 직접 접근 불가
        // javascript : for(let number of numbers){}, numbers.forEach(number=>console.log(num));
        for(int number : numbers){
            System.out.println(number);
        }
        System.out.println();

        int[] nums = {1, 2, 3};
        // index 직접 접근 불가
        for(int num : nums){
            num = num * 3;
        }
        // index 직접 접근 가능
        for(i=0; i<nums.length; i++){
            nums[i] = nums[i] * 3;
        }

        for(int num : nums){
            System.out.println(num);
        }
        System.out.println();

        // break
        for(int z=0; z<10; z++){
            System.out.println(z);
            if(z == 5) break; //for문 중단
        }
        System.out.println();

        //continue
        for(int z=0; z<10; z++){
            if(z % 2 == 0) continue;//조건 만족시 건너뛰기
            System.out.println(z);
        }
        System.out.println();

        // 레이블(Label)
        // 중첩 반복문에서 특정 반복문을 제어할 때 사용
        outer:
        for(int x = 2; x<10; x++){
            if(x>4) break outer;//4단까지 출력 후 for문 종료
            System.out.printf("*****%d단*****%n",x);
            for(int y = 1; y<10; y++){
                System.out.printf("%d X %d = %d%n",x,y,x*y);
            }
        }
    }
}

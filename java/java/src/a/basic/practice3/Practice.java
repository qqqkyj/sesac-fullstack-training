package a.basic.practice3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Practice {
    public static void main(String[] args) {
        // 문제 1: 배열 최댓값/최솟값
        // 배열에서 최댓값과 최솟값을 찾으세요.
        int[] numbers = {45, 23, 78, 12, 89, 34};
        Arrays.sort(numbers);
        System.out.println("최댓값: "+numbers[numbers.length-1]);
        System.out.println("최솟값: "+numbers[0]);
        System.out.println();

        // T. 1
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<numbers.length; i++){
            max  = Math.max(max, numbers[i]);
            min = Math.min(min, numbers[i]);
        }
        System.out.println("최댓값: "+max);
        System.out.println("최솟값: "+min);
        System.out.println();


        // 문제 2: 배열 뒤집기
        // 배열을 역순으로 뒤집으세요.
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("원본: "+ Arrays.toString(arr));
        for(int i=0; i<arr.length/2; i++){
            int tmp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = tmp;
        }
        System.out.println("뒤집기: "+ Arrays.toString(arr));
        System.out.println();

        //T.2-1
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] reverseNumbers = new int[arr2.length];
        for(int i=0; i<arr2.length; i++){
            reverseNumbers[i] = arr2[arr2.length-1-i];
        }
        System.out.println("원본: "+ Arrays.toString(arr2));
        System.out.println("뒤집기: "+ Arrays.toString(reverseNumbers));
        System.out.println();

        //T.2-2
        int left = 0;
        int right = arr2.length-1;
        while(left<right){
            int tmp = arr2[left];
            arr2[left] = arr2[right];
            arr2[right] = tmp;
            left++;
            right--;
        }
        System.out.println("원본 뒤집기: "+ Arrays.toString(arr2));
        System.out.println();

        // 문제 3: 특정 값 찾기
        // 배열에서 특정 값이 있는 인덱스를 찾으세요. 없으면 -1을 반환하세요.
        // 3-1.풀이
        int[] arr3 = {10, 20, 30, 40, 50};
        int target = 30;
        Arrays.sort(arr3);
        int answer = Arrays.binarySearch(arr3, target) >=0 ? Arrays.binarySearch(arr3, target) : -1;
        System.out.println(answer);
        System.out.println();

        // 3-2.풀이
        int index = -1;
        for(int i=0; i<arr3.length; i++){
            if(arr3[i] == target){
                index = i;
                break;
            }
        }
        System.out.println(index);
        System.out.println();


        // 문제 4: 배열 요소 개수 세기
        // 배열에서 각 숫자가 몇 번 나오는지 세세요.
        // 4-1. 풀이
        int[] arr4 = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 10};
        Arrays.sort(arr4);
        int cnt = 0;
        int target4 = arr4[0];
        for(int i=0; i<arr4.length; i++){
            if(arr4[i] == target4){
                cnt++;
            }
            else{
                System.out.println(target4+": "+cnt+"개");
                target4 = arr4[i];
                cnt=1;
            }
        }
        System.out.println(target4+": "+cnt+"개");
        System.out.println();
        
        // 4-2. 풀이
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr4.length; i++){
            map.put(arr4[i],map.getOrDefault(arr4[i],0)+1);
        }
        for(Integer key: map.keySet()){
            System.out.println(key+": "+map.get(key)+"개");
        }
        System.out.println();

        // T. 4 => 단점: arr4의 요소 중 큰 수가 있으면 빈 값이 많이 생김
        // 배열의 가장 큰 수
        int maxNum = arr4[0];
        for(int num : arr4){
            maxNum = Math.max(maxNum,num);
        }

        //카운트 배열
        int[] count = new int[maxNum+1];

        //개수 세기
        for(int num: arr4){
            count[num]++;
        }
        System.out.println(Arrays.toString(count));
        System.out.println();

        // 문제 5: 2차원 배열 합계
        // 2차원 배열의 모든 요소의 합을 구하세요.
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int sum = 0;
        for(int[] arr5: matrix){
            for(int num: arr5){
                sum += num;
            }
        }
        System.out.println("합계: "+sum);
        System.out.println();

        // 문제 6: 배열에서 두 번째로 큰 수
        // 배열에서 두 번째로 큰 수를 찾으세요.
        int[] arr6 = {45, 23, 78, 12, 89, 34};
        Arrays.sort(arr6);
        System.out.println("두 번째로 큰 수: "+ arr6[arr6.length-2]);
        System.out.println();

        //T.6
        int maxNum6  = arr6[0];
        int secondMax = arr6[0];
        for(int i=1; i<arr6.length; i++){
            if(arr6[i] > maxNum6){
                secondMax = maxNum6; //가장 큰 수를 secondMax로 토스
                maxNum6 = arr6[i]; //가장 큰 수로 교체
            }else if(arr6[i] > secondMax && arr6[i] != maxNum6){
                secondMax = arr6[i];
            }
        }
        System.out.println("두 번째로 큰 수: "+ secondMax);
        System.out.println();
    }
}

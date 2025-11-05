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
            }
        }
        System.out.println(index);
        System.out.println();


        // 문제 4: 배열 요소 개수 세기
        // 배열에서 각 숫자가 몇 번 나오는지 세세요.
        // 4-1. 풀이
        int[] arr4 = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
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
    }
}

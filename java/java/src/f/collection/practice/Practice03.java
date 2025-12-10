package f.collection.practice;

import java.util.*;

public class Practice03 {
    public static void main(String[] args) {
        // 테스트 1
        ArrayList<Integer> list1 = new ArrayList<>(
                Arrays.asList(1, 4, 2, 10, 23, 3, 1, 0, 20)
        );
        System.out.println("입력: " + list1 + ", k=4");
        System.out.println("최대 합: " + maxSubArraySum(list1, 4));

        // 테스트 2
        ArrayList<Integer> list2 = new ArrayList<>(
                Arrays.asList(2, 1, 5, 1, 3, 2)
        );
        System.out.println("\n입력: " + list2 + ", k=3");
        System.out.println("최대 합: " + maxSubArraySum(list2, 3));

        // 테스트 3
        ArrayList<Integer> list3 = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5)
        );
        System.out.println("\n입력: " + list3 + ", k=2");
        System.out.println("최대 합: " + maxSubArraySum(list3, 2));

        // 테스트 4
        ArrayList<Integer> list4 = new ArrayList<>(
                Arrays.asList(5, 5, 5, 5)
        );
        System.out.println("\n입력: " + list4 + ", k=3");
        System.out.println("최대 합: " + maxSubArraySum(list4, 3));
    }

    public static int maxSubArraySum(ArrayList<Integer> list, int k) {
        // 여기에 코드 작성 (Sliding Window)
        int left = 0;
        int right = k-1;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=left; i<=right; i++){
            sum += list.get(i);
        }
        max = Math.max(sum, max);

        while (right < list.size()-1) {
            sum -= list.get(left++);
            sum+= list.get(++right);
            max = Math.max(sum, max);
        }

        return max;
    }

    // T
    public static int maxSubArraySum2(ArrayList<Integer> list, int k) {
        if(list == null || list.isEmpty() || list.size() < k){
            return -1;
        }

        int windowSum = 0;
        for(int i=0; i<k; i++){windowSum+=list.get(i);}

        int maxSum = windowSum;
        for(int i=k; i<list.size(); i++){
            windowSum = windowSum - list.get(i-k) + list.get(i);
            maxSum = Math.max(windowSum, maxSum);
        }

        return maxSum;
    }
}

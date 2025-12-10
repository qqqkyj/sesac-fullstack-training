package a.basic;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        // 배열 선언, 크기 지정
        // 값은 0으로 초기화
        int[] numbers = new int[5];

        // 선언 후 값 할당
        numbers[0] = 100;
        numbers[1] = 200;

        System.out.println(numbers.length);
        System.out.println(numbers[0]);
        System.out.println(numbers[4]);

        // 배열 초기화
        // 선언 후 한 칸씩 할당
        int[] arr1 = new int[5];
        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3;

        // 선언과 동시에 초기화
        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        // 생략
        int[] arr3 = {1, 2, 3, 4, 5};

        String[] names = {"kim", "lee", "park"};
        System.out.println(names.length);

        int[] scores = {80, 40, 80, 90, 100};
        // 인덱스 접근
        for(int i=0; i < scores.length; i++){
            System.out.println(scores[i]);
        }
        // 요소 반복
        for(int score: scores){
            System.out.println(score);
        }

        // 다차원 배열
        // int[][] matrix = new int[5][5];
        int[][] matrix = {
                {1, 2, 3}, // i = 0
                {4, 5, 6}, // i = 1
                {7, 8, 9}  // i = 2
        };

//        System.out.println(matrix[0][0]); // 1
//        System.out.println(matrix[0][1]); // 2
//        System.out.println(matrix[0][2]); // 3

        // 인덱스로 접근
        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[i].length; j++){
                System.out.println(matrix[i][j]);
            }
        }

        int[][] jagged = {
                {1},          //row[0]
                {2, 3},       // row[1]
                {4, 5, 6},    // row[2]
                {7, 8, 9, 10} // row[3]
        };

        // 향상된 for문
        for(int[] row: jagged){
            for(int item: row){
                System.out.println(item);
            }
        }

        // Arrays 유틸리티 클래스
        int[] nums = {5, 2, 1, 7, 8};

        // 1. toString() - 배열을 문자열로
        System.out.println(nums); // [I@b4c966a : nums의 주소값
        System.out.println(Arrays.toString(nums)); // [5, 2, 1, 7, 8]

        // 2. sort() - 정렬
        Arrays.sort(nums); // 정렬
        System.out.println(Arrays.toString(nums)); // [1, 2, 5, 7, 8]

        // 3. binarySearch() - 이진 탐색(정렬된 배열에서)
        int idx = Arrays.binarySearch(nums, 7); // 탐색전 반드시 sort할 것
        System.out.println(idx);

        // 4. fill() - 배열 채우기
        int[] filled = new int[10];
        Arrays.fill(filled, 99);// filled 배열에 99로 채우기
        System.out.println(Arrays.toString(filled));//

        // 5. copyOf() - 배열 복사(깊은 복사)
        int[] origin = {1, 2, 3, 4, 5};
        int[] copied = Arrays.copyOf(origin, origin.length); // [99, 99, 99, 99, 99, 99, 99, 99, 99, 99]
        System.out.println(Arrays.toString(copied));// [1, 2, 3, 4, 5]

        // 얕은 복사(참조만 복사) - 위험!
        int[] copied2 = origin;// origin의 값 복사가 아닌 주소를 복사
        System.out.println(Arrays.toString(copied2));// [1, 2, 3, 4, 5]
        System.out.println();
        origin[0] = 100;
        System.out.println(Arrays.toString(origin));// [100, 2, 3, 4, 5]
        System.out.println(Arrays.toString(copied));// [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(copied2));// [100, 2, 3, 4, 5]
        System.out.println(origin.equals(copied)); // false
        System.out.println(origin.equals(copied2)); // true

        // 6. copyOfRange() - 범위 복사
        int[] ranged = Arrays.copyOfRange(origin, 1, 3);
        System.out.println(Arrays.toString(ranged));

        // 7. equals() - 배열 비교
        int[] arrA = {1, 2, 3};
        int[] arrB = {1, 2, 3};
        System.out.println(arrA == arrB);// false(주소값이 다름)
        System.out.println(Arrays.equals(arrA, arrB));// true(값이 같음)

        // 8. deepToString() - 다차원 배열 출력
        int[][] mat = {{1, 2}, {3, 4}};
        System.out.println(Arrays.toString(mat));// 주소 : [[I@4e50df2e, [I@1d81eb93]
        System.out.println(Arrays.deepToString(mat));// 값 : [[1, 2], [3, 4]]

        // 가변 길이 배열의 필요성 - ArrayList(컬렉션 파트 참고)
        //origin[99] = 100; // ArrayIndexOutOfBoundsException발생
    }
}

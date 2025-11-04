package a.basic;

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

    }
}

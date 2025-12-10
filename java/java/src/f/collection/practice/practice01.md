## 문제 1: 두 번째로 큰 수 찾기

정수 리스트에서 두 번째로 큰 수를 찾는 프로그램을 작성하세요.

**입력:**
- 정수가 담긴 ArrayList

**출력:**
- 두 번째로 큰 수 (존재하지 않으면 -1)

**제약 조건:**
- 리스트의 크기는 0 이상
- 중복된 값이 있을 수 있음
- 모든 숫자는 양수 (positive integers)
- Collections.sort() 사용 금지

**예제:**

```java
입력: [5, 3, 9, 1, 7]
출력: 7

입력: [10, 10, 10]
출력: -1 (모두 같은 값)

입력: [5, 5, 3, 3, 1]
출력: 3

입력: [5]
출력: -1 (요소가 하나)
```

**테스트 코드:**

```java
import java.util.*;

public class Practice01 {
    public static void main(String[] args) {
        // 테스트 1
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(5, 3, 9, 1, 7));
        System.out.println("입력: " + list1);
        System.out.println("출력: " + findSecondLargest(list1));

        // 테스트 2
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(10, 10, 10));
        System.out.println("\n입력: " + list2);
        System.out.println("출력: " + findSecondLargest(list2));

        // 테스트 3
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(5, 5, 3, 3, 1));
        System.out.println("\n입력: " + list3);
        System.out.println("출력: " + findSecondLargest(list3));

        // 테스트 4
        ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(5));
        System.out.println("\n입력: " + list4);
        System.out.println("출력: " + findSecondLargest(list4));
    }

    public static int findSecondLargest(ArrayList<Integer> list) {
        // 여기에 코드 작성
        return -1;
    }
}
```


---

## 문제 2: 배열 회전 후 특정 값 찾기

리스트를 왼쪽으로 k번 회전한 후, 특정 값의 인덱스를 찾는 프로그램을 작성하세요.

**입력:**
- 정수가 담긴 ArrayList
- 회전 횟수 k
- 찾을 값 target

**출력:**
- 회전 후 target의 인덱스 (없으면 -1)

**예제:**

```java
입력: [1, 2, 3, 4, 5], k=2, target=1
회전 과정:
  원본: [1, 2, 3, 4, 5]
  1회전: [2, 3, 4, 5, 1]
  2회전: [3, 4, 5, 1, 2]
출력: 3 (1의 인덱스)

입력: [10, 20, 30, 40], k=1, target=40
회전 과정:
  원본: [10, 20, 30, 40]
  1회전: [20, 30, 40, 10]
출력: 2 (40의 인덱스)

입력: [1, 2, 3], k=5, target=2
회전 과정:
  5 % 3 = 2번 회전
  원본: [1, 2, 3]
  1회전: [2, 3, 1]
  2회전: [3, 1, 2]
출력: 2 (2의 인덱스)
```

**테스트 코드:**

```java
import java.util.*;

public class Practice02 {
    public static void main(String[] args) {
        // 테스트 1
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("원본: " + list1);
        int result1 = findAfterRotation(list1, 2, 1);
        System.out.println("2번 회전 후: " + list1);
        System.out.println("1의 인덱스: " + result1);

        // 테스트 2
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        System.out.println("\n원본: " + list2);
        int result2 = findAfterRotation(list2, 1, 40);
        System.out.println("1번 회전 후: " + list2);
        System.out.println("40의 인덱스: " + result2);

        // 테스트 3
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println("\n원본: " + list3);
        int result3 = findAfterRotation(list3, 5, 2);
        System.out.println("5번 회전 후 (5%3=2): " + list3);
        System.out.println("2의 인덱스: " + result3);
    }

    public static int findAfterRotation(ArrayList<Integer> list, int k, int target) {
        // 여기에 코드 작성
        return -1;
    }
}
```

**힌트:**
- k가 리스트 크기보다 클 수 있으므로 k % size 활용
- 왼쪽 회전: 첫 번째 요소를 마지막으로 이동

---

## 문제 3: 특정 길이 부분 배열의 최대 합

정수 리스트에서 길이가 k인 연속된 부분 배열의 합 중 최댓값을 찾으세요.

**입력:**
- 정수가 담긴 ArrayList
- 부분 배열의 길이 k

**출력:**
- 길이 k인 부분 배열의 최대 합

**예제:**

```java
입력: [1, 4, 2, 10, 23, 3, 1, 0, 20], k=4
부분 배열들:
  [1, 4, 2, 10] = 17
  [4, 2, 10, 23] = 39
  [2, 10, 23, 3] = 38
  [10, 23, 3, 1] = 37
  [23, 3, 1, 0] = 27
  [3, 1, 0, 20] = 24
출력: 39

입력: [2, 1, 5, 1, 3, 2], k=3
부분 배열들:
  [2, 1, 5] = 8
  [1, 5, 1] = 7
  [5, 1, 3] = 9
  [1, 3, 2] = 6
출력: 9

입력: [1, 2, 3, 4, 5], k=2
부분 배열들:
  [1, 2] = 3
  [2, 3] = 5
  [3, 4] = 7
  [4, 5] = 9
출력: 9

입력: [5, 5, 5, 5], k=3
부분 배열들:
  [5, 5, 5] = 15
  [5, 5, 5] = 15
출력: 15
```

**테스트 코드:**

```java
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
        return 0;
    }
}
```

---

## 문제 4: 숫자별 빈도수 세기

리스트에 있는 각 숫자가 몇 번 나타나는지 세어 [값, 개수] 형태로 반환하세요.

**입력:**
- 정수가 담긴 ArrayList

**출력:**
- ArrayList<ArrayList<Integer>>
    - 각 내부 리스트: [값, 개수]
    - 결과는 처음 나타난 순서대로 저장

**예제:**

```java
입력: [1, 3, 2, 1, 3, 1]
출력: [[1, 3], [3, 2], [2, 1]]

입력: [5, 5, 5, 5, 5]
출력: [[5, 5]]

입력: [1, 2, 3, 4, 5]
출력: [[1, 1], [2, 1], [3, 1], [4, 1], [5, 1]]

입력: []
출력: []
```

**테스트 코드:**

```java
import java.util.*;

public class Practice04 {
    public static void main(String[] args) {
        // 테스트 1
        ArrayList<Integer> list1 = new ArrayList<>(
            Arrays.asList(1, 3, 2, 1, 3, 1)
        );
        System.out.println("입력: " + list1);
        System.out.println("출력: " + countFrequency(list1));

        // 테스트 2
        ArrayList<Integer> list2 = new ArrayList<>(
            Arrays.asList(5, 5, 5, 5, 5)
        );
        System.out.println("\n입력: " + list2);
        System.out.println("출력: " + countFrequency(list2));

        // 테스트 3
        ArrayList<Integer> list3 = new ArrayList<>(
            Arrays.asList(1, 2, 3, 4, 5)
        );
        System.out.println("\n입력: " + list3);
        System.out.println("출력: " + countFrequency(list3));

        // 테스트 4
        ArrayList<Integer> list4 = new ArrayList<>();
        System.out.println("\n입력: " + list4);
        System.out.println("출력: " + countFrequency(list4));
    }

    public static ArrayList<ArrayList<Integer>> countFrequency(ArrayList<Integer> list) {
        // 여기에 코드 작성
        return new ArrayList<>();
    }
}
```


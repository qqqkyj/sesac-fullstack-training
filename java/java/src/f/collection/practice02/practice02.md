### 문제 1: 두 배열의 공통 원소 찾기 

두 개의 정수 배열이 주어질 때, 두 배열에 모두 존재하는 공통 원소들을 찾아 반환하세요.

**요구사항**:
- 메서드명: `findCommonElements`
- 파라미터: `int[] arr1`, `int[] arr2`
- 반환 타입: `Set<Integer>`
- 중복 없이 반환
- 순서는 상관없음

**제약 조건**:
- 배열의 크기: 0 이상
- 배열에 중복된 값이 있을 수 있음
- 공통 원소가 없으면 빈 Set 반환

**예시**:

| 입력 arr1 | 입력 arr2 | 출력 |
|----------|----------|------|
| [1, 2, 3, 4, 5] | [3, 4, 5, 6, 7] | [3, 4, 5] |
| [1, 1, 2, 2, 3] | [2, 2, 3, 3, 4] | [2, 3] |
| [1, 2, 3] | [4, 5, 6] | [] |
| [] | [1, 2, 3] | [] |

**힌트**:
- HashSet의 집합 연산(교집합) 활용
- `retainAll()` 메서드 사용

**테스트 코드**:

```java
public class Practice01 {
    public static void main(String[] args) {
        // 테스트 1
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};
        Set<Integer> result1 = findCommonElements(arr1, arr2);
        System.out.println("테스트 1: " + result1);  // [3, 4, 5]

        // 테스트 2
        int[] arr3 = {1, 1, 2, 2, 3};
        int[] arr4 = {2, 2, 3, 3, 4};
        Set<Integer> result2 = findCommonElements(arr3, arr4);
        System.out.println("테스트 2: " + result2);  // [2, 3]

        // 테스트 3: 공통 원소 없음
        int[] arr5 = {1, 2, 3};
        int[] arr6 = {4, 5, 6};
        Set<Integer> result3 = findCommonElements(arr5, arr6);
        System.out.println("테스트 3: " + result3);  // []

        // 테스트 4: 빈 배열
        int[] arr7 = {};
        int[] arr8 = {1, 2, 3};
        Set<Integer> result4 = findCommonElements(arr7, arr8);
        System.out.println("테스트 4: " + result4);  // []
    }

    // 여기에 메서드 구현
    public static Set<Integer> findCommonElements(int[] arr1, int[] arr2) {
        // 구현 필요
        return null;
    }
}
```

### 문제 2: 단어 빈도수 세기 

문자열 배열이 주어질 때, 각 단어가 몇 번 등장하는지 세어서 Map으로 반환하세요.

**요구사항**:
- 메서드명: `countWordFrequency`
- 파라미터: `String[] words`
- 반환 타입: `Map<String, Integer>`
- 키: 단어, 값: 등장 횟수
- 대소문자 구분

**제약 조건**:
- 배열 크기: 0 이상
- 빈 배열이면 빈 Map 반환
- null 값은 없다고 가정

**예시**:

| 입력 | 출력 |
|------|------|
| ["apple", "banana", "apple", "cherry", "banana", "apple"] | {apple=3, banana=2, cherry=1} |
| ["hello", "world"] | {hello=1, world=1} |
| [] | {} |
| ["test", "test", "test"] | {test=3} |

**힌트**:
- HashMap 사용
- `getOrDefault()` 또는 `putIfAbsent()` 활용

**테스트 코드**:

```java
public class Practice03 {
    public static void main(String[] args) {
        // 테스트 1
        String[] words1 = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        Map<String, Integer> result1 = countWordFrequency(words1);
        System.out.println("테스트 1: " + result1);
        // {apple=3, banana=2, cherry=1}

        // 테스트 2
        String[] words2 = {"hello", "world"};
        Map<String, Integer> result2 = countWordFrequency(words2);
        System.out.println("테스트 2: " + result2);
        // {hello=1, world=1}

        // 테스트 3: 빈 배열
        String[] words3 = {};
        Map<String, Integer> result3 = countWordFrequency(words3);
        System.out.println("테스트 3: " + result3);
        // {}

        // 테스트 4: 모두 같은 단어
        String[] words4 = {"test", "test", "test"};
        Map<String, Integer> result4 = countWordFrequency(words4);
        System.out.println("테스트 4: " + result4);
        // {test=3}
    }

    // 여기에 메서드 구현
    public static Map<String, Integer> countWordFrequency(String[] words) {
        // 구현 필요
        return null;
    }
}
```


### 문제 3: 문자 위치 인덱스 찾기 

문자열이 주어질 때, 각 문자가 등장하는 모든 위치(인덱스)를 Map으로 반환하세요.

**요구사항**:
- 메서드명: `findCharacterPositions`
- 파라미터: `String str`
- 반환 타입: `Map<Character, List<Integer>>`
- 키: 문자, 값: 등장 위치 리스트
- 대소문자 구분

**제약 조건**:
- 문자열 길이: 0 이상
- 빈 문자열이면 빈 Map 반환
- 인덱스는 0부터 시작

**예시**:

| 입력 | 출력 |
|------|------|
| "hello" | {h=[0], e=[1], l=[2, 3], o=[4]} |
| "programming" | {p=[0], r=[1, 4], o=[2], g=[3, 6, 7], a=[5], m=[8, 9], i=[10], n=[11]} |
| "aaa" | {a=[0, 1, 2]} |
| "" | {} |

**힌트**:
- HashMap과 ArrayList 조합
- `putIfAbsent()`로 리스트 초기화

**테스트 코드**:

```java
import java.util.*;

public class Practice05 {
    public static void main(String[] args) {
        // 테스트 1
        String str1 = "hello";
        Map<Character, List<Integer>> result1 = findCharacterPositions(str1);
        System.out.println("테스트 1: " + result1);
        // {h=[0], e=[1], l=[2, 3], o=[4]}

        // 테스트 2
        String str2 = "programming";
        Map<Character, List<Integer>> result2 = findCharacterPositions(str2);
        System.out.println("테스트 2: " + result2);

        // 테스트 3: 모두 같은 문자
        String str3 = "aaa";
        Map<Character, List<Integer>> result3 = findCharacterPositions(str3);
        System.out.println("테스트 3: " + result3);
        // {a=[0, 1, 2]}

        // 테스트 4: 빈 문자열
        String str4 = "";
        Map<Character, List<Integer>> result4 = findCharacterPositions(str4);
        System.out.println("테스트 4: " + result4);
        // {}
    }

    // 여기에 메서드 구현
    public static Map<Character, List<Integer>> findCharacterPositions(String str) {
        // 구현 필요
        return null;
    }
}
```



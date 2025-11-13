package g.javaclass;

import java.util.*;

public class MathRandomMain {
    public static void main(String[] args) {
        //절대값
        System.out.println(Math.abs(-10));
        //최대, 최소
        System.out.println(Math.min(10, 20));
        System.out.println(Math.max(10, 20));
        //올림
        double num = 3.7;
        System.out.println(Math.ceil(num));//4.0
        //내림
        System.out.println(Math.floor(num));//3.0
        //반올림
        System.out.println(Math.round(num));//4
        //제곱
        System.out.println(Math.pow(2,3));//8.0
        System.out.println(Math.sqrt(9));//3.0
        //상수
        System.out.println(Math.PI);
        System.out.println(Math.E);
        //Random
        Random random = new Random();
        System.out.println(random.nextInt(100));//0~99
        //특정 범위
        int min = 10;
        int max = 20;
        System.out.println(random.nextInt(max - min)+min);//10~19
        System.out.println(random.nextInt(10, 20));// Java 17+

        //배열 요소 무작위 선택
        String[] colors = {"빨강", "파랑", "노랑", "초록"};
        // 무작위 인덱스
        int index = random.nextInt(colors.length);
        String selected = colors[index];
        System.out.println("선택된 색: " + selected);

        // 배열 섞기(Shuffle)
        Integer[] numbers = {1, 2, 3, 4, 5};
        // List로 변환 후 섞기
        List<Integer> list = Arrays.asList(numbers);
        Collections.shuffle(list);
        System.out.println(list);  // [3, 1, 5, 2, 4] (무작위)

        // 확률 기반 이벤트
        // 30% 확률로 성공
        double successRate = 0.3;
        boolean success = random.nextDouble() < successRate;

        if (success) {
            System.out.println("성공!");
        } else {
            System.out.println("실패!");
        }

        // 주사위 (1 ~ 6)
        int dice = random.nextInt(6) + 1;//(0~5) + 1
        System.out.println("주사위: " + dice);

        //중복 없는 난수
        Set<Integer> lotte = new HashSet<>();
        // 1 ~ 45 중에서 중복 없이 6개 선택 (로또)
        while (lotte.size() < 6) {
            int number = random.nextInt(45) + 1;//(0~44)+1
            lotte.add(number);
        }

        List<Integer> lotteList = new ArrayList<>(lotte);
        Collections.sort(lotteList);
        System.out.println("로또 번호: " + lotteList);
    }
}

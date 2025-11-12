package f.collection.practice;

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
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if (answer.isEmpty()) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.addAll(Arrays.asList(list.get(i), 1));
                answer.add(temp);
            } else {
                int key, value;
                boolean flag = false;
                for (int j = 0; j < answer.size(); j++) {
                    key = answer.get(j).get(0);
                    value = answer.get(j).get(1);
                    if (key == list.get(i)) {
                        flag = true;
                        answer.get(j).set(1, value + 1);//value값 +1
                        break;
                    }
                }
                if (!flag) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.addAll(Arrays.asList(list.get(i), 1));
                    answer.add(temp);
                }
            }
        }

        return answer;
    }
}

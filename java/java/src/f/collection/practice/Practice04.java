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
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            boolean flag = false; //key값 일치 여부
            for (int j = 0; j < answer.size(); j++) {
                int key = answer.get(j).get(0);
                int value = answer.get(j).get(1);
                if (key == list.get(i)) {
                    flag = true;
                    answer.get(j).set(1, value + 1);//value+1
                    break;
                }
            }
            if (!flag) { //일치하는 key가 없다면 생성
                ArrayList<Integer> temp = new ArrayList<>();
                temp.addAll(Arrays.asList(list.get(i), 1));
                answer.add(temp);
            }
        }

        return answer;
    }

    // T
    public static ArrayList<ArrayList<Integer>> countFrequency2(ArrayList<Integer> list) {
        if(list == null || list.isEmpty()){
            return null;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList();
        // list : [1, 3, 2, 1, 3, 1]
        for(int num : list){
            boolean found = false;//result의 존재 여부

            //result에 있으면 +1
            for(ArrayList<Integer> pair : result) {
                if(pair.get(0) == num){
                    found = true;
                    pair.set(1, pair.get(1)+1);
                    break;
                }
            }

            //result에 없으면 리스트에 추가 [n, 1]
            if(!found){
                ArrayList<Integer> newPair = new ArrayList<>();
                newPair.addAll(Arrays.asList(num, 1));
                result.add(newPair);
            }
        }

        return new ArrayList<>();
    }
}

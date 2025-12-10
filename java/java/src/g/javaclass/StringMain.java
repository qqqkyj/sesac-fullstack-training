package g.javaclass;

import java.util.Arrays;

public class StringMain {
    public static void main(String[] args) {
        // 리터럴 방식(권장)
        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println(str1 == str2);//true

//        // 다른 객체(비권장)
//        String str3 = new String("hi");
//        String str4 = new String("hi");
//        System.out.println(str3 == str4);//false

        String str3 = "hello";
        System.out.println(str1.equals(str3));//값 비교 false
        System.out.println(str1.equalsIgnoreCase(str3));//true

        System.out.println(str1.length());//길이
        System.out.println(str1.charAt(2));//2번 index의 character
        System.out.println(str1.indexOf("l"));//"l"의 index값 2
        System.out.println(str1.lastIndexOf("l"));//3
        System.out.println(str1.substring(2, 4));//ll(2이상 4미만)
        System.out.println(str1);
        System.out.println(str1.contains("E"));//false
        System.out.println(str1.startsWith("H"));
        System.out.println(str1.endsWith("l"));
        System.out.println(str1.isEmpty());
        System.out.println(str1.isBlank());//공백만 있어도 true(Java 11+)
        String str4 = " Hello World ";
        System.out.println(str4.trim());//공백제거
        System.out.println(str4.strip());//유니코드 공백 포함 제거(Java 11+)
        System.out.println(str4.replace("Hello","Hi"));
        String csv ="apple, banana, orange";
        System.out.println(Arrays.toString(csv.split(",")));//분할
        System.out.println(String.join(" ", csv.replace(",","")));//결합
        StringBuilder sb = new StringBuilder();
        Arrays.stream(csv.split(",")).forEach(s -> sb.append(s).append(" "));
        System.out.println(sb);
    }
}

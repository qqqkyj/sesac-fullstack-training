package h.exception;
import java.io.*;

public class ErrorException {
    public static void main(String[] args){
//        Error
//        recursiveMethod();

//        Exception
//        ArithmeticException
//        try {
//            int result = 10/0;
//        }
//        catch(Exception e) {
//            System.out.println(e.getMessage());
//        }

//        NullPointerException
//        String str = null;
//        System.out.println(str.length());

//        ArrayIndexOutOfBoundsException
//        int[] arr = {1, 2, 3};
//        System.out.println(arr[99]);

//        NumberFormatException
//        int num = Integer.parseInt("asdf");

//        IllegalArgumentException
//        int age = -10;
//        if(age < 0){
//            throw new IllegalArgumentException("나이는 0보다 작을 수 없습니다.");
//        }

//        tryCatch를 생성하지 않으면 컴파일 오류 발생
//        try {
//            FileReader fr = new FileReader("a.txt");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }

//        try{
//            int result = 1/0;
//        }
//        catch (ArithmeticException e){
//            System.out.println("0으로 나눌 수 없습니다.");
//        }

//        FileReader fr = null;
//        try{
//            fr = new FileReader("data.txt");
//            System.out.println("파일을 불러왔습니다.");
//        }catch (IOException e) {
//            System.out.println("파일이 존재하지 않습니다.");
//        } finally{
//            try {
//                fr.close();
//            } catch (IOException e) {
//                System.out.println("파일을 닫기를 실패했습니다.");
//            }
//        }


        try {
            String input = "123";
            int num = Integer.parseInt(input);
            int result = 100/num;
        }
        catch (NumberFormatException e) {
            // input = "asdf"인 경우
            // For input string: "asdf"
            System.out.println("형변환 불가: " +e.getMessage());
        }
        catch (ArithmeticException e) {
            // input = "0"인 경우
            // / by zero
            System.out.println("계산 오류: "+e.getMessage());
        }
        catch (Exception e) {
            System.out.println("모르는 예외: "+e.getMessage());
        }


    }

//    static void recursiveMethod(){
//        recursiveMethod();//StackOverflowError
//    }

    static void method() throws IOException{
        FileReader fr = new FileReader("text.txt");
    }
}

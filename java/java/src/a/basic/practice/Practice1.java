package a.basic.practice;

public class Practice1 {

    public static void main(String[] args) {
        // 문제 1: 홀짝 판별
        // 정수를 입력받아 홀수인지 짝수인지 판별하세요.
        int num = 17;
        String isEven = num % 2 == 0 ? "짝수" : "홀수";
        System.out.printf("%d는 %s입니다.%n", num, isEven);

        // 문제 2: 학점 계산
        // 점수를 입력받아 학점을 출력하세요.
        /*
         **학점 기준:**
        - 90점 이상: A
        - 80점 이상: B
        - 70점 이상: C
        - 60점 이상: D
        - 60점 미만: F
         */
        int score = 85;
        String grade = score >= 90 ? "A" : score >= 80 ? "B" : score >= 70 ? "C" : score >= 60 ? "D" : "F";
        System.out.println("학점:"+grade);

        // 문제 3: 윤년 판별
        /*
        **윤년 조건:**
        - 4로 나누어떨어지면서 100으로 나누어떨어지지 않거나
        - 400으로 나누어떨어지는 해
         */
        int year = 2024;
        System.out.println(year+"년은 윤년"+(((year%4==0 && year%100!=0) || year%400==0) ? "입니다.":"이 아닙니다."));

        // 문제 4: 삼각형 유효성 검사
        // 세 변의 길이를 입력받아 삼각형을 만들 수 있는지 검사하세요.
        /*
        **삼각형 조건:**
        - 세 변의 길이가 모두 양수
        - 가장 긴 변 < 나머지 두 변의 합
         */
        int a = 3, b = 4, c = 5;
        boolean flag = (a>0 && b>0 && c>0) && ((c < a+b) && (b < a+c) && (c < a+b));
        System.out.println("삼각형을 만들 수 "+(flag?"있습니다.":"없습니다."));

        // 문제 5: 계절 판별
        // 월을 입력받아 계절을 출력하세요. switch 문을 사용하세요.
        int month = 7;
        String session = switch (month){
            case 3,4,5 -> "봄";
            case 6,7,8 -> "여름";
            case 9,10,11 -> "가을";
            case 12,1,2 -> "겨울";
            default -> "";
        };
        System.out.printf(session.isEmpty()?"존재하지 않는 월입니다.%n":"%d월은 %s입니다.%n",month,session);

        // 문제 6: 요일 판별
        // 요일 번호를 입력받아 평일/주말을 구분하세요. 향상된 switch 문을 사용하세요.
        /*
        **요일 번호:**
        - 1: 월요일
        - 2: 화요일
        - ...
        - 7: 일요일
         */
        int day = 6;
        String dayName = switch (day){
            case 1 -> "월";
            case 2 -> "화";
            case 3 -> "수";
            case 4 -> "목";
            case 5 -> "금";
            case 6 -> "토";
            case 7 -> "일";
            default -> "";
        };
        System.out.printf(dayName.isEmpty()?"존재하지 않는 요일입니다.%n":
                "%d: %s요일은 %s입니다.%n", day, dayName ,day == 6 || day == 7?"주말":"평일");

        // 문제 7: BMI 계산 및 판정
        // 키(cm)와 몸무게(kg)를 입력받아 BMI를 계산하고 판정하세요.
        //BMI 계산: 몸무게(kg) / (키(m) × 키(m))
        /*
        판정 기준:
        18.5 미만: 저체중
        18.5 이상 23 미만: 정상
        23 이상 25 미만: 과체중
        25 이상: 비만
         */
        double height = 175.0; //cm
        double weight = 70.0; //kg
        double bmi = weight / (height/100 * height/100);
        String result = bmi >= 25 ? "비만" : bmi>= 23 ? "과체중" : bmi >=18.5 ? "정상 체중" : "저체중";
        System.out.printf("BMI: %.2f%n%s입니다.%n",bmi,result);

        // 문제 8: 최댓값 구하기
        // 세 개의 정수 중 최댓값을 구하세요. if 문을 사용하세요.
        a = 10;
        b = 25;
        c = 17;
        if(a > b && a > c)
        {
            System.out.println("최댓값: "+a);
        }
        else if(b > a && b > c)
        {
            System.out.println("최댓값: "+b);
        }
        else{
            System.out.println("최댓값: "+c);
        }

        // 문제 9: 시험 합격 여부
        // 세 과목의 점수를 입력받아 합격 여부를 판단하세요.
        /*
        합격 조건:
        평균이 60점 이상
        모든 과목이 40점 이상
         */
        int math = 70, english = 80, science = 45;
        if(math >= 40 && english >= 40 && science >= 40)
        {
            int avg = (math + english + science) / 3;
            System.out.println(avg >= 60 ? "합격" : "불합격");
        }
        else
        {
            System.out.println("불합격(과목 낙제)");
        }

        // 문제 10: 할인율 계산
        // 구매 금액에 따라 할인율을 적용하세요.
        /*
        할인 기준:
        10만원 이상: 10% 할인
        5만원 이상: 5% 할인
        5만원 미만: 할인 없음
        추가: 회원이면 추가 5% 할인
         */
        int price = 120000;
        boolean isMember = true;
        int discount = price >= 100000 ? 10 : price >= 50000 ? 5 : 0;
        double total = isMember? total = price*(100 - discount)/100*0.95 : price*(100 - discount)/100;
        System.out.println("원가: "+price+"원");
        System.out.println("할인율: "+discount+"%");
        System.out.println("최종 금액: "+total+"원");
    }
}

package c.oop2.practice;
// 도서 관리 시스템
// 메서드와 오버로딩을 활용한 간단한 도서 관리 시스템을 만들어봅시다.
public class LibraryMain {
    public static void main(String[] args) {
        System.out.println("=== 도서 관리 시스템 ===\n");

        // 도서관 생성 (최대 10권)
        Library library = new Library(10);

        // 책 추가 (다양한 방식으로)
        library.addBook("홍길동전", "허균", 15000);
        library.addBook("1984", "조지 오웰", 18000);
        library.addBook("백년의 고독", "가브리엘 가르시아 마르케스", 22000);

        System.out.println("책 3권이 추가되었습니다.\n");

        // 전체 도서 목록
        System.out.println("=== 전체 도서 목록 ===");
        library.displayAllBooks();
        System.out.println();

        // 제목으로 검색
        System.out.println("=== 검색 결과 (제목: 년) ===");
        library.searchByTitle("년");
        System.out.println();

        // 저자로 검색
        System.out.println("=== 검색 결과 (저자: 오웰) ===");
        library.searchByAuthor("오웰");
        System.out.println();

        // 통계
        System.out.println("=== 통계 ===");
        System.out.println("총 도서 수: " + library.getBookCount() + "권");
        System.out.println("전체 가격: " + library.getTotalPrice() + "원");
        System.out.println("평균 가격: " + library.getAveragePrice() + "원");
        System.out.println();

        // 할인 적용
        System.out.println("=== 10% 할인 적용 ===");
        library.applyDiscountToAll(10);
        library.displayAllBooks();
    }
}

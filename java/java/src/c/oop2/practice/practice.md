# 도서 관리 시스템 

메서드와 오버로딩을 활용한 간단한 도서 관리 시스템을 만들어봅시다.

## 요구사항

### Book 클래스

**필드:**
- title (String)
- author (String)
- price (int)
- isbn (String)

**생성자:**
- 제목, 저자만 받는 생성자 (가격 0, ISBN null)
- 제목, 저자, 가격을 받는 생성자 (ISBN null)
- 모든 필드를 받는 생성자

**메서드:**
- displayInfo(): 책 정보 출력
- displayInfo(boolean detailed): 상세 정보 여부에 따라 다르게 출력
- applyDiscount(int percent): 할인율 적용
- applyDiscount(int amount, boolean isPercent): 할인 금액/율 적용

### Library 클래스

**필드:**
- books (Book 배열)
- bookCount (int)

**메서드:**
- addBook(Book book): 책 추가
- addBook(String title, String author): 책 추가 (오버로딩)
- addBook(String title, String author, int price): 책 추가 (오버로딩)
- searchByTitle(String title): 제목으로 검색
- searchByAuthor(String author): 저자로 검색
- displayAllBooks(): 모든 책 출력
- getTotalPrice(): 전체 책 가격 합계
- getAveragePrice(): 평균 가격

## 예시 실행

```
=== 도서 관리 시스템 ===

책 추가: 홍길동전
책 추가: 1984
책 추가: 백년의 고독

=== 전체 도서 목록 ===
1. 홍길동전 - 저자: 허균, 가격: 15000원
2. 1984 - 저자: 조지 오웰, 가격: 18000원
3. 백년의 고독 - 저자: 가브리엘 가르시아 마르케스, 가격: 22000원

=== 검색 결과 (제목: 년) ===
1. 백년의 고독 - 저자: 가브리엘 가르시아 마르케스, 가격: 22000원

=== 통계 ===
총 도서 수: 3권
전체 가격: 55000원
평균 가격: 18333원

=== 할인 적용 (10%) ===
홍길동전: 15000원 → 13500원
```

## 실습 코드

아래 코드를 복사하여 TODO 부분을 완성하세요.

### LibraryMain.java (테스트 코드 - 수정 금지)

```java
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
```

### Book.java

```java
public class Book {
    // TODO: 필드 선언
    // - title (String): 제목
    // - author (String): 저자
    // - price (int): 가격
    // - isbn (String): ISBN

    // TODO: 생성자 오버로딩 (this()를 사용하여 연결)
    // 1. Book(String title, String author)
    //    - 가격은 0, ISBN은 null로 초기화

    // 2. Book(String title, String author, int price)
    //    - ISBN은 null로 초기화

    // 3. Book(String title, String author, int price, String isbn)
    //    - 모든 필드 초기화

    // TODO: displayInfo() 메서드
    // 출력 형식: "제목 - 저자: 저자명, 가격: 0000원"

    // TODO: displayInfo(boolean detailed) 메서드 오버로딩
    // detailed가 true이고 isbn이 null이 아니면 ISBN도 출력
    // 위의 displayInfo()에서 이 메서드를 호출하도록 구현

    // TODO: applyDiscount(int percent) 메서드
    // percent% 할인 적용 (예: 10 입력 시 10% 할인)

    // TODO: applyDiscount(int amount, boolean isPercent) 메서드 오버로딩
    // isPercent가 true면 퍼센트 할인, false면 정액 할인

    // TODO: getTitle() 메서드
    // 제목 반환

    // TODO: getAuthor() 메서드
    // 저자 반환

    // TODO: getPrice() 메서드
    // 가격 반환
}
```

### Library.java

```java
public class Library {
    // TODO: 필드 선언
    // - books (Book[]): 책 배열
    // - bookCount (int): 현재 책의 개수

    // TODO: 생성자
    // Library(int capacity)
    // - books 배열을 capacity 크기로 생성
    // - bookCount를 0으로 초기화

    // TODO: addBook(Book book) 메서드
    // - books 배열에 book 추가
    // - bookCount 증가
    // - 배열이 가득 차면 "더 이상 책을 추가할 수 없습니다." 출력

    // TODO: addBook(String title, String author) 메서드 오버로딩
    // - Book 객체를 생성하여 addBook(Book) 호출

    // TODO: addBook(String title, String author, int price) 메서드 오버로딩
    // - Book 객체를 생성하여 addBook(Book) 호출

    // TODO: displayAllBooks() 메서드
    // - 모든 책의 정보를 출력 (번호 포함)
    // - 형식: "1. 제목 - 저자: 저자명, 가격: 0000원"

    // TODO: searchByTitle(String keyword) 메서드
    // - 제목에 keyword가 포함된 책을 모두 출력
    // - 대소문자 구분 없이 검색 (toLowerCase() 사용)

    // TODO: searchByAuthor(String keyword) 메서드
    // - 저자명에 keyword가 포함된 책을 모두 출력

    // TODO: getTotalPrice() 메서드
    // - 모든 책 가격의 합계 반환

    // TODO: getAveragePrice() 메서드
    // - 평균 가격 반환
    // - 책이 없으면 0 반환

    // TODO: getBookCount() 메서드
    // - 현재 책의 개수 반환

    // TODO: applyDiscountToAll(int percent) 메서드
    // - 모든 책에 percent% 할인 적용
}
```

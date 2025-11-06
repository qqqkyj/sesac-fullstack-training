package c.oop2.practice;

import java.util.Arrays;

public class Library {
    private Book[] books;
    private int bookCount;

    public Library(int capacity){
        this.bookCount = 0;
        this.books = new Book[capacity];
    }

    public void addBook(Book book){
        if(bookCount >= books.length){
            System.out.println("더 이상 책을 추가할 수 없습니다.");
        }else{
            books[bookCount] = book;
            bookCount++;
        }
    }

    public void addBook(String title, String author){
        addBook(new Book(title, author));
    }

    public void addBook(String title, String author, int price){
        addBook(new Book(title, author, price));
    }

    public void searchByTitle(String keyword){
        for(int i=0; i<bookCount; i++){
            if(books[i].getTitle().toLowerCase().contains(keyword.toLowerCase()))
                books[i].displayInfo();
        }
    }

    public void searchByAuthor(String keyword){
        for(int i=0; i<bookCount; i++){
            if(books[i].getAuthor().toLowerCase().contains(keyword.toLowerCase()))
                books[i].displayInfo();
        }
    }

    public void displayAllBooks(){
        for(int i=0; i<bookCount; i++){
            books[i].displayInfo();
        }
    }

    public int getTotalPrice(){
        int total = 0;
        for(int i=0; i<bookCount; i++){
            total+=books[i].getPrice();
        }
        return total;
    }

    public int getAveragePrice(){
        if(this.bookCount == 0){return 0;}
        else return getTotalPrice()/this.bookCount;
    }

    public int getBookCount(){
        return this.bookCount;
    }

    public void applyDiscountToAll(int percent){
        for(int i=0; i<bookCount; i++){
            books[i].applyDiscount(percent);
        }
    }
}

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
        if(this.bookCount == this.books.length){
            System.out.println("더 이상 책을 추가할 수 없습니다.");
        }else{
            this.books[this.bookCount++] = book;
        }
    }

    public void addBook(String title, String author){
        Book book = new Book(title, author);
        addBook(book);
    }

    public void addBook(String title, String author, int price){
        Book book = new Book(title, author, price);
        addBook(book);
    }

    public void searchByTitle(String title){
        for(Book book : this.books){
            if(book != null && book.getTitle().toLowerCase().contains(title.toLowerCase())){
                book.displayInfo();
            }
        }
    }

    public void searchByAuthor(String author){
        for(Book book : this.books){
            if(book != null && book.getAuthor().toLowerCase().contains(author.toLowerCase())){
                book.displayInfo();
            }
        }
    }

    public void displayAllBooks(){
        for(Book book : this.books){
            if(book != null)book.displayInfo(true);
            else break;
        }
    }

    public int getTotalPrice(){
        int total = 0;
        for(Book book : this.books){
            if (book != null)total+=book.getPrice();
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
        for(Book book : this.books){
            if(book != null) book.applyDiscount(percent);
        }
    }
}

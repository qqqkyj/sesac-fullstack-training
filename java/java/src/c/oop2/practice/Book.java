package c.oop2.practice;

public class Book {
    private String title;
    private String author;
    private int price;
    private String isbn;

    public Book(String title, String author) {
        this(title, author, 0, null);
    }

    public Book(String title, String author, int price) {
        this(title, author, price, null);
    }

    public Book(String title, String author, int price, String isbn) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void displayInfo(){
        System.out.printf("%s - 저자: %s, 가격: %d원%n",this.title,this.author,this.price);
    }

    public void displayInfo(boolean detailed){
        if(detailed && isbn != null){
            System.out.printf("%s - 저자: %s, 가격: %d원, isbn: %s%n",this.title,this.author,this.price,this.isbn);
        }
        else{
            displayInfo();
        }
    }

    public void applyDiscount(int percent){
        setPrice(getPrice() * (100 - percent) / 100);
    }

    public void applyDiscount(int amount, boolean isPercent){
        if(isPercent){  applyDiscount(amount); }// 할인률 적용
        else{ setPrice(getPrice() - amount);  }// 금액 할인 적용
    }
}

package com.woodee.ect.test.ex04;

public class Book {
    public String title;
    public int price;
    public String author;
    public String publisher;
    public String pubDate;

    public Book(String title, int price, String author, String publisher, String pubDate) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pubDate='" + pubDate + '\'' +
                '}';
    }

    public static void main(String[] args) {

        Book book = new Book("모바일 웹", 35100, "김근경", "운칠기삼", "2020-07-12");
        System.out.println(book.toString());

        book.setTitle("javascript 완벽가이드");
        book.setPrice(29700);
        book.setAuthor("Woody");
        book.setPublisher("포스");
        book.setPubDate("2014-11-25");

        System.out.println(book.getTitle());
        System.out.println(book.getPrice());
        System.out.println(book.getAuthor());
        System.out.println(book.getPublisher());
        System.out.println(book.getPubDate());

    }
}


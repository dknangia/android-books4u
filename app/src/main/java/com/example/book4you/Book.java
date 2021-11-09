package com.example.book4you;

public class Book {
    private int Id;
    private String Name;
    private String Author;
    private  String Description;
    private int Pages;
    private double Price;
    private String bookImageUrl;


    public Book(int id, String name, String author, String description, int pages, double price, String bookImageUrl) {
        Id = id;
        Name = name;
        Author = author;
        Description = description;
        Pages = pages;
        Price = price;
        this.bookImageUrl = bookImageUrl;
    }

    public String getBookImageUrl() {
        return bookImageUrl;
    }

    public void setBookImageUrl(String bookImageUrl) {
        this.bookImageUrl = bookImageUrl;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getPages() {
        return Pages;
    }

    public void setPages(int pages) {
        Pages = pages;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Author='" + Author + '\'' +
                ", Description='" + Description + '\'' +
                ", Pages=" + Pages +
                ", Price=" + Price +
                ", bookImageUrl='" + bookImageUrl + '\'' +
                '}';
    }
}

package com.example.book4you;

import java.util.ArrayList;


public class Util {

    static ArrayList<Book> allBooks;

    public Util() {
        if (allBooks == null) {
            allBooks = new ArrayList<>();
            populateAllBooks();
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static void setAllBooks(ArrayList<Book> allBooks) {
        Util.allBooks = allBooks;
    }


    private void populateAllBooks() {

        int id = 0;
        String name;
        String author;
        double price;
        int pages;
        String imageURL;
        String description;


        //1
        id++;
        name = "The Guest List";
        author = "Lucy Foley";
        price = 14.89;
        pages = 237;
        imageURL = "https://m.media-amazon.com/images/M/MV5BNzQyNzYyMjMwNV5BMl5BanBnXkFtZTcwNTUwODgwMw@@._V1_UY209_CR19,0,140,209_AL_.jpg";
        description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable.";
        allBooks.add(new Book(
                id,
                name,
                author,
                description,
                pages,
                price,
                imageURL
        ));

        //2
        id++;
        name = "Another Guest List";
        author = "Lucy Foley";
        price = 14.89;
        pages = 237;
        imageURL = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1597345150l/54911607._SY475_.jpg";
        description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable.";
        allBooks.add(new Book(
                id,
                name,
                author,
                description,
                pages,
                price,
                imageURL
        ));


        //3
        id++;
        name = "Dune";
        author = "Frank Herbit";
        price = 10.89;
        pages = 560;
        imageURL = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1555447414i/44767458.jpg";
        description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable.";
        allBooks.add(new Book(
                id,
                name,
                author,
                description,
                pages,
                price,
                imageURL
        ));


        //4
        id++;
        name = "Wish You Were Here";
        author = "Jodi Picoult";
        price = 23.45;
        pages = 214;
        imageURL = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1622420981i/57700040.jpg";
        description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable.";
        allBooks.add(new Book(
                id,
                name,
                author,
                description,
                pages,
                price,
                imageURL
        ));

        //5
        id++;
        name = "Gilded";
        author = "Marissa Meyer";
        price = 10.89;
        pages = 250;
        imageURL = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1614276588i/56614597.jpg";
        description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable.";
        allBooks.add(new Book(
                id,
                name,
                author,
                description,
                pages,
                price,
                imageURL
        ));

        //6
        id++;
        name = "Window Shopping";
        author = "Taisa Bailey";
        price = 35.69;
        pages = 352;
        imageURL = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1631093429i/58943206.jpg";
        description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable.";
        allBooks.add(new Book(
                id,
                name,
                author,
                description,
                pages,
                price,
                imageURL
        ));




    }


}

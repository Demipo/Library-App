package com.bernard;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int copies;
    private int copiesAvailable;

    //empty constructor
    public Book(){}

    //constructor accepting arguments
    public Book(String title, String author, String isbn, int copies, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.copies = copies;
        this.copiesAvailable = copiesAvailable;

    }
    public Book(String title){
        this.title = title;
    }

    //To override the toString() method
    public String toString(){
        return title+" "+author+" "+isbn+" "+copies+" "+copiesAvailable;
    }

    //getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getCopies() { return copies; }
    public int getCopiesAvailable() { return copiesAvailable; }

    //setters
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setCopies(int copies) { this.copies = copies; }
    public void setCopiesAvailable(int copiesAvailable) { this.copiesAvailable = copiesAvailable; }

}

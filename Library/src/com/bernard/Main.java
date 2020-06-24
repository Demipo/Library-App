package com.bernard;

import java.util.*;

public class Main {


    public static void main(String[] args) {
    SecondaryMain sm = new SecondaryMain();
    Library lib = new Library();
        sm.openLibrary();
        sm.welcomeNote();

        System.out.println(lib.user);
        System.out.println(lib.book);
    }
}

class SecondaryMain{
        PendingBorrower borrower = new PendingBorrower();
        Library lib = new Library();
        User user = new User();
        Book book = new Book();

        static Scanner scan = new Scanner(System.in);
        static int mode = 0;
        int val = -1;

    public static void openLibrary(){
        do{
            System.out.println("The library is closed");
            System.out.println("Enter a librarian id to open the library");}
        while(scan.nextInt() != 111111);
        System.out.println("Define lending mode: \n1-For non-prioritised borrow\n2-For prioritised borrow");
        mode = scan.nextInt();
    }
    public void welcomeNote(){
        System.out.println("-----------Welcome to the Library-----------\n");
        System.out.println("What would you like to do? \n1-To register\n2-To use the library\n3-I'm a librarian");
        val = scan.nextInt();
        if(val == 1) {
            signUp();
            if(val == 1){  signIn(); }
            else if(val == 0){ welcomeNote(); }
        }
        else if(val == 2) {
            signIn();
            if(val == 1){  userFunction(); }
            else if(val == 0){ welcomeNote(); }
        }
        else if (val == 3) {
            librarianValidation();
            librarianDuty();
            if(val == 1){  librarianDuty(); }
            else if(val == 0){ welcomeNote(); }
        }
    }
    public void signUp(){
        User user = new User();
        System.out.println("Enter full name:");
        user.setName(scan.next());
        System.out.println("Enter email:");
        user.setEmail(scan.next());
        System.out.println("Enter cadre:");
        user.setUserType(scan.next());
        System.out.println("Enter cadre/level(1-Junior 2-Senior 3-Staff)");
        user.setLevel(scan.nextInt());
        lib.addUser(user);
        System.out.println("Registration was successful");
        System.out.println("Enter 1-To use the library\n 0-To go back");
        val = scan.nextInt();
        if(val == 1){ signIn();}
        else if (val == 0){ welcomeNote();}
    }

    public void signIn(){
            userFunction();
    }

    public void userFunction(){
        PendingBorrower borrower = new PendingBorrower();
        System.out.println("Enter: \n1-To borrow a book\n2-To return a book");
        val = scan.nextInt();
        if (val == 1 && mode == 1) {
            System.out.println("Enter the title of the book");
            borrower.setTitle(scan.next());
            System.out.println("Enter the registered email");
            borrower.setEmail(scan.next());
            lib.joinQueue(borrower);
            System.out.println("Now you are queued, will get back to you in a jive!");
        } else if (val == 1 && mode == 2) {
            System.out.println("Enter the title of the book");
            borrower.setTitle(scan.next());
            System.out.println("Enter the registered email");
            borrower.setEmail(scan.next());
            System.out.println("Enter your level");
            borrower.setLevel(scan.nextInt());
            lib.joinQueue(borrower);
            System.out.println("Now you are queued, will get back to you in a jive!");
        } else if (val == 2) {
            System.out.println("Enter the title of book to be returned");
            lib.returnBook(new PendingBorrower(scan.next(), user.getEmail()));
            System.out.println("Book was returned");
        }
        System.out.println("Enter 1-To to borrow another book or return a book\n 0-To return to the menu");
        val = scan.nextInt();
        if(val == 1){ userFunction();}
        else if (val == 0){ welcomeNote();}
    }

    public void librarianValidation() {
        System.out.println("Enter a librarian id");
        if (scan.nextInt() == 860519) {
            System.out.println("Welcome librarian");
        }
    }

    public void librarianDuty() {
        System.out.println("Enter \n1-To add news books\n2-To attend to intending borrowers");
        val = scan.nextInt();
        if (val == 1) {
            Book book = new Book();
            System.out.println("Enter book title");
            book.setTitle(scan.next());
            System.out.println("Enter book ISBN");
            book.setIsbn(scan.next());
            System.out.println("Enter book author");
            book.setAuthor(scan.next());
            System.out.println("Enter number of copies");
            book.setCopies(scan.nextInt());
            book.setCopiesAvailable(book.getCopies());
            lib.addBook(book);
        } else if (val == 2) {
            if (mode == 1) {
                lib.lendBook();
            } else {
                lib.lendBookOnPriority();
            }
        }
        System.out.println("Enter 1-To to add another book or attend to an intending borrower\n 0-To return to the menu");
        val = scan.nextInt();
        if(val == 1){ librarianDuty();}
        else if (val == 0){ welcomeNote();}
    }
}

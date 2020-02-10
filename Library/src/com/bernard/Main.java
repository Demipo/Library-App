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










//package com.bernard;
//
//        import java.util.ArrayList;
//        import java.util.HashMap;
//        import java.util.Queue;
//        import java.util.LinkedList;
//        import java.util.Map;
//
//public class Library {
//
//
//    //storage structure for users and boos data
//    ArrayList users = new ArrayList();
//    ArrayList books = new ArrayList();
//    Queue<PendingBorrower> queue = new LinkedList<PendingBorrower>();
//
//    Map<Integer, User> user = new HashMap<Integer, User>();
//    Map<Integer, Book> book = new HashMap<Integer, Book>();
//
//    //add user to users
//    public void addUser(int id, User member){
//        for (Map.Entry<Integer, User> entry : user.entrySet()) {
//            if(entry.getValue().getEmail() == member.getEmail()){
//                System.out.println("User already exist");
//            }
//        }
//        user.put(id, member);
//    }
//
//    //add book to books
//    public void addBook(int id, Book bok) {
//        for (Map.Entry<Integer, Book> entry : book.entrySet()) {
//            if(entry.getValue().getTitle() == bok.getTitle()){
//                System.out.println("Title already exist");
//            }
//        }
//        book.put(id, bok);
//    }
//
//    //join queue of borrowers
//    public void joinQueue(PendingBorrower borrower){ queue.add(borrower); }
//
//    //lend book
//    public void lendBook() {
//        int countForUser = 0;
//        int countForBook = 0;
//        int copy = 0;
//        for (PendingBorrower item : queue) {
//            //user validation
//            for (Map.Entry<Integer, User> entry : user.entrySet()) {
//                if (entry.getValue().getEmail() == item.getEmail()) {
//                    countForUser++;
//                }
//            }
//            if (countForUser == 1) {
//                System.out.println("--> Welcome @" + " " + item.getEmail());
//                //book validation
//                for (Map.Entry<Integer, Book> entry : book.entrySet()) {
//                    if (entry.getValue().getTitle() == item.getTitle()) {
//                        countForBook++;
//                        copy = entry.getValue().getCopiesAvailable();
//                        if(entry.getValue().getCopiesAvailable() > 0){
//                            entry.getValue().setCopiesAvailable(copy - 1);
//                        }
//                    }
//                }
//                if (countForBook == 1 && copy > 0) {
//                    System.out.println("Access granted!");
//                    System.out.println("Return book("+ item.getTitle() +")in two weeks\n");
//                }
//                else {
//                    System.out.println("The book you requested is not available");
//                }
//            }
//            else {
//                System.out.println("--> "+item.getEmail() +  ", you are not a registered user\n");
//            }
//            //returns counters to 0
//            countForBook = 0;
//            countForUser = 0;
//        }
//        System.out.println(book);
//        System.out.println(queue);
//        queue.clear();
//        System.out.println(queue);
//    }
//
//    public void lendBookOnPriority(){
//        Queue<PendingBorrower> cloneLevelQueue = new LinkedList(queue); //a clone of levelQueue
//        Queue<PendingBorrower> permQueue = new LinkedList(); //temporary storage
//        PendingBorrower tempItem = new PendingBorrower("", "", 0);
////        tempItem.setTitle(levelQueue.peek().getTitle()); //set title of tempItem to the first value
////        tempItem.setLevel(0);
//        for (PendingBorrower itemOne : cloneLevelQueue) {
//            tempItem = itemOne;
//            for (PendingBorrower itemTwo : cloneLevelQueue) {
//                if (itemTwo.getTitle() == tempItem.getTitle() && itemTwo.getLevel() > tempItem.getLevel()) {
//                    tempItem = itemTwo;
//                }
//            }
//            permQueue.add(tempItem);
//            cloneLevelQueue.remove(tempItem);
//        }
//        if (cloneLevelQueue != null){
//            for (PendingBorrower item : cloneLevelQueue){
//                permQueue.add(item);
//            }
//        }
//        queue = new LinkedList<>(permQueue);
//        lendBook();
//    }
//
//}

//    public void lendBookOnPriority(){
//        Queue<PendingBorrower> cloneLevelQueue = new LinkedList(queue); //a clone of levelQueue
//        Queue<PendingBorrower> permQueue = new LinkedList(); //temporary storage
//        PendingBorrower tempItem = new PendingBorrower("", "", 0);
//        for (PendingBorrower itemOne : cloneLevelQueue) {
//            tempItem = itemOne;
//            for (PendingBorrower itemTwo : cloneLevelQueue) {
//                if (itemTwo.getTitle().equals(tempItem.getTitle()) && itemTwo.getLevel() > tempItem.getLevel()) {
//                    tempItem = itemTwo;
//                }
//            }
//            permQueue.add(tempItem);
//            cloneLevelQueue.remove(tempItem);
//        }
//        if (cloneLevelQueue != null){
//            for (PendingBorrower item : cloneLevelQueue){
//                permQueue.add(item);
//            }
//        }
//        queue = new LinkedList<>(permQueue);
//
//        System.out.println(queue);
//        lendBook();
//    }

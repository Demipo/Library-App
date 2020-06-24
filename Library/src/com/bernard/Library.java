package com.bernard;

import java.util.*;

public class Library {

    //library mode
    public boolean isLibraryOpen (int mode ){
        if (mode == 1){ return true; }
        return false;
    }

    //storage structure for users and books data
    PriorityQueue<PendingBorrower> queue = new PriorityQueue<>(5, PendingBorrower.CompareBookTitleAndLevel);
    Map<Integer, User> user = new HashMap<Integer, User>();
    Map<Integer, Book> book = new HashMap<Integer, Book>();

    PendingBorrower pb = new PendingBorrower();

    public void addUser(User member){
        int alreadyUserChecker = 0;
        for (Map.Entry<Integer, User> entry : user.entrySet()) {
            if(entry.getValue().getEmail().equals(member.getEmail())){
                System.out.println("User already exist");
                alreadyUserChecker++;
            }
        }
        if(alreadyUserChecker == 0 ){
            user.put(user.size()+1, member);
            System.out.println(user);
        }
    }

    public boolean emailValidation(String email) {
        boolean val = false;
        for (Map.Entry<Integer, User> entry : user.entrySet()) {
            if (entry.getValue().getEmail().equals(email)) {
                System.out.println(email);
                val = true || val ;
            }
        }
        return val;
    }

    public void addBook(Book bok) {
        int alreadyBookChecker = 0;
        for (Map.Entry<Integer, Book> entry : book.entrySet()) {
            if(entry.getValue().getTitle().toLowerCase().equals(bok.getTitle().toLowerCase()) ){
                System.out.println("Title already exist");
                alreadyBookChecker++;
            }
        }
        if(alreadyBookChecker == 0){
            book.put(book.size()+1, bok);
            System.out.println(book);
        }
    }

    //join queue of borrowers
    public void joinQueue(PendingBorrower borrower){ queue.add(borrower);}

    //lend book
    public void lendBook() {
        int countForUser = 0;
        int countForBook = 0;
        int copy = 0;
        for (PendingBorrower item : queue) {
            //user validation
            for (Map.Entry<Integer, User> entry : user.entrySet()) {
                if (entry.getValue().getEmail().equals(item.getEmail())) {
                    countForUser++;
                }
            }
            if (countForUser == 1) {
                System.out.println("--> Welcome @" + " " + item.getEmail());
                //book validation
                for (Map.Entry<Integer, Book> entry : book.entrySet()) {
                    System.out.println(entry.getValue().getTitle());
                    if (entry.getValue().getTitle().equals(item.getTitle())) {
                        countForBook++;
                        copy = entry.getValue().getCopiesAvailable();
                        if(entry.getValue().getCopiesAvailable() > 0){
                            entry.getValue().setCopiesAvailable(copy - 1);
                        }
                    }
                }
                if (countForBook == 1 && copy > 0) {
                    System.out.println("Access granted!");
                    System.out.println("Return book("+ item.getTitle() +")in two weeks\n");
                }
                else {
                    System.out.println("Book taken");
                }
            }
            else {
                System.out.println("--> "+item.getEmail() +  ", you are not a registered user\n");
            }
            //returns counters to 0
            countForBook = 0;
            countForUser = 0;
        }
        queue.clear();
    }

    //lending based on priority
    public void lendBookOnPriority(){
        //Collections.sort(queue, PendingBorrower.CompareBookTitleAndLevel);
        lendBook();
    }
    public void returnBook(PendingBorrower borrower){
        for (Map.Entry<Integer, Book> entry : book.entrySet()) {
            if(entry.getValue().getTitle().equals(borrower.getTitle())){
                entry.getValue().setCopiesAvailable(entry.getValue().getCopiesAvailable()+1);
            }
        }
    }
}

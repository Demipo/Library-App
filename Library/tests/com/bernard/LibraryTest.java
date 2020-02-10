package com.bernard;

import static org.junit.Assert.*;

public class LibraryTest {
    Library lib = new Library();
    User user;

    @org.junit.Test
    public void addUser_userNotPresent() {
        lib.addUser(new User("Bernard", "beronad@gmail.com", "Staff", 3));
        assertEquals(1,lib.user.size());
    }

    @org.junit.Test
    public void addUser_userPresent() {
        lib.addUser(new User("Bernard", "beronad@gmail.com", "Staff", 3));
        lib.addUser(new User("John", "beronad@gmail.com", "Senior", 2));
        assertEquals(1,lib.user.size());
    }

    @org.junit.Test
    public void addBook_bookNotPresent() {
        lib.addBook(new Book("Java", "Bernard", "123-456-78", 4, 4));
        assertEquals(1,lib.book.size());
    }

    @org.junit.Test
    public void addBook_bookPresent() {
        lib.addBook(new Book("Java", "Bernard", "123-456-78", 4, 4));
        lib.addBook(new Book("Java", "Bernard", "123-456-78", 4, 4));
        assertEquals(1,lib.book.size());
    }

    @org.junit.Test
    public void joinQueue() {
        lib.joinQueue(new PendingBorrower("Java", "beronad@gmail.com", 3));
        lib.joinQueue(new PendingBorrower("Java", "beronad@gmail.com", 3));
        assertEquals(2, lib.queue.size());
    }
}
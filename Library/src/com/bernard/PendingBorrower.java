package com.bernard;

import java.util.Comparator;

public class PendingBorrower {
    private String title;
    private String email;
    private int level;


    public PendingBorrower(String title, String email) {
        this.title = title;
        this.email = email;
    }

    public PendingBorrower(String title, String email, int level) {
        this.title = title;
        this.email = email;
        this.level = level;
    }

    public PendingBorrower() {
    }

    public void setTitle(String title) { this.title = title; }
    public void setEmail(String email) { this.email = email; }
    public void setLevel(int level) { this.level = level; }

    public String getEmail() {
        return email;
    }
    public String getTitle() { return title; }
    public int getLevel() { return level; }

    //To override the toString() method
    @Override
    public String toString(){
        return email+" "+title+" "+level;
    }

               //.............tried out the java.util.Comparator interface...............//
    public static Comparator<PendingBorrower> CompareBookTitleAndLevel = new Comparator<PendingBorrower>() {
        @Override
        public int compare(PendingBorrower pbOne, PendingBorrower pbTwo) {
            int flag = pbOne.getTitle().compareTo(pbTwo.getTitle());
            if(flag == 0) {
                flag = pbTwo.getLevel() - pbOne.getLevel();
            }
            return flag;
        }
    };

}

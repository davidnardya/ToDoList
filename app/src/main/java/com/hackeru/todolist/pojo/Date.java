package com.hackeru.todolist.pojo;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date getDate() {
        Date date = new Date(this.day, this.month, this.year);
        return date;
    }

    public void setDay(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
}

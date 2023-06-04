package com.web.WebCalendar.model;

import com.web.WebCalendar.util.Months;
import com.web.WebCalendar.util.Years;

public class CalendarUnit {
    private int month;
    private int year;
    private int day = 1;

    public CalendarUnit() {
    }

    public int getMonths() {
        return month;
    }

    public void setMonths(int month) {
        this.month = month;
    }

    public int getYears() {
        return year;
    }

    public void setYears(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}

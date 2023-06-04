package com.web.WebCalendar.util;

public enum Years {
    ONE(2021),
    TWO(2022),
    THREE(2023),
    FOUR(2024),
    FIVE(2025),
    SIX(2026),
    SEVEN(2027),
    EIGHT(2028),
    NINE(2029),
    ZERO(2030);

    private int year;
    Years(int year) {
    this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

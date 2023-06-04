package com.web.WebCalendar.util;

public enum Months {

    JANUARY("Январь",0),
    FEBRUARY("Февраль",1),
    MARCH("Март",2),
    APRIL("Апрель",3),
    MAY("Май",4),
    JUNE("Июнь",5),
    JULY("Июль",6),
    AUGUST("Август",7),
    SEPTEMBER("Сентябрь",8),
    OCTOBER("Октябрь",9),
    NOVEMBER("Ноябрь",10),
    DECEMBER("Декабрь",11);

    private String rusName;
    private int num;
    Months(String rusName, int num) {
        this.rusName = rusName;
        this.num = num;
    }

    public String getRusName() {
        return rusName;
    }

    public int getNum() {
        return num;
    }
}

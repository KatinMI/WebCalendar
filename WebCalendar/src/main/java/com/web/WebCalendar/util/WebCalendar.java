package com.web.WebCalendar.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class  WebCalendar {
    private String time;
    private Calendar calendar;
    private List<Date> months;

    private Date date;

    public WebCalendar() {

    }
    public void GenerateMonths(Calendar calendar){
        this.calendar = calendar;
        int lengthOfMonth = LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH) + 1,calendar.get(Calendar.DAY_OF_MONTH)).lengthOfMonth();
        months = new ArrayList<>(42);
        this.calendar.set(Calendar.DAY_OF_MONTH, 1);
        int start = (this.calendar.get(Calendar.DAY_OF_WEEK) + 5) % 7;
        for(int x = 0; x< 42; x++){
            if (x < start || x >= lengthOfMonth + start){
                months.add(null);
            } else {
                months.add(new Date(this.calendar.getTimeInMillis()));
                this.calendar.set(Calendar.DAY_OF_MONTH, this.calendar.get(Calendar.DAY_OF_MONTH) + 1);
            }
        }
        this.calendar = calendar;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public List<Date> getMonths() {
        return months;
    }

    public void setMonths(List<Date> months) {
        this.months = months;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDayOfData(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }
    public Date getDateOfTime(String time){
        Long l = Long.valueOf(time);
        return new Date(l);
    }
    public List<Date> getMonthsWithoutNull(){
        List<Date> list = new ArrayList<>();
        for (Date date : months) {
            if (date != null) list.add(date);
        }
        return list;
    }
    public int getMonthOfData(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH) + 1;
    }
    public int getYearOfData(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }
    public String getDayForUrl(){
        System.out.println(getDayOfData(date)+"."+getMonthOfData(date) + "." + getYearOfData(date));
        return getDayOfData(date)+"."+getMonthOfData(date) + "." + getYearOfData(date);
    }
}
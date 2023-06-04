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

    private Calendar calendar;
    private List<Date> months;

    public WebCalendar() {

    }
    public void GenerateMonths(Calendar calendar){
        this.calendar = calendar;
        int lengthOfMonth = LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH) + 1,calendar.get(Calendar.DAY_OF_MONTH)).lengthOfMonth();
        months = new ArrayList<>(42);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int start = (calendar.get(Calendar.DAY_OF_WEEK) + 5) % 7;
        for(int x = 0; x< 42; x++){
            if (x < start || x >= lengthOfMonth + start){
                months.add(null);
            } else {
                months.add(new Date(calendar.getTimeInMillis()));
                calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
            }
        }
        calendar = null;
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
    public int getDayOfData(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }
}
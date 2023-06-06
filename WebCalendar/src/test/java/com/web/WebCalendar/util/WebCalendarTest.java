package com.web.WebCalendar.util;

import org.assertj.core.api.Assert;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class WebCalendarTest {
    private static WebCalendar wb;
    @BeforeAll
    static void generateMonths() {
        wb = new WebCalendar();
        wb.GenerateMonths(new GregorianCalendar(2023,0,1));
    }
    @Test
    void generateMonthSize(){
        Assertions.assertEquals(42, wb.getMonths().size());
    }
    @Test
    void generateMonthCorrect(){
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0 );
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.AM_PM, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = new Date(calendar.getTimeInMillis());
        Assertions.assertEquals(date.getTime(),wb.getMonthsWithoutNull().get(0).getTime());
    }
    @Test
    void getDay(){
        Assertions.assertEquals(1,wb.getDayOfData(wb.getMonthsWithoutNull().get(0)));
    }
    @Test
    void getMonth(){
        Assertions.assertEquals(1,wb.getMonthOfData(wb.getMonthsWithoutNull().get(0)));
    }
    @Test
    void getYear(){
        Assertions.assertEquals(2023,wb.getYearOfData(wb.getMonthsWithoutNull().get(0)));
    }

}
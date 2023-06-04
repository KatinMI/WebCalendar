package com.web.WebCalendar.util;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class WebCalendarTest {

    @Test
    void generateMonths() {
        WebCalendar wb = new WebCalendar();
        wb.GenerateMonths(new GregorianCalendar(2023,0,1));
        System.out.println(wb.getMonths().toString());
        for (Date data: wb.getMonths()) {
            if (data != null) {
                System.out.println(data.toString() + ") " + wb.getDayOfData(data));
            } else
                System.out.println("null");
        }
        System.out.println(wb.getMonths().size());
    }
}
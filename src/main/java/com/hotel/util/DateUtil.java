package com.hotel.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateUtil {
    @Value("${date.jarek}")
    String date;
    public Date createDateFromString(String dateStr) {
        System.out.println("*************************");
        System.out.println(date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            date = new Date();
        }
        return date;
    }
}

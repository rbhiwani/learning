package com.learning.demo;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class TestDateFormat {
    

    @Test
    public void test(){

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SS");
        String dateString = "05-06-2023 12:06:53.13";
        Date date = format.parse(dateString, new ParsePosition(0));
        System.out.println(date);
    }
}

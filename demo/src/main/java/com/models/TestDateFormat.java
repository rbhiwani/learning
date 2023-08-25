package com.models;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TestDateFormat {
    

    
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SS");
        String dateString = "05-06-2023 12:06:53.13";
        Date date = format.parse(dateString, new ParsePosition(0));
        System.out.println(date);

        String s = "LOCKING_B";
        String s1 = "LOCK_S";
        System.out.println(s.compareTo(s1));
        List<String> list = Arrays.asList(s1,s);
        Collections.sort(list, (obj, obj1) -> obj1.compareTo(obj));
        System.out.println(list);
    }
}

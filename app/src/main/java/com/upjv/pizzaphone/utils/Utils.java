package com.upjv.pizzaphone.utils;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Utils {

    public static String getDate(){

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }
}

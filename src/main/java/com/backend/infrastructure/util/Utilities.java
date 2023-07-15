package com.backend.infrastructure.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Utilities {
    public  static Date coverterDate(String date) throws ParseException {
        SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
        return inputFormatter.parse(date);
    }
}

package com.backend.infrastructure.util;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final  class Utilities {

    public  static LocalDateTime coverterDate(String date) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

        return dateTime;
    }
}

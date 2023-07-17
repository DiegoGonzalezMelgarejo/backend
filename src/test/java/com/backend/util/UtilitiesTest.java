package com.backend.util;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilitiesTest {

    @Test
    void coverterDate_ValidDateString_ReturnsParsedDate() throws ParseException {
        // Arrange
        String dateString = "2023-07-16-10.30.00";

        // Act
        LocalDateTime result = Utilities.coverterDate(dateString);

        // Assert
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        LocalDateTime expectedDate = LocalDateTime.parse(dateString, formatter);
        assertEquals(expectedDate, result);
    }
}

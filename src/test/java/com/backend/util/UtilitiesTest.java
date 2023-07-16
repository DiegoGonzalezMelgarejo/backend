package com.backend.util;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilitiesTest {

    @Test
    void coverterDate_ValidDateString_ReturnsParsedDate() throws ParseException {
        // Arrange
        String dateString = "2023-07-16-10.30.00";

        // Act
        Date result = Utilities.coverterDate(dateString);

        // Assert
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
        Date expectedDate = formatter.parse(dateString);
        assertEquals(expectedDate, result);
    }
}

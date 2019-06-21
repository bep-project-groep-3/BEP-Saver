package org.nl.hu.sie.bep.business;

import org.junit.jupiter.api.Test;
import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoublesTest {
    @Test
    public void test() throws ParseException {
        EditRows editRows = new EditRows();

        assertEquals("%0501", editRows.editDouble(-505.0100, 5));
        assertEquals(" 000050501", editRows.editDouble(-505.01, 10));
        assertEquals(" 000501", editRows.editDouble(-5.01, 7));
        assertEquals("!05", editRows.editDouble(-105.01, 3));
        assertEquals("“05", editRows.editDouble(-205.01, 3));
        assertEquals("#05", editRows.editDouble(-305.01, 3));
        assertEquals("$05", editRows.editDouble(-405.01, 3));
        assertEquals("%05", editRows.editDouble(-505.01, 3));
        assertEquals("&05", editRows.editDouble(-605.01, 3));
        assertEquals("\\05", editRows.editDouble(-705.01, 3));
        assertEquals("(05", editRows.editDouble(-805.01, 3));
        assertEquals(")05", editRows.editDouble(-905.01, 3));
        assertEquals("00100", editRows.editDouble(10.0, 5));
        assertEquals("0000121", editRows.editDouble(12.10, 7));
        assertEquals("10", editRows.editPositiveDouble(100.0,2));
        assertEquals("1000", editRows.editPositiveDouble(100.0,4));

    }
}
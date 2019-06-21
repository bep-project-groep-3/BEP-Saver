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
        assertEquals("%05", editRows.editDouble(-505.01, 3));
        assertEquals("00100", editRows.editDouble(10.0, 5));
        assertEquals("0000121", editRows.editDouble(12.10, 7));
    }
}
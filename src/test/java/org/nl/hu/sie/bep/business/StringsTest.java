package org.nl.hu.sie.bep.business;

import org.junit.jupiter.api.Test;
import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class StringsTest {
    @Test
    public void test() throws ParseException {

        EditRows editRows = new EditRows();

        assertEquals("Hoi  ", editRows.editString("Hoi", 5));
        assertEquals("Hoi", editRows.editString("Hoi", 3));
        assertEquals("Hoi", editRows.truncate("Hoiiiiiiii", 3));
        assertEquals("00501", editRows.editDouble(5.01, 5));
    }
}
package org.nl.hu.sie.bep.business;

import org.junit.jupiter.api.Test;
import org.nl.hu.sie.bep.business.filesaving.EditRows;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditRowsTest {

    @Test
    public void test() {

        EditRows editRows = new EditRows();

        assertEquals("Hoi  ", editRows.editString("Hoi",5));
        assertEquals("Hoi", editRows.editString("Hoi",3));
        assertEquals("Hoi", editRows.truncate("Hoiiiiiiii", 3));
        assertEquals("00501", editRows.editDouble(5.01, 5));


        assertEquals("%0501", editRows.editDouble(-505.0100, 5));
        assertEquals(" 000050501", editRows.editDouble(-505.01, 10));
        assertEquals("%05", editRows.editDouble(-505.01, 3));

    }



}

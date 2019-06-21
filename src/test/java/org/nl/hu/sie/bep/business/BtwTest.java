package org.nl.hu.sie.bep.business;

import org.junit.jupiter.api.Test;
import org.nl.hu.sie.bep.business.dto.FactuurRegelRow;
import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.text.ParseException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BtwTest {
    @Test
    public void test() throws ParseException {

        EditRows editRows = new EditRows();

        assertEquals("0", editRows.editBTWtype(FactuurRegelRow.BtwType.GEEN));
        assertEquals("1", editRows.editBTWtype(FactuurRegelRow.BtwType.LAAG));
        assertEquals("2", editRows.editBTWtype(FactuurRegelRow.BtwType.HOOG));

    }
}

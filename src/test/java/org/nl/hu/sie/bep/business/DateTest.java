package org.nl.hu.sie.bep.business;

import org.junit.jupiter.api.Test;
import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class DateTest {

    @Test
    public void test() throws ParseException {

        EditRows editRows = new EditRows();

        SimpleDateFormat format = new SimpleDateFormat("ddMMyy");
        Date date = format.parse("200619");

        assertEquals("200619", editRows.editDate(date));
    }
}
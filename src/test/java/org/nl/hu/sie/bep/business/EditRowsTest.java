package org.nl.hu.sie.bep.business;

import org.junit.jupiter.api.Test;
import org.nl.hu.sie.bep.business.dto.FactuurRegelRow;
import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class EditRowsTest {

    @Test
    public void test() throws ParseException {

        EditRows editRows = new EditRows();

        assertEquals("Hoi  ", editRows.editString("Hoi",5));
        assertEquals("Hoi", editRows.editString("Hoi",3));
        assertEquals("Hoi", editRows.truncate("Hoiiiiiiii", 3));
        assertEquals("00501", editRows.editDouble(5.01, 5));

        assertEquals("%0501", editRows.editDouble(-505.0100, 5));
        assertEquals(" 000050501", editRows.editDouble(-505.01, 10));
        assertEquals("%05", editRows.editDouble(-505.01, 3));
        assertEquals("00100", editRows.editDouble(10.0, 5));
        assertEquals("0000121", editRows.editDouble(12.10, 7));


        SimpleDateFormat format = new SimpleDateFormat("ddMMyy");
        Date date = format.parse("200619");

        assertEquals("200619", editRows.editDate(date));

        String sixtyCharacters = "Hallo, dit is een string van 60 karakters. Lang zeg…!!!!!!!!";
        String sixtyOneCharacters = "Hallo, dit is een string van 60 karakters. Lang zeg…!!!!!!!!" + "!";
        String oneHundredTwentyCharacters = sixtyCharacters + sixtyCharacters;
        String twoHundredCharacters = sixtyCharacters + sixtyCharacters + sixtyCharacters + "!!!!!!!!!!!!!!!!!!!!";

        assertEquals(Arrays.asList("TienletterTienletterTienletterTienletterTienletter          "), editRows.knipProductomschrijving("TienletterTienletterTienletterTienletterTienletter"));
        assertEquals(Arrays.asList(sixtyCharacters), editRows.knipProductomschrijving(sixtyCharacters));
        assertEquals(Arrays.asList(sixtyCharacters, "!                                                                                                                       "), editRows.knipProductomschrijving(sixtyOneCharacters));
        assertEquals(Arrays.asList(sixtyCharacters, sixtyCharacters + "                                                            "), editRows.knipProductomschrijving(oneHundredTwentyCharacters));
        assertEquals(Arrays.asList(sixtyCharacters, oneHundredTwentyCharacters), editRows.knipProductomschrijving(sixtyCharacters + oneHundredTwentyCharacters));
        assertEquals(Arrays.asList(sixtyCharacters, oneHundredTwentyCharacters, "!!!!!!!!!!!!!!!!!!!!                                                                                                    "), editRows.knipProductomschrijving(twoHundredCharacters));

        assertEquals("0", editRows.editBTWtype(FactuurRegelRow.BtwType.GEEN));
        assertEquals("1", editRows.editBTWtype(FactuurRegelRow.BtwType.LAAG));
        assertEquals("2", editRows.editBTWtype(FactuurRegelRow.BtwType.HOOG));

    }
}

package org.nl.hu.sie.bep.business;

import org.junit.jupiter.api.Test;
import org.nl.hu.sie.bep.business.dto.FactuurRow;
import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;

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

        Date date = new Date();

        assertEquals("190619", editRows.editDate(date));

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

        FactuurRow.BtwType geen = FactuurRow.BtwType.GEEN;

        assertEquals("0", editRows.editBTWtype(FactuurRow.BtwType.GEEN));
        assertEquals("1", editRows.editBTWtype(FactuurRow.BtwType.LAAG));
        assertEquals("2", editRows.editBTWtype(FactuurRow.BtwType.HOOG));

    }
}

package org.nl.hu.sie.bep.business;

import org.junit.jupiter.api.Test;
import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.text.ParseException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ProductomschrijvingTest {

  @Test
  public void test() throws ParseException {

    EditRows editRows = new EditRows();

    String sixtyCharacters = "Hallo, dit is een string van 60 karakters. Lang zeg...!!!!!!";
    String sixtyOneCharacters = "Hallo, dit is een string van 60 karakters. Lang zeg...!!!!!!" + "!";
    String oneHundredTwentyCharacters = sixtyCharacters + sixtyCharacters;
    String twoHundredCharacters = sixtyCharacters + sixtyCharacters + sixtyCharacters + "!!!!!!!!!!!!!!!!!!!!";

    assertEquals(Arrays.asList("TienletterTienletterTienletterTienletterTienletter          "), editRows.knipProductomschrijving("TienletterTienletterTienletterTienletterTienletter"));
    assertEquals(Arrays.asList(sixtyCharacters), editRows.knipProductomschrijving(sixtyCharacters));
    assertEquals(Arrays.asList(sixtyCharacters, "!                                                                                                                       "), editRows.knipProductomschrijving(sixtyOneCharacters));
    assertEquals(Arrays.asList(sixtyCharacters, sixtyCharacters + "                                                            "), editRows.knipProductomschrijving(oneHundredTwentyCharacters));
    assertEquals(Arrays.asList(sixtyCharacters, oneHundredTwentyCharacters), editRows.knipProductomschrijving(sixtyCharacters + oneHundredTwentyCharacters));
    assertEquals(Arrays.asList(sixtyCharacters, oneHundredTwentyCharacters, "!!!!!!!!!!!!!!!!!!!!                                                                                                    "), editRows.knipProductomschrijving(twoHundredCharacters));
  }
}

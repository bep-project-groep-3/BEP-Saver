package org.nl.hu.sie.bep.business;

import org.junit.jupiter.api.Test;
import org.nl.hu.sie.bep.business.dto.*;
import org.nl.hu.sie.bep.business.filesaving.CreateMockClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RowsTest {

    @Test
    public void testStrings() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("ddMMyy");
        Date date = format.parse("200619");

        FactuurRegelRow factuurRegel = new FactuurRegelRow("Dit is een productomschrijving", 10.0, 12.10, FactuurRegelRow.BtwType.HOOG, date, "euro");
        assertEquals("RDit is een productomschrijving                              0010000001212200619euro  \n", factuurRegel.getText());

        FactuurRegelRow langeFactuurRegel = new FactuurRegelRow("Dit is een productomschrijving                              HalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHaloHalloHalloHalloHallooHalloHallo", 10.0, 12.10, FactuurRegelRow.BtwType.HOOG, date, "euro");
        assertEquals("RDit is een productomschrijving                              0010000001212200619euro  \n" +
                "THalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHaloHalloHalloHalloHalloo\n"
                        + "THalloHallo                                                                                                              \n", langeFactuurRegel.getText());

        List<FactuurRegelRow> listFactuurRegels = new ArrayList<FactuurRegelRow>();
        listFactuurRegels.add(factuurRegel);
        listFactuurRegels.add(factuurRegel);

        FactuurInfoRow factuur = new FactuurInfoRow(date, "12345", listFactuurRegels);
        assertEquals("F20061912345     \nRDit is een productomschrijving                              0010000001212200619euro  \n" +
                "RDit is een productomschrijving                              0010000001212200619euro  \n", factuur.getText());

        List<FactuurInfoRow> listFacturen = new ArrayList<FactuurInfoRow>();
        listFacturen.add(factuur);

        KlantRow klant = new KlantRow("Hans Anders", "Mvr.", "Brigitte", "Le", "Blanc", "Sikkel", "29", "6026DH", "Maarheeze", "12345678", "NL18RABO0011", "123456", listFacturen);
        assertEquals("KHans Anders                             Mvr.  Brigitte            Le     Blanc                                   Sikkel                                                      29        6026DHMaarheeze           12345678     NL18RABO0011                                                    123456    \n" +
                "F20061912345     \nRDit is een productomschrijving                              0010000001212200619euro  \n" +
                "RDit is een productomschrijving                              0010000001212200619euro  \n", klant.getText());

        List<KlantRow> klanten = new ArrayList<KlantRow>();
        klanten.add(klant);

        BedrijfRow bedrijfRow = new BedrijfRow("Bedrijf 1", "Hardenbroek", "84", "3452NJ", "Vleuten", "1234567890123", "NL11RABO12345", "1234567890", klanten);
        assertEquals("BBedrijf 1                                                   Hardenbroek                                                 84        3452NJVleuten             1234567890123NL11RABO12345                                                   1234567890\n" +
                "KHans Anders                             Mvr.  Brigitte            Le     Blanc                                   Sikkel                                                      29        6026DHMaarheeze           12345678     NL18RABO0011                                                    123456    \n" +
                "F20061912345     \nRDit is een productomschrijving                              0010000001212200619euro  \n" +
                "RDit is een productomschrijving                              0010000001212200619euro  \n", bedrijfRow.getText());
    }
}

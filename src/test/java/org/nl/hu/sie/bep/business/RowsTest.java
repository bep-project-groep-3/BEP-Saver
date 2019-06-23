package org.nl.hu.sie.bep.business;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.nl.hu.sie.bep.dto.BedrijfRow;
import org.nl.hu.sie.bep.dto.FactuurInfoRow;
import org.nl.hu.sie.bep.dto.FactuurRow;
import org.nl.hu.sie.bep.dto.KlantRow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RowsTest {

  @Test
  @Disabled
  public void testStrings() throws ParseException {
    SimpleDateFormat format = new SimpleDateFormat("ddMMyy");
    Date date = format.parse("200619");

    FactuurRow factuurRegel = new FactuurRow();
    factuurRegel.setProductOmschrijving("Dit is een productomschrijving");
    factuurRegel.setAantal(10.0);
    factuurRegel.setPrijsPerStuk(12.10);
    factuurRegel.setBtwType(FactuurRow.BtwType.HOOG);
    factuurRegel.setRegelDatum(date);
    factuurRegel.setEenheid("euro");

    assertEquals("RDit is een productomschrijving                              0010000001212200619euro  \n", factuurRegel.getText());

    FactuurRow langeFactuurRegel = new FactuurRow();
    langeFactuurRegel.setProductOmschrijving("Dit is een productomschrijving                              HalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHaloHalloHalloHalloHallooHalloHallo");
    langeFactuurRegel.setAantal(10.0);
    langeFactuurRegel.setPrijsPerStuk(12.10);
    langeFactuurRegel.setBtwType(FactuurRow.BtwType.HOOG);
    langeFactuurRegel.setRegelDatum(date);
    langeFactuurRegel.setEenheid("euro");

    assertEquals("RDit is een productomschrijving                              0010000001212200619euro  \n" +
            "THalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHalloHaloHalloHalloHalloHalloo\n"
            + "THalloHallo                                                                                                              \n", langeFactuurRegel.getText());

    List<FactuurRow> listFactuurRegels = new ArrayList<>();
    listFactuurRegels.add(factuurRegel);
    listFactuurRegels.add(factuurRegel);

    FactuurInfoRow factuur = new FactuurInfoRow();
    factuur.setFactuurdatum(date);
    factuur.setFactuurNummer("12345");
    factuur.setFactuurRegels(listFactuurRegels);

    assertEquals("F20061912345     \nRDit is een productomschrijving                              0010000001212200619euro  \n" +
            "RDit is een productomschrijving                              0010000001212200619euro  \n", factuur.getText());

    List<FactuurInfoRow> listFacturen = new ArrayList<>();
    listFacturen.add(factuur);

    KlantRow klant = new KlantRow();
    klant.setBedrijfsnaam("Hans Anders");
    klant.setAanhef("Mvr.");
    klant.setVoornaam("Brigitte");
    klant.setTussenvoegsel("Le");
    klant.setAchternaam("Blanc");
    klant.setStraat("Sikkel");
    klant.setHuisnummer("29");
    klant.setPlaats("Maarheeze");
    klant.setBtwNummer("12345678");
    klant.setIban("NL18RABO0011");
    klant.setBic("123456");
    klant.setFacturen(listFacturen);

    assertEquals("KHans Anders                             Mvr.  Brigitte            Le     Blanc                                   Sikkel                                                      29        6026DHMaarheeze           12345678     NL18RABO0011                                                    123456    \n" +
            "F20061912345     \nRDit is een productomschrijving                              0010000001212200619euro  \n" +
            "RDit is een productomschrijving                              0010000001212200619euro  \n", klant.getText());

    List<KlantRow> klanten = new ArrayList<>();
    klanten.add(klant);

    BedrijfRow bedrijfRow = new BedrijfRow();
    bedrijfRow.setBedrijfsNaam("Bedrijf 1");
    bedrijfRow.setStraat("Hardenbroek");
    bedrijfRow.setStraatNummer("84");
    bedrijfRow.setPostcode("3452NJ");
    bedrijfRow.setPlaats("Vleuten");
    bedrijfRow.setBtwcode("1234567890123");
    bedrijfRow.setIban("NL11RABO12345");
    bedrijfRow.setBic("1234567890");
    bedrijfRow.setKlanten(klanten);

    assertEquals("BBedrijf 1                                                   Hardenbroek                                                 84        3452NJVleuten             1234567890123NL11RABO12345                                                   1234567890\n" +
            "KHans Anders                             Mvr.  Brigitte            Le     Blanc                                   Sikkel                                                      29        6026DHMaarheeze           12345678     NL18RABO0011                                                    123456    \n" +
            "F20061912345     \nRDit is een productomschrijving                              0010000001212200619euro  \n" +
            "RDit is een productomschrijving                              0010000001212200619euro  \n", bedrijfRow.getText());
  }
}

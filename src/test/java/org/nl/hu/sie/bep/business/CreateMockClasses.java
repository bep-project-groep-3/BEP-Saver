package org.nl.hu.sie.bep.business;

import org.nl.hu.sie.bep.dto.BedrijfRow;
import org.nl.hu.sie.bep.dto.FactuurInfoRow;
import org.nl.hu.sie.bep.dto.FactuurRow;
import org.nl.hu.sie.bep.dto.KlantRow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateMockClasses {

  private CreateMockClasses() {
    //
  }

  public static BedrijfRow createMockClasses() {
    Date date = new Date();

    // klant 1
    FactuurRow factuurRegel1 = new FactuurRow();
    factuurRegel1.setBtwType(FactuurRow.BtwType.HOOG);
    factuurRegel1.setAantal(10.0);
    factuurRegel1.setPrijsPerStuk(12.10);
    factuurRegel1.setRegelDatum(date);
    factuurRegel1.setEenheid("euro");
    factuurRegel1.setProductOmschrijving("Dit is een productomschrijving");
    factuurRegel1.setRegelDatum(date);

    FactuurRow factuurRegel2 = new FactuurRow();
    factuurRegel2.setBtwType(FactuurRow.BtwType.LAAG);
    factuurRegel2.setAantal(10.0);
    factuurRegel2.setPrijsPerStuk(12.10);
    factuurRegel2.setRegelDatum(date);
    factuurRegel2.setEenheid("euro");
    factuurRegel2.setProductOmschrijving("Een productomschrijving");
    factuurRegel2.setRegelDatum(date);

    List<FactuurRow> factuurRegels = new ArrayList<>();
    factuurRegels.add(factuurRegel1);
    factuurRegels.add(factuurRegel2);
    FactuurInfoRow factuur = new FactuurInfoRow();
    factuur.setFactuurdatum(date);
    factuur.setFactuurNummer("12345");
    factuur.setFactuurRegels(factuurRegels);

    List<FactuurInfoRow> facturen = new ArrayList<>();
    facturen.add(factuur);

    KlantRow klant1 = new KlantRow();
    klant1.setBedrijfsnaam("Hans Anders");
    klant1.setAanhef("Mvr.");
    klant1.setVoornaam("Brigitte");
    klant1.setTussenvoegsel("Le");
    klant1.setAchternaam("Blanc");
    klant1.setStraat("Sikkel");
    klant1.setHuisnummer("29");
    klant1.setPostcode("1234AB");
    klant1.setPlaats("Maarheeze");
    klant1.setBtwNummer("12345678");
    klant1.setIban("NL18RABO0011");
    klant1.setBic("123456");
    klant1.setFacturen(facturen);

    List<KlantRow> klanten = new ArrayList<>();
    klanten.add(klant1);

    // klant 2
    FactuurRow factuurRegel3 = new FactuurRow();
    factuurRegel3.setProductOmschrijving("Een korte productomschrijving");
    factuurRegel3.setEenheid("euro");
    factuurRegel3.setPrijsPerStuk(12.10);
    factuurRegel3.setAantal(10.0);
    factuurRegel3.setBtwType(FactuurRow.BtwType.LAAG);
    factuurRegel3.setRegelDatum(date);
    List<FactuurRow> factuurRegels2 = new ArrayList<>();
    factuurRegels2.add(factuurRegel3);

    FactuurInfoRow factuur2 = new FactuurInfoRow();
    factuur2.setFactuurdatum(date);
    factuur2.setFactuurNummer("12377");
    factuur2.setFactuurRegels(factuurRegels2);

    List<FactuurInfoRow> facturen2 = new ArrayList<>();

    facturen2.add(factuur2);
    KlantRow klant2 = new KlantRow();
    klant2.setBedrijfsnaam("Albert Heijn");
    klant2.setAanhef("Dhr.");
    klant2.setVoornaam("Mark");
    klant2.setTussenvoegsel("de");
    klant2.setAchternaam("Wit");
    klant2.setStraat("Sikkel");
    klant2.setHuisnummer("29");
    klant2.setPostcode("1234AB");
    klant2.setPlaats("Maarheeze");
    klant2.setBtwNummer("12345478");
    klant2.setIban("NL18RABO33011");
    klant2.setBic("123455");
    klant2.setFacturen(facturen2);

    klanten.add(klant2);

    BedrijfRow bedrijf = new BedrijfRow();
    bedrijf.setBedrijfsNaam("Bedrijf 1");
    bedrijf.setStraat("Hardenbroek");
    bedrijf.setStraatNummer("84");
    bedrijf.setPostcode("3452NJ");
    bedrijf.setPlaats("Vleuten");
    bedrijf.setBtwcode("1234567890123");
    bedrijf.setIban("NL11RABO12345");
    bedrijf.setBic("1234567890");
    bedrijf.setKlanten(klanten);

    return bedrijf;
  }
}
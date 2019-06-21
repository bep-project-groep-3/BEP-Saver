package org.nl.hu.sie.bep.business.filesaving;

import org.nl.hu.sie.bep.business.dto.*;

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
        FactuurRegelRow factuurRegel1 = new FactuurRegelRow( "Dit is een productomschrijving", 10.0, 12.10, FactuurRegelRow.BtwType.HOOG, date, "euro");
        FactuurRegelRow factuurRegel2 = new FactuurRegelRow( "Een productomschrijving", 10.0, 12.10, FactuurRegelRow.BtwType.LAAG, date, "euro");
        List<FactuurRegelRow> factuurRegels = new ArrayList<>();
        factuurRegels.add(factuurRegel1);
        factuurRegels.add(factuurRegel2);
        FactuurInfoRow factuur = new FactuurInfoRow(date, "12345", factuurRegels);
        List<FactuurInfoRow> facturen = new ArrayList<>();
        facturen.add(factuur);

        KlantRow klant1 = new KlantRow( "Hans Anders", "Mvr.", "Brigitte", "Le", "Blanc", "Sikkel", "29", "6026DH", "Maarheeze", "12345678", "NL18RABO0011", "123456", facturen);
        List<KlantRow> klanten = new ArrayList<>();
        klanten.add(klant1);

        // klant 2
        FactuurRegelRow factuurRegel3 = new FactuurRegelRow( "Een korte productomschrijving", 10.0, 12.10, FactuurRegelRow.BtwType.LAAG, date, "euro");
        List<FactuurRegelRow> factuurRegels2 = new ArrayList<>();
        factuurRegels2.add(factuurRegel3);
        FactuurInfoRow factuur2 = new FactuurInfoRow(date, "12377", factuurRegels2);
        List<FactuurInfoRow> facturen2 = new ArrayList<>();

        facturen2.add(factuur2);
        KlantRow klant2 = new KlantRow( "Albert Heijn", "Dhr.", "Mark", "de", "Wit", "Sikkel", "29", "6026DH", "Maarheeze", "12345478", "NL18RABO33011", "123455", facturen2);
        klanten.add(klant2);

        return new BedrijfRow("Bedrijf 1", "Hardenbroek", "84", "3452NJ", "Vleuten", "1234567890123", "NL11RABO12345", "1234567890", klanten);
    }
}
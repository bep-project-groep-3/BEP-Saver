package org.nl.hu.sie.bep.business.dto;

import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.util.List;

public class KlantRow extends Row {
    private String bedrijfsnaam;
    private String aanhef;
    private String voornaam;
    private String tussenvoegsel;
    private String achternaam;
    private String straat;
    private String huisnummer;
    private String postcode;
    private String plaats;
    private String btwNummer;
    private String iban;
    private String bic;
    private List<FactuurInfoRow> facturen;

    public KlantRow(String bedrijfsnaam, String aanhef, String voornaam, String tussenvoegsel, String achternaam, String straat, String huisnummer, String postcode, String plaats, String btwNummer, String iban, String bic, List<FactuurInfoRow> facturen) {
        super(RowType.KLANT);
        this.bedrijfsnaam = bedrijfsnaam;
        this.aanhef = aanhef;
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.plaats = plaats;
        this.btwNummer = btwNummer;
        this.iban = iban;
        this.bic = bic;
        this.facturen = facturen;
    }

    public List<FactuurInfoRow> getFacturen() {
        return facturen;
    }

    @Override
    public String getText() {
        String klantString = "K" + EditRows.editString(bedrijfsnaam, 40) + EditRows.editString(aanhef, 6) + EditRows.editString(voornaam, 20) + EditRows.editString(tussenvoegsel, 7) + EditRows.editString(achternaam, 40) +
                EditRows.editString(straat, 60) + EditRows.editString(huisnummer, 10) + EditRows.editString(postcode, 6) + EditRows.editString(plaats, 20) + EditRows.editString(btwNummer, 13) + EditRows.editString(iban, 64) + EditRows.editString(bic, 10) + "\n";
        for (FactuurInfoRow factuurInfoRow : facturen) {
            klantString += factuurInfoRow.getText();
        }
        return klantString;
    }
}
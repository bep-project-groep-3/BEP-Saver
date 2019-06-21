package org.nl.hu.sie.bep.business.dto;

import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.util.List;

public class KlantRow implements Row {
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
        super();
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("K");
        stringBuilder.append(EditRows.editString(bedrijfsnaam, 40));
        stringBuilder.append(EditRows.editString(aanhef, 6));
        stringBuilder.append(EditRows.editString(voornaam, 20));
        stringBuilder.append(EditRows.editString(tussenvoegsel, 7));
        stringBuilder.append(EditRows.editString(achternaam, 40));
        stringBuilder.append(EditRows.editString(straat, 60));
        stringBuilder.append(EditRows.editString(huisnummer, 10));
        stringBuilder.append(EditRows.editString(postcode, 6));
        stringBuilder.append(EditRows.editString(plaats, 20));
        stringBuilder.append(EditRows.editString(btwNummer, 13));
        stringBuilder.append(EditRows.editString(iban, 64));
        stringBuilder.append(EditRows.editString(bic, 10));
        stringBuilder.append("\n");

        for (FactuurInfoRow factuurInfoRow : facturen) {
            stringBuilder.append(factuurInfoRow.getText());
        }
        return stringBuilder.toString();
    }
}
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
        StringBuilder bld = new StringBuilder();
        bld.append("K");
        bld.append(EditRows.editString(bedrijfsnaam, 40));
        bld.append(EditRows.editString(aanhef, 6));
        bld.append(EditRows.editString(voornaam, 20));
        bld.append(EditRows.editString(tussenvoegsel, 7));
        bld.append(EditRows.editString(achternaam, 40));
        bld.append(EditRows.editString(straat, 60));
        bld.append(EditRows.editString(huisnummer, 10));
        bld.append(EditRows.editString(postcode, 6));
        bld.append(EditRows.editString(plaats, 20));
        bld.append(EditRows.editString(btwNummer, 13));
        bld.append(EditRows.editString(iban, 64));
        bld.append(EditRows.editString(bic, 10));
        bld.append("\n");

        for (FactuurInfoRow factuurInfoRow : facturen) {
            bld.append(factuurInfoRow.getText());
        }
        return bld.toString();
    }
}
package org.nl.hu.sie.bep.business.dto;

import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.util.List;

public class BedrijfRow implements Row {
    private String bedrijfsNaam;
    private String straat;
    private String straatNummer;
    private String postcode;
    private String plaats;
    private String btwcode;
    private String iban;
    private String bic;
    private List<KlantRow> klanten;


    public BedrijfRow(String bedrijfsNaam, String straat, String straatNummer, String postcode, String plaats, String btwcode, String iban, String bic, List<KlantRow> klanten) {
        super();
        this.bedrijfsNaam = bedrijfsNaam;
        this.straat = straat;
        this.straatNummer = straatNummer;
        this.postcode = postcode;
        this.plaats = plaats;
        this.btwcode = btwcode;
        this.iban = iban;
        this.bic = bic;
        this.klanten = klanten;
    }

    @Override
    public String getText() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("B");
        stringBuilder.append(EditRows.editString(bedrijfsNaam, 60));
        stringBuilder.append(EditRows.editString(straat, 60));
        stringBuilder.append(EditRows.editString(straatNummer, 10));
        stringBuilder.append(EditRows.editString(postcode, 6));
        stringBuilder.append(EditRows.editString(plaats, 20));
        stringBuilder.append(EditRows.editString(btwcode, 13));
        stringBuilder.append(EditRows.editString(iban, 64));
        stringBuilder.append(EditRows.editString(bic, 10));
        stringBuilder.append("\n");

        for (KlantRow klantRow : klanten) {
            stringBuilder.append(klantRow.getText());
        }
        return stringBuilder.toString();
    }
}
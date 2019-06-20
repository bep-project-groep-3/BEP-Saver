package org.nl.hu.sie.bep.business.dto;

import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.util.List;

public class BedrijfRow extends Row {
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
        super(RowType.BEDRIJF);
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
        String bedrijfString = "B" + EditRows.editString(bedrijfsNaam, 60) + EditRows.editString(straat, 60) + EditRows.editString(straatNummer, 10) + EditRows.editString(postcode, 6) + EditRows.editString(plaats, 20) + EditRows.editString(btwcode, 13) + EditRows.editString(iban, 64) + EditRows.editString(bic, 10) + "\n";
        for (KlantRow klantRow : klanten) {
            bedrijfString += klantRow.getText();
        }
        return bedrijfString;
    }
}

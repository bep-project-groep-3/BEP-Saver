package org.nl.hu.sie.bep.business.dto;

import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.util.ArrayList;
import java.util.List;

public class TekstRow extends Row {

    public TekstRow(String productOmschrijving) {
        super(RowType.TEKST);
        this.productOmschrijving = productOmschrijving;
    }

    private String productOmschrijving;

    List<String> regels = new ArrayList<String>();

    @Override
    public String getText() {
        List<String> productOmschrijvingStrings = EditRows.knipProductomschrijving(productOmschrijving);

        for (int i = 1; i < productOmschrijvingStrings.size(); i++) {
            TekstRow row = new TekstRow(productOmschrijvingStrings.get(i));
            regels.add(addMultipleTextRows(row));
        }
        String tekstRegel = "";
        for (String string : regels) {
            tekstRegel += string;
        }
        return tekstRegel;
    }

    public String addMultipleTextRows(TekstRow row) {
        return "T" + row.productOmschrijving + "\n";
    }
}

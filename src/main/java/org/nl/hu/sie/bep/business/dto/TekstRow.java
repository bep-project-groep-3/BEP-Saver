package org.nl.hu.sie.bep.business.dto;

import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.util.ArrayList;
import java.util.List;

public class TekstRow implements Row {

    public TekstRow(String productOmschrijving) {
        super();
        this.productOmschrijving = productOmschrijving;
    }

    private String productOmschrijving;

    @Override
    public String getText() {
        List<String> regels = new ArrayList<>();
        List<String> productOmschrijvingStrings = EditRows.knipProductomschrijving(productOmschrijving);

        for (int i = 1; i < productOmschrijvingStrings.size(); i++) {
            TekstRow row = new TekstRow(productOmschrijvingStrings.get(i));
            regels.add(addMultipleTextRows(row));
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (String string : regels) {

            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    private String addMultipleTextRows(TekstRow row) {
        return "T" + row.productOmschrijving + "\n";
    }
}

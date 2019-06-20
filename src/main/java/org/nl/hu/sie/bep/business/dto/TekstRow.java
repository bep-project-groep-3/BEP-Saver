package org.nl.hu.sie.bep.business.dto;

import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.util.ArrayList;
import java.util.List;

public class TekstRow extends Row{

    public TekstRow(RowType type, String productOmschrijving) {
        super(RowType.TEKST);
        this.productOmschrijving = productOmschrijving;
    }

    private String productOmschrijving;

    List<String> regels;

    @Override
    public String getText() {
        List<String> productOmschrijvingStrings = EditRows.knipProductomschrijving(productOmschrijving);

        for (int i = 1; i < productOmschrijvingStrings.size(); i++) {
            TekstRow row = new TekstRow(RowType.TEKST, productOmschrijvingStrings.get(i));
            regels.add(addMultipleTextRows(row));
        }
        return "";
    }

    public String addMultipleTextRows(TekstRow row) {
        return "T" + row.productOmschrijving + "\r\n";
    }
}

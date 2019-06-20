package org.nl.hu.sie.bep.business.dto;

import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.util.Date;
import java.util.List;

public class FactuurRegelRow extends Row {
    private String productOmschrijving;
    private double aantal;
    private double prijsPerStuk;
    private BtwType btwType;
    private Date regelDatum;
    private String eenheid;

    public enum BtwType {
        GEEN,
        LAAG,
        HOOG
    }

    public FactuurRegelRow(RowType type, String productOmschrijving, double aantal, double prijsPerStuk, BtwType btwType, Date regelDatum, String eenheid) {
        super(RowType.FACTUURREGEL);
        this.productOmschrijving = productOmschrijving;
        this.aantal = aantal;
        this.prijsPerStuk = prijsPerStuk;
        this.btwType = btwType;
        this.regelDatum = regelDatum;
        this.eenheid = eenheid;
    }

    @Override
    public String getText() {
        if (productOmschrijving.length() <= 60) {
            return "R" + EditRows.editString(productOmschrijving, 60) + EditRows.editDouble(aantal, 5) + EditRows.editDouble(prijsPerStuk, 7) + EditRows.editBTWtype(btwType) + EditRows.editDate(regelDatum) + EditRows.editString(eenheid, 6);
        }  // Als lengte groter is dan 60 dan wil ik alleen hierin de eerste string van 60 karakters hebben en de rest in TekstRow
        List<String> productOmschrijvingStrings = EditRows.knipProductomschrijving(productOmschrijving);
        // GetText van textrows
        return "R" + productOmschrijvingStrings.get(0) + EditRows.editDouble(aantal, 5) + EditRows.editDouble(prijsPerStuk, 7) + EditRows.editBTWtype(btwType) + EditRows.editDate(regelDatum) + EditRows.editString(eenheid, 6);
    }
}

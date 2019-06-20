package org.nl.hu.sie.bep.business.dto;

public abstract class Row {
    private RowType type;

    public Row(RowType type) {
        this.type = type;
    }

    public enum RowType {
        BEDRIJF,
        KLANT,
        FACTUUR,
        FACTUURREGEL,
        TEKST
    }

    public abstract String getText();
}

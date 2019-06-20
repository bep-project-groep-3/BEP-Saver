package org.nl.hu.sie.bep.business.dto;

import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.util.Date;
import java.util.List;

public class FactuurInfoRow extends Row{
    private Date factuurdatum;
    private String factuurNummer;
    private List<FactuurRegelRow> factuurRegels;

    public FactuurInfoRow(RowType type, Date factuurdatum, String factuurNummer, List<FactuurRegelRow> factuurRegels) {
        super(RowType.FACTUUR);
        this.factuurdatum = factuurdatum;
        this.factuurNummer = factuurNummer;
        this.factuurRegels = factuurRegels;
    }

    @Override
    public String getText() {
        return "F" + EditRows.editDate(factuurdatum) + EditRows.editString(factuurNummer, 10);
    }
}

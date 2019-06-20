package org.nl.hu.sie.bep.business.dto;

import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.util.Date;
import java.util.List;

public class FactuurInfoRow extends Row{
    private Date factuurdatum;
    private String factuurNummer;
    private List<FactuurRegelRow> factuurRegels;

    public FactuurInfoRow(Date factuurdatum, String factuurNummer, List<FactuurRegelRow> factuurRegels) {
        super(RowType.FACTUUR);
        this.factuurdatum = factuurdatum;
        this.factuurNummer = factuurNummer;
        this.factuurRegels = factuurRegels;
    }

    public List<FactuurRegelRow> getFactuurRegels() {
        return factuurRegels;
    }

    @Override
    public String getText() {
        String factuurInfoString = "F" + EditRows.editDate(factuurdatum) + EditRows.editString(factuurNummer, 10) + "\n";
        for (FactuurRegelRow factuurRegelRow : factuurRegels){
            factuurInfoString += factuurRegelRow.getText();
        }
        return factuurInfoString;
    }
}

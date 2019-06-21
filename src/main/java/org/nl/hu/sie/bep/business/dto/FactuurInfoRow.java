package org.nl.hu.sie.bep.business.dto;

import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.util.Date;
import java.util.List;

public class FactuurInfoRow implements Row{
    private Date factuurdatum;
    private String factuurNummer;
    private List<FactuurRegelRow> factuurRegels;

    public FactuurInfoRow(Date factuurdatum, String factuurNummer, List<FactuurRegelRow> factuurRegels) {
        super();
        this.factuurdatum = factuurdatum;
        this.factuurNummer = factuurNummer;
        this.factuurRegels = factuurRegels;
    }

    public List<FactuurRegelRow> getFactuurRegels() {
        return factuurRegels;
    }

    @Override
    public String getText() {
        StringBuilder bld = new StringBuilder();
        bld.append("F");
        bld.append(EditRows.editDate(factuurdatum));
        bld.append(EditRows.editString(factuurNummer, 10));
        bld.append("\n");

        for (FactuurRegelRow factuurRegelRow : factuurRegels){
            bld.append(factuurRegelRow.getText());
        }
        return bld.toString();
    }
}

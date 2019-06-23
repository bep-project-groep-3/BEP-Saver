package org.nl.hu.sie.bep.business.dto;

import org.nl.hu.sie.bep.business.filesaving.EditRows;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FactuurRegelRow implements Row {
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

  public FactuurRegelRow(String productOmschrijving, double aantal, double prijsPerStuk, BtwType btwType, Date regelDatum, String eenheid) {
    super();
    this.productOmschrijving = productOmschrijving;
    this.aantal = aantal;
    this.prijsPerStuk = prijsPerStuk;
    this.btwType = btwType;
    this.regelDatum = regelDatum;
    this.eenheid = eenheid;
  }

  @Override
  public String getText() {
    StringBuilder stringBuilder = new StringBuilder();
    //stringBuilder.append("R" + EditRows.editString(productOmschrijving, 60) + EditRows.editDouble(aantal, 5) + EditRows.editDouble(prijsPerStuk, 7) + EditRows.editBTWtype(btwType) + EditRows.editDate(regelDatum) + EditRows.editString(eenheid, 6) + "\n");
    if (productOmschrijving.length() <= 60) {
      return stringBuilder.toString();
    }

    stringBuilder.append(getTextRows(productOmschrijving));
    return stringBuilder.toString();
  }

  public String getTextRows(String productOmschrijving) {
    List<String> regels = new ArrayList<>();
    List<String> productOmschrijvingStrings = EditRows.knipProductomschrijving(productOmschrijving);

    for (int i = 1; i < productOmschrijvingStrings.size(); i++) {
      regels.add(addMultipleTextRows(productOmschrijvingStrings.get(i)));
    }
    StringBuilder stringBuilder = new StringBuilder();

    for (String string : regels) {

      stringBuilder.append(string);
    }
    return stringBuilder.toString();
  }

  private String addMultipleTextRows(String row) {
    return "T" + row + "\n";
  }

}

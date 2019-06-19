package org.nl.hu.sie.bep.business.filesaving;

import org.nl.hu.sie.bep.business.dto.FactuurRow;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EditRows {

    public String editBTWtype(FactuurRow.BtwType btwType) {
        switch (btwType) {
            case GEEN:
                return "0";
            case LAAG:
                return "1";
            case HOOG:
                return "2";
            default:
                return " ";
        }
    }

    public String editDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    public List<String> knipProductomschrijving(String productOmschrijving) {
        List<String> listProductomschrijving = new ArrayList<String>();
        if (productOmschrijving.length() <= 60) {
            listProductomschrijving.add(editString(productOmschrijving, 60));
            return listProductomschrijving;
        }

        listProductomschrijving.add(productOmschrijving.substring(0, 60));
        String overgeblevenString = productOmschrijving.substring(60);

        while (overgeblevenString.length() > 120) {
            String regel = overgeblevenString.substring(0, 120);
            listProductomschrijving.add(regel);
            overgeblevenString = overgeblevenString.substring(120);
        }

        listProductomschrijving.add(editString(overgeblevenString, 120));
        return listProductomschrijving;
    }

    public String editString(String inputString, int length) {
        StringBuilder sb = new StringBuilder();
        if (inputString.length() > length) {
            return truncate(inputString, length);
        }

        if (inputString.length() == length) {
            return inputString;
        }

        sb.append(inputString);
        while (sb.length() < length) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public String editDouble(Double amount, int length) {
        if (amount.toString().startsWith("-")) {
            return editNegativeDouble(amount, length);
        }
        return editPositiveDouble(amount, length);
    }

    public String editPositiveDouble(Double amount, int length) {
        String amountWithoutComma = Double.toString(amount).replace(".", "");
        StringBuilder sb = new StringBuilder();

        if (amountWithoutComma.length() > length) {
            return truncate(amountWithoutComma, length);
        }

        if (amountWithoutComma.length() == length) {
            return amountWithoutComma;
        }

        while (sb.length() < (length - amountWithoutComma.length())) {
            sb.append("0");
        }
        sb.append(amountWithoutComma);
        return sb.toString();
    }

    public String editNegativeDouble(Double amount, int length) {
        String withoutCommaNegativeSign = Double.toString(amount).replace(".", "").replace("-", "");

        StringBuilder sb = new StringBuilder();

        if (withoutCommaNegativeSign.length() > length) {
            String verkort = truncate(withoutCommaNegativeSign, length);
            sb.append(negativeNumberSymbol(verkort.charAt(0)));
            sb.append(verkort.substring(1));
            return sb.toString();
        }

        if (withoutCommaNegativeSign.length() == length) {
            sb.append(negativeNumberSymbol(withoutCommaNegativeSign.charAt(0)));
            sb.append(withoutCommaNegativeSign.substring(1));
            return sb.toString();
        }

        sb.append(" ");
        while (sb.length() < (length - withoutCommaNegativeSign.length())) {
            sb.append("0");
        }
        sb.append(withoutCommaNegativeSign);
        return sb.toString();
    }

    public String negativeNumberSymbol(char number) {
        switch (number) {
            case '0':
                return " ";
            case '1':
                return "!";
            case '2':
                return "“";
            case '3':
                return "#";
            case '4':
                return "$";
            case '5':
                return "%";
            case '6':
                return "&";
            case '7':
                return "\\";
            case '8':
                return "(";
            case '9':
                return ")";
            default:
                return " ";
        }
    }

    public String truncate(String inputString, int length) {
        return inputString.substring(0, length);
    }
}

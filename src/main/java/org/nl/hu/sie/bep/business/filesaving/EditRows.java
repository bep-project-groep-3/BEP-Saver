package org.nl.hu.sie.bep.business.filesaving;

public class EditRows {

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
        } return editPositiveDouble(amount, length);
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

    public String negativeNumberSymbol(Character number) {
        if (number.equals('0')){
            return " ";
        }

        if (number.equals('1')){
            return "!";
        }

        if (number.equals('2')){
            return "“";
        }

        if (number.equals('3')){
            return "#";
        }

        if (number.equals('4')){
            return "$";
        }

        if (number.equals('5')){
            return "%";
        }

        if (number.equals('6')){
            return "&";
        }

        if (number.equals('7')){
            return "\\";
        }

        if (number.equals('8')){
            return "(";
        }

        if (number.equals('9')){
            return ")";
        }
        return "";
    }

    public String truncate(String inputString, int length) {
        return inputString.substring(0, length);
    }
}

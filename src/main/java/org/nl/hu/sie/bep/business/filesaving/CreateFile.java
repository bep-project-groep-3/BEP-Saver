package org.nl.hu.sie.bep.business.filesaving;

import org.nl.hu.sie.bep.business.dto.BedrijfRow;
import org.nl.hu.sie.bep.business.exceptions.FileCreateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormatSymbols;

public class CreateFile {

    private static final Logger logger = LoggerFactory.getLogger(CreateFile.class);

    public static String getMonthName(int monthIndex) {
        return new DateFormatSymbols().getMonths()[monthIndex - 1];
    }

    public static void createFile(int maand, BedrijfRow bedrijfRow) throws FileCreateException{
        if (maand < 0 || maand > 11) {
            System.out.println("Er is geen geldige maand ingevuld");
            return;
        }

        String maandString = getMonthName(maand);

        try {
            File file = new File(maandString + ".txt");

            if (!file.exists() && !file.createNewFile()) {
                logger.warn("Het is niet gelukt om een bestand aan te maken");
            }

            try (PrintWriter pw = new PrintWriter(file)) {

                pw.println(bedrijfRow.getText());
                pw.flush();
            }

            logger.info("File is gemaakt");
            logger.info("File locatie: " + file.getAbsolutePath());

        } catch (
                IOException e) {
            throw new FileCreateException("Lukt niet om een bestand aan te maken", e);
        }
    }
}
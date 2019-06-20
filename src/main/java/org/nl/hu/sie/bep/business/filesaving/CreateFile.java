package org.nl.hu.sie.bep.business.filesaving;

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

    public static void main(String[] args) throws FileCreateException {

        if (args.length == 0) {
            System.out.println("Er is geen maand ingevuld");
            return;
        }

        String maand = getMonthName(Integer.parseInt(args[0]));

        try {
            File file = new File("C:\\Users\\Brigitte\\Desktop\\Files\\factuurgegevens " + maand + ".txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            try (PrintWriter pw = new PrintWriter(file)) {

                pw.println(CreateMockClasses.createMockClasses().getText());
                pw.flush();
            }

            logger.info("File is gemaakt");

        } catch (
                IOException e) {
            throw new FileCreateException("Lukt niet om een bestand aan te maken", e);
        }
    }
}
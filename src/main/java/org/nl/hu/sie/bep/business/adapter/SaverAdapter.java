package org.nl.hu.sie.bep.business.adapter;

import org.nl.hu.sie.bep.business.exceptions.FileCreateException;
import org.nl.hu.sie.bep.business.filesaving.CreateFile;
import org.nl.hu.sie.bep.dto.BedrijfRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaverAdapter implements Adapter {

  private static Logger logger = LoggerFactory.getLogger(SaverAdapter.class);

  public void save(int maand, BedrijfRow bedrijfRow) {
    try {
      CreateFile.createFile(maand, bedrijfRow);
    } catch (FileCreateException e) {
      logger.info("Something went wrong, please try again.");
    }
  }
}
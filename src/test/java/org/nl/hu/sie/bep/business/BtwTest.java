package org.nl.hu.sie.bep.business;

import org.junit.jupiter.api.Test;
import org.nl.hu.sie.bep.business.filesaving.EditRows;
import org.nl.hu.sie.bep.dto.FactuurRow;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class BtwTest {
  @Test
  public void test() throws ParseException {

    EditRows editRows = new EditRows();

    assertEquals("0", editRows.editBTWtype(FactuurRow.BtwType.GEEN));
    assertEquals("1", editRows.editBTWtype(FactuurRow.BtwType.LAAG));
    assertEquals("2", editRows.editBTWtype(FactuurRow.BtwType.HOOG));

  }
}

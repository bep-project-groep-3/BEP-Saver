package org.nl.hu.sie.bep.business;

import org.junit.jupiter.api.Test;
import org.nl.hu.sie.bep.business.exceptions.FileCreateException;
import org.nl.hu.sie.bep.business.filesaving.CreateFile;

public class CreateFileTest {

    @Test
    public void test() throws FileCreateException {
       CreateFile.createFile(8, CreateMockClasses.createMockClasses());
    }
}

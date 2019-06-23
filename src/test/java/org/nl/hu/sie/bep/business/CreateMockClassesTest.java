package org.nl.hu.sie.bep.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateMockClassesTest {

    @Test
    public void testCreateMockClasses() {
        // Setup
        final String expectedResult = CreateMockClasses.createMockClasses().getText();

        // Run the test
        final String result = CreateMockClasses.createMockClasses().getText();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}

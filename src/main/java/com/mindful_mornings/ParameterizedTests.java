package com.mindful_mornings;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
@Category(ParameterizedTests.class)
public class ParameterizedTests {

    private ConsoleMindfulMornings app;
    private String inputOption;
    private String expectedResult;

    public ParameterizedTests(String inputOption, String expectedResult) {
        this.inputOption = inputOption;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "1", "Morning Routine" },
                { "2", "Main Menu" },
                { "invalid", "Main Menu" }
        });
    }

    @Before
    public void setUp() {
        app = new ConsoleMindfulMornings();
    }

    @Test
    public void testHandleMainMenu() {
        app.handleMainMenu(inputOption);
        assertEquals(expectedResult, app.getCurrentMenu());
    }

    // Add more parameterized tests for other methods
}

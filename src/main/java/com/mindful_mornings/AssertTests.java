package com.mindful_mornings;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.experimental.categories.Category;

@Category(AssertTests.class)
public class AssertTests {
    @Test
    public void testHandleMainMenu_ValidOption() {
        ConsoleMindfulMornings app = new ConsoleMindfulMornings();
        app.handleMainMenu("1");
        assertEquals("Morning Routine", app.getCurrentMenu());
    }

    @Test
    public void testHandleMainMenu_InvalidOption() {
        ConsoleMindfulMornings app = new ConsoleMindfulMornings();
        app.handleMainMenu("invalid");
        assertEquals("Main Menu", app.getCurrentMenu());
    }

    @Test
    public void testHandleMorningRoutineMenu_ValidOption() {
        ConsoleMindfulMornings app = new ConsoleMindfulMornings();
        app.setCurrentMenu("Morning Routine");
        app.handleMorningRoutineMenu("task1");
        assertEquals("task1", app.getMorningRoutine().get(0));
    }

    @Test
    public void testHandleMorningRoutineMenu_InvalidOption() {
        ConsoleMindfulMornings app = new ConsoleMindfulMornings();
        app.setCurrentMenu("Morning Routine");
        app.handleMorningRoutineMenu("");
        assertTrue(app.getMorningRoutine().isEmpty());
    }

    @Test
    public void testStartMeditationSession() {
        // This test checks if the meditation session starts without errors.
        ConsoleMindfulMornings app = new ConsoleMindfulMornings();
        app.startMeditationSession();
        // No assertion is made as it's a console output-based method.
    }

    @Test
    public void testRecordGratitudeEntry() {
        ConsoleMindfulMornings app = new ConsoleMindfulMornings();
        app.recordGratitudeEntry("Feeling grateful for nature.");
        assertEquals("Feeling grateful for nature.", app.getGratitudeEntries().get(0));
    }

    // Add more black box tests for Equivalence Partitioning, Boundary Value Analysis, Pairwise Testing
}

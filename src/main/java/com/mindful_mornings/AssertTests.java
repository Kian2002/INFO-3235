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

   //black box testing
    //Tests Ranges from 6 to 100 if the user enters anything from these ranges it shows invalid 
    @Test
    public void testHandleMainMenu_InvalidNumericOption() {
        ConsoleMindfulMornings app = new ConsoleMindfulMornings();
        for (int i = 6; i <= 100; i++) { // This tests 6 to 100
            app.handleMainMenu(String.valueOf(i));
            assertEquals("For input " + i + ", expected 'Main Menu' to show invalid option handling.", 
                         "Main Menu", app.getCurrentMenu());
            }
        }
    
    //black box testing 
    // made a specific case for the numeral value 0 
    @Test
    public void testHandleMainMenu_InvalidNumericOption0() {
        ConsoleMindfulMornings app = new ConsoleMindfulMornings();
        app.handleMainMenu("0"); // 
        assertEquals("Main Menu", app.getCurrentMenu());
    }
    
    //Black Box testing 
    //If Empty String option is provided invalid 
    @Test
    public void testHandleMainMenu_EmptyStringOption() {
        ConsoleMindfulMornings app = new ConsoleMindfulMornings();
        app.handleMainMenu("");
        assertEquals("Main Menu", app.getCurrentMenu());
    }
    
    
    //Black Box Testing 
    //If negative number's entered ranging from -1 to -100 Prompt Invalid Option 
    public void testHandleMainMenu_InvalidNegativeNumericOption() {
        ConsoleMindfulMornings app = new ConsoleMindfulMornings();
        for (int i = -1; i <= -100; i++) { // This tests -1 to -100 
            app.handleMainMenu(String.valueOf(i));
            assertEquals("For input " + i + ", expected 'Main Menu' to show invalid option handling.", 
                         "Main Menu", app.getCurrentMenu());
            }
        }
}

package com.mindful_mornings;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.experimental.categories.Category;

@Category(ExceptionHandlingTests.class)
public class ExceptionHandlingTests {
    @Test
    public void testRecordGratitudeEntry_WithNullEntry() {
        ConsoleMindfulMornings app = new ConsoleMindfulMornings();
        assertThrows(NullPointerException.class, () -> app.recordGratitudeEntry(null));
    }

    @Test
    public void testRecordGratitudeEntry_WithEmptyEntry() {
        ConsoleMindfulMornings app = new ConsoleMindfulMornings();
        assertThrows(IllegalArgumentException.class, () -> app.recordGratitudeEntry(""));
    }
}


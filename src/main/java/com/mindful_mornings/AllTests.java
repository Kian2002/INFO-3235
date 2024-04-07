package com.mindful_mornings;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AssertTests.class,
        ParameterizedTests.class,
        ExceptionHandlingTests.class
})
public class AllTests {
}


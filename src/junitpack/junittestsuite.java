package junitpack;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ OnlySaveTestCase.class, EditTestCase.class, DeleteTestCase.class, SaveAndFinishTestCase.class })

public class junittestsuite {

}

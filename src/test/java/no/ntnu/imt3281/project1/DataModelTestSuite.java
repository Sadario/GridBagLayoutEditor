/**
 * 
 */
package no.ntnu.imt3281.project1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author oivindk
 * 
 *         Run this test to test the complete data model for this project. It
 *         will test the classes used for the different components as well as
 *         the model itself.
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ BaseComponentTest.class, ButtonTest.class,
        LabelTest.class, TextFieldTest.class, TextAreaTest.class,
        GBLEDataModelTest.class })

public class DataModelTestSuite {

}

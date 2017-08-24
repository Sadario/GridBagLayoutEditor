/**
 * 
 */
package no.ntnu.imt3281.project1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.Serializable;

import org.junit.Test;

/**
 * @author oivindk
 * 
 *         This class will test the BaseComponent class. The BaseComponent class
 *         is the class that all other components inherits from. It contains
 *         basic properties that is common for all components.
 */
public class BaseComponentTest {

    @Test
    public void testBaseComponent() {
    	// nextComponentID is a static member in BaseComponent. Need to reset it to 
    	// 1 (one) because we do not know in what order the tests is executed.
    	BaseComponent.nextComponentID = 1;
        BaseComponent component = new BaseComponent();
        assertTrue (component instanceof Serializable);
        // variable names should contain a suffix starting with
        // the number "1" and then increment with "1" for each
        // component created
        assertEquals("component1", component.getVariableName());
        BaseComponent component2 = new BaseComponent();
        assertEquals("component2", component2.getVariableName());

        // Default text for components is an empty string
        assertEquals("", component.getText());

        // Components as default has no special editor
        assertEquals(null, component.getSpecialEditor());

        // All components should as default be placed at row/column 1
        assertEquals(1, component.getRow(), 0);
        assertEquals(1, component.getCol(), 0);

        // All components should as default span 1 row/column
        assertEquals(1, component.getCols(), 0);
        assertEquals(1, component.getRows(), 0);

        // All components should have CENTER as default anchor
        assertEquals(java.awt.GridBagConstraints.CENTER, component.getAnchor());

        // All componenst should have NONE as default fill
        assertEquals(java.awt.GridBagConstraints.NONE, component.getFill());

        component.setText("Test");
        component.setVariableName("myVariable");
        component.setCol(2);
        component.setRow(3);
        component.setCols(4);
        component.setRows(5);
        component.setAnchor(6);
        component.setFill(7);

        // When creating a component based on another component
        // all values, including variable name, should be copied
        // to the new component
        BaseComponent component3 = new BaseComponent(component);
        assertEquals("myVariable", component3.getVariableName());
        assertEquals("Test", component3.getText());
        assertEquals(2, component3.getCol(), 0);
        assertEquals(3, component3.getRow(), 0);
        assertEquals(4, component3.getCols(), 0);
        assertEquals(5, component3.getRows(), 0);
        assertEquals(6, component3.getAnchor(), 0);
        assertEquals(7, component3.getFill(), 0);
    }

    @Test
    public void testTextFieldCodeCreation() {
    	// nextComponentID is a static member in BaseComponent. Need to reset it to 
    	// 1 (one) because we do not know in what order the tests is executed.
    	BaseComponent.nextComponentID = 1;
        BaseComponent component = new BaseComponent();
        component.setText("Test");
        component.setCol(2);
        component.setRow(3);
        component.setCols(4);
        component.setRows(5);
        component.setAnchor(6);
        component.setFill(7);

        // This is the code that is to be placed in the constructor
        // of the generated class
        String layoutCode = "\t\tgbc.gridx = 2;\n" + "\t\tgbc.gridy = 3;\n"
                + "\t\tgbc.gridwidth = 4;\n" + "\t\tgbc.gridheight = 5;\n"
                + "\t\tgbc.anchor = 6;\n" + "\t\tgbc.fill = 7;\n"
                + "\t\tlayout.setConstraints(component1, gbc);\n"
                + "\t\tadd(component1);\n";
        assertEquals(layoutCode, component.getLayoutCode());
    }

}

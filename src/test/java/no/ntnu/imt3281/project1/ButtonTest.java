/**
 * 
 */
package no.ntnu.imt3281.project1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author oivindk
 *
 *         This class tests the Button component. It inherits from BaseComponent
 *         and is used to represent a JButton component in the model.
 */
public class ButtonTest {

    @Test
    public void testButton() {
    	// nextComponentID is a static member in BaseComponent. Need to reset it to 
    	// 1 (one) because we do not know in what order the tests is executed.
    	BaseComponent.nextComponentID = 1;

        Button button = new Button();
        assertEquals("component1", button.getVariableName());
        assertTrue(button instanceof BaseComponent);
        assertEquals(null, button.getSpecialEditor());

        button.setText("Test");
        button.setCol(2);
        button.setRow(3);
        button.setCols(4);
        button.setRows(5);

        // Creating a button based on a component should be the same
        // as creating a component based on a component
        BaseComponent component = new BaseComponent(button);
        Button button2 = new Button(component);

        assertEquals("component1", button2.getVariableName());
        assertEquals("Test", button2.getText());
        assertEquals(2, button2.getCol(), 0);
        assertEquals(3, button2.getRow(), 0);
        assertEquals(4, button2.getCols(), 0);
        assertEquals(5, button2.getRows(), 0);
    }

    @Test
    public void testButtonCodeCreation() {
    	// nextComponentID is a static member in BaseComponent. Need to reset it to 
    	// 1 (one) because we do not know in what order the tests is executed.
    	BaseComponent.nextComponentID = 1;

        Button button = new Button();
        button.setText("Test");
        button.setCol(2);
        button.setRow(3);
        button.setCols(4);
        button.setRows(5);
        button.setAnchor(6);
        button.setFill(7);

        // This is the code that is to be placed at class level for
        // this component
        String definition = "\tJButton component1 = new JButton(\"Test\");\n";
        assertEquals(definition, button.getDefinition());

        // This is the code that is to be placed in the constructor
        // of the generated class
        String layoutCode = "\t\tgbc.gridx = 2;\n" + "\t\tgbc.gridy = 3;\n"
                + "\t\tgbc.gridwidth = 4;\n" + "\t\tgbc.gridheight = 5;\n"
                + "\t\tgbc.anchor = 6;\n" + "\t\tgbc.fill = 7;\n"
                + "\t\tlayout.setConstraints(component1, gbc);\n"
                + "\t\tadd(component1);\n";
        assertEquals(layoutCode, button.getLayoutCode());
    }
}

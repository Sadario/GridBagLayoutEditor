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
 *         This class tests the TextField component. It inherits from
 *         BaseComponent and is used to represent a JTextField component in the
 *         model.
 */
public class TextFieldTest {

    @Test
    public void testTextField() {
    	// nextComponentID is a static member in BaseComponent. Need to reset it to 
    	// 1 (one) because we do not know in what order the tests is executed.
    	BaseComponent.nextComponentID = 1;

        TextField textField = new TextField();
        assertEquals("component1", textField.getVariableName());
        assertTrue(textField instanceof BaseComponent);
        assertTrue(textField.getSpecialEditor() instanceof java.awt.Component);
        textField.setWidth(12);
        assertEquals(12, textField.getWidth(), 0);

        textField.setText("Test");
        textField.setCol(2);
        textField.setRow(3);
        textField.setCols(4);
        textField.setRows(5);

        // Creating a button based on a component should be the same
        // as creating a component based on a component
        BaseComponent component = new BaseComponent(textField);
        TextField textField2 = new TextField(component);

        assertEquals("component1", textField2.getVariableName());
        assertEquals("Test", textField2.getText());
        assertEquals(2, textField2.getCol(), 0);
        assertEquals(3, textField2.getRow(), 0);
        assertEquals(4, textField2.getCols(), 0);
        assertEquals(5, textField2.getRows(), 0);
    }

    @Test
    public void testTextFieldCodeCreation() {
    	// nextComponentID is a static member in BaseComponent. Need to reset it to 
    	// 1 (one) because we do not know in what order the tests is executed.
    	BaseComponent.nextComponentID = 1;

        TextField textField = new TextField();
        textField.setText("Test");
        textField.setCol(2);
        textField.setRow(3);
        textField.setCols(4);
        textField.setRows(5);
        textField.setAnchor(6);
        textField.setFill(7);
        textField.setWidth(12);

        // This is the code that is to be placed at class level for
        // this component
        String definition = "\tJTextField component1 = new JTextField(\"Test\", 12);\n";
        assertEquals(definition, textField.getDefinition());

        // This is the code that is to be placed in the constructor
        // of the generated class
        String layoutCode = "\t\tgbc.gridx = 2;\n" + "\t\tgbc.gridy = 3;\n"
                + "\t\tgbc.gridwidth = 4;\n" + "\t\tgbc.gridheight = 5;\n"
                + "\t\tgbc.anchor = 6;\n" + "\t\tgbc.fill = 7;\n"
                + "\t\tlayout.setConstraints(component1, gbc);\n"
                + "\t\tadd(component1);\n";
        assertEquals(layoutCode, textField.getLayoutCode());
    }
}

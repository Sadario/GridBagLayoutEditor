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
 *         This class tests the TextArea component. It inherits from
 *         BaseComponent and is used to represent a JTextArea component in the
 *         model.
 */
public class TextAreaTest {

    @Test
    public void testTextArea() {
    	// nextComponentID is a static member in BaseComponent. Need to reset it to 
    	// 1 (one) because we do not know in what order the tests is executed.
    	BaseComponent.nextComponentID = 1;

        TextArea textArea = new TextArea();
        assertEquals("component1", textArea.getVariableName());
        assertTrue(textArea instanceof BaseComponent);
        assertTrue(textArea.getSpecialEditor() instanceof java.awt.Component);

        textArea.setText("Test");
        textArea.setCol(2);
        textArea.setRow(3);
        textArea.setCols(4);
        textArea.setRows(5);

        // Creating a button based on a component should be the same
        // as creating a component based on a component
        BaseComponent component = new BaseComponent(textArea);
        TextArea textArea2 = new TextArea(component);

        assertEquals("component1", textArea2.getVariableName());
        assertEquals("Test", textArea2.getText());
        assertEquals(2, textArea2.getCol(), 0);
        assertEquals(3, textArea2.getRow(), 0);
        assertEquals(4, textArea2.getCols(), 0);
        assertEquals(5, textArea2.getRows(), 0);
    }

    @Test
    public void testTextAreaCodeCreation() {
    	// nextComponentID is a static member in BaseComponent. Need to reset it to 
    	// 1 (one) because we do not know in what order the tests is executed.
    	BaseComponent.nextComponentID = 1;

        TextArea textArea = new TextArea();
        textArea.setText("Test");
        textArea.setCol(2);
        textArea.setRow(3);
        textArea.setCols(4);
        textArea.setRows(5);
        textArea.setAnchor(6);
        textArea.setFill(7);
        textArea.setTextRows(12);
        textArea.setTextCols(42);
        textArea.setWrap(true);

        // This is the code that is to be placed at class level for
        // this component
        String definition = "\tJTextArea component1 = new JTextArea(\"Test\", 12, 42);\n";
        assertEquals(definition, textArea.getDefinition());

        // This is the code that is to be placed in the constructor
        // of the generated class
        // Note the component1.setWrap(true); line, default for wrapping
        // is false
        String layoutCode = "\t\tgbc.gridx = 2;\n" + "\t\tgbc.gridy = 3;\n"
                + "\t\tgbc.gridwidth = 4;\n" + "\t\tgbc.gridheight = 5;\n"
                + "\t\tgbc.anchor = 6;\n" + "\t\tgbc.fill = 7;\n"
                + "\t\tlayout.setConstraints(component1, gbc);\n"
                + "\t\tadd(component1);\n" + "\t\tcomponent1.setWrapStyleWord(true);\n";
        assertEquals(layoutCode, textArea.getLayoutCode());
    }
}

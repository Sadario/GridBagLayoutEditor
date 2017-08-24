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
 *         This class tests the Label component. It inherits from BaseComponent
 *         and is used to represent a JLabel component in the model.
 */
public class LabelTest {

    @Test
    public void testLabel() {
    	// nextComponentID is a static member in BaseComponent. Need to reset it to 
    	// 1 (one) because we do not know in what order the tests is executed.
    	BaseComponent.nextComponentID = 1;

        Label label = new Label();
        assertEquals("component1", label.getVariableName());
        assertTrue(label instanceof BaseComponent);
        assertEquals(null, label.getSpecialEditor());

        label.setText("Test");
        label.setCol(2);
        label.setRow(3);
        label.setCols(4);
        label.setRows(5);

        // Creating a button based on a component should be the same
        // as creating a component based on a component
        BaseComponent component = new BaseComponent(label);
        Label label2 = new Label(component);

        assertEquals("component1", label2.getVariableName());
        assertEquals("Test", label2.getText());
        assertEquals(2, label2.getCol(), 0);
        assertEquals(3, label2.getRow(), 0);
        assertEquals(4, label2.getCols(), 0);
        assertEquals(5, label2.getRows(), 0);
    }

    @Test
    public void testButtonCodeCreation() {
    	// nextComponentID is a static member in BaseComponent. Need to reset it to 
    	// 1 (one) because we do not know in what order the tests is executed.
    	BaseComponent.nextComponentID = 1;
    	
    	Label label = new Label();
        label.setText("Test");
        label.setCol(2);
        label.setRow(3);
        label.setCols(4);
        label.setRows(5);
        label.setAnchor(6);
        label.setFill(7);

        // This is the code that is to be placed at class level for
        // this component
        String definition = "\tJLabel component1 = new JLabel(\"Test\");\n";
        assertEquals(definition, label.getDefinition());

        // This is the code that is to be placed in the constructor
        // of the generated class
        String layoutCode = "\t\tgbc.gridx = 2;\n" + "\t\tgbc.gridy = 3;\n"
                + "\t\tgbc.gridwidth = 4;\n" + "\t\tgbc.gridheight = 5;\n"
                + "\t\tgbc.anchor = 6;\n" + "\t\tgbc.fill = 7;\n"
                + "\t\tlayout.setConstraints(component1, gbc);\n"
                + "\t\tadd(component1);\n";
        assertEquals(layoutCode, label.getLayoutCode());
    }
}

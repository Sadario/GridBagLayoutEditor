package no.ntnu.imt3281.project1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import org.junit.Test;

/**
 * @author oivindk
 *
 *         This class tests the GBLEDataModel. This model provides data for the
 *         JTable which acts as the view of our application. The model can be
 *         saved to and loaded from a file and the definitions and layout code
 *         for all components can be extracted as separate strings.
 * 
 */
public class GBLEDataModelTest {

    /**
     * Testing basics of GBLEDataModel, i.e. correct initialization of the
     * model. Also checks that the column names are correct.
     */
    @Test
    public void testGBLEDataModel() {
        GBLEDataModel dataModel = new GBLEDataModel();

        // GBLEDataModel should inherit from AbstractTableModel
        assertTrue(dataModel instanceof javax.swing.table.AbstractTableModel);

        // Newly created data model should contain 0 rows
        assertEquals(0, dataModel.getRowCount(), 0);

        // Data model should have nine columns
        assertEquals(9, dataModel.getColumnCount(), 0);
        // The names of the columns (assuming default (English) language)
        assertEquals("Component type", dataModel.getColumnName(0));
        assertEquals("Variable name", dataModel.getColumnName(1));
        assertEquals("Text", dataModel.getColumnName(2));
        assertEquals("Row", dataModel.getColumnName(3));
        assertEquals("Column", dataModel.getColumnName(4));
        assertEquals("Rows", dataModel.getColumnName(5));
        assertEquals("Columns", dataModel.getColumnName(6));
        assertEquals("Anchor", dataModel.getColumnName(7));
        assertEquals("Fill", dataModel.getColumnName(8));
    }

    /**
     * Checks adding and removing of components. Also checks getValueAt method.
     */
    @Test
    public void testAddRemoveComponent() {
        GBLEDataModel dataModel = new GBLEDataModel();
        Label label = new Label();
        label.setText("Test");
        label.setRow(5);
        label.setCol(6);
        label.setRows(7);
        label.setCols(8);
        label.setAnchor(9);
        label.setFill(10);
        dataModel.addComponent(label);

        // A label should report as a JLabel
        assertEquals("JLabel", dataModel.getValueAt(0, 0));
        // The variable name should be as set in the component
        assertEquals(label.getVariableName(), dataModel.getValueAt(0, 1));
        // The text should be as set in the component
        assertEquals("Test", dataModel.getValueAt(0, 2));

        // The rest is numeric values
        assertEquals(5, dataModel.getValueAt(0, 3));
        assertEquals(6, dataModel.getValueAt(0, 4));
        assertEquals(7, dataModel.getValueAt(0, 5));
        assertEquals(8, dataModel.getValueAt(0, 6));
        assertEquals(9, dataModel.getValueAt(0, 7));
        assertEquals(10, dataModel.getValueAt(0, 8));

        TextField textField1 = new TextField();
        textField1.setText("Second component");
        TextField textField2 = new TextField();
        textField2.setText("Third component");

        dataModel.addComponent(textField1);
        dataModel.addComponent(textField2);

        // We should now have 3 components in the model
        assertEquals(3, dataModel.getRowCount(), 0);
        // Components should be in the order they where added
        assertEquals("Test", dataModel.getValueAt(0, 2));
        assertEquals("Second component", dataModel.getValueAt(1, 2));
        assertEquals("Third component", dataModel.getValueAt(2, 2));

        dataModel.removeComponent(0);
        // Second component should now have moved up to be the first one
        assertEquals("Second component", dataModel.getValueAt(0, 2));
        assertEquals("Third component", dataModel.getValueAt(1, 2));

        dataModel.removeComponent(textField2);
        // Second component should now be only component in the model
        assertEquals(1, dataModel.getRowCount(), 0);
        assertEquals("Second component", dataModel.getValueAt(0, 2));
    }

    /**
     * Check altering component type in a row. This method also checks the
     * getDefinitons method.
     */
    @Test
    public void testChangingComponentType() {
        GBLEDataModel dataModel = new GBLEDataModel();
        Label label = new Label();
        label.setText("Test");
        label.setRow(5);
        label.setCol(6);
        label.setRows(7);
        label.setCols(8);
        label.setAnchor(9);
        label.setFill(10);
        dataModel.addComponent(label);

        // Alter the component to a different type.
        // Nothing but the type should change
        dataModel.setValueAt("JTextField", 0, 0);
        TextField textField = new TextField(label);
        String expected = textField.getDefinition();
        assertEquals(expected, dataModel.getDefinitions());

        // Change it back to Label, round trip should not change anything
        dataModel.setValueAt("JLabel", 0, 0);
        expected = label.getDefinition();
        assertEquals(expected, dataModel.getDefinitions());

        // Checking the result for definitions having two components
        dataModel.addComponent(textField);
        expected = label.getDefinition() + textField.getDefinition();
        assertEquals(expected, dataModel.getDefinitions());
    }

    @Test
    public void testMovingComponents() {
        GBLEDataModel dataModel = new GBLEDataModel();
        Label label = new Label();
        dataModel.addComponent(label);
        Button button = new Button();
        dataModel.addComponent(button);
        TextField textField = new TextField();
        dataModel.addComponent(textField);
        TextArea textArea = new TextArea();
        dataModel.addComponent(textArea);

        // The button should be on the second row and the
        // textarea should be on the fourth row
        assertEquals("JButton", dataModel.getValueAt(1, 0));
        assertEquals("JTextArea", dataModel.getValueAt(3, 0));

        // Move the button (second row) down one row
        // this also means that the third row moves up one row
        dataModel.moveComponentDown(1);
        assertEquals("JButton", dataModel.getValueAt(2, 0));
        assertEquals("JTextField", dataModel.getValueAt(1, 0));

        // Move the button (now on third row) down one more row
        // this means that the forth row should move up to the third row
        dataModel.moveComponentDown(2);
        assertEquals("JButton", dataModel.getValueAt(3, 0));
        assertEquals("JTextArea", dataModel.getValueAt(2, 0));

        // Try to move the button (now on the fourth row) down one more row
        // This should not make any changes to the model
        dataModel.moveComponentDown(3);
        assertEquals("JLabel", dataModel.getValueAt(0, 0));
        assertEquals("JTextField", dataModel.getValueAt(1, 0));
        assertEquals("JTextArea", dataModel.getValueAt(2, 0));
        assertEquals("JButton", dataModel.getValueAt(3, 0));

        // Move the textField (on the second row) up one row
        dataModel.moveComponentUp(1);
        assertEquals("JTextField", dataModel.getValueAt(0, 0));
        assertEquals("JLabel", dataModel.getValueAt(1, 0));

        // Move the textField (now on the first row) up one more row
        // This should not make any changes to the model
        dataModel.moveComponentUp(0);
        assertEquals("JTextField", dataModel.getValueAt(0, 0));
        assertEquals("JLabel", dataModel.getValueAt(1, 0));
    }

    @Test
    public void testSaveClearAndLoad() {
        GBLEDataModel dataModel = new GBLEDataModel();
        Label label = new Label();
        dataModel.addComponent(label);
        Button button = new Button();
        dataModel.addComponent(button);
        TextField textField = new TextField();
        dataModel.addComponent(textField);
        TextArea textArea = new TextArea();
        dataModel.addComponent(textArea);

        String defs = dataModel.getDefinitions();
        String layout = dataModel.getLayoutCode();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
		dataModel.save(bos);
		dataModel.clear();

		// The model should now contain zero rows
		assertEquals(0, dataModel.getRowCount(), 0);

		ByteArrayInputStream bis = new ByteArrayInputStream(
		        bos.toByteArray());
		dataModel.load(bis);
        // Definitions and layout code should be the same before and after
        // being saved and loaded
        assertEquals(defs, dataModel.getDefinitions());
        assertEquals(layout, dataModel.getLayoutCode());
    }
}

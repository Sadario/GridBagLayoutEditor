/**
 * 
 */
package no.ntnu.imt3281.project1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author thomasgg
 * @author sadario
 */
public class GBLEDataModel extends AbstractTableModel {

	/**
	 * 		DATA:
	 */
	private static final long serialVersionUID = 1L;
	private Vector<BaseComponent> components;
	private String[] columnNames;
	
	/**
	 * 		INHERITED METHODS:
	 */

	
	/**
	 * Returns the number of rows in the table.
	 * @return number of rows
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return components.size();
	}

	/** 
	 * Function returns the number of columns in the table.
	 * @return number of columns in table
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	 * Returns the table value at the specified table cell.
	 * The private Vector's contents corresponds to the visual table.
	 * 
	 * @param rowIndex Integer row value
	 * @param columnIndex Integer column value
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		BaseComponent temp = components.get(rowIndex);
		switch(columnIndex) {
			case 0:  return "J" + temp.getClass().getSimpleName(); // Type
			case 1:  return temp.getVariableName();                // Variable name
			case 2:  return temp.getText();                        // Text
			case 3:  return temp.getRow();                         // Row 
			case 4:  return temp.getCol();                         // Column
			case 5:  return temp.getRows();                        // Rows
			case 6:  return temp.getCols();                        // Columns 
			case 7:  return temp.getAnchor();                      // Anchor
			case 8:  return temp.getFill();                        // Fill
			default: return null;
		}
		
	}
	
	
	/**
	 * Returns the name of the column.
	 * @see javax.swing.table.TableModel#getColumnName(int)
	 * @return name of column
	 * @param column the column you want the name for
	 */
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	
	/**
	 * 		METHODS:
	 */
	/**
	 * The no-argument GBLEDataModel constructor
	 * generates the arrays and sets default values.
	 * It also sets the column-names for the table, according to locale-settings.
	 */
	public GBLEDataModel() {
		ResourceBundle rb = ResourceBundle.getBundle("no.ntnu.imt3281.project1.AppResourcesBundle");
		components = new Vector<BaseComponent>();
		columnNames = new String[] {
				rb.getString("columnName.type"),
				rb.getString("columnName.variablename"),
				rb.getString("columnName.text"),
				rb.getString("columnName.row"),
				rb.getString("columnName.column"),
				rb.getString("columnName.rows"),
				rb.getString("columnName.columns"),
				rb.getString("columnName.anchor"),
				rb.getString("columnName.fill")
		};
	}
	
	public String getDefinitions() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getLayoutCode() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * 
	 * @param streamObject
	 */
	public void save(OutputStream os) {
	 /* REVIEW
	  * 
	  * Dobbeltsjekk at filnavn/destinasjon er definert i argumentet
	  * Exception må dirigeres et annet sted.
     */
		try {
			ObjectOutputStream out = new ObjectOutputStream(os);  // Wrap the stream object, making it serialized
			out.writeObject(components);                          // Write the object to the out stream
		} catch(IOException e) {
			System.err.println("A file writing error occured. " +
		        "Check your write permissions and remaining disk space.");
		}
		
	}

	public void load(InputStream is) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Removes all stored components.
	 * 
	 */
	public void clear() {
		components.clear();
	}

	/**
	 * Adds a component to the table.
	 * 
	 * @param component inherited from BaseComponent to be added.
	 */
	public void addComponent(BaseComponent component) {
		components.add(component);
	}

	/**
	 * Removes the component at the given position.
	 * 
	 * @param position Integer position in the components Vector
	 */
	public void removeComponent(int position) {
		components.removeElementAt(position);
	}

	/**
	 * Removes the first occurence of given component.
	 * 
	 * @param component inherited of BaseComponent 
	 */
	public void removeComponent(BaseComponent component) {
		components.removeElement(component);
		// REVIEW:
		// remove(Object o) - "removes first occurence of specified element"
		// removeElement(Object o) - "Removes the first (lowest-indexed) occurence of specified el"
		// Hvem av dem?
		
	}

	/**
	 * Swaps the given component with the one above.
	 * 
	 * @param index Integer index of the component to move up.
	 */
	public void moveComponentUp(int index) {
		if(index > 0) {
		    BaseComponent temp = components.get(index);
		    components.set(index, components.get(index-1));
		    components.set(index-1, temp);
		}
	}
	
	/**
	 * Swaps the given component with the one below.
	 * 
	 * @param index Integer index of the component to move down.
	 */
	public void moveComponentDown(int index) {
		if(index < components.size() - 1) {
			BaseComponent temp = components.get(index);
			components.set(index, components.get(index+1));
			components.set(index+1, temp);
		}

		
	}
}

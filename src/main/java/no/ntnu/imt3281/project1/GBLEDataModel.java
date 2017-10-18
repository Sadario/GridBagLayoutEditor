/**
 * 
 */
package no.ntnu.imt3281.project1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
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
	 * The no-argument GBLEDataModel constructor
	 * generates the arrays and sets default values.
	 * It also sets the column-names for the table, according to locale-settings.
	 */
	public GBLEDataModel() {
		components = new Vector<BaseComponent>();
		columnNames = new String[] {
				I18N.getString("columnName.type"),
				I18N.getString("columnName.variablename"),
				I18N.getString("columnName.text"),
				I18N.getString("columnName.row"),
				I18N.getString("columnName.column"),
				I18N.getString("columnName.rows"),
				I18N.getString("columnName.columns"),
				I18N.getString("columnName.anchor"),
				I18N.getString("columnName.fill")
		};
	}
	
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
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 * @param rowIndex Integer row value
	 * @param columnIndex Integer column value
	 * @return String value of a Component's string attributes
	 * @return Integer value of a Component's integer attributes
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
	 * Calls editCompontentAttributes() for the component and attribute
	 * found in the given rowIndex and columnIndex.
	 * 
	 * @param stringVal String value of the component type
	 * @param rowIndex Integer value of the component's row index
	 * @param columnIndex Integer value of the component's column index
	 * @see javax.swing.table.TableModel#setValueAt(object, int, int)
	 * @see GBLEDataModel#editComponentAttributes(BaseComponent, String, int)
	 */
	@Override
	public void setValueAt(Object stringVal, int rowIndex, int columnIndex) {
		BaseComponent temp = components.get(rowIndex);   
		switch(columnIndex) {
		    case 0: editComponentAttributes(temp, stringVal.toString(), rowIndex); break;
		    case 1: temp.setVariableName(stringVal.toString());                    break;
		    case 2: temp.setText(stringVal.toString());                            break;
		    case 3: temp.setRow(Integer.parseInt(stringVal.toString()));           break;
		    case 4: temp.setCol(Integer.parseInt(stringVal.toString()));           break;
		    case 5: temp.setRows(Integer.parseInt(stringVal.toString()));          break;
		    case 6: temp.setCols(Integer.parseInt(stringVal.toString()));          break;
		    case 7: temp.setAnchor(Integer.parseInt(stringVal.toString()));        break;
		    case 8: temp.setFill(Integer.parseInt(stringVal.toString()));          break;
		    default: break;
		    
	    }
	}
	
	/**
	 * Changes the component type by creating a new instance
	 * of the component corresponding to the given string value, in 
	 * the given Vector index.
	 * 
	 * @param comp BaseComponent child to be edited.
	 * @param val String value of the component type.
	 * @param index Integer value of the index in the BaseComponent Vector
	 */
	private void editComponentAttributes(BaseComponent comp, String val, int row) {
		switch(val) {
		case "JTextField": components.set(row, new TextField(comp)); break;
		case "JTextArea":  components.set(row, new TextArea(comp));  break;
		case "JLabel":     components.set(row, new Label(comp));     break;
		case "JButton":    components.set(row, new Button(comp));    break;
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
	 * Returns the number of column headings
	 * 
	 * @return Integer number of column headings
	 */
	public int getNumColumns() {
		return columnNames.length;
	}
	
	/**
	 * 		METHODS:
	 */

	
	/**
	 * Returns the definitions to all objects in the Vector
	 * separated by new line characters.
	 * 
	 * @return String value of the objects' definitions
	 */
	public String getDefinitions() {
		StringBuilder defs = new StringBuilder();
		
		for (BaseComponent obj : components) {
			defs.append(obj.getDefinition());
		}
		return defs.toString();
	}
	
	/**
	 * Returns the layout code for all objects in the Vector
	 * separated by new line characters.
	 * 
	 * @return String value of the objects' layouts.
	 */
	public String getLayoutCode() {
		StringBuilder layouts = new StringBuilder();
		
		for(BaseComponent obj : components) {
			layouts.append(obj.getLayoutCode());
		}
		return layouts.toString();
	}
	
	/**
	 * Adds a component to the table.
	 * 
	 * @param component inherited from BaseComponent to be added.
	 */
	public void addComponent(BaseComponent component) {
		components.add(component);
		fireTableRowsInserted(0, components.size());	// Må oppdatere fra første til siste komponent
	}													// for at fjerning, deretter innlegging skal oppføre seg normalt.

	/**
	 * Removes the component at the given position.
	 * 
	 * @param position Integer position in the components Vector
	 */
	public void removeComponent(int position) {
		components.removeElementAt(position);
		fireTableRowsUpdated(position, components.size());
	}

	/**
	 * Removes the first occurrence of given component.
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
		    fireTableRowsUpdated(index-1, index);
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
			fireTableRowsUpdated(index, index+1);
		}
	}
	
	/**
	 * Cells are editable by default.
	 * @return Boolean true
	 * 
	 */
	@Override
	public boolean isCellEditable(int row, int col) {
		return true;
	}
	
	/**
	 * 
	 * 
	 * @param os
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

	/**
	 * 
	 * @param is
	 */
	@SuppressWarnings("unchecked")
	public void load(InputStream is) {
		/**
		 * REVIEW
		 * Helt utrolig at testen gikk igjennom.
		 * Vi må få en bedre forståelse for save(), load() og 
		 * fikse de.
		 */
		try {
			ObjectInputStream in = new ObjectInputStream(is);
			components = (Vector<BaseComponent>) in.readObject();
			fireTableDataChanged();
		} catch(IOException e) {
			System.err.println("err");
		} catch(ClassNotFoundException temp) { // Vet ikke hvorfor in.readObject(); krevde denne
			System.err.println(temp.getMessage());
		}
	}

	/**
	 * Removes all stored components.
	 * 
	 */
	public void clear() {
		components.clear();
		BaseComponent.resetNextComponentID();
		fireTableDataChanged();
	}

}

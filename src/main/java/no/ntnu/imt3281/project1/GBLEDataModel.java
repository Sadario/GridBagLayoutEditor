/**
 * 
 */
package no.ntnu.imt3281.project1;

import java.io.InputStream;
import java.io.OutputStream;
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
	private Vector<BaseComponent> data;
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
		return data.size();
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

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
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
		data = new Vector<BaseComponent>();
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
	
	public void save(OutputStream os) {
		// TODO Auto-generated method stub
		
	}

	public void load(InputStream is) {
		// TODO Auto-generated method stub
		
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public void addComponent(BaseComponent label) {
		// TODO Auto-generated method stub
		
	}

	public void removeComponent(int i) {
		// TODO Auto-generated method stub
		
	}

	public void removeComponent(BaseComponent textField2) {
		// TODO Auto-generated method stub
		
	}

	public void moveComponentUp(int i) {
		// TODO Auto-generated method stub
		
	}
	
	public void moveComponentDown(int i) {
		// TODO Auto-generated method stub
		
	}
}

/**
 * 
 */
package no.ntnu.imt3281.project1;

import java.io.InputStream;
import java.io.OutputStream;
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

	
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
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
	 * 		METHODS:
	 */
	public GBLEDataModel() {
		// TODO Auto-generated constructor stub
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

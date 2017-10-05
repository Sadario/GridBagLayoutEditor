package no.ntnu.imt3281.project1;
import java.awt.Component;
import java.io.Serializable;

public class BaseComponent implements Serializable {
	
	private static final long serialVersionUID = 1L;  // tempKommentar: 
	private String variableName;
	private String text;
	private int row;
	private int col;
	private int rows;
	private int cols;
	private int anchor;
	private int fill;
	protected static int nextComponentID;   // tempKommentar: Benyttes av child-klassene (se testfilene)
	
	/**
	 * temp
	 * 
	 */
	public BaseComponent() {
		
		nextComponentID++;
	}
	public BaseComponent(BaseComponent component) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * temp
	 * 
	 * @return
	 */
    public String getDefinition() {
    	return "temp";
    }
    
    /**
     * temp
     * 
     */
	public String getLayoutCode() {
		return "temp";
	}
	
	/**
	 * temp
	 * 
	 * @return
	 */
	public String getVariableName() {
		return variableName;
	}
	
	/**
	 * temp
	 * 
	 * @param name
	 */
	public void setVariableName(String name) {
	  // temp	
	}
	
	/**
	 * Returns the component's display text
	 * 
	 * @return the String text of the component
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Sets the components display text
	 * 
	 * @param the String text of the component
	 */
	public void setText(String text) {
		
	}
	
	/**
	 * temp
	 * 
	 * @return
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * temp
	 * 
	 * @param row
	 */
	public void setRow(int row) {
		
	}
	
	/**
	 * temp
	 * 
	 * @return
	 */
	public int getRows() {
		return rows;
	}
	
	
	/**
	 * temp
	 * 
	 * @param rows
	 */
	public void setRows(int rows) {
		
	}
	
	/**
	 * temp
	 * 
	 * @return 
	 */
	public int getCol() {
		return col;
	}
	
	/**
	 * temp
	 * 
	 * @param col
	 */
	public void setCol(int col) {
		
	}
	
	/**
	 * temp
	 * 
	 * @return
	 */
	public int getCols() {
		return cols;
	}
	
	
	/**
	 * temp
	 * 
	 * @param cols
	 */
	public void setCols(int cols) {
		
	}
	
	/**
	 * temp
	 * 
	 * @return
	 */
	public int getAnchor() {
		return anchor;
	}
	
	/**
	 * temp
	 * 
	 * @param anchor
	 */
	public void setAnchor(int anchor) {
		
	}
	
	/**
	 * temp
	 * 
	 * @return
	 */
	public int getFill() {
		return fill;
	}
	
	/**
	 * temp
	 * 
	 * @param fill
	 */
	public void setFill(int fill) {
		
	}
	
	/**
	 * temp
	 * 
	 * @param temp
	 */
	public Component getSpecialEditor() {
		return null;
	}
}

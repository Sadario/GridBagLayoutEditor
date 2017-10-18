package no.ntnu.imt3281.project1;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.io.Serializable;

/**
 * BaseComponent class contains all the common properties
 * of the different components.
 * 
 * @author thomasgg
 * @author sadario
 */
public class BaseComponent implements Serializable {
	
	private static final long serialVersionUID = 1L;  
	private String variableName;
	private String text;
	private int row;
	private int col;
	private int rows;
	private int cols;
	private int anchor;
	private int fill;
	protected static int nextComponentID;  
	
	/**
	 * The no-argument BaseComponent constructor creates 
	 * a new component with an empty text field and default values 
	 * for the number of rows and columns the component spans.
	 * 
	 */
	public BaseComponent() {
		variableName = "component" + nextComponentID;
		text = "";
		row = col = rows = cols = 1;
		anchor = GridBagConstraints.CENTER;
		fill = GridBagConstraints.NONE;
		nextComponentID++;
	}
	
	/**
	 * The 1-argument BaseComponent constructor takes
	 * an existing component as parameter and copies
	 * its attributes to a new component.
	 * 
	 * @param component object to copy
	 */
	public BaseComponent(BaseComponent component) {
		variableName = component.variableName;
		text = component.text;
		row = component.row;
		col = component.col;
		rows = component.rows;
		cols = component.cols;
		anchor = component.anchor;
		fill = component.fill;
	}
	
	/**
	 * Only inherited classes returns specific component definitions.
	 * 
	 * @return null
	 */
    public String getDefinition() {
    	return null;
    }
    	
	/**
	 * Gets the variable name of the component.
	 * 
	 * @return String of the object's variable name
	 */
	public String getVariableName() {
		return variableName;
	}
	
	/**
	 * Sets the variable name of the component.
	 * 
	 * @param name the variable name of the object.
	 */
	public void setVariableName(String name) {
	  this.variableName = name;	
	}
	
	/**
	 * Gets the component's display text
	 * 
	 * @return the String text of the component
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Sets the component's display text
	 * 
	 * @param text String text of the component
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Gets the row number of the component's position.
	 * 
	 * @see java.awt.GridBagConstraints
	 * @return Integer row number which the object is placed.
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * Sets the row number of the component's position
	 * 
	 * @see java.awt.GridBagConstraints
	 * @param row Integer row number which the object is placed.
	 */
	public void setRow(int row) {
		this.row = row;
	}
	
	/**
	 * Gets the number of rows which the component occupies.
	 * 
	 * @see java.awt.GridBagConstraints
	 * @return Integer number of rows which the object occupies.
	 */
	public int getRows() {
		return rows;
	}
		
	/**
	 * Sets the number of rows which the component occupies.
	 * 
	 * @see java.awt.GridBagConstraints
	 * @param rows Integer number of rows which the object occupies.
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	/**
	 * Gets the column number of the component's position.
	 * 
	 * @see java.awt.GridBagConstraints
	 * @return Integer column number of the object's position.
	 */
	public int getCol() {
		return col;
	}
	
	/**
	 * Sets the column number of this component's position.
	 * 
	 * @see java.awt.GridBagConstraints
	 * @param col Integer number of the column which the object occupies.
	 */
	public void setCol(int col) {
		this.col = col;
	}
	
	/**
	 * Gets the number of columns which the component occupies.
	 * 
	 * @see java.awt.GridBagConstraints
	 * @return Integer number of columns which the object occupies.
	 */
	public int getCols() {
		return cols;
	}
	
	/**
	 * Sets the number of coloumns which the component occupies.
	 * 
	 * @see java.awt.GridBagConstraints
	 * @param cols number of columns which the component will occupy
	 */
	public void setCols(int cols) {
		this.cols = cols;
	}
	
	/**
	 * Gets the anchoring of the component.
	 * 
	 * @see java.awt.GridBagConstraints
	 * @return Integer value of the anchoring of the object.
	 */
	public int getAnchor() {
		return anchor;
	}
	
	/**
	 * Sets the anchoring of the component.
	 * 
	 * @see java.awt.GridBagConstraints
	 * @param anchor Integer value of the object's anchor.
	 */
	public void setAnchor(int anchor) {
		this.anchor = anchor;
	}
	
	/**
	 * Gets the fill of the component.
	 * 
	 * @see java.awt.GridBagConstraints
	 * @return Integer number of the object's fill.
	 */
	public int getFill() {
		return fill;
	}
	
	/**
	 * Sets the fill of the component.
	 * 
	 * @see java.awt.GridBagConstraints
	 * @param fill Integer value of the object's fill.
	 */
	public void setFill(int fill) {
		this.fill = fill;
	}
	
	/**
	 * Gets, if existing, special fields specific to each component.
	 * Inherited classes overrides this method and returns their
	 * class specific fields.
	 * 
	 * @return a JPanel of the specific component's special fields which can be edited
	 */
	public Component getSpecialEditor() {
		return null;
	}
	
    /**
     * Gets a String representation of the component's layout Java code.
     * 
     * @return String containing the layout code for the object
     */
	public String getLayoutCode() {
		return 	"\t\tgbc.gridx = " + getCol() + ";\n\t\tgbc.gridy = " + getRow() + ";\n" +
				"\t\tgbc.gridwidth = " + getCols() + ";\n\t\tgbc.gridheight = " + getRows() + ";\n" +
				"\t\tgbc.anchor = " + getAnchor() + ";\n\t\tgbc.fill = " + getFill() + ";\n" +
				"\t\tlayout.setConstraints(" + getVariableName() + ", gbc);\n" +
				"\t\tadd(" + getVariableName() + ");\n";
	}
	
	/**
	 * Resets the component ID to 0.
	 */
	public static void resetNextComponentID() {
		nextComponentID = 0;
	}
}

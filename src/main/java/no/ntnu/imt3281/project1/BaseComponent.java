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
	 * 
	 * 
	 */
	public BaseComponent() {
		variableName = "component" + nextComponentID;
		text = "";
		row = col = rows = cols = 1;
		anchor = java.awt.GridBagConstraints.CENTER;
		nextComponentID++;
	}
	
	/**
	 * 
	 * @param component			The component to copy
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
		nextComponentID++;
	}
	/**
	 * 
	 * 
	 * @return	
	 */
    public String getDefinition() {
    	String ret;
    	
    	if 		(this instanceof Label)
    		ret = "\tJLabel " + this.variableName + " = new JLabel(\"" + this.text + "\");\n";
    	else if (this instanceof Button)
    		ret = "\tJButton " + this.variableName + " = new JButton(\"" + this.text + "\");\n";
    	else if (this instanceof TextField)
    		ret = "\tJTextField " + this.variableName + " = new JTextField(\"" + this.text + "\");\n";
    	else if (this instanceof TextArea)
    		ret = "\tJTextArea " + this.variableName + " = new JTextArea(\"" + this.text + "\");\n";
    	else ret = null;
    	
    	
    	return ret;
    }
    
    /**
     * temp
     * 
     */
	public String getLayoutCode() {
		return 	"\t\tgbc.gridx = " + getCol() + ";\n\t\tgbc.gridy = " + getRow() + ";\n" +
				"\t\tgbc.gridwidth = " + getCols() + ";\n\t\tgbc.gridheight = " + getRows() + ";\n" +
				"\t\tgbc.anchor = " + getAnchor() + ";\n\t\tgbc.fill = " + getFill() + ";\n" +
				"\t\tlayout.setConstraints(" + getVariableName() + ", gbc);\n" +
				"\t\tadd(" + getVariableName() + ");\n";
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
	  this.variableName = name;	
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
		this.text = text;
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
		this.row = row;
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
		this.rows = rows;
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
		this.col = col;
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
		this.cols = cols;
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
		this.anchor = anchor;
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
		this.fill = fill;
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

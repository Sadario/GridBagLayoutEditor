/**
 * 
 */
package no.ntnu.imt3281.project1;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * TextArea class represents a definable JTextArea object
 * to be used in the GridBagLayout editor.
 * 
 * @author thomasgg
 * @author sadario
 */
public class TextArea extends BaseComponent {
	
	private static final long serialVersionUID = 1L;
	private int textRows;
	private int textCols;
	private boolean wrap;

	/**
	 * No argument constructor sets wrap false
	 * and calls BaseComponent's constructor
	 * 
	 * @see BaseComponent#BaseComponent()
	 */
	public TextArea() {
		super();
		wrap = false;
	}

	/**
	 * 
	 * @see BaseComponent#BaseComponent(BaseComponent)
	 * @param component to be sent to BaseComponent's constructor
	 */
	public TextArea(BaseComponent component) {
		super(component);
	}

	/**
	 * Gets the number of rows in the text area.
	 * 
	 * @return Integer number of rows in the text area.
	 */
	public int getTextRows() {
		return textRows;
	}
	
	/**
	 * Sets the number of rows in the text area.
	 * 
	 * @param textRows Integer number of rows in the text area.
	 */
	public void setTextRows(int textRows) {
		this.textRows = textRows;
	}
	
	/**
	 * Gets the number of columns in the text area.
	 * 
	 * @return Integer number of columns in the text area.
	 */
	public int getTextCols() {
		return textCols;
	}

	/**
	 * Sets the number of columns in the text area.
	 * 
	 * @param textCols Integer number of columns in the text area.
	 */
	public void setTextCols(int textCols) {
		this.textCols = textCols;
	}
	
	/**
	 * Returns true/false dependent on the text area's wrap state.
	 * 
	 * @return Boolean true if wrapped, false otherwise.
	 */
	public boolean getWrap() {
		return wrap;
	}

	/**
	 * Sets true/false for the text field's wrap state.
	 * 
	 * @param wrap Boolean true or false.
	 */
	public void setWrap(boolean wrap) {
		this.wrap = wrap;
	}
	
	/**
	 * Returns a String object definition of the JTextArea object
	 * 
	 * @return returns a JTextArea object definition as a string
	 */
	public String getDefinition() {
		return "\tJTextArea " + getVariableName() + " = new JTextArea(\"" + getText() + "\", " + getTextRows() + ", " + getTextCols() + ");\n";
	}

	/**
	 * TEMP - needs review/discussion
	 * 
	 */
	public Component getSpecialEditor() {
		return new JPanel(new GridLayout(2,2));
	}
	
    /**
     * Gets a String representation of the text area's layout Java code.
     * 
     * @return String containing the layout code for the object
     */
	public String getLayoutCode() {
		return super.getLayoutCode() + "\t\t" + getVariableName() +
			   "." + "setWrapStyleWord(" + getWrap() + ");\n";
	}
}

package no.ntnu.imt3281.project1;

import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * TextField class represents a definable JTextField object
 * to be used in the GridBagLayout editor.
 * 
 * @author Thomas Gundersen & Ola Nicolaisen
 */
public class TextField extends BaseComponent {
	
	private static final long serialVersionUID = 1L;
	private int width;


	public TextField() {
		super();
	}

	public TextField(BaseComponent component) {
		super(component);
	}

	/**
	 * Sets the width of the text field.
	 * 
	 * @param width Integer value of the textfield's width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Gets the width of the text field.
	 * 
	 * @return Integer value of the text field's width.
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Returns a String object definition of the JTextField object
	 * 
	 * @return returns a JTextField object definition as a string
	 */
	public String getDefinition() {
		return "\tJTextField " + getVariableName() + " = new JTextField(\"" + getText() + "\");\n";
	}
	
	/**
	 * TEMP - needs review/discussion
	 * 
	 */
	public JPanel getSpecialEditor() {
		return new JPanel(new GridLayout(2,2));
	}

}

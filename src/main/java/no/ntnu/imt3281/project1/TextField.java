/**
 * 
 */
package no.ntnu.imt3281.project1;

/**
 * 
 *
 */
public class TextField extends BaseComponent {

	/**
	 * 		DATA:
	 */
	private static final long serialVersionUID = 1L;
	private int width;

	/**
	 * 		METHODS:
	 */
	public TextField() {
		// TODO Auto-generated constructor stub
	}

	public TextField(BaseComponent component) {
		// TODO Auto-generated constructor stub
	}

	public void setWidth(int i) {
		// TODO Auto-generated method stub
		
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Returns a String object definition of the JTextField object
	 * 
	 * @return returns a JTextField object definition as a string
	 */
	public String getDefinition() {
		return "\tJTextField " + getVariableName() + " = new JTextField(\"" + getText() + "\");\n";
	}

}

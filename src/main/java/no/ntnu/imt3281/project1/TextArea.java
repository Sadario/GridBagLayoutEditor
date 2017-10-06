/**
 * 
 */
package no.ntnu.imt3281.project1;

/**
 * 
 *
 */
public class TextArea extends BaseComponent {
	
	/**
	 * 		DATA:
	 */
	
	private static final long serialVersionUID = 1L;
	private int textRows;
	private int textCols;
	private boolean wrap;

	/**
	 * 		METHODS:
	 */
	
	public TextArea() {
		// TODO Auto-generated constructor stub
	}

	public TextArea(BaseComponent component) {
		// TODO Auto-generated constructor stub
	}

	public int getTextRows() {
		// TODO
		return 0;
	}
	
	public void setTextRows(int i) {
		// TODO Auto-generated method stub
		
	}
	
	public int getTextCols() {
		// TODO
		return 0;
	}

	public void setTextCols(int i) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean getWrap() {
		// TODO
		return false;
	}

	public void setWrap(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Returns a String object definition of the JTextArea object
	 * 
	 * @return returns a JTextArea object definition as a string
	 */
	public String getDefinition() {
		return "\tJTextArea " + getVariableName() + " = new JTextArea(\"" + getText() + "\");\n";
	}

}

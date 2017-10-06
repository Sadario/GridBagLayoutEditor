/**
 * 
 */
package no.ntnu.imt3281.project1;

/**
 * Label class represents a definable JLabel object
 * to be used in the GridBagLayout editor.
 * 
 * @author thomasgg
 * @author sadario
 */
public class Label extends BaseComponent {

	/**
	 * 		DATA:
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 		METHODS:
	 */
	public Label() {
		super();
	}

	public Label(BaseComponent component) {
		super(component);
	}
	
	
	/**
	 * Returns a String object definition of the JLabel object
	 * 
	 * @return returns a JLabel object definition as a string
	 */
	public String getDefinition() {
		return "\tJLabel " + getVariableName() + " = new JLabel(\"" + getText() + "\");\n";
	}

}

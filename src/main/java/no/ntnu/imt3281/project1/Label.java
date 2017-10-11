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
	
	/**
	 * No argument constructor calls BaseComponent's constructor
	 * 
	 * @see BaseComponent#BaseComponent()
	 */
	public Label() {
		super();
	}

	/**
	 * 1-argument constructor takes a Label object and 
	 * sends it to the BaseComponent.
	 * 
	 * @see BaseComponent#BaseComponent(BaseComponent)
	 * @param component to be sent to BaseComponent's constructor
	 */
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

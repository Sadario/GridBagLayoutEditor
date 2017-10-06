package no.ntnu.imt3281.project1;

/**
 * Button class represents a definable JButton object
 * to be used in the GridBagLayout editor.
 * 
 * @author thomasgg
 * @author sadario
 */
public class Button extends BaseComponent {
	private static final long serialVersionUID = 1L;

	/**
	 * No argument constructor calls BaseComponent's constructor
	 * 
	 * @see BaseComponent#BaseComponent()
	 */
	public Button() {
		super();
	}

	/**
	 * 1-argument constructor takes Button object and 
	 * sends it to the BaseComponent.
	 * 
	 * @see BaseComponent#BaseComponent(BaseComponent)
	 * @param component to be sent to BaseComponent's constructor
	 */
	public Button(BaseComponent component) {
		super(component);
	}
	
	/**
	 * Returns a String object definition of the JButton object
	 * 
	 * @return returns a JButton object definition as a string
	 */
	public String getDefinition() {
		return "\tJButton " + getVariableName() + " = new JButton(\"" + getText() + "\");\n";
	}



}

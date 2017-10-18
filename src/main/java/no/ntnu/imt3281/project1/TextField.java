package no.ntnu.imt3281.project1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;

/**
 * TextField class represents a definable JTextField object
 * to be used in the GridBagLayout editor.
 * 
 * @author thomasgg
 * @author sadario
 */
public class TextField extends BaseComponent {
	
	private static final long serialVersionUID = 1L;
	private int width;
	
	// CONSTANTS
	private static final int SPINNERMAX = 500;

	/**
	 * No argument constructor calls BaseComponent's constructor
	 * 
	 * @see BaseComponent#BaseComponent()
	 */
	public TextField() {
		super();
	}

	/**
	 * 
	 * @see BaseComponent#BaseComponent(BaseComponent)
	 * @param component to be sent to BaseComponent's constructor
	 */
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
		return "\tJTextField " + getVariableName() + " = new JTextField(\"" + getText() + "\", " + getWidth() + ");\n";
	}
	
	
	/**
	 * Creates the panel, to populate a frame, with option to edit special values.
	 * @return JPanel with the content to view in special editor
	 */
	@Override
	public Component getSpecialEditor() {
		JPanel mainPanel = new JPanel();
		JPanel contentPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JLabel label = new JLabel(I18N.getString("specialEditor.JLabel.text"));
		JButton button = null;
		
		mainPanel.setLayout(new BorderLayout());
		contentPanel.setLayout(new GridLayout(1, 2));
				
		mainPanel.add(label, BorderLayout.NORTH);
		mainPanel.add(contentPanel, BorderLayout.CENTER);
		
		JSpinner spinner = App.addLabeledSpinner(contentPanel, I18N.getString("specialEditor.width"), SPINNERMAX, width);
		
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout());
		button = new JButton("OK");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				width = (int) spinner.getValue();
				SwingUtilities.getWindowAncestor(mainPanel).dispose();
			}
			
		});
		buttonPanel.add(button);
		button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.getWindowAncestor(mainPanel).dispose();
			}
			
		});
		buttonPanel.add(button);
		
		return mainPanel;
	}
}

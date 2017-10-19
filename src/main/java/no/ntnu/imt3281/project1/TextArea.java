/**
 * 
 */
package no.ntnu.imt3281.project1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;

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
	private final int SPINNERMAXROWS = 50;
	private final int SPINNERMAXCOLS = 150;

	/**
	 * No argument constructor calls BaseComponent's constructor
	 * and sets wrapping to false.
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
	 * Creates the panel, to populate a frame, with option to edit special values.
	 * @return JPanel with the content to view in special editor
	 */
	@Override
	public Component getSpecialEditor() {
		JPanel mainPanel = new JPanel();
		JPanel contentPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JLabel label = new JLabel(I18N.getString("specialEditor.JLabel.text"));
		JCheckBox wrapCheck = new JCheckBox();
		JButton button = null;
		
		mainPanel.setLayout(new BorderLayout());
		contentPanel.setLayout(new GridLayout(3, 2));
				
		mainPanel.add(label, BorderLayout.NORTH);
		mainPanel.add(contentPanel, BorderLayout.CENTER);
		
		JSpinner columnsSpinner = App.addLabeledSpinner(contentPanel, I18N.getString("specialEditor.columns"), SPINNERMAXCOLS, textCols);
		JSpinner rowsSpinner = App.addLabeledSpinner(contentPanel, I18N.getString("specialEditor.rows"), SPINNERMAXROWS, textRows);

		label = new JLabel(I18N.getString("specialEditor.checkBox.wrapping"));
		contentPanel.add(label);
		if (wrap == true) wrapCheck.setSelected(true);
		contentPanel.add(wrapCheck);
		
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout());
		button = new JButton("OK");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textRows = (int) rowsSpinner.getValue();
				textCols = (int) columnsSpinner.getValue();
				wrap = (boolean) wrapCheck.isSelected();
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

package no.ntnu.imt3281.project1;

import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 * Creates the ToolBar for the application
 * @author sadario
 * @author thomasgg
 */
public class ToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;

	public ToolBar(ActionListener handler) {        
		super("Draggable");                            
	}

	/**
	 * Creates buttons based on the arguments sent with.
	 * 
	 * @param iconName String file name of the image icon (not file path).
	 * @param buttonName String value used by action handlers to uniquely identify the button.
	 * @param handler ActionListener object managing the action handler.
	 */
	public void makeButton(	String iconName,
						    String buttonName, 
							ActionListener handler) {
		
		JButton button = new JButton();
		Icon icon = new ImageIcon(getClass().getResource("graphics/" + iconName));
		button.setActionCommand(buttonName);
		button.addActionListener(handler);
		button.setToolTipText(I18N.getString("buttons." + buttonName + ".toolTip"));
		button.setIcon(icon);
		this.add(button);
	}
}

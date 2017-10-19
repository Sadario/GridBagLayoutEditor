/**
 * 
 */
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToolBar(ActionListener handler) {        
		super("Draggable");
	//	addButtons(this, handler);                                 
	}

	/*
	public void addButtons(ToolBar toolBar, ActionListener handler) {
		makeButton("New.gif", "newFile", handler);
		makeButton("OpenDoc.gif", "openFile", handler);
		makeButton("Save.gif", "saveFile", handler);
		toolBar.addSeparator();
		makeButton("ExecuteProject.gif", "generate", handler);
		makeButton("SaveJava.gif", "saveBin", handler);
		toolBar.addSeparator();
		makeButton("NewRow.gif", "newRow", handler);
		makeButton("MoveRowUp.gif", "moveRowUp", handler);
		makeButton("MoveRowDown.gif", "moveRowDown", handler);
		toolBar.addSeparator();
		makeButton("Help.gif", "help", handler);
		
	}
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

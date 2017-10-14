/**
 * 
 */
package no.ntnu.imt3281.project1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

/**
 * @author sadario
 *
 */
public class ToolBar extends JToolBar {

	public ToolBar(ActionListener handler) {        
		super("Draggable");
		addButtons(this, handler);                                 
	}

	private void addButtons(ToolBar toolBar, ActionListener handler) {
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

	private void makeButton(	String iconName,
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

	/**
	 * @param orientation
	 */
	public ToolBar(int orientation) {
		super(orientation);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 */
	public ToolBar(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param orientation
	 */
	public ToolBar(String name, int orientation) {
		super(name, orientation);
		// TODO Auto-generated constructor stub
	}
}

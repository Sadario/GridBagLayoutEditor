/**
 * 
 */
package no.ntnu.imt3281.project1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 * @author sadario
 *
 */
public class ToolBar extends JToolBar {
	/**
	 * 
	 */
	public ToolBar(ButtonListener l) {                             // TESTING
		super("Draggable");
		addButtons(this, l);                                       // TESTING
	}

	private void addButtons(ToolBar toolBar, ButtonListener l) {   // TESTING
		JButton button = null;
		button = makeButton("New.gif", "newFile");
		toolBar.add(button);
		button.addActionListener(l);                                // TESTING
		button = makeButton("OpenDoc.gif", "openFile");
		toolBar.add(button);
		button = makeButton("Save.gif", "saveFile");
		toolBar.add(button);
		toolBar.addSeparator();
		button = makeButton("ExecuteProject.gif", "generate");
		toolBar.add(button);
		button = makeButton("SaveJava.gif", "saveBin");
		toolBar.add(button);
		toolBar.addSeparator();
		button = makeButton("NewRow.gif", "newRow");
		toolBar.add(button);
		button = makeButton("MoveRowUp.gif", "moveRowUp");
		toolBar.add(button);
		button = makeButton("MoveRowDown.gif", "moveRowDown");
		toolBar.add(button);
		toolBar.addSeparator();
		button = makeButton("Help.gif", "help");
		toolBar.add(button);
		
	}

	private JButton makeButton(	String iconName,
								String buttonName ) {
		//ButtonHandler handler = new ButtonHandler();
		I18N bundle = new I18N();
		JButton button = new JButton();
		Icon icon = new ImageIcon(getClass().getResource("graphics/" + iconName));
		//button.setActionCommand(buttonName);
		//button.addActionListener(handler);
		button.setToolTipText(bundle.getString("buttons." + buttonName + ".toolTip"));
		button.setIcon(icon);
		
		
		return button;
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

	// #TODO WORK IN PROGRESS
	
	
	/*private class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			
			switch (cmd) {
			case "newFile":
				newFile();
				break;

			default:
				break;
			}
		}
		

		private void newFile() {
			GBLEDataModel.clear();
		}
	}
	*/
}

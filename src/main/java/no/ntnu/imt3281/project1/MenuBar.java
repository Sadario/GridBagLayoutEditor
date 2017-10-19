package no.ntnu.imt3281.project1;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;

/**
 * Creates the MenuBar for the application.
 * @author sadario
 * @author thomasgg
 * 
 */
public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	/**
	 * The constructor does not perform any specific tasks.
	 * 
	 */
	public MenuBar() {}
	
	/**
	 * 
	 * Give function the name (matching *.properties-files) of the new JMenu you want to create.
	 * *.properties should contain "menuBar." + 'parameter of this function'
	 * 
	 * @param name of menuitem (matches *.properties-files which fills the component with text)
	 * @return JMenu to populate menubar in application.
	 */
	public JMenu createJMenu(String name) {
		JMenu object = new JMenu(I18N.getString(name));
		String mnemonic = name + ".mnemonic";
		mnemonic = I18N.getString(mnemonic);
		object.setMnemonic(mnemonic.charAt(0));
		
		return object;
	}
	
	/**
	 * Give this function the name of the parent JMenu, the name of the JMenuItem you wish to create,
	 * and name of icon-file, and it creates your JMenuItem and fills strings from *.properties.
	 * 
	 * @param parent the JMenu-object you want to create a new JMenuItem in
	 * @param name the name of the new JMenuItem
	 * @param graphic the name of the file in folder 'graphics' (entire file-name e.g. "New.gif", or "" if no graphic is needed). 
	 * @param handler The ActionListener handling the events.
	 * @return JMenuItem-object to add to parent-JMenu.
	 */	
	public JMenuItem createJMenuItem(String parent, String name, String graphic, ActionListener handler) {
		JMenuItem object;
		String itemPath = "menuBar." + parent + '.' + name;
		String mnemonic = itemPath + ".mnemonic";
		Icon icon;
		if (graphic != "") {
			icon = new ImageIcon(getClass().getResource("graphics/" + graphic));
			object = new JMenuItem(I18N.getString(itemPath), icon);
		} else object = new JMenuItem(I18N.getString(itemPath));
		mnemonic = I18N.getString(mnemonic);
		object.setMnemonic(mnemonic.charAt(0));
		object.setActionCommand(name);
		object.addActionListener(handler);
		return object;
	}
}

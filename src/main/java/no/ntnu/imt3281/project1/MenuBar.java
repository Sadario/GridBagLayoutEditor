/**
 * 
 */
package no.ntnu.imt3281.project1;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * @author sadario
 * @author thomasgg
 * Menubar for the application, with different functionality #TODO
 */
public class MenuBar extends JMenuBar {
	/**
	 * Creates the MenuBar at the top of the application.
	 * #TODO implement listeners
	 * 
	 */
	public MenuBar() {
		// JMenu fileMenu = createJMenu("menuBar.file");
/*		JMenuItem newFileMenuItem = createJMenuItem("file", "new", "New.gif");
		JMenuItem openFileMenuItem = createJMenuItem("file", "open", "OpenDoc.gif");
		JMenuItem saveMenuItem = createJMenuItem("file", "save", "Save.gif");
		JMenuItem saveAsMenuItem = createJMenuItem("file", "saveAs", "Save.gif");
		JMenuItem previewMenuItem = createJMenuItem("file", "preview", "");
		JMenuItem generateMenuItem = createJMenuItem("file", "generate", "SaveJava.gif");
		JMenuItem exitMenuItem = createJMenuItem("file", "exit", "");
 */
		
	/*	this.add(fileMenu);
		fileMenu.add(newFileMenuItem);
		fileMenu.add(openFileMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.add(saveAsMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(previewMenuItem);
		fileMenu.add(generateMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
     */
		/*
		 * 		EDIT-MENU
		 */
		
   /*
		JMenu editMenu = createJMenu("menuBar.edit");
		JMenuItem newRowMenuItem = createJMenuItem("edit", "newRow", "NewRow.gif");
		JMenuItem preferencesMenuItem = createJMenuItem("edit", "preferences", "");
		
		newRowMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		this.add(editMenu);
		editMenu.add(newRowMenuItem);
		editMenu.addSeparator();
		editMenu.add(preferencesMenuItem);
	*/
		/*
		 * 		HELP-MENU
		 */
	/*	JMenu helpMenu = createJMenu("menuBar.help");
		JMenuItem helpMenuItem = createJMenuItem("help", "help", "Help.gif");
		JMenuItem aboutMenuItem = createJMenuItem("help", "about", "");
		
		this.add(helpMenu);
		helpMenu.add(helpMenuItem);
		helpMenu.addSeparator();
		helpMenu.add(aboutMenuItem);
		*/
	}
	/**
	 * This function is private, so documentation is unnecessary, but I chose to document it...
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
	 * @return JMenuItem-object to add to parent-JMenu.
	 */	
	public JMenuItem createJMenuItem(String parent, String name, String graphic) {
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
		return object;
	}
	

}

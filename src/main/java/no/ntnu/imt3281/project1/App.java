package no.ntnu.imt3281.project1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * App class serves as a container for the whole application and also contains
 * the static main function.
 * 
 * @author thomasgg
 * @author sadario
 *
 */
public class App extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int UP = -1;
	private static final int DOWN = 1;
	private static JTextField statusBar;
	private boolean hasDefinedSaveLocation;                            // Editor file is saved to disk
	private boolean isChanged;                                         // Editor file has unsaved changes
	private File saveFile;
	private GBLEDataModel data;
	private JTable table;
	
	private Integer[] fillConstraints = {GridBagConstraints.NONE,
			GridBagConstraints.HORIZONTAL,
			GridBagConstraints.VERTICAL,
			GridBagConstraints.BOTH 
	};
	
	private Integer[] anchorConstraints = { GridBagConstraints.CENTER, 
			GridBagConstraints.EAST,
			GridBagConstraints.NORTH,
			GridBagConstraints.NORTHEAST,
			GridBagConstraints.NORTHWEST,
			GridBagConstraints.WEST,
			GridBagConstraints.SOUTH,
			GridBagConstraints.SOUTHEAST,
			GridBagConstraints.SOUTHWEST
	};
	

	
	/**
	 * Constructor
	 * 
	 */
	public App() {
		super(I18N.getString("application.title"));
		this.setLayout(new BorderLayout());
		hasDefinedSaveLocation = false;
		isChanged = false;
		
		createAndShowBars();
		createAndShowTable();
		createRightClickContextMenu();
		add(statusBar, BorderLayout.SOUTH);
		
		setSize(800, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		setStatusText("Program initialized");
	}

	/**
	 * See {@link https://stackoverflow.com/questions/3558293/java-swing-jtable-right-click-menu-how-do-i-get-it-to-select-aka-highlight-t}
	 */
	private void createRightClickContextMenu() {
		JPopupMenu popup = createPopupMenu();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
				if (row >= 0 && row < table.getRowCount()) {
					table.setRowSelectionInterval(row,  row);
				} else {
					table.clearSelection();
				}
				
				int rowIndex = table.getSelectedRow();
				if (rowIndex < 0) return;
				if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
	}
	
	/**
	 * Gives right-click menu, containing delete- and special value editor-option
	 * @return Right-click menu
	 */
	
	private JPopupMenu createPopupMenu() {
		JPopupMenu menu = new JPopupMenu();
		ActionListener menuListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				switch (event.getActionCommand()) {
				case "getSpecialEditor":
					getSpecialEditor();
					break;
				case "deleteItem":
					data.removeComponent(table.getSelectedRow());
					break;
				default:
					break;
				}
			}
		};
		JMenuItem item;
		menu.add(item = new JMenuItem(I18N.getString("popupMenu.specialEditor")));
		item.setActionCommand("getSpecialEditor");
		item.setHorizontalTextPosition(JMenuItem.RIGHT);
		item.addActionListener(menuListener);
		menu.add(item = new JMenuItem(I18N.getString("popupMenu.deleteItem")));
		item.setActionCommand("deleteItem");
		item.setHorizontalTextPosition(JMenuItem.RIGHT);
		item.addActionListener(menuListener);
		menu.setLabel("LabelTest");
		menu.setBorder(new BevelBorder(BevelBorder.RAISED));
		menu.addPopupMenuListener(new PopupListener());
		table.setComponentPopupMenu(menu);
		return menu;				
	}
	
	private void getSpecialEditor() {
		BaseComponent comp = data.components.elementAt(table.getSelectedRow());
		Dimension windowDimension = null;
		String windowTitle = null;
		
		if (comp instanceof TextArea || comp instanceof TextField) {
			if (comp instanceof TextArea) {
				windowDimension = new Dimension(320, 145);
				windowTitle = I18N.getString("specialEditor.JTextArea.title");
			} else if (comp instanceof TextField) {
				windowDimension = new Dimension(320, 95);
				windowTitle = I18N.getString("specialEditor.JTextField.title");
			}
			JDialog frame = new JDialog(this, windowTitle, true); 
			frame.setSize(windowDimension);
			JPanel panel = (JPanel)data.components.elementAt(table.getSelectedRow()).getSpecialEditor();
			frame.add(panel);
			if (frame != null) {
				frame.setVisible(true);
			}
		}
	}
	
	/**
	 * Calls the functions which creates the surrounding menu- and toolbars.
	 * 
	 * @see 
	 */
	private void createAndShowBars() {
		
		ClickHandler handler = new ClickHandler();
		
		MenuBar menuBar = new MenuBar();		
		createFileMenu(menuBar, handler);
		createEditMenu(menuBar, handler);
		createHelpMenu(menuBar, handler);
		setJMenuBar(menuBar);
		
		ToolBar toolBar = new ToolBar(handler);
		createToolbar(toolBar, handler);
		add(toolBar, BorderLayout.NORTH);
		createStatusBar();
	}
	
	/**
	 * Creates the file menu and attaches appropriate event handlers.
	 * 
	 * @param bar Menu bar object which contains all the menu items.
	 * @param handler private ClickHandler object which manages the event handlers.
	 */
	private void createFileMenu(MenuBar bar, ClickHandler handler) {
		
		JMenu fileMenu = bar.createJMenu("menuBar.file");      
		bar.add(fileMenu);
		
		fileMenu.add(bar.createJMenuItem("file", "newFile", "New.gif", handler));
		fileMenu.add(bar.createJMenuItem("file", "open", "OpenDoc.gif", handler));
		fileMenu.add(bar.createJMenuItem("file", "save", "Save.gif", handler));
		fileMenu.add(bar.createJMenuItem("file", "saveAs", "Save.gif", handler));
		fileMenu.addSeparator();
		fileMenu.add(bar.createJMenuItem("file", "preview", "", handler));
		fileMenu.add(bar.createJMenuItem("file", "generateJava", "SaveJava.gif", handler));
		fileMenu.addSeparator();
		fileMenu.add(bar.createJMenuItem("file", "exit", "", handler));
		
	}
	
	
	private void createEditMenu(MenuBar bar, ClickHandler handler) {
		
		JMenu editMenu = bar.createJMenu("menuBar.edit");
		bar.add(editMenu);
		
		editMenu.add(bar.createJMenuItem("edit", "newRow", "NewRow.gif", handler));
		editMenu.addSeparator();
		editMenu.add(bar.createJMenuItem("edit", "preferences", "", handler));
		
	}
	
	/**
	 * Creates the help menu and attaches appropriate event handlers.
	 * 
	 * @param bar Menu bar object which contains all the menu items.
	 * @param handler private clickHandler object which manages the event handlers.
	 */
	private void createHelpMenu(MenuBar bar, ClickHandler handler) {
		JMenu helpMenu = bar.createJMenu("menuBar.help");
		bar.add(helpMenu);
		
		helpMenu.add(bar.createJMenuItem("help", "help", "Help.gif", handler));
		helpMenu.addSeparator();
		helpMenu.add(bar.createJMenuItem("help", "about", "", handler));
	}

	/**
	 * Creates the tool bar including all of its contents.
	 * 
	 * @param bar ToolBar object which contains all the toolbar buttons.
	 * @param handler private ClickHandler object which manages the event handlers.
	 */
	private void createToolbar(ToolBar bar, ClickHandler handler) {
		
		bar.makeButton("New.gif", "newFile", handler);
		bar.makeButton("OpenDoc.gif", "open", handler);
		bar.makeButton("Save.gif", "save", handler);
		bar.addSeparator();
		bar.makeButton("ExecuteProject.gif", "generateJava", handler);
		bar.makeButton("SaveJava.gif", "generateJava", handler);
		bar.addSeparator();
		bar.makeButton("NewRow.gif", "newRow", handler);
		bar.makeButton("MoveRowUp.gif", "moveRowUp", handler);
		bar.makeButton("MoveRowDown.gif", "moveRowDown", handler);
		bar.addSeparator();
		bar.makeButton("Help.gif", "help", handler);
		
	}
	
	/**
	 * Creates an empty main table.
	 */
	private void createAndShowTable() {
		data = new GBLEDataModel();
		table = new JTable(data);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.getViewport().setBackground(Color.WHITE);		// Ellers ser tabellen stygg ut, om vi fjerner komponenter
		add(scrollPane);
		createStatusBar();
	    makeSpecialColumns(table);
	    
	    for (int i = 0; i <= 8; i++) {		// Kortere kode. Behov for å endre bredde på hver enkelt? 
	    	table.getColumnModel().getColumn(i).setPreferredWidth(100);
	    }
	    // Thomas kommentar: Tanken var forskjellige bredder
	    /*
	    table.getColumnModel().getColumn(0).setPreferredWidth(100);
	    table.getColumnModel().getColumn(1).setPreferredWidth(100);
	    table.getColumnModel().getColumn(2).setPreferredWidth(100);
	    table.getColumnModel().getColumn(3).setPreferredWidth(100);
	    table.getColumnModel().getColumn(4).setPreferredWidth(100);
	    table.getColumnModel().getColumn(5).setPreferredWidth(100);
	    table.getColumnModel().getColumn(6).setPreferredWidth(100);
	    table.getColumnModel().getColumn(7).setPreferredWidth(100);
	    table.getColumnModel().getColumn(8).setPreferredWidth(100);
	    */
	    table.setRowHeight(20);
	    
	}
	
	/**
	 * Creates cell-specific renderer for columns 0, 7 and 8.
	 * 
	 * @param table JTable object containing the table
	 */
	private void makeSpecialColumns(JTable table) {
		String[] componentTypes = { "JLabel", "JButton", "JTextField", "JTextArea" };
		JComboBox<String> comboBox0 = new JComboBox<String>(componentTypes);
		table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboBox0));
		createIconComboBox(anchorConstraints, 7);
		table.getColumnModel().getColumn(7).setCellRenderer(new AnchorFillRenderer());
		table.getColumnModel().getColumn(8).setCellRenderer(new AnchorFillRenderer());


		createIconComboBox(fillConstraints, 8);
	}
	
	/**
	 * Makes JComboBoxes in specific columns in the JTable 
	 * 
	 * @param iconConstraints Integer-array, corresponding to GridBagConstraints
	 * @param col the column to add the combobox to
	 */
	public void createIconComboBox(Integer[] iconConstraints, int col) {
		JComboBox<Integer> comboBox = new JComboBox<Integer>(iconConstraints);
		comboBox.setRenderer(new IconListRenderer());
		table.getColumnModel().getColumn(col).setCellEditor(new DefaultCellEditor(comboBox));
	}
		
	/**
	 * Clears the table of components.
	 * 
	 */
	private void newFile() {
		data.clear();
		hasDefinedSaveLocation = false;
		isChanged = true;
	}
	
	/**
	 * Creates a new table row with the default component.
	 * 
	 */
	private void newRow() {
		data.addComponent(new Label());
		isChanged = true;
	}
	
	/**
	 * Moves a component up or down dependent on the given direction.
	 * 
	 * @param direction Integer value -1 (constant UP) for up, +1 for down (constant DOWN).
	 */
	private void moveRow(int direction) {
		int currentRow = table.getSelectedRow();
		
		if(direction == UP && currentRow > 0) {
			data.moveComponentUp(table.getSelectedRow());
			table.getSelectionModel().setSelectionInterval(currentRow-1, currentRow-1);
			isChanged = true;
											// La til en sjekk, for å unngå
											// flytting av nederste rad nedover:
		} else if (direction == DOWN && currentRow != data.getRowCount()-1) {
			data.moveComponentDown(table.getSelectedRow());
			table.getSelectionModel().setSelectionInterval(currentRow+1, currentRow+1);
			isChanged = true;
		}
	}
	
	/**
	 * Shows a centered message dialog.
	 * 
	 */
	private void showHelpDialog() {
		JOptionPane.showMessageDialog(this, "Not yet implemented");
	}
	
	/**
	 * Saves the current GridBagLayout file to the directory where the
	 * application lies.
	 * 
	 */
	private void save() {
		if(hasDefinedSaveLocation) {
			try {
				FileOutputStream fos = new FileOutputStream(saveFile);
				data.save(fos);
				fos.close();
				isChanged = false;
			} catch (IOException e) {
				
			}
		} else {
			saveAs();
		}
	}
	
	/**
	 * Saves the current GridBagLayout file to a directory of the user's
	 * choice with a filename and extension of the user's choice.
	 * 
	 */
	private void saveAs() {
		saveFile = getFileChooser("save");

		if(saveFile != null) {
			
			if(!saveFile.getName().endsWith(".gbl")) {
				saveFile = new File(saveFile + ".gbl");
			}
			try {
				FileOutputStream fos = new FileOutputStream(saveFile);
				data.save(fos);
				fos.close();
				hasDefinedSaveLocation = true;
				isChanged = false;
			} catch (IOException e) {
			
			}
		}
	}
	
	/**
	 * Loads an existing GridBagLayout file from a directory of the user's
	 * choice.
	 * 
	 */
	private void load() {
		if(isChanged == true) {
			save();
		}
		
		File openFile = getFileChooser("load");
		
		if(openFile != null) {
			try {
				FileInputStream fis = new FileInputStream(openFile);
				data.load(fis);
				hasDefinedSaveLocation = true;
				isChanged = false;
			} catch (FileNotFoundException e) {
				
			}
			
		}
	}
	
	/**
	 * Handles the visual file navigation on the user's system and
	 * returns the chosen file.
	 * 
	 * @return File Object of the selected folder/file, null if cancel.
	 */
	private File getFileChooser(String operation) {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("GridBagLayout layout file", "gbl");
		fileChooser.setFileFilter(filter);
		
		fileChooser.setDialogTitle(I18N.getString("fileChooser.title." + operation));
		fileChooser.setApproveButtonText(I18N.getString("fileChooser.approve." + operation));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		int res = fileChooser.showOpenDialog(this);
		
		if(res == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		} else {
			return null;
		}
	}
	
	/**
	 * Gets Java code from getJavaCodeString(String) and writes
	 * this to a text file with the same file path as
	 * the current saveFile. Adds a .java extension.
	 * 
	 */
	private void exportJavaCode() {
		
		if(isChanged || saveFile == null) {                          // Uses the file name on disk
			save();
		}

		
		String temp[];
		String fileName, className, exportFilePath, exportFileName;
		
		temp      = saveFile.getAbsolutePath().split("((/)|(\\\\))");
		
		fileName  = temp[temp.length-1].substring(0, 1).toUpperCase() 
				  + temp[temp.length-1].substring(1).toLowerCase();
		className = fileName.split("\\.")[0];
		
		exportFilePath  = saveFile.getAbsolutePath();
		exportFileName = exportFilePath.substring(0, exportFilePath.length() 
							- (fileName.length())) 
							+ className + ".java";
		
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(exportFileName)));
			out.write(getJavaExportString(className).toString());
			out.close();
		} catch (IOException e) {
			
		}
		
	}
	
	/**
	 * Exits the program, asks to save if changes are made.
	 * 
	 */
	private void exit() {
		if(isChanged) {
			save();
		}
		System.exit(0);
	}
	
	/**
	 * Builds the Java code constructed by the editor which9ol., is to be
	 * exported to a .java file.
	 * 
	 * @param className String value of the file name which will be used as the class name.
	 * @return String representation of the java code to be exported to file.
	 */
	private String getJavaExportString(String className) {
			
		StringBuilder javaCode = new StringBuilder();
		javaCode.append("import javax.swing.*;\n");
		javaCode.append("import java.awt.*;\n\n");
		javaCode.append("/**\n* Code generated from GridBagLayoutEditor v0.1\n*/\n");
		javaCode.append("public class " + className + " extends JPanel {\n");
		javaCode.append(data.getDefinitions() + "\n");
		javaCode.append("\tpublic " + className +  "() {\n");
		javaCode.append("\t\tGridBagLayout layout = new GridBagLayout();\n");
		javaCode.append("\t\tGridBagConstraints gbc = new GridBagConstraints();\n");
		javaCode.append("\t\tsetLayout(layout);\n");
		javaCode.append(data.getLayoutCode());
		javaCode.append("\t}\n\n");
		javaCode.append("\tpublic static void main(String[] args) {\n");
		javaCode.append("\t\tJFrame frame = new JFrame();\n");
		javaCode.append("\t\tframe.setSize(400, 400);\n");
		javaCode.append("\t\tframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\n");
		javaCode.append("\t\tframe.setVisible(true);\n\n");
		javaCode.append("\t\t" + className + " temp = new " + className + "();\n");
		javaCode.append("\t\tframe.add(temp, BorderLayout.CENTER);\n");
		javaCode.append("\t}\n}\n");
		return javaCode.toString();
	}

	
	private static void createStatusBar() {
		statusBar = new JTextField();
		statusBar.setEditable(false);
		statusBar.setHighlighter(null);
	}
	
	private static void setStatusText(String newText) {
		statusBar.setText(newText);
	}
	
	
	
	/**
	 * 
	 * @param args No command-line arguments are used
	 */
    public static void main( String[] args )
    {
    	App window = new App();
    }   
	
    private class ClickHandler implements ActionListener {
		
    	@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			
			switch (cmd) {
				case "newFile":
					newFile();
					break;
				
				case "newRow":
					newRow();
					break;

				case "moveRowUp":
					moveRow(UP);
					break;
					
				case "moveRowDown":
					moveRow(DOWN);
					break;
					
				case "help":
					showHelpDialog();
					break;
					
				case "save":
					save();
					break;
					
				case "saveAs":
					saveAs();
					break;
				
				case "open":
					load();
					break;
					
				case "generateJava":
					exportJavaCode();
					break;
					
				case "exit":
					exit();
					break;
					
					
				default:
					System.out.println(cmd);
					break;
			}
		}
	}
    
	
	private class PopupListener implements PopupMenuListener {

		@Override
		public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			
		}

		@Override
		public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
			
		}

		@Override
		public void popupMenuCanceled(PopupMenuEvent e) {
			
		}
		
	}

	/**
	 * Creates JSpinner-object with associated label, with correct values for min/max/current.
	 * Assumes minimum-value is 0.
	 * 
	 * @see <a href="http://docs.oracle.com/javase/tutorial/uiswing/examples/components/SpinnerDemoProject/src/components/SpinnerDemo.java"></a>
	 * @param c Container to add the JSpinner to
	 * @param label Label with the text associated with the spinner
	 * @param spinnerMax Maximum value for this spinner
	 * @param currentValue The current value of this parameter for the object, also starting-point for spinner.
	 * @return JSpinner-object
	 */
	public static JSpinner addLabeledSpinner(Container c, String label, int spinnerMax, int currentValue) {
		final int SPINNERMIN = 0;
		
		JLabel l = new JLabel(label);
		c.add(l);
		
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(currentValue, SPINNERMIN, spinnerMax, 1));
		l.setLabelFor(spinner);
		c.add(spinner);
		
		spinner.setEditor(new JSpinner.NumberEditor(spinner));
		return spinner;
	}
}



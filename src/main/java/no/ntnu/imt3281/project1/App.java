package no.ntnu.imt3281.project1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * App class serves as a container for the whole application and also contains
 * the static main function.
 * 
 * @author thomasgg
 * @author sadario
 *
 */
public class App extends JFrame
{
	private static final int UP = -1;
	private static final int DOWN = 1;
	private GBLEDataModel data;
	private JTable table;
	
	/**
	 * Constructor
	 * 
	 */
	public App() {
		super(I18N.getString("application.title"));
		this.setLayout(new BorderLayout());
		
		createAndShowBars();
		createAndShowTable();
		
		setSize(800, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
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
		
		JTextField statusBar = new JTextField("statusBar - TestText");
		statusBar.setEditable(false);
		statusBar.setHighlighter(null);
		add(statusBar, BorderLayout.SOUTH);
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
		fileMenu.add(bar.createJMenuItem("file", "generate", "SaveJava.gif", handler));
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
	
	private void createHelpMenu(MenuBar bar, ClickHandler handler) {
		
	}
	
	/**
	 * Creates the toolbar including all of its contents.
	 * 
	 * @param bar ToolBar object which contains all the toolbar buttons.
	 * @param handler private ClickHandler object which manages the event handlers.
	 */
	private void createToolbar(ToolBar bar, ClickHandler handler) {
		
		bar.makeButton("New.gif", "newFile", handler);
		bar.makeButton("OpenDoc.gif", "openFile", handler);
		bar.makeButton("Save.gif", "saveFile", handler);
		bar.addSeparator();
		bar.makeButton("ExecuteProject.gif", "generate", handler);
		bar.makeButton("SaveJava.gif", "saveBin", handler);
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
		add(new JScrollPane(table));
	    
	    makeSpecialColumns(table, data);
	    
	    for (int i = 0; i <= 8; i++) {		// Kortere kode. Behov for å endre bredde på hver enkelt? 
	    	table.getColumnModel().getColumn(i).setPreferredWidth(100);
	    }
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
	 * Makes each table cell interactive and editable.
	 * 
	 */
	private void makeSpecialColumns(JTable table, GBLEDataModel data) {
		String[] componentTypes = { "JLabel", "JButton", "JTextField", "JTextArea" };
		JComboBox<String> comboBox0 = new JComboBox<String>(componentTypes);
		table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboBox0));
		

//	AnchorFillRenderer anchorFillRenderer = new AnchorFillRenderer();                             
//	JComboBox<Integer> comboBox7 = new JComboBox<Integer>(anchorFillRenderer.getAnchorValues());
//	comboBox7.setRenderer((ListCellRenderer<>) anchorFillRenderer);

		String[] anchorIconNames = { 	"anchor_center", "anchor_north", 
				"anchor_northeast", "anchor_northwest", 
				"anchor_south", "anchor_southwest", 
				"anchor_southeast" };
		createIconComboBox(anchorIconNames, 7);
		
		String[] fillIconNames = {	"skaler_begge", "skaler_horisontalt",
				"skaler_ingen", "skaler_vertikalt" };
		createIconComboBox(fillIconNames, 8);
	}
	
	/**
	 * Makes JComboBoxes in specific columns in the JTable 
	 * 
	 * @param iconNames String-array with the icon-names (excluding path and *.filetype
	 * @param col the column to add the combobox to
	 */
	public void createIconComboBox(String[] iconNames, int col) {
		Vector<Icon> icons = new Vector<Icon>();
		
		for (String iconName : iconNames) {
			String fullIconPath = "graphics/" + iconName + ".png";
			Icon icon = new ImageIcon(getClass().getResource(fullIconPath));
			icons.add(icon);
		}

		JComboBox<Icon> comboBox = new JComboBox<Icon>(icons);
		table.getColumnModel().getColumn(col).setCellEditor(new DefaultCellEditor(comboBox));

	}
		
	/**
	 * Clears the table of components.
	 * 
	 */
	private void clear() {
		data.clear();
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
											// La til en sjekk, for å unngå
											// flytting av nederste rad nedover:
		} else if (direction == DOWN && currentRow != data.getRowCount()-1) {
			data.moveComponentDown(table.getSelectedRow());
			table.getSelectionModel().setSelectionInterval(currentRow+1, currentRow+1);
		}
	}
	
	
	/**
	 * 
	 * 
	 * @param args
	 */
    public static void main( String[] args )
    {
    	App window = new App();
    }
    
    
    
    private class TableHandler implements TableModelListener {

		@Override
		public void tableChanged(TableModelEvent e) {
			int row = e.getFirstRow();
			int col = e.getColumn();
			TableModel model = (TableModel)e.getSource();
			Object cellData = model.getValueAt(row, col);
			
			if(col == 0) {
				// data.setValueAt(Object stringVal, int rowIndex, int 0)
			}
			
		}


    	
    }
    
	private class ClickHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			
			switch (cmd) {
				case "newFile":
					clear();
					break;
				
				case "newRow":
					data.addComponent(new Label());
					break;

				case "moveRowUp":
					moveRow(UP);
					break;
					
				case "moveRowDown":
					moveRow(DOWN);
					break;
					
				default:
					System.out.println(cmd);
					break;
			}
		}
	}
}

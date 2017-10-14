package no.ntnu.imt3281.project1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
	 * Creates the surrounding menu- and toolbars.
	 * 
	 */
	private void createAndShowBars() {
		MenuBar bar = new MenuBar();
		ClickHandler handler = new ClickHandler();
		createFileMenu(bar, handler);
		createEditMenu(bar, handler);
		createHelpMenu(bar, handler);
		ToolBar toolBar = new ToolBar();
		this.add(toolBar, BorderLayout.NORTH);
	}
	
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
		
		this.setJMenuBar(bar);
	}
	
	private void createEditMenu(MenuBar bar, ClickHandler handler) {
		JMenu editMenu = bar.createJMenu("menuBar.edit");
		bar.add(editMenu);
		
		// test
		
		editMenu.add(bar.createJMenuItem("edit", "newRow", "NewRow.gif", handler));
		editMenu.addSeparator();
		editMenu.add(bar.createJMenuItem("edit", "preferences", "", handler));
		
	}
	
	private void createHelpMenu(MenuBar bar, ClickHandler handler) {
		
	}
	
	
	/**
	 * Creates an empty main table.
	 */
	private void createAndShowTable() {
		data = new GBLEDataModel();
		table = new JTable(data);
		
	    this.add(new JScrollPane(table));
		
		String[] columnHeaders = new String[data.getNumColumns()];
		
		for(int ii = 0; ii < data.getNumColumns(); ++ii) {
			columnHeaders[ii] = data.getColumnName(ii);
	//		table.getColumnModel().getColumn(ii).setPreferredWidth(20);
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
    
	private class ClickHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
		//	JOptionPane.showMessageDialog(null, cmd);
			
			switch (cmd) {
			
			case "newFile":
				data.clear();
				
				break;
			case "newRow":
				data.addComponent(new Label());
				break;

			default:
				break;
			}
		}
		


	}
    
}

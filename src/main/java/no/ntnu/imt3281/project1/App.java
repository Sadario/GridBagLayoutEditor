package no.ntnu.imt3281.project1;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

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
	GBLEDataModel data;
	
	/**
	 * 
	 * 
	 */
	public App() {
		super("GridBagLayout editor");
		this.setLayout(new BorderLayout());
		data = new GBLEDataModel();
		
		JMenuBar bar = new MenuBar();
		this.setJMenuBar(bar);
		
		ToolBar toolBar = new ToolBar();
		this.add(toolBar, BorderLayout.NORTH);
	}
	
	/**
	 * 
	 * 
	 * @param args
	 */
    public static void main( String[] args )
    {
        App window = new App();
        // linjene under kan og puttes i App CTOR (uten window.) - bedre?
		window.setSize(800, 400);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
        
    }
}

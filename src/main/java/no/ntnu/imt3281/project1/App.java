package no.ntnu.imt3281.project1;

import javax.swing.JFrame;

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
		super("Window title test");
		data = new GBLEDataModel();
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

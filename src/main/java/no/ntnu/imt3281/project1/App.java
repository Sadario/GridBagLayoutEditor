package no.ntnu.imt3281.project1;

import javax.swing.JPanel;


public class App extends JPanel
{
	GBLEDataModel data;
	
	public App() {
		data = new GBLEDataModel();
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}

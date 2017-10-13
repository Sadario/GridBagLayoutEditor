package no.ntnu.imt3281.project1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		
		JOptionPane.showMessageDialog(null, "test:  " + event.getActionCommand());
	}
	

}

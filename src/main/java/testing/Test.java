package testing;
import javax.swing.*;
import java.awt.*;

/**
* Code generated from GridBagLayoutEditor v0.1
*/
public class Test extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel component0 = new JLabel("dette er min label");
	JButton component1 = new JButton("knapper");
	JTextArea component2 = new JTextArea("test", 0, 0);

	public Test() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(layout);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 10;
		gbc.gridheight = 10;
		gbc.anchor = 10;
		gbc.fill = 2;
		layout.setConstraints(component0, gbc);
		add(component0);
		gbc.gridx = 5;
		gbc.gridy = 5;
		gbc.gridwidth = 10;
		gbc.gridheight = 10;
		gbc.anchor = 10;
		gbc.fill = 0;
		layout.setConstraints(component1, gbc);
		add(component1);
		gbc.gridx = 20;
		gbc.gridy = 20;
		gbc.gridwidth = 1;
		gbc.gridheight = 50;
		gbc.anchor = 10;
		gbc.fill = 0;
		layout.setConstraints(component2, gbc);
		add(component2);
		component2.setWrapStyleWord(false);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		Test temp = new Test();
		frame.add(temp, BorderLayout.CENTER);
	}
}

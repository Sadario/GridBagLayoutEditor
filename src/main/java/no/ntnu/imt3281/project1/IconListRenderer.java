/**
 * 
 */
package no.ntnu.imt3281.project1;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.util.HashMap;

import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 * Renders icons in JComboBoxes in column 7 and 8
 * @author sadario
 * @author thomasgg
 */
public class IconListRenderer extends DefaultListCellRenderer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<Integer, Icon> icons;

	/**
	 * Creates a HashMap, where GridBagConstraints refer to icons
	 */
	public IconListRenderer() {
		icons = new HashMap<Integer, Icon>();
		icons.put(GridBagConstraints.NORTH, new ImageIcon(getClass().getResource("graphics/anchor_north.png")));
		icons.put(GridBagConstraints.NORTHEAST, new ImageIcon(getClass().getResource("graphics/anchor_northeast.png")));
		icons.put(GridBagConstraints.NORTHWEST, new ImageIcon(getClass().getResource("graphics/anchor_northwest.png")));
		icons.put(GridBagConstraints.EAST, new ImageIcon(getClass().getResource("graphics/anchor_east.png")));
		icons.put(GridBagConstraints.CENTER, new ImageIcon(getClass().getResource("graphics/anchor_center.png")));
		icons.put(GridBagConstraints.WEST, new ImageIcon(getClass().getResource("graphics/anchor_west.png")));
		icons.put(GridBagConstraints.SOUTH, new ImageIcon(getClass().getResource("graphics/anchor_south.png")));
		icons.put(GridBagConstraints.SOUTHEAST, new ImageIcon(getClass().getResource("graphics/anchor_southeast.png")));
		icons.put(GridBagConstraints.SOUTHWEST, new ImageIcon(getClass().getResource("graphics/anchor_southwest.png")));
		icons.put(GridBagConstraints.NONE, new ImageIcon(getClass().getResource("graphics/skaler_ingen.png")));
		icons.put(GridBagConstraints.HORIZONTAL, new ImageIcon(getClass().getResource("graphics/skaler_horisontalt.png")));
		icons.put(GridBagConstraints.VERTICAL, new ImageIcon(getClass().getResource("graphics/skaler_vertikalt.png")));
		icons.put(GridBagConstraints.BOTH, new ImageIcon(getClass().getResource("graphics/skaler_begge.png")));
	}

	/* (non-Javadoc)
	 * @see javax.swing.ListCellRenderer#getListCellRendererComponent(javax.swing.JList, java.lang.Object, int, boolean, boolean)
	 */
	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index,
													boolean isSelected, boolean cellHasFocus) {

		
		JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		
		// Get icon to use for the list item value
		
		Icon icon = icons.get(value);
		
		// Set icon to display for value
		
		label.setIcon(icon);
		return label;
	}

}

package no.ntnu.imt3281.project1;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/** 
 * Renders icons on columns 7 and 8
 * @author sadario
 * @author thomasgg
 */

public class AnchorFillRenderer extends JLabel implements TableCellRenderer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient Map<Integer, Icon> icons;
	
	public AnchorFillRenderer() {
		setOpaque(true);
		
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
	
	/**
	 * Overridden TableCellRenderer-function.
	 * @return Component Icon to populate cell
	 */
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, 
			                                       boolean isSelected, boolean hasFocus,
			                                       int row, int column) {
		if (value != null) {
			if (column == 7 || column == 8) {
				this.setIcon(icons.get(value));
			}
		}
		return this;
	}
	
	

	
}

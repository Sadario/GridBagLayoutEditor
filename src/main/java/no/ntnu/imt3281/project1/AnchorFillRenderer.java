package no.ntnu.imt3281.project1;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.table.TableCellRenderer;

public class AnchorFillRenderer extends JLabel implements TableCellRenderer {
	
	private Map<String, Integer> anchorMap;
	private Map<String, Integer> fillMap;
	
	public AnchorFillRenderer() {
		
		anchorMap = new HashMap<String, Integer>();
		fillMap = new HashMap<String, Integer>();
		
		setOpaque(true);
		
		anchorMap.put("anchor_north", GridBagConstraints.NORTH);
		anchorMap.put("anchor_northeast", GridBagConstraints.NORTHEAST);
		anchorMap.put("anchor_northwest", GridBagConstraints.NORTHWEST);
		anchorMap.put("anchor_east", GridBagConstraints.EAST);
		anchorMap.put("anchor_center", GridBagConstraints.CENTER);
		anchorMap.put("anchor_west", GridBagConstraints.WEST);
		anchorMap.put("ancor_south", GridBagConstraints.SOUTH);
		anchorMap.put("anchor_southeast", GridBagConstraints.SOUTHEAST);
		anchorMap.put("anchor_southwest", GridBagConstraints.SOUTHWEST);
		
		fillMap.put("skaler_horisontal", GridBagConstraints.HORIZONTAL);
		fillMap.put("skaler_vertikal", GridBagConstraints.VERTICAL);
		fillMap.put("skaler_begge", GridBagConstraints.BOTH);
		fillMap.put("skaler_ingen", GridBagConstraints.NONE);
		
	}
	
	public Integer[] getAnchorValues() {
		Integer[] temp;
		temp = new Integer[9];
		
		System.out.println(temp[0]);
		return temp;
		
		// må returnere array med int-er 
	}

	/**
	 * 
	 * @see javax.swing.ListCellRenderer#getListCellRendererComponent(JList, Object, int, boolean, boolean)
	 */
/*	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, 
			                                      boolean isSelected, boolean cellHasFocus) {
		if(value != null) {
			setFont(list.getFont());
			setIcon(new ImageIcon(getClass().getResource("/graphics/")));
		}
		
		if(isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionBackground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		
		return this;
	}
*/
	



	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, 
			                                       boolean isSelected, boolean hasFocus,
			                                       int row, int column) {
		if(value != null) {
			setIcon(new ImageIcon(getClass().getResource("/graphics/")));
		}
		
		if(isSelected) {
			setBackground(table.getSelectionBackground());
			setForeground(table.getSelectionBackground());
		} else {
			setBackground(table.getBackground());
			setForeground(table.getForeground());
		}
				
		return this;
	}
	
	
	

	
}

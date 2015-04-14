package USCorg;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchPanel extends JPanel {
	
	public String searchText;
	public JButton searchBut;
	public JTextField searchTextfield;

	public SearchPanel() {
		// TODO Auto-generated constructor stub
		
		searchTextfield = new JTextField();
		JLabel titleLab = new JLabel("  Search Organizations:");
		titleLab.setForeground(Color.DARK_GRAY);
		JLabel blankLab1 = new JLabel("");
		JLabel blankLab2 = new JLabel("");
		JLabel searchLab = new JLabel("  Search: ");
		searchLab.setForeground(Color.DARK_GRAY);
		searchBut = new JButton("Search");
		searchBut.setForeground(Color.DARK_GRAY);
		setLayout(new GridLayout(3,2));
		add(titleLab);
		add(blankLab1);
		add(searchLab);
		add(searchTextfield);
		add(blankLab2);
		add(searchBut);
		setBackground(Color.LIGHT_GRAY);
	}

}

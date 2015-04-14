package USCorg;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/* Registration panel that will go in place of the central
 * display panel in the GUI. Shows up when a user clicks
 * the "Click to Register" button.
 */

public class OrganizationPanel extends JPanel {
	JLabel nameLabel = new JLabel("Organization Name");
	
	public OrganizationPanel(String name)  {
		this.nameLabel.setText(name);
		setLayout(new GridLayout(1,2));
		setBackground(Color.BLACK);
		add(new ImagePanel());
		add(getOrganizationPanel());
	}
	
	JPanel getOrganizationPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(6,2));
		Font font = nameLabel.getFont();
		nameLabel.setFont(font.deriveFont(Font.BOLD));
		nameLabel.setForeground(Color.BLUE);
		JLabel descriptionLabel = new JLabel("Description: ");
		JLabel blankLabel = new JLabel("");
		JLabel contactLabel = new JLabel("Contact: ");
		JLabel numberMembersLabel = new JLabel("Number of Members: ");
		JLabel duesLabel = new JLabel("Dues: ");
		JLabel audienceLabel = new JLabel("Audience: ");
		JTextPane descriptionPane = new JTextPane();
		JTextPane contactPane = new JTextPane();
		JTextPane numberMembersPane = new JTextPane();
		JTextPane duesPane = new JTextPane();
		JTextPane audiencePane = new JTextPane();

		
		

		mainPanel.add(nameLabel);
		mainPanel.add(blankLabel);
		mainPanel.add(descriptionLabel);
		mainPanel.add(descriptionPane);
		mainPanel.add(contactLabel);
		mainPanel.add(contactPane);
		mainPanel.add(numberMembersLabel);
		mainPanel.add(numberMembersPane);
		mainPanel.add(duesLabel);
		mainPanel.add(duesPane);
		mainPanel.add(audienceLabel);
		mainPanel.add(audiencePane);

		
		
		
		return mainPanel;
	}
}
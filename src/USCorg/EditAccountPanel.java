package USCorg;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EditAccountPanel extends JPanel {
	
	JButton editAccountButton;
	JPanel displayPanel;
	
	public EditAccountPanel(JPanel displayPanel){
		super.setLayout(new GridLayout(1,1));
		editAccountButton = new JButton("Edit Account");
		this.displayPanel = displayPanel;	
		add(editAccountButton);
		editAccountButton.addActionListener(new setDisplayPanelActionListener(displayPanel, new AccountPanel()));

		
		
	}

}

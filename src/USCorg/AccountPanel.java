package USCorg;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* Registration panel that will go in place of the central
 * display panel in the GUI. Shows up when a user clicks
 * the "Click to Register" button.
 */

public class AccountPanel extends JPanel {
	public AccountPanel()  {
		setLayout(new BorderLayout());
		
		add(getAccountPanel());
	}
	
	JPanel getAccountPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JLabel titleLabel = new JLabel("Edit Account");
		titleLabel.setForeground(Color.RED);
		JTextField firstNameTextField = new JTextField("First Name");
		JLabel firstnameLabel = new JLabel("First Name: ");
		JTextField lastNameTextField = new JTextField("Last Name");
		JLabel lastnameLabel = new JLabel("Last Name: ");
		JTextField emailTextField = new JTextField("USC Email");
		JLabel emailLabel = new JLabel("USC Email: ");
		JTextField idTextField = new JTextField("USC ID #");
		JLabel idLabel = new JLabel("USC ID #: ");
		JTextField passwordTextField = new JTextField("New Password");
		JLabel passwordLabel = new JLabel("New Password: ");
		JTextField confirmPasswordTextField = new JTextField("Confirm Password");
		JLabel confirmPasswordLabel = new JLabel("Confirm Password: ");

		
		JButton editAccountButton = new JButton("Edit Account");
		
		JPanel [] rowPanels = new JPanel[6];
		for (int i = 0; i < 6; i++) {
			rowPanels[i] = new JPanel();
		}
		rowPanels[0].add(titleLabel);
		rowPanels[1].add(firstnameLabel);
		rowPanels[1].add(firstNameTextField);
		rowPanels[1].add(lastnameLabel);
		rowPanels[1].add(lastNameTextField);
		rowPanels[2].add(emailLabel);
		rowPanels[2].add(emailTextField);
		rowPanels[3].add(idLabel);
		rowPanels[3].add(idTextField);
		rowPanels[4].add(passwordLabel);
		rowPanels[4].add(passwordTextField);
		rowPanels[4].add(confirmPasswordLabel);
		rowPanels[4].add(confirmPasswordTextField);
		rowPanels[5].add(editAccountButton);
		
		for (int i = 0; i < 6; i++) {
			mainPanel.add(rowPanels[i]);
		}
		
		
		return mainPanel;
	}
}
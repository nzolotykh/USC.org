package USCorg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* Registration panel that will go in place of the central
 * display panel in the GUI. Shows up when a user clicks
 * the "Click to Register" button.
 */

public class RegistrationPanel extends JPanel {
	
	JButton registerButton = new JButton ("Register");
	JPanel displayPanel;
	
	public RegistrationPanel( JPanel displayPanel)  {
		this.displayPanel = displayPanel;
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setBackground(Color.white);
		JLabel titleLabel = new JLabel("Registration: Page 1                             \n");
		titleLabel.setForeground(Color.BLUE);
		JLabel blankLabel = new JLabel("Personal Information    ");
		blankLabel.setForeground(Color.RED);
		add(titleLabel);
		add(blankLabel);
		add(getRegistrationPanel());
		add(registerButton);
		
		


	}
	
	JPanel getRegistrationPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(6,2));
		mainPanel.setBackground(Color.white);
		
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
	
		registerButton.addActionListener(new setDisplayPanelActionListener(displayPanel, new RegistrationPanel2()));

		
		mainPanel.add(firstnameLabel);
		mainPanel.add(firstNameTextField);
		mainPanel.add(lastnameLabel);
		mainPanel.add(lastNameTextField);
		mainPanel.add(emailLabel);
		mainPanel.add(emailTextField);
		mainPanel.add(idLabel);
		mainPanel.add(idTextField);
		mainPanel.add(passwordLabel);
		mainPanel.add(passwordTextField);
		mainPanel.add(confirmPasswordLabel);
		mainPanel.add(confirmPasswordTextField);
		//mainPanel.add(registerButton);
		

		

		
		
		return mainPanel;
	}
}
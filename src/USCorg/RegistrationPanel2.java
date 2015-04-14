package USCorg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* Registration panel that will go in place of the central
 * display panel in the GUI. Shows up when a user clicks
 * the "Click to Register" button.
 */

public class RegistrationPanel2 extends JPanel {
	
	JButton registerButton = new JButton ("Register");
	
	public RegistrationPanel2()  {
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setBackground(Color.white);
		JLabel titleLabel = new JLabel("Registration: Page 2                             \n");
		titleLabel.setForeground(Color.BLUE);
		JLabel blankLabel = new JLabel("Now, tell us a little bit about yourself.    ");
		blankLabel.setForeground(Color.RED);
		add(titleLabel);
		add(blankLabel);
		add(getRegistration2Panel());
		add(registerButton);

	}
	
	JPanel getRegistration2Panel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(6,2));
		mainPanel.setBackground(Color.white);
		
		JTextField majorTextField = new JTextField("Ex. Computer Science");
		JLabel majorLabel = new JLabel("Major(s)");
		JTextField minorTextField = new JTextField("Ex. Cinematic Arts");
		JLabel minorLabel = new JLabel("Minor: ");
	

		
		
		mainPanel.add(majorLabel);
		mainPanel.add(majorTextField);
		mainPanel.add(minorLabel);
		mainPanel.add(minorTextField);

		//mainPanel.add(registerButton);
		

		
		
		return mainPanel;
	}
}
package USCorg;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	
	public String userName;
	public String passWord;
	public JButton registerBut;
	public JButton loginBut;
	public JTextField loginText;
	public JTextField passText;
	JLabel messageLab;
		//these textfield's will contain the user's text to pass into the backend
	JPanel displayPanel;

	public LoginPanel( JPanel displayPanel) {
		
		this.displayPanel = displayPanel;	
		JLabel titleLab = new JLabel("  Please Login!");
		JLabel loginLab = new JLabel("  Login: ");
		titleLab.setForeground(Color.LIGHT_GRAY);
		loginLab.setForeground(Color.LIGHT_GRAY);
		JLabel passLab = new JLabel("  Password: ");
		passLab.setForeground(Color.LIGHT_GRAY);
		JLabel blankLab1 = new JLabel("");
		JLabel blankLab2 = new JLabel("");
		messageLab = new JLabel("");
		messageLab.setForeground(Color.YELLOW);

		loginBut = new JButton("Login!");
		loginBut.setForeground(Color.BLUE);
		
		JLabel registerLab = new JLabel("  Not a member?");
		registerLab.setForeground(Color.RED);
		registerBut = new JButton("Click to Register");
		//registerBut.addActionListener(new setDisplayPanelActionListener(displayPanel,null));

		registerBut.addActionListener(new setDisplayPanelActionListener(displayPanel, new RegistrationPanel(displayPanel)));
		/*registerBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				displayPanel.removeAll();
				displayPanel.add(new RegistrationPanel());
			}
			
		});*/
		registerBut.setForeground(Color.RED);
		loginText = new JTextField();
		passText = new JTextField();
		loginBut.addActionListener(new ActionListener(){
			//testing if login function in backend works, provide example to call a function 
			//from backend and database
			//TODO modify it 
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Backend.login(loginText.getText(), passText.getText())) {
					messageLab.setText("  YOU LOGGED IN");
				} else {
					messageLab.setText("  Incorrect Login.");
				}
			}
		});
		super.setBackground(Color.DARK_GRAY);
		setLayout(new GridLayout(5,2));
			
		add(titleLab);
		add(blankLab1);
		add(loginLab);
		add(loginText);
		add(passLab);
		add(passText);
		add(messageLab);
		add(loginBut);
		add(registerLab);
		add(registerBut);
				
	}

}

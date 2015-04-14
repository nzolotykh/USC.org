package USCorg;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CurrentOrgPanel extends JPanel {
	
	//this is pretty simple but essentially it'll just be a textarea where we can append the student's orgs
	//-Priyam
	public JTextArea textArea; //textarea used to display them
	public ArrayList<String> currentOrgs; //probably the arraylist we'll pass into

	
	public CurrentOrgPanel() {
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setForeground(Color.RED);
		
		currentOrgs = new ArrayList<String>();
		//currentOrgs = Backend.getUserOrganizationsNames(Backend.getCurrentUser());
		currentOrgs.add("  Futsol Club");
		currentOrgs.add("  LavaLab");
		currentOrgs.add("  Photography Club");
		textArea.append("  Current Organizations: \n \n");
		for(int i = 0; i < currentOrgs.size(); i++)
		{
			textArea.append(currentOrgs.get(i) + "\n");
		}
		textArea.append(" \n I sneezed on the GUI and the GUI got sickah");

		

		
		setLayout(new GridLayout(1,1));
		add(textArea);

		
		
		// TODO Auto-generated constructor stub
	}

}
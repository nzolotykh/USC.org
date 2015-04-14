package USCorg;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class NotificationPanel extends JPanel {
	
	public JTextArea firstTextarea;
	public JTextArea secondTextarea;
	public JTextArea thirdTextarea;

	
	public NotificationPanel() {
		firstTextarea = new JTextArea();
		firstTextarea.setBackground(Color.BLUE);
		secondTextarea = new JTextArea();
		secondTextarea.setBackground(Color.RED);
		thirdTextarea = new JTextArea();
		thirdTextarea.setBackground(Color.WHITE);
		
		JLabel titleLab = new JLabel("  Notifications:");
		titleLab.setForeground(Color.DARK_GRAY);
		JLabel mondayLab = new JLabel("  Monday: ");
		mondayLab.setForeground(Color.DARK_GRAY);

		JLabel tuesdayLab = new JLabel("  Tuesday: ");
		tuesdayLab.setForeground(Color.DARK_GRAY);

		JLabel wednesdayLab = new JLabel("  Wednesday: ");
		wednesdayLab.setForeground(Color.DARK_GRAY);

		JLabel blankLab1 = new JLabel("");
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridLayout(4,2));
		add(titleLab);
		add(blankLab1);
		add(mondayLab);
		add(firstTextarea);
		firstTextarea.append("'Y'all feel it too?'");

		add(tuesdayLab);
		add(secondTextarea);
		secondTextarea.append("'AMERICA RWB'");

		add(wednesdayLab);
		add(thirdTextarea);
		thirdTextarea.append("'Is she a gold digger?'");

		
		
		// TODO Auto-generated constructor stub
	}

}
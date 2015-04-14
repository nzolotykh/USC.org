package USCorg;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame{
	/* NOTES FOR PRIYAM (regarding GUI):
	 * 
	 * 1. Please make sure to name your variables with full names.
	 * I cleaned up the MainFrame class in terms of that, so try to follow something similar!
	 * It's annoying to write everything out, but really helps when you have a lot of things.
	 * 
	 * 2. Try not to manually change the sizes of GUI with .setSize() and using specific numbers,
	 * especially for things like panels. I think it will look different depending on the size
	 * of the user's monitor so if we do that, the GUI might look different depending on the user.
	 * For panels, generally, I don't think you need to specify the size because the layout manager
	 * should handle that for you. But when you do, try to think of the size in terms of the user's
	 * screen size proportions (e.g., .getScreenSize().getWidth() for the width of the monitor).
	 * Also if you specify the size of a panel or something, make sure to do it in that object's
	 * constructor and not in the MainFrame!
	 * 
	 * 3. If you notice, I added the JPanel displayPanel as a MainFrame object.
	 * That will be the central display panel where we will display other panels when the user
	 * interacts with the UI. For example, when the user clicks to Register, the display panel
	 * is where the user will see the registration forms.
	 * Notice I did not make it static. When we create other classes that will
	 * need access to that panel, we will pass it in as a reference for performance maximization.
	 * For an example, look at the registration button in the LoginPanel class.
	 * 
	 * 4. The setDisplayPanelActionListener will be used exactly for that purpose -- to set
	 * the central display panel to another panel. Probably will be used mainly with buttons.
	 * 
	 * Love and Rainbows,
	 * 					Nikita
	 * 
	 */
	
	
	
	private JPanel displayPanel = new JPanel();
	private JPanel eastPanel = new JPanel();
	private JPanel westPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	
	public MainFrame()  {
		super("USC.org");
		super.setLayout(new BorderLayout());

		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		eastPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		westPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		add(eastPanel, BorderLayout.EAST);
		add(westPanel, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		
		//created east, west, and center panels that'll use boxlayouts to add all the panels into
		//still not sure how to actually customize size and everything tho...
		//Priyam

		LogoPanel logoPanel = new LogoPanel();
		LoginPanel loginPanel = new LoginPanel(displayPanel);
		loginPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		SearchPanel searchPanel = new SearchPanel();
		searchPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		CategoryPanel categoryPanel = new CategoryPanel(displayPanel);
		categoryPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		NotificationPanel notificationPanel = new NotificationPanel();
		notificationPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		CalendarPanel calendarPanel = new CalendarPanel();
		calendarPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		CurrentOrgPanel currentorgPanel = new CurrentOrgPanel();
		currentorgPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		EditAccountPanel editaccountPanel = new EditAccountPanel(displayPanel);
		//editaccountPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		
		JPanel blankPanel = new JPanel();
		blankPanel.setBackground(Color.WHITE);

		displayPanel.setBackground(Color.WHITE);
		JScrollPane scroll = new JScrollPane(displayPanel);
		centerPanel.add(logoPanel);
		centerPanel.add(scroll);
		//centerPanel.add(blankPanel);
		
		westPanel.add(loginPanel);
		westPanel.add(searchPanel);
		westPanel.add(categoryPanel);
		westPanel.add(new JPanel());
		westPanel.add(new JPanel());
		westPanel.add(new JPanel());
		westPanel.add(editaccountPanel);

		eastPanel.add(currentorgPanel);
		eastPanel.add(notificationPanel);
		eastPanel.add(calendarPanel);
		eastPanel.add(new JPanel());

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setVisible(true);
		setResizable(false);
		validate();
	}
	
	public static void main(String [] args)
	{
		MainFrame mf = new MainFrame();
	}

}

class setDisplayPanelActionListener implements ActionListener {
	//this is an action listener that will be used to alternate the display panel
	//display panel = central panel
	JPanel newPanel;
	JPanel displayPanel;
	
	setDisplayPanelActionListener(JPanel displayPanel, JPanel newPanel) {
		this.newPanel = newPanel;
		this.displayPanel = displayPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (displayPanel.getComponentCount() != 0)
			displayPanel.getComponent(0).setVisible(false);
		displayPanel.removeAll();
		displayPanel.add(newPanel);
		displayPanel.validate();
		
	}
	
}
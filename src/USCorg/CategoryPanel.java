package USCorg;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

public class CategoryPanel extends JPanel implements TreeSelectionListener {
	
	private JTree organizationTree;
	private ArrayList<String> categoryArray;
	private JLabel categoryLabel;
	private JPanel displayPanel;
		//We need to meet in person in order to sort this shit out but I basically made an arraylist
	//of categories
	//I'm assuming we'll then use this to add into each thing as I did underneath manually -Priyam
	public CategoryPanel(JPanel displayPanel)
	{
		this.displayPanel = displayPanel;
		categoryArray = new ArrayList<String>();
		categoryArray.add("Sports");
		categoryArray.add("Technology");
		categoryArray.add("Arts");
		categoryLabel = new JLabel("  View Organizations (By Category)");
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(" Category");
		for(int i = 0; i < categoryArray.size(); i++)
		{
			DefaultMutableTreeNode categoryNode = new DefaultMutableTreeNode(categoryArray.get(i));
			if(i == 0)
			{
				categoryNode.add(new DefaultMutableTreeNode("Archery Club"));
				categoryNode.add(new DefaultMutableTreeNode("Futsol Club"));
				categoryNode.add(new DefaultMutableTreeNode("Tennis Club"));
			}
			if(i == 1)
			{
				categoryNode.add(new DefaultMutableTreeNode("Spark SC"));
				categoryNode.add(new DefaultMutableTreeNode("LavaLab"));
			}
			if(i == 2)
			{
				categoryNode.add(new DefaultMutableTreeNode("Photography Club"));
			}
			root.add(categoryNode);
		}
		
		
		setBackground(Color.WHITE);
		setLayout(new GridLayout(2,1));
		organizationTree = new JTree(root);
		organizationTree.setBackground(Color.WHITE);
		organizationTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		organizationTree.addTreeSelectionListener(this);
		
		//organizationTree.
		add(categoryLabel);
		add(organizationTree);
	}
	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) organizationTree.getLastSelectedPathComponent();
		if(node == null)
			return;
		Object nodeInfo = node.getUserObject();
		
		if(node.isLeaf()) {
			String temp = nodeInfo.toString();
			displayPanel.removeAll();
			displayPanel.add(new OrganizationPanel(temp));
			
			System.out.println(temp);	
		} 
		
	}
	
	//Not sure how we're going to do this in terms of backend, so I'm just gonna add some placeholder categories.

}

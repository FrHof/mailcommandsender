package com.guicommandmaker;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//TODO BEGIN TO WORK ON THE LOGIC
public class MainPage extends JFrame{
	private String receivedInfo;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MainPage() {
		initGui();
	}
	public final void initGui() {
		setSize(1120,600);
		setTitle("Commande fromage Vallentien");
		setResizable(false);
		
		String[] names = {};
		String[] items = {};
		// BUTTONS : 
		JButton button = new JButton("Send");
		button.setBounds(943,486,135,40);
		
		JButton buttonAddPerson = new JButton("+");
		buttonAddPerson.setBounds(81,486,62,40);
		
		JButton buttonDelPerson = new JButton("-");
		buttonDelPerson.setBounds(227,486,62,40);
		
		JButton buttonAddItem = new JButton("+");
		buttonAddItem.setBounds(414, 486, 62, 40);
		
		JButton buttonModifyItem = new JButton("Mod");
		buttonModifyItem.setBounds(497, 486, 62, 40);
		
		JButton buttonDelItem = new JButton("-");
		buttonDelItem.setBounds(581, 486, 62, 40);
		
		// TEXT FIELD : PREVIEW OF THE EMAIL :
		final JTextField mailPreview = new JTextField();
		mailPreview.setBounds(698,20,380,450);
		
		// LIST OF PEOPLE IN THE COMMAND AND LABEL : 
		JList<String> nameList = new JList<String>(names);
		nameList.setBounds(30,20,315,450);
		JLabel nameListLabel = new JLabel("Personnes dans la commande");
		nameListLabel.setBounds(100, 5, 176, 15);
		
		// LIST OF ITEMS IN THE COMMAND OF THE PERSON SELECTED AND LABEL
		JList<String> selectItems = new JList<String>(items);
		selectItems.setBounds(382, 20, 292, 450);
		JLabel selectItemsLabel = new JLabel("Element pour la personne sélectionnée");
		selectItemsLabel.setBounds(414, 5, 230, 15);
		
		add(button);
		add(buttonAddPerson);
		add(buttonAddItem);
		add(buttonModifyItem);
		add(buttonDelPerson);
		add(buttonDelItem);
		add(mailPreview);
		add(nameList);
		add(nameListLabel);
		add(selectItems);
		add(selectItemsLabel);
		setLayout(null);
		setVisible(true);
		
		buttonAddPerson.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new AddNewPage("Ajouter une personne dans la commande", ActionToExec.CHOOSE_PERSON);
			}
		});
	}
	
	public void changeFrameLogo(String pathToFile) {
		ImageIcon img = new ImageIcon(pathToFile);
		this.setIconImage(img.getImage());
	}
	// TODO Use receivedInfo to pass infos between JFrame
	public String getReceivedInfo() {
		return receivedInfo;
	}
	public void setReceivedInfo(String receivedInfo) {
		this.receivedInfo = receivedInfo;
	}
	public static void main(String[] args) {
		//LoginPage logpage = new LoginPage();
		//new AddNewPage("Add Person",ActionToExec.MODIFY_ITEM);
		MainPage theMain = new MainPage();
		theMain.initGui();
		// TODO Modify logo of the windows
	}

}
/*
 * button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				textField.setText("You have clicked the button !");
			}
		});
 */
 
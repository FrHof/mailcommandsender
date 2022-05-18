package com.guicommandmaker;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JList;

public class MainPage extends JFrame{
	public MainPage() {
		initGui();
	}
	public final void initGui() {
		setSize(1120,600);
		setTitle("Commande fromage Vallentien");
		setResizable(false);
		
		String[] names = {"Yannick","Elodie","Brigitte","Annick","Joëlle","Martine"};
		
		JButton button = new JButton("Send");
		button.setBounds(943,486,135,40);
		
		final JTextField mailPreview = new JTextField();
		mailPreview.setBounds(698,20,380,450);
		
		JList nameList = new JList<String>(names);
		nameList.setBounds(30,20,315,450);
		
		JPanel weightSelect = new JPanel();
		weightSelect.setBounds(370, 20, 83, 450);
		weightSelect.setBackground(Color.gray);
		
		JPanel selectCheese = new JPanel();
		selectCheese.setBounds(463, 20, 211, 450);
		selectCheese.setBackground(Color.gray);
		
		add(button);
		add(mailPreview);
		add(nameList);
		add(weightSelect);
		add(selectCheese);
		setLayout(null);
		setVisible(true);
	}
	
	public void changeFrameLogo(String pathToFile) {
		ImageIcon img = new ImageIcon(pathToFile);
		this.setIconImage(img.getImage());
	}
	public static void main(String[] args) {
		LoginPage logpage = new LoginPage();
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
 
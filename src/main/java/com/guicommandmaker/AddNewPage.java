package com.guicommandmaker;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewPage extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// TODO pass origin Jframe in parameter
	AddNewPage(String title, ActionToExec action){
		setSize(595,415);
		setTitle(title);
		setResizable(false);
		final ArrayList<String> known =new ArrayList<String>();
		JButton addNewEntry = new JButton("+");
		addNewEntry.setBounds(347, 45, 117, 40);
		
		
		JButton delEntry = new JButton("-");
		delEntry.setBounds(347, 107, 117, 40);
		 
		if (action == ActionToExec.ADD_ITEM || action == ActionToExec.MODIFY_ITEM) {
			final String[] unities = {"kg","g","/"};
			JComboBox<String> unity = new JComboBox<String>(unities);
			unity.setBounds(347, 232, 117, 40);
			add(unity);
			
			JTextField quantity = new JTextField();
			quantity.setBounds(345,167,117,40);
			add(quantity);
			if (action == ActionToExec.MODIFY_ITEM) {
				//TODO Get the default value from the modified item
			}
		}
		JButton finish = new JButton("Ajouter");
		finish.setBounds(347, 290, 117, 40);
		
		final JList knownList = new JList( known.toArray());
		knownList.setBounds(34, 45, 283, 285);
		
		// Add all to JFrame:
		add(addNewEntry);
		add(delEntry);
		add(finish);
		add(knownList);
		setLayout(null);
		setVisible(true);
		
		// All action button : 
		// Add new entry in the list view
		addNewEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userInput = JOptionPane.showInputDialog("Entrer le nom de la personne a ajouter");
				if (userInput != "") {
					known.add(userInput);
					knownList.updateUI();
				}
				
				
			}
		});
	}
}

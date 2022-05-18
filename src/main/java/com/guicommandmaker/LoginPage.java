package com.guicommandmaker;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.WindowEvent;

public class LoginPage extends JFrame{
	final private String user = "test";
	final private String passw = "test";
	private JTextField userTf;
	private JPasswordField passwPf;
	boolean auth_verified;
	LoginPage(){
		// TODO CHANGE THE CALL TO FIELD WITH A CALL TO GETTER AND SETTER
		this.auth_verified = false;
		setSize(615, 345);
		setTitle("Connexion");
		setResizable(false);
		JLabel usernameLab = new JLabel("Nom d'utilisateur");
		usernameLab.setBounds(180,51,97,15);
		JTextField username = new JTextField();
		username.setBounds(180,70,254,40);
		this.userTf = username;
		
		JLabel passwordLab = new JLabel("Mot de passe");
		passwordLab.setBounds(180,120,78,15);
		JPasswordField password = new JPasswordField();
		password.setBounds(180,140,255,40);
		this.passwPf = password;
		JButton button = new JButton("Valider");
		button.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent e) {
		        checkAuth();
		    }
		});
		button.setBounds(250,215,117,40);
		add(username);
		add(usernameLab);
		add(password);
		add(passwordLab);
		add(button);
		
		setLayout(null);
		setVisible(true);
		toFront();
		requestFocus();
	}
	//		GETTERS AND SETTERS : 
	public JTextField getUserTf() {
		return userTf;
	}

	public void setUserTf(JTextField userTf) {
		this.userTf = userTf;
	}

	public JPasswordField getPasswPf() {
		return passwPf;
	}

	public void setPasswPf(JPasswordField passwPf) {
		this.passwPf = passwPf;
	}

	public boolean isAuth_verified() {
		return auth_verified;
	}

	public void setAuth_verified(boolean auth_verified) {
		this.auth_verified = auth_verified;
	}

	public String getUser() {
		return user;
	}

	public String getPassw() {
		return passw;
	}
	private void checkAuth() {
		if (String.valueOf(getPasswPf().getPassword()).equals(getPassw()) && getUserTf().getText().equals(getUser())) {
			MainPage gui = new MainPage();
			gui.setVisible(true);
			this.dispose();
		}
		else {
			JOptionPane.showMessageDialog(this, "Mauvais identifiants de connexion");
		}
	}
	public void setFrameLogo(String pathToFile) {
		ImageIcon img = new ImageIcon(pathToFile);
		this.setIconImage(img.getImage());
	}
}

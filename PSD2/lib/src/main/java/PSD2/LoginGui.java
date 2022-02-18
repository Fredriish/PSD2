package PSD2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.Color;

public class LoginGui {

	private JFrame frame;
	private Panel panel;
	private JLabel PersonNummerLabel;
	private JTextField personnummerInputField;
	private JButton loginButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGui window = new LoginGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new Panel();
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		PersonNummerLabel = new JLabel("Personnummer  ex. 001122 5555");
		GridBagConstraints gbc_PersonNummerLabel = new GridBagConstraints();
		gbc_PersonNummerLabel.gridwidth = 7;
		gbc_PersonNummerLabel.insets = new Insets(0, 0, 5, 0);
		gbc_PersonNummerLabel.gridx = 0;
		gbc_PersonNummerLabel.gridy = 0;
		panel.add(PersonNummerLabel, gbc_PersonNummerLabel);
		
		personnummerInputField = new JTextField();
		GridBagConstraints gbc_personnummerInputField = new GridBagConstraints();
		gbc_personnummerInputField.gridwidth = 7;
		gbc_personnummerInputField.insets = new Insets(0, 0, 5, 0);
		gbc_personnummerInputField.gridx = 0;
		gbc_personnummerInputField.gridy = 2;
		panel.add(personnummerInputField, gbc_personnummerInputField);
		personnummerInputField.setColumns(10);
		
		loginButton = new JButton("Logga in");
		loginButton.addActionListener(e ->{
			//String parsedInfo = parseLoginInfo(personnummerInputField.getText());
		});
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.gridwidth = 7;
		gbc_loginButton.gridx = 0;
		gbc_loginButton.gridy = 4;
		panel.add(loginButton, gbc_loginButton);
	}
	/*
	private String parseLoginInfo(String input) {
		String tmp="";
		for(int a = 0;a<input.length();a++) {
			if(input.charAt(a)==' ' || input.charAt(a)=='-') {
				
			}
			else
				tmp+=input.charAt(a);
		}
		
		return tmp;
	}*/
}

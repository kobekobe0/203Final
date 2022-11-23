import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.annotation.processing.FilerException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Register extends JFrame implements ActionListener{
	JLabel loginBg = new JLabel();
	ImageIcon loginBgImg = new ImageIcon("loginBg.jpg");
	JLabel loginTitle = new JLabel("Register");
	JTextField usernameField = new JTextField();
	JTextField passwordField = new JTextField();
	JTextField confirmPasswordField = new JTextField();
	JPanel loginInputPanel = new JPanel();
	JButton loginBtn = new JButton();
	JLabel registerText = new JLabel();
	JRadioButton adminRadio = new JRadioButton("admin");
	JRadioButton userRadio = new JRadioButton("user");
    ButtonGroup radioGroup = new ButtonGroup();

	
    public Register(){
    	//adding elements
    	
		loginTitle.setBounds(100, 100, 200, 100);
		loginTitle.setFont(new Font("Sans", Font.PLAIN, 30));
		loginTitle.setForeground(Color.WHITE);
		
		usernameField.setSize(250, 30);
		usernameField.setBounds(100, 200, 200, 30);
		passwordField.setSize(250, 30);
		passwordField.setBounds(100, 250, 200, 30);
		confirmPasswordField.setSize(250, 30);
		confirmPasswordField.setBounds(100, 300, 200, 30);
		
		loginBtn.setBounds(200, 370, 100, 30);
		loginBtn.setText("Register");
		
		registerText.setText("Already have an account.");
		registerText.setBounds(180, 410, 200, 10);
		registerText.setFont(new Font("Sans", Font.PLAIN, 10));
		registerText.setForeground(Color.blue);
		

		
		loginInputPanel.setBackground(Color.gray);    	
		loginInputPanel.setPreferredSize(new Dimension(400,600));
		loginInputPanel.setSize(800, 600);
		loginInputPanel.setLayout(null);
		loginInputPanel.add(loginTitle);
		loginInputPanel.add(usernameField);
		loginInputPanel.add(passwordField);
		loginInputPanel.add(confirmPasswordField);
		loginInputPanel.add(loginBtn);
		loginInputPanel.add(registerText);

		
		loginBtn.addActionListener(this);
		
		setSize(1000,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(loginInputPanel, BorderLayout.EAST);
    }
    public static void main(String[] args) {
    	//initialization
        // TODO code application logic here
        Register login = new Register();
        login.setVisible(true);
        
    }

    	@Override
    	public void actionPerformed(ActionEvent e) {
        	if (e.getSource().equals(loginBtn)) { //element action
        		
        		try{  
        			if(usernameField.getText().strip().equals("") && passwordField.getText().strip().equals("") && confirmPasswordField.getText().strip().equals("")) {
        				System.out.println("Please enter input values on all field");
        			} else if(!passwordField.getText().strip().equals(confirmPasswordField.getText().strip())) {
        				System.out.print("Please confirm password");
        			} else {
        				this.setVisible(false); // find way to close
        				Accounts.addAccount(usernameField.getText().strip(), passwordField.getText().strip(), 999);
        				Login loginFrame = new Login();
        				Accounts.printAccount(1);
        				System.out.println("");
        				loginFrame.setVisible(true);
        				
        			}
        		}catch(NullPointerException e1){
        			System.out.println(e1);
        			System.out.println("please select what type of person you are");
        		}
        		
        		
        		
        		
        	
    		}	
    
    	}
    }

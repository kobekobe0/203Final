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

public class Login extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel loginBg = new JLabel();
	ImageIcon loginBgImg = new ImageIcon("loginBg.jpg");
	JLabel loginTitle = new JLabel("Login");
	JTextField usernameField = new JTextField();
	JTextField passwordField = new JTextField();
	JPanel loginInputPanel = new JPanel();
	JButton loginBtn = new JButton();
	JButton registerText = new JButton();
	JRadioButton adminRadio = new JRadioButton("admin");
	JRadioButton userRadio = new JRadioButton("user");
    ButtonGroup radioGroup = new ButtonGroup();

    //sadkoasd
	
    public Login(){
    	//adding elements
    	
		loginTitle.setBounds(100, 100, 200, 100);
		loginTitle.setFont(new Font("Sans", Font.PLAIN, 30));
		loginTitle.setForeground(Color.WHITE);
		
		usernameField.setSize(250, 30);
		usernameField.setBounds(100, 200, 200, 30);
		passwordField.setSize(250, 30);
		passwordField.setBounds(100, 250, 200, 30);
		
		loginBtn.setBounds(220, 320, 80, 30);
		loginBtn.setText("Login");
		
		registerText.setText("Create an account.");
		registerText.setOpaque(true);
		registerText.setBounds(210, 360, 200, 10);
		registerText.setFont(new Font("Sans", Font.PLAIN, 10));
		registerText.setForeground(Color.blue);
		
		adminRadio.setBounds(101, 290, 70, 10);
		adminRadio.setOpaque(true);
		adminRadio.setBackground(new Color(0,0,0,0));
		adminRadio.setActionCommand("admin");
		
		userRadio.setBounds(170, 290, 90, 10);
		userRadio.setOpaque(true);
		userRadio.setBackground(new Color(0,0,0,0));
		userRadio.setActionCommand("user");
		
		radioGroup.add(adminRadio);
		radioGroup.add(userRadio);
		
		loginInputPanel.setBackground(Color.gray);    	
		loginInputPanel.setPreferredSize(new Dimension(400,600));
		loginInputPanel.setSize(800, 600);
		loginInputPanel.setLayout(null);
		loginInputPanel.add(loginTitle);
		loginInputPanel.add(usernameField);
		loginInputPanel.add(passwordField);
		loginInputPanel.add(loginBtn);
		loginInputPanel.add(registerText);
		loginInputPanel.add(adminRadio);
		loginInputPanel.add(userRadio);
		
		loginBtn.addActionListener(this);
		registerText.addActionListener(this);
		
		setSize(1000,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(loginInputPanel, BorderLayout.EAST);
    }
    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
        
    }

    	@Override
    	public void actionPerformed(ActionEvent e) {
        	if (e.getSource().equals(loginBtn)) { //element action
        		
        		try{  
        			if(radioGroup.getSelection().getActionCommand().equals("admin")) {
        				Admin acc = new Admin();
                		if(usernameField.getText().equals(acc.username) && passwordField.getText().equals(acc.password)) {
                			System.out.print("login as admin");
                		}else{
                			System.out.print("Wrong Credentials");
                		};
            		}else if(radioGroup.getSelection().getActionCommand().equals("user")) {
            			//find user in Accounts class if it exists

            			if(Accounts.findAccount(usernameField.getText(), passwordField.getText())) {
            				System.out.print("Success");
            				UserAccount acc = Accounts.getAccount(usernameField.getText(), passwordField.getText());
            				System.out.println("SUCCESS NAME: " + acc.name);
            				CurrentUser.setCurrentUser(acc.name, acc.money);
            				System.out.println("CURRENT USER: "+CurrentUser.name);
            				this.setVisible(false);
            				MenuUser menu = new MenuUser();
            				menu.setVisible(true);
            			} else {
            				System.out.print("Failed");
            				//prompt error msg box
            			};
            		};
        		}catch(NullPointerException e1){
        			System.out.println(e1);
        			System.out.println("please select what type of person you are");
        		}

    		}	
        	if(e.getSource().equals(registerText)) {
    			try {
    			this.setVisible(false);
    			Register regForm = new Register();
    			regForm.setVisible(true);
    			} catch (NullPointerException e1) {
    			
    			}
    		}	
        	
        	
    
    	}

    	
    }

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

public class MenuUser extends JFrame implements ActionListener{
	JLabel loginBg = new JLabel();
	ImageIcon loginBgImg = new ImageIcon("loginBg.jpg");
	JLabel loginTitle = new JLabel("Menu Page");
	JTextField usernameField = new JTextField();
	JTextField passwordField = new JTextField();
	JPanel loginInputPanel = new JPanel();
	JButton loginBtn = new JButton();
	JLabel registerText = new JLabel();
	JRadioButton adminRadio = new JRadioButton("admin");
	JRadioButton userRadio = new JRadioButton("user");
    ButtonGroup radioGroup = new ButtonGroup();
    
    String moneyString = Integer.toString(CurrentUser.money);
    JLabel username = new JLabel(CurrentUser.name);
    JLabel money = new JLabel(moneyString);

	
    public MenuUser(){
    	//adding elements
		loginTitle.setBounds(100, 100, 200, 100);
		loginTitle.setFont(new Font("Sans", Font.PLAIN, 30));
		loginTitle.setForeground(Color.WHITE);
		
		username.setBounds(100, 200, 500, 100);
		username.setFont(new Font("Sans", Font.PLAIN, 30));
		money.setBounds(100, 400, 500, 100);
		money.setFont(new Font("Sans", Font.PLAIN, 30));

		
		loginBtn.setBounds(220, 320, 80, 30);
		loginBtn.setText("Logout");
		
		loginInputPanel.setBackground(Color.gray);    	
		loginInputPanel.setPreferredSize(new Dimension(1000,600));
		loginInputPanel.setSize(800, 600);
		loginInputPanel.setLayout(null);
		loginInputPanel.add(loginBtn);
		loginInputPanel.add(username);
		loginInputPanel.add(money);

		
		loginBtn.addActionListener(this);
		
		setSize(1000,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(loginInputPanel, BorderLayout.EAST);
    }
    public static void main(String[] args) {
    	//initialization
        // TODO code application logic here
        MenuUser login = new MenuUser();
        login.setVisible(true);
        
    }

    	@Override
    	public void actionPerformed(ActionEvent e) {
        	if (e.getSource().equals(loginBtn)) { //element action
        		
        		try{  
        			this.setVisible(false);
        			Login loginForm = new Login();
        			loginForm.setVisible(true);
        		}catch(NullPointerException e1){
        			System.out.println(e1);
        			System.out.println("please select what type of person you are");
        		}
        	
    		}	
    
    	}
    }

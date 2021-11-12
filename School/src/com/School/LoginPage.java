package com.School;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JToggleButton;
import java.awt.Button;
import javax.swing.JPasswordField;

public class LoginPage {

	private JFrame frame;
	private JTextField textuser;
	private JPasswordField textpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 314);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbluser = new JLabel("User id");
		lbluser.setBounds(148, 97, 64, 14);
		frame.getContentPane().add(lbluser);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(148, 140, 64, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnlogin = new JButton("LOGIN");
		btnlogin.setForeground(Color.BLUE);
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con=null;
				String url="jdbc:mysql://localhost:3306/school_page";
				try {
					String user=textuser.getText();
					String password=textpassword.getText();
					con=DriverManager.getConnection(url, "root", "");
					Class.forName("com.mysql.jdbc.Driver");
					Statement st=con.createStatement();
					
				String	str="Select * from login_page WHERE user='"+user+"'AND password='"+password+"'";	
				System.out.println("correct query");
			    ResultSet rs=st.executeQuery(str);
			    if(rs.next())
			    {
			    	String module=rs.getString("module");
			    	
			    	if(module.equalsIgnoreCase("staff"))
			    	{
			    		StafViewPage sp=new StafViewPage();
			    		sp.main3(user);
			    	}
			    	else if(module.equalsIgnoreCase("admin"))
			    	{
			    	AdminRegPage ap=new AdminRegPage();
			    	ap.main();
			    	}
			    	else if(module.equalsIgnoreCase("student"))
			    	{
			    		System.out.println("student");
			    		HomePage sp=new HomePage();
			    		sp.main4(user);
			    	}
			    }
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					try {
						con.close();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
		});
		btnlogin.setBounds(187, 195, 89, 23);
		frame.getContentPane().add(btnlogin);
		
		textuser = new JTextField();
		textuser.setBounds(232, 94, 86, 20);
		frame.getContentPane().add(textuser);
		textuser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Login in");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setForeground(new Color(255, 51, 153));
		lblNewLabel.setBounds(187, 39, 84, 32);
		frame.getContentPane().add(lblNewLabel);
		
		textpassword = new JPasswordField();
		textpassword.setBounds(232, 137, 86, 20);
		frame.getContentPane().add(textpassword);
	}
}

package com.School;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class StudRegPage {

	private JFrame frame;
	private JTextField textname;
	private JTextField textage;
	private JTextField textemail;
	private JPasswordField textpassword;

	/**
	 * Launch the application.
	 */
	public void main2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudRegPage window = new StudRegPage();
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
	public StudRegPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Registeration");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(145, 11, 169, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(76, 52, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setBounds(76, 93, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textname = new JTextField();
		textname.setBounds(172, 45, 86, 20);
		frame.getContentPane().add(textname);
		textname.setColumns(10);
		
		textage = new JTextField();
		textage.setBounds(172, 93, 86, 20);
		frame.getContentPane().add(textage);
		textage.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=null;
				try {
					
					String name=textname.getText();
					String age=textage.getText();
					String email=textemail.getText();
					String password=textpassword.getText();
					String url="jdbc:mysql://localhost:3306/school_page";
				
						
						con=DriverManager.getConnection(url, "root", "");
						Class.forName("com.mysql.jdbc.Driver");
						Statement st=con.createStatement();
						String module="student";
						String str="insert into student_page(name,age,email,password)values('"+name+"','"+age+"','"+email+"','"+password+"')";
						String str1="insert into login_page(user,password,module)values('"+email+"','"+password+"','"+module+"')";
						System.out.println("query no1 correct ");
						int result=st.executeUpdate(str);
						int result1=st.executeUpdate(str1);
						if(result>0)
						{
							System.out.println("successfully Inserted");
							frame.dispose();
					        JOptionPane.showMessageDialog(frame, "Student  registered successfully");
						}
						if(result1>0)
						{
							System.out.println("successfully in login page Inserted");
							frame.dispose();
					//JOptionPane.showMessageDialog(frame, "Staff registered successfully");
						}
						}
						
					
				 catch (Exception e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		btnSubmit.setBounds(169, 227, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(76, 136, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(76, 175, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textemail = new JTextField();
		textemail.setBounds(172, 133, 86, 20);
		frame.getContentPane().add(textemail);
		textemail.setColumns(10);
		
		textpassword = new JPasswordField();
		textpassword.setBounds(172, 172, 86, 20);
		frame.getContentPane().add(textpassword);
	}

}

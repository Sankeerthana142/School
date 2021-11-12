package com.School;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class StafRegPage {

	private JFrame frame;
	private JTextField textname;
	private JTextField textsubject;
	private JTextField textcontact;
	private JTextField textemail;
	private JTextField textpassword;

	/**
	 * Launch the application.
	 */
	public void main1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StafRegPage window = new StafRegPage();
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
	public StafRegPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 245, 245));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(84, 37, 69, 14);
		frame.getContentPane().add(lblName);
		
		textname = new JTextField();
		textname.setBounds(229, 34, 86, 20);
		frame.getContentPane().add(textname);
		textname.setColumns(10);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(84, 78, 46, 14);
		frame.getContentPane().add(lblSubject);
		
		JLabel lblContactNumber = new JLabel("Contact number");
		lblContactNumber.setBounds(84, 122, 109, 14);
		frame.getContentPane().add(lblContactNumber);
		
		textsubject = new JTextField();
		textsubject.setBounds(229, 75, 86, 20);
		frame.getContentPane().add(textsubject);
		textsubject.setColumns(10);
		
		textcontact = new JTextField();
		textcontact.setBounds(229, 119, 86, 20);
		frame.getContentPane().add(textcontact);
		textcontact.setColumns(10);
		
		JLabel lblEmailid = new JLabel("Email_id");
		lblEmailid.setBounds(84, 162, 63, 14);
		frame.getContentPane().add(lblEmailid);
		
		textemail = new JTextField();
		textemail.setBounds(229, 159, 86, 20);
		frame.getContentPane().add(textemail);
		textemail.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				String name=textname.getText();
				String subject=textsubject.getText();
				String contact=textcontact.getText();
				String email=textemail.getText();
				String password=textpassword.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/school_page";
					String username="root";
					String password1="";
					String module="staff";
					con=DriverManager.getConnection(url,username,password1);
					Statement st=con.createStatement();
					String str="insert into staff_page(Name,Subject,Contact,Email,Password)values('"+name+"','"+subject+"','"+contact+"','"+email+"','"+password+"')";
					String str1="insert into login_page(user,password,module)values('"+email+"','"+password+"','"+module+"')";
					System.out.println(str);
					int result= st.executeUpdate(str);
					int result1=st.executeUpdate(str1);
					if(result>0)
					{
						System.out.println("successfully Inserted");
						frame.dispose();
				JOptionPane.showMessageDialog(frame, "Staff registered successfully");
					}
					if(result1>0){
						System.out.println("successfully Inserted");
						frame.dispose();
				JOptionPane.showMessageDialog(frame, "Staff registered in login successfully");
					}
			}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
				}
				finally{
					try {
						con.close();
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
			           }
			}
		});
		btnSubmit.setBounds(167, 227, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblStaffRegisteration = new JLabel("Staff Registeration");
		lblStaffRegisteration.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblStaffRegisteration.setBounds(167, 0, 137, 20);
		frame.getContentPane().add(lblStaffRegisteration);
		
		textpassword = new JTextField();
		textpassword.setBounds(229, 190, 86, 20);
		frame.getContentPane().add(textpassword);
		textpassword.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(84, 193, 46, 14);
		frame.getContentPane().add(lblPassword);
	}
}

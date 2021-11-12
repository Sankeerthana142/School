package com.School;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

public class StafViewPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	static String user2;
	public void main3(String user2) {
		this.user2=user2;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StafViewPage window = new StafViewPage();
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
	public StafViewPage() {
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
		
		JLabel lblNewLabel = new JLabel("View details");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(176, 11, 107, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(125, 44, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Subject");
		lblNewLabel_2.setBounds(125, 87, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contact");
		lblNewLabel_3.setBounds(125, 130, 57, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(125, 180, 57, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnAddMark = new JButton("Add marks");
		btnAddMark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMarkPage ap=new AddMarkPage();
				ap.main5(user2);
			}
		});
		btnAddMark.setBounds(165, 216, 89, 23);
		frame.getContentPane().add(btnAddMark);
		
		JEditorPane editorname = new JEditorPane();
		editorname.setBounds(231, 38, 106, 20);
		frame.getContentPane().add(editorname);
		
		JEditorPane editorsubject = new JEditorPane();
		editorsubject.setBounds(231, 81, 106, 20);
		frame.getContentPane().add(editorsubject);
		
		JEditorPane editorcontact = new JEditorPane();
		editorcontact.setBounds(231, 124, 106, 20);
		frame.getContentPane().add(editorcontact);
		
		JEditorPane editoremail = new JEditorPane();
		editoremail.setBounds(231, 174, 106, 20);
		frame.getContentPane().add(editoremail);
		
		
		 String url="jdbc:mysql://localhost:3306/school_page";
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,"root","");
			Statement st=con.createStatement();
			String str1="SELECT * FROM staff_page WHERE email='"+user2+"'";
			ResultSet rs=st.executeQuery(str1);
			if(rs.next()){
				String email=rs.getString("email");
				String name=rs.getString("name");
			   String contact=rs.getString("contact");
			     String subject=rs.getString("subject");
				editorname.setText(name);
				editorsubject.setText(subject);
				editorcontact.setText(contact);
				editoremail.setText(email);
				System.out.println(user2);
				
				
				
			}
		
		/*else
		{
			System.out.println("view successfull");
			//JOptionPane.showMessageDialog(frame, "login successfully");
		}*/
		
				
		
	} catch (Exception e1) {
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
}

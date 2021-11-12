package com.School;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddMarkPage {

	private JFrame frame;
	private JTextField textname;
	private JTextField textmark;
	static String user2;

	/**
	 * Launch the application.
	 */
	public void main5(String user2) {
		this.user2=user2;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMarkPage window = new AddMarkPage();
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
	public AddMarkPage() {
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
		
		JLabel lblNameOfStudent = new JLabel("Name of Student");
		lblNameOfStudent.setBounds(99, 75, 103, 14);
		frame.getContentPane().add(lblNameOfStudent);
		
		JLabel lblEnterTheMarks = new JLabel("Enter the marks");
		lblEnterTheMarks.setBounds(99, 111, 103, 14);
		frame.getContentPane().add(lblEnterTheMarks);
		
		textname = new JTextField();
		textname.setBounds(212, 72, 86, 20);
		frame.getContentPane().add(textname);
		textname.setColumns(10);
		
		textmark = new JTextField();
		textmark.setBounds(212, 108, 86, 20);
		frame.getContentPane().add(textmark);
		textmark.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textname.getText();
				String mark=textmark.getText();
				Connection con=null;
				String url="jdbc:mysql://localhost:3306/school_page";
				try {
					con=DriverManager.getConnection(url,"root", "");
					Class.forName("com.mysql.jdbc.Driver");
					Statement st=con.createStatement();
					
					String str1="select subject from staff_page where email='"+user2+"'";
					System.out.println(str1);
					ResultSet rs=st.executeQuery(str1);
					if(rs.next())
					{
                      
							String subject=rs.getString("subject");
							String str="update student_page set "+subject+"='"+mark+"' where name='"+name+"'";
							System.out.println(str);
							int result=st.executeUpdate(str);
							if(result>0)
							{
								
								JOptionPane.showMessageDialog(btnSubmit, "mark submitted");
							}
					
						
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally
				{
				try {
					con.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				
			}
		});
		btnSubmit.setBounds(154, 161, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnlogout = new JButton("Logout");
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginPage lp=new LoginPage();
				lp.main(null);
			}
		});
		btnlogout.setBounds(345, 0, 89, 23);
		frame.getContentPane().add(btnlogout);
	}
}

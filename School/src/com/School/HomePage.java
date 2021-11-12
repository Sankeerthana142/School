package com.School;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class HomePage {

	private JFrame frame;
	static String user1;

	/**
	 * Launch the application.
	 */
	public void main4(String user1) {
		this.user1=user1;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
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
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Details");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(170, 0, 123, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(94, 56, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(94, 93, 46, 14);
		frame.getContentPane().add(lblAge);
		
		JLabel lblMaths = new JLabel("Maths");
		lblMaths.setBounds(94, 173, 46, 14);
		frame.getContentPane().add(lblMaths);
		
		JLabel lblPhysics = new JLabel("Physics");
		lblPhysics.setBounds(94, 216, 46, 14);
		frame.getContentPane().add(lblPhysics);
		
		JLabel lblChemistry = new JLabel("Chemistry");
		lblChemistry.setBounds(94, 255, 74, 14);
		frame.getContentPane().add(lblChemistry);
		
		JEditorPane editorname = new JEditorPane();
		editorname.setBounds(161, 50, 106, 20);
		frame.getContentPane().add(editorname);
		
		JEditorPane editorage = new JEditorPane();
		editorage.setBounds(161, 87, 106, 20);
		frame.getContentPane().add(editorage);
		
		JEditorPane editormaths = new JEditorPane();
		editormaths.setBounds(161, 167, 106, 20);
		frame.getContentPane().add(editormaths);
		
		JEditorPane editorphysics = new JEditorPane();
		editorphysics.setBounds(161, 210, 106, 20);
		frame.getContentPane().add(editorphysics);
		
		JEditorPane editorchemistry = new JEditorPane();
		editorchemistry.setBounds(161, 255, 106, 20);
		frame.getContentPane().add(editorchemistry);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage lp=new LoginPage();
				lp.main(null);
			}
		});
		btnLogout.setBounds(335, 8, 89, 23);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(94, 133, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JEditorPane editoremail = new JEditorPane();
		editoremail.setBounds(161, 124, 106, 20);
		frame.getContentPane().add(editoremail);
		String url="jdbc:mysql://localhost:3306/school_page";
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,"root","");
			Statement st=con.createStatement();
			String str1="SELECT * FROM student_page WHERE email='"+user1+"'";
			ResultSet rs=st.executeQuery(str1);
			if(rs.next()){
				String name=rs.getString("name");
				String email=rs.getString("email");
				String age=rs.getString("age");
			   String maths=rs.getString("maths");
			     String chemistry=rs.getString("chemistry");
			     String physics=rs.getString("physics");
				editoremail.setText(email);
				editorage.setText(age);
				editormaths.setText(maths);
				editorchemistry.setText(chemistry);
				editorphysics.setText(physics);
				editorname.setText(name);
				
				
				
				
			}
		
		else
		{
			System.out.println("view successfull for student");
			//JOptionPane.showMessageDialog(frame, "login successfully");
		}
		
				
		
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

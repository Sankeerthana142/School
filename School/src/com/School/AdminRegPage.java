package com.School;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminRegPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegPage window = new AdminRegPage();
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
	public AdminRegPage() {
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
		
		JButton btnAddStaff = new JButton("ADD STAFF");
		btnAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StafRegPage sp=new StafRegPage();
				sp.main1();
			}
		});
		btnAddStaff.setBounds(140, 60, 140, 23);
		frame.getContentPane().add(btnAddStaff);
		
		JButton btnAddStudent = new JButton("ADD STUDENT");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudRegPage sp=new StudRegPage();
				sp.main2();
			}
		});
		btnAddStudent.setBounds(140, 103, 140, 23);
		frame.getContentPane().add(btnAddStudent);
		
		JButton btnlogout = new JButton("logout");
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage lp=new LoginPage();
				lp.main(null);
			}
		});
		btnlogout.setBounds(345, 0, 89, 23);
		frame.getContentPane().add(btnlogout);
	}

}

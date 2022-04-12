package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db.MyDB;

public class Main extends JFrame {
	private JTextField idinputfield;
	private JTextField pwinputfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2000, 100, 600, 500);
		getContentPane().setLayout(null);
		
		JLabel loginLabel = new JLabel("로그인");
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setOpaque(true);
		loginLabel.setBackground(Color.PINK);
		loginLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		loginLabel.setBounds(172, 109, 217, 53);
		getContentPane().add(loginLabel);
		
		JButton loginBtn = new JButton("로그인");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			
				String loginID = idinputfield.getText();
				String loginPW = pwinputfield.getText();
				
				
				MyDB db = new MyDB();
				int loginResult = db.login(loginID, loginPW);
				if(loginResult == 1000) {
					Lotto lotto = new Lotto();
					lotto.setVisible(true);
					setVisible(false);
					System.out.println("로그인 성공");
					
				}else {
					JOptionPane.showMessageDialog(getContentPane(), "아이디가 없습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
					
				
			}
		});
		loginBtn.setBounds(316, 185, 73, 97);
		getContentPane().add(loginBtn);
		
		idinputfield = new JTextField();
		idinputfield.setBounds(172, 185, 131, 46);
		idinputfield.setColumns(10);
		getContentPane().add(idinputfield);
		
		
		pwinputfield = new JTextField();
		pwinputfield.setBounds(172, 241, 131, 46);	
		pwinputfield.setColumns(10);
		getContentPane().add(pwinputfield);
		
		JButton memRegBtn = new JButton("회원가입");
		memRegBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				RegistFrame rf = new RegistFrame();
				rf.setVisible(true);
				setVisible(false);
				
				
			}
		});
		memRegBtn.setBounds(172, 299, 217, 28);
		getContentPane().add(memRegBtn);
		
	}
}

package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import db.MyDB;

public class RegistFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistFrame frame = new RegistFrame();
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
	public RegistFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2000, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton ReturnBaseBtn = new JButton("돌아가기");
		ReturnBaseBtn.setBounds(242, 398, 105, 28);
		ReturnBaseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main mi = new Main();
				mi.setVisible(true);
				setVisible(false);

			}
		});
		contentPane.setLayout(null);
		contentPane.add(ReturnBaseBtn);

		JLabel label = new JLabel("회원가입");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(240, 75, 124, 45);
		contentPane.add(label);

		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(134, 166, 59, 18);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(188, 169, 114, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("비밀번호 확인");
		lblNewLabel_1_1.setBounds(107, 200, 109, 28);
		contentPane.add(lblNewLabel_1_1);

		

		JButton btnNewButton_1 = new JButton("돌아가기");
		btnNewButton_1.setBounds(334, 200, 105, 28);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_1_2 = new JLabel("아이디");
		lblNewLabel_1_2.setBounds(145, 134, 59, 28);
		contentPane.add(lblNewLabel_1_2);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(188, 132, 114, 22);
		contentPane.add(textField);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(188, 203, 114, 22);
		contentPane.add(textField_2);
		
		
		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// db 넣기
//				String id = textField.getText();
//				String pw = textField_1.getText();
//				System.out.println("id 값" +id);
//				System.out.println("pw 값" +pw);
//				System.out.println("회원가입 완료");
//				
//				setVisible(false);
//				Main main = new  Main();
//				main.setVisible(true);
//				
//		
//			 MyDB db = new MyDB();
//			 db.insert(id, pw);

				// 비밀번호 확인
				boolean idFix = false;
				boolean pwFix = false;

				String pw = textField_1.getText();
				String rePw = textField_2.getText();
				String id = textField.getText();
				String resultID = id.trim().replaceAll(" ", "");
				String onlyEng = resultID.replaceAll("[^a-zA-Z0-9]", "");
				
				MyDB db1 = new MyDB();
				boolean idDuplicate = db1.idDuplicate(onlyEng);
				
				if(idDuplicate == true) {
					JOptionPane.showMessageDialog(contentPane, "아이디가 중복됩니다.", "경고", JOptionPane.WARNING_MESSAGE);
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");				
					
				}
				

				if (onlyEng.length() > 0) {
					System.out.println("영어로만 이루어진 올바른 아이디 입니다.");
					System.out.println("DB에 저장될 아이디 :" + onlyEng);
					idFix = true;
				} else {
					System.out.println("영어가 아닌 다른 문자가 섞여 있습니다.");
					JOptionPane.showMessageDialog(contentPane, "영어로만 입력하세요", "경고", JOptionPane.WARNING_MESSAGE);
				}

				if (pw == null || pw.equals("")) {
					System.out.println("비밀번호 값을 입력하세요.");
					JOptionPane.showMessageDialog(contentPane, "비밀번호 입력하세요", "경고", JOptionPane.WARNING_MESSAGE);
				} else {
					String resultPW = pw.trim().replaceAll(" ", "");
					if (resultPW.equals(rePw)) {
						System.out.println("비밀번호가 일치합니다.");
						JOptionPane.showMessageDialog(contentPane, "비밀번호가 일치합니다.", "경고", JOptionPane.WARNING_MESSAGE);
						pwFix = true;
					} else {
						textField_1.setText("");
						textField_2.setText("");
						System.out.println("비밀번호가 일치하지 않습니다.");
						JOptionPane.showMessageDialog(contentPane, "비밀번호가 일치하지 않습니다.", "경고",
								JOptionPane.WARNING_MESSAGE);
					}
				
				}

				if (idFix == true && pwFix == true && idDuplicate == false) {
					MyDB db = new MyDB();
					db.insert(onlyEng, pw);
					System.out.println("insert 완료");
					setVisible(false);
					Main main = new Main();
					main.setVisible(true);
				}

				// id 검사 완료

			}

		});

		btnNewButton.setBounds(334, 140, 105, 44);
		contentPane.add(btnNewButton);
	}
}

package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Lotto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lotto frame = new Lotto();
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
	public Lotto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("로또번호 추출");
		label.setBounds(143, 12, 140, 35);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label);
	
		
		JLabel one = new JLabel("New label");
		one.setBounds(32, 49, 59, 57);
		contentPane.add(one);
		
		JLabel two = new JLabel("New label");
		two.setBounds(103, 49, 59, 57);
		contentPane.add(two);
		
		JLabel three = new JLabel("New label");
		three.setBounds(175, 49, 59, 57);
		contentPane.add(three);
		
		JLabel four = new JLabel("New label");
		four.setBounds(255, 49, 59, 57);
		contentPane.add(four);
		
		JLabel five = new JLabel("New label");
		five.setBounds(332, 49, 59, 57);
		contentPane.add(five);
		
		JLabel six = new JLabel("New label");
		six.setBounds(185, 126, 59, 57);
		contentPane.add(six);
		
		JButton btnNewButton = new JButton("추첨");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Set<Integer> set = new HashSet<Integer>();

		        for (int i = 0; set.size() < 6; ++i) {
		            int num = (int) (Math.random()*45) + 1;
		            set.add((num));
		        }

		        System.out.println("set >>> " + set);

		        List<Integer> list = new ArrayList<Integer>(set);
		        Collections.sort(list);
		        
		        one.setText(Integer.toString(list.get(0)));
		        two.setText(Integer.toString(list.get(1)));
		        three.setText(Integer.toString(list.get(2)));
		         four.setText(Integer.toString(list.get(3)));
		          five.setText(Integer.toString(list.get(4)));
		          six.setText(Integer.toString(list.get(5)));
		          
		      
		        
		       
		       
		     
		   
		    }
			
	
			
		});
		
		
		
		
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(160, 223, 105, 28);
		contentPane.add(btnNewButton);
	}
}

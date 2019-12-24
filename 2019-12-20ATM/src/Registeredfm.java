package com;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Registeredfm extends JFrame {
 
	private JPanel contentPane;
	private JTextField NewName;
	private JPasswordField NewPassword;
	private JPasswordField RnewPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registeredfm frame = new Registeredfm();
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
	public Registeredfm() {
	
		setResizable(false);
		setTitle("�û�ע��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 225);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("���û�ע��");
		label.setForeground(Color.black);
		label.setFont(new Font("��������", Font.PLAIN, 16));
		label.setBackground(new Color(0, 255, 51));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.NORTH);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLabel label_1 = new JLabel("�û���:");
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		label_1.setForeground(Color.BLACK);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(33, 25, 54, 15);
		layeredPane.add(label_1);
		
		JLabel label_2 = new JLabel("����:");
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		label_2.setForeground(Color.BLACK);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(33, 59, 54, 15);
		layeredPane.add(label_2);
		
		JLabel label_3 = new JLabel("ȷ������:");
		label_3.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		label_3.setForeground(Color.BLACK);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(21, 94, 66, 15);
		layeredPane.add(label_3);
		
		NewName = new JTextField();
		NewName.setBounds(127, 23, 95, 21);
		layeredPane.add(NewName);
		NewName.setColumns(10);
		
		NewPassword = new JPasswordField();
		NewPassword.setBounds(127, 57, 95, 21);
		layeredPane.add(NewPassword);
		
		RnewPassword = new JPasswordField();
		RnewPassword.setBounds(127, 92, 95, 21);
		layeredPane.add(RnewPassword);
		
		JButton zhuce = new JButton("ע��");
		zhuce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��֤ע��
				String NuserName=NewName.getText();
				String Nuserpassword=NewPassword.getText();
				String RuserPassword=RnewPassword.getText();
				if(RuserPassword.length()!=6){
					JOptionPane.showMessageDialog(null, "�������Ϊ6λ����", "��ܰ��ʾ", JOptionPane.INFORMATION_MESSAGE);
					new Registeredfm().setVisible(true);
					dispose();
				}else if (Nuserpassword.equals(RuserPassword)) {
					/**
					 * �����ݿ��¼����û���
					 */
				Account account=new Account();
				AccountDao ad=new AccountDao();
				account.setUsername(NuserName);
				account.setPassword(Nuserpassword);
			ad.insert(account);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "�����������벻һ�£�", "��ܰ��ʾ", JOptionPane.ERROR_MESSAGE);
					new Registeredfm().setVisible(true);
					dispose();
				}
			}
		});
		zhuce.setForeground(Color.black);
		zhuce.setFont(new Font("����", Font.PLAIN, 22));
		zhuce.setBounds(230, 130, 85, 26);
		layeredPane.add(zhuce);
	}
}

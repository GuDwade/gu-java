package com;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LogOnfm extends JFrame {
	private JPanel contentPane;
	private JTextField UserId;
	private JPasswordField UserPassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnfm frame = new LogOnfm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LogOnfm() {
		setResizable(false);
		setTitle("�û���¼����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 235);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("��ӭʹ��");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("��������", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(83, 10, 111, 15);
		layeredPane.add(lblNewLabel);
		
		JLabel User = new JLabel("�û���:");
		User.setHorizontalAlignment(SwingConstants.RIGHT);
		User.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		User.setForeground(Color.BLACK);
		User.setBounds(24, 44, 60, 15);
		layeredPane.add(User);
		
		JLabel PassWord = new JLabel("����:");
		PassWord.setHorizontalAlignment(SwingConstants.RIGHT);
		PassWord.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		PassWord.setForeground(Color.BLACK);
		PassWord.setBounds(24, 106, 60, 15);
		layeredPane.add(PassWord);
		
		UserId = new JTextField();
		UserId.setBounds(103, 42, 93, 21);
		layeredPane.add(UserId);
		UserId.setColumns(10);
		
		UserPassword = new JPasswordField();
		UserPassword.setBounds(103, 104, 93, 21);
		layeredPane.add(UserPassword);
		
		JButton jb_logon = new JButton("��¼");
		jb_logon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * ��½����֤���û���½
				 */
				String userId=UserId.getText();
				String userPassword=UserPassword.getText();
				AccountDao ad=new AccountDao();
				boolean fixusername=ad.searchname(userId);
				boolean fixuserpass=ad.searchpassword(userPassword);
				if(fixusername&&fixuserpass){
					//��½�ɹ�
					JOptionPane.showMessageDialog(null, "��½�ɹ�",
							"��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
					new Menufm(userId, userPassword).setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "��½ʧ�ܣ��û������������",
							"��Ϣ��ʾ",JOptionPane.ERROR_MESSAGE);
					
				}
			
			}
			}
			);
		jb_logon.setFont(new Font("����", Font.PLAIN, 20));
		jb_logon.setForeground(Color.BLACK);
		jb_logon.setBounds(103, 150, 93, 30);
		layeredPane.add(jb_logon);
		
	}
}

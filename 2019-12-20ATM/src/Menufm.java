package com;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Menufm extends JFrame {
	
	  
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menufm frame = new Menufm(null,null);
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
	public Menufm(final String name,final String password) {
		setResizable(false);
	
		setTitle("�û��˵�����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 266);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(Color.BLACK);
		layeredPane.setBackground(Color.BLACK);
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("�˻�������"+name);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(115, 35, 183, 15);
		layeredPane.add(lblNewLabel);
		
		JLabel lblatm = new JLabel("��ӭʹ��");
		lblatm.setForeground(Color.BLUE);
		lblatm.setFont(new Font("�����п�", Font.PLAIN, 16));
		lblatm.setHorizontalAlignment(SwingConstants.LEFT);
		lblatm.setBounds(175, 15, 183, 15);
		layeredPane.add(lblatm);
		
		JButton Searchaccount = new JButton("��ѯ");
		Searchaccount.setForeground(Color.black);
		Searchaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * �û���ѯ����
				 */
				AccountDao ad=new AccountDao();
				ad.showString(name);


			}
		});
		Searchaccount.setBounds(52, 70, 93, 23);
		layeredPane.add(Searchaccount);
		
		JButton PopMoney = new JButton("ȡ��");
		PopMoney.setForeground(Color.black);
		PopMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new GetMoneyfm(name, password).setVisible(true);
				dispose();
			}
		});
		PopMoney.setBounds(253, 70, 93, 23);
		layeredPane.add(PopMoney);
		
		JButton PutMoney = new JButton("���");
		PutMoney.setForeground(Color.black);
		PutMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/**
			 * �û�����
			 */
				
			Account account=new Account();
			AccountDao ad=new AccountDao();
			String  s= JOptionPane.showInputDialog("����������:");
			double money=Double.parseDouble((s.equals("")?"0":s));
			if(money<=0){
				JOptionPane.showMessageDialog(null, "���������",
					"��Ϣ��ʾ",JOptionPane.ERROR_MESSAGE);
			}
			else {
				double tempMoney=ad.popMoney(name);
				double finalMoney=tempMoney+money;
				account.setMoney(finalMoney);
				account.setUsername(name);
				ad.putMoney(account);
				JOptionPane.showMessageDialog(null, "���ɹ�����ǰ���:��"+finalMoney,
						"��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
			}
			}
		});
		PutMoney.setBounds(52, 120, 93, 23);
		layeredPane.add(PutMoney);
		
		
		
		
		JButton button = new JButton("ת��");
		button.setForeground(Color.black);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * �û�ת��
				 */
				Account account=new Account();
				Account account2=new Account();
				AccountDao ad=new AccountDao();
				AccountDao ad2=new AccountDao();
				String userName2=JOptionPane.showInputDialog("��������Ҫת����˻���");
				if(userName2.equals(name)){
					JOptionPane.showMessageDialog(null, "�û����ܸ��Լ�ת�˵�Ŷ!!!", "����",
							JOptionPane.ERROR_MESSAGE);
				}else if(ad.searchname(userName2)!=true){
						JOptionPane.showMessageDialog(null, "�û������ڣ����֤����ת��!", "��Ϣ��ʾ", 
								JOptionPane.ERROR_MESSAGE);
					}	
				else {
					double tempMoney2=ad2.popMoney(userName2);
					double tempMoney=ad.popMoney(name);
					String  s= JOptionPane.showInputDialog("����ת�˽��:");
					double money=Double.parseDouble((s.equals("")?"0":s));	
					
					if(tempMoney<money){
						JOptionPane.showMessageDialog(null, "��������!", "��Ϣ��ʾ", 
								JOptionPane.ERROR_MESSAGE);
					}else if (money==0) {
						JOptionPane.showMessageDialog(null, "���������!", "��Ϣ��ʾ", 
								JOptionPane.ERROR_MESSAGE);
					}
					else {
						double finalMoney2=tempMoney2+money;
						double finalMoney=tempMoney-money;
						account2.setMoney(finalMoney2);
						account2.setUsername(userName2);
						ad2.putMoney(account2);
						account.setMoney(finalMoney);
						account.setUsername(name);
						ad.putMoney(account);
						JOptionPane.showMessageDialog(null, "ת�˳ɹ���","��Ϣ��ʾ",
					              JOptionPane.INFORMATION_MESSAGE);
										
					}
				}		
				}	
		});
		button.setBounds(253, 120, 93, 23);
		layeredPane.add(button);
		
		JButton changePassWord = new JButton("����");
		changePassWord.setForeground(Color.black);
		changePassWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account account=new Account();
				AccountDao ad=new AccountDao();
				String  newPassWord= JOptionPane.showInputDialog("�������µ�����:");
				if(newPassWord.equals(password)){
					JOptionPane.showMessageDialog(null, "��ԭ������ͬ�����ܲ��ɹ�", "��Ϣ��ʾ",
							JOptionPane.ERROR_MESSAGE);
				}else {
				String  newPassWord1= JOptionPane.showInputDialog("���ٴ�ȷ������:");
				if(!newPassWord1.equals(newPassWord)) {
					JOptionPane.showMessageDialog(null, "�������벻��ͬ���ٴ�ȷ��", "��Ϣ��ʾ",
							JOptionPane.ERROR_MESSAGE);
					}else {
					account.setPassword(newPassWord1);
					JOptionPane.showMessageDialog(null, "���ܳɹ���","��Ϣ��ʾ",
				              JOptionPane.INFORMATION_MESSAGE);
				}
			 }
			}
		
		 });
		changePassWord.setBounds(52, 170, 93, 23);
		layeredPane.add(changePassWord);
		
		
		
		
		
		JButton Exit = new JButton("�˳�");
		Exit.setForeground(Color.gray);
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "��ӭ�ٴε�½ʹ�ã�����","��Ϣ��ʾ",
			              JOptionPane.INFORMATION_MESSAGE);
			dispose();
				
			}
		});
		Exit.setBounds(253, 170, 93, 23);
		layeredPane.add(Exit);
		
	}
}

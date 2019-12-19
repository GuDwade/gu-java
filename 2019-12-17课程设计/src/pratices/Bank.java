package pratices;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Bank
{
    static int temp=10000;
    static int tm=0;/*filename.createNewFile()
	File filename=new File("D:\\Eclipse Workspace\\Training\\user\\"+shuru1.getText()+"\\name.txt");fileID.mkdirs();
	File fileID=new File("D:\\Eclipse Workspace\\Training\\user\\"+shuru1.getText());if(!fileID.exists())*/
    private static void createAndShowGUI()
    {
        JFrame f =new JFrame("中国银行");
        f.setSize(730, 500);
        f.setLocation(400,300);
        JTextArea showArea = new JTextArea(1,35);
        f.setResizable(true);//窗口是否可以尺寸大小
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel l1 = new JLabel();//l1标签
        ImageIcon icon = new ImageIcon("D:\\Eclipse Workspace\\Training\\img\\1.jpg");
        l1.setIcon(icon);//l1为图片标签
        JButton b1 = new JButton("登 录");
        JButton b2 = new JButton("退 出");
        JButton b3 = new JButton("注 册");
        JPanel panel = new JPanel();
        JLabel zhanghao = new JLabel("账号：");
        JLabel mima = new JLabel("密码：");
        JTextArea ja=new JTextArea(2,10);
        JTextField shuru1= new JTextField (20);
        JTextField shuru2= new JTextField (20);
        panel.add(zhanghao);
        panel.add(shuru1);
        panel.add(mima);
        panel.add(shuru2);
        panel.add(b1);
        panel.add(b3);
        panel.add(b2);
        panel.add(showArea);
        panel.add(ja);
        f.add(l1,BorderLayout.PAGE_START);
        f.add(panel,BorderLayout.CENTER);
        f.setVisible(true);

        b1.addActionListener(e ->
        {	String yonghu = "D:\\Eclipse Workspace\\Training\\user\\user.txt";
            String key = "D:\\Eclipse Workspace\\Training\\user\\key.txt";
            //@SuppressWarnings("unused")
            String content1 = shuru1.getText();
            //@SuppressWarnings("unused")
            String content2 = shuru2.getText();
            try(FileReader reader1 = new FileReader(yonghu);
                FileReader reader2 = new FileReader(key);
                BufferedReader br1 = new BufferedReader(reader2);
                BufferedReader br = new BufferedReader(reader1)
            )
            {
                String line;
                String line1;
                line1=br1.readLine();
                while ((line=br.readLine()) != null)
                {
                    if((line.equals(content1))&&(line1.equals(content2)))
                    {f.setVisible(false);
                        denglu();}
                    else
                        showArea.append("用户名或密码输入错误");
                }
            }
            catch (IOException e1)
            {e1.printStackTrace();}



        });

        b2.addActionListener(e ->
        {
            System.exit(0);
        });

        b3.addActionListener(e ->
        {
            panel.removeAll();//移除布局
            JLabel zhanghao1 = new JLabel("账号：");
            JLabel mima1 = new JLabel("密码：");
            JTextField shuru3= new JTextField (20);
            JTextField shuru4= new JTextField (20);
            JButton zhuce = new JButton("完 成");
            JButton back = new JButton("返 回");
            panel.add(zhanghao1);
            panel.add(shuru3);
            panel.add(mima1);
            panel.add(shuru4);
            panel.add(zhuce);
            panel.add(back);
            panel.validate();//刷新
            panel.repaint();//重画

            zhuce.addActionListener(g ->
            {
                String content1 = shuru3.getText();//获取注册名字
                String content2 = shuru4.getText();//获取注册密码
                File fp=new File("D:\\Eclipse Workspace\\Training\\user\\user.txt");
                try {
                    PrintWriter pfp = new PrintWriter(fp);
                    pfp.print(content1);

                    pfp.close();
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                //BufferedReader bu = new BufferedReader(new InputStreamReader());
                File fp1=new File("D:\\Eclipse Workspace\\Training\\user\\key.txt");
                try {
                    PrintWriter pfp = new PrintWriter(fp1);
                    pfp.print(content2);

                    pfp.close();
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            });

            back.addActionListener(w ->
            {
                panel.removeAll();//移除布局
                panel.add(zhanghao);
                panel.add(shuru1);
                panel.add(mima);
                panel.add(shuru2);
                panel.add(b1);
                panel.add(b3);
                panel.add(b2);
                panel.add(showArea);
                f.add(l1,BorderLayout.PAGE_START);
                f.add(panel,BorderLayout.CENTER);
                f.setVisible(true);
                panel.validate();//刷新
                panel.repaint();//重画
            });
        });
    }

    private static void denglu()
    {
        JFrame f =new JFrame("中国银行");
        f.setSize(580, 500);
        f.setLocation(400,300);
        JTextArea showArea = new JTextArea(50,50);
        JLabel l1 = new JLabel();//l1标签
        ImageIcon icon = new ImageIcon("D:\\Eclipse Workspace\\Training\\img\\2.jpg");
        l1.setIcon(icon);
        f.setResizable(true);//窗口是否可以尺寸大小
        f.setVisible(true);
        JTextField input = new JTextField(20);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("欢迎,请在选择你需要的操作");
        JButton b1 = new JButton("存 款");
        JButton b2 = new JButton("取 款");
        JButton b3 = new JButton("余 额");
        JButton b4 = new JButton("退 出");
        JPanel panel = new JPanel();
        f.add(panel);
        panel.add(l1);
        panel.add(label);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(input);
        panel.add(showArea);


        b1.addActionListener(e ->//存款
        {

            String tem = input.getText();
            if((tem!=null) && (!tem.trim().equals("")))

            {
                int j= Integer.parseInt( tem);
                temp=temp+j;
                showArea.setText(" ");
                showArea.append("存款成功，当前余额为"+temp+"!");
            }
            else
            {
                showArea.setText(" ");
                showArea.append("错误！重输！");
            }input.setText("");
        });
        b2.addActionListener(w ->//取款
        {


            String tem = input.getText();
            if((tem!=null) && (!tem.trim().equals("")))
            {
                int j= Integer.parseInt( tem);
                if(j>temp)
                {
                    showArea.setText(" ");
                    showArea.append("你哪有这么多的钱来取哦！");
                }else
                {
                    temp=temp-j;
                    showArea.setText(" ");
                    showArea.append("取款成功，当前余额为"+temp+"!");
                }
            }
            else
            {
                showArea.setText(" ");
                showArea.append("错误！重输！");
            }
            input.setText("");
        });

        b3.addActionListener(w ->
        {
            showArea.setText(" ");
            showArea.append("当前余额为"+temp+"!\n");
        });
        b4.addActionListener(w ->
        {
            f.setVisible(false);
            createAndShowGUI();

        });

    }
    private static void setDefaultCloseOperation(int disposeOnClose) {
        // TODO Auto-generated method stub

    }

    public static void main (String[] args)
    {
        SwingUtilities.invokeLater(Bank::createAndShowGUI);
    }
}

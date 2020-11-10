import sun.awt.image.ToolkitImage;
import java.awt.*;
import javax.swing.*;
public class BallGame extends JFrame{

    Image desk=Toolkit.getDefaultToolkit().getImage("pic/desk.jpg");
    Image ball=Toolkit.getDefaultToolkit().getImage("pic/ball.png");


    double  x=100;	//小球的横坐标
    double  y=100; //小球的纵坐

    //boolean right=true;//控制小球水平方向

    double degree =3.14/3;  //弧度  60

    //绘制窗口
    public void paint(Graphics g){
        System.out.println("绘制一次");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int)x, (int)y,null);
        /*
        if(right){
            x=x+5;
        }else{
            x=x-5;
        }

        if(x>856-30-40){
            right=false;
        }
        if(x<40){
            right=true;
        }
        */
        x=x+10*Math.cos(degree);
        y=y+10*Math.sin(degree);
        //改变方向
        if(y>501-40-30||y<0+40+40){
            degree=-degree;
        }

        if(x>856-40-30||x<40){
            degree=3.14-degree;
        }
    }

    //创建窗口
    public void launchFrame() {
        setSize(856, 500);
        setLocation(50, 50);
        setVisible(true);

        //实现动画
        while (true){
            repaint();

            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BallGame bg=new BallGame();
        bg.launchFrame();
    }
}

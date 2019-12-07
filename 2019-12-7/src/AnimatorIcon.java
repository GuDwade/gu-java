import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimatorIcon extends JPanel implements ActionListener {
    ImageIcon[]images;
    Timer animationTimer;
    int currentImage=0;
    int delay=500;
    int width;
    int height;
    public AnimatorIcon(){
        setBackground(Color.white);
        images=new ImageIcon[2];
        for(int i=0;i<images.length;i++){
            images[i]=new ImageIcon(getClass().getResource("C:\\Users\\Administrator\\Desktop\\好.gif"));
            width=images[0].getIconWidth();
            height=images[0].getIconHeight();
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        images[currentImage].paintIcon(this,g,70,0);
        currentImage=(currentImage+1)%2;
    }
    public void actionPerformed(ActionEvent actionEvent){
        repaint();
    }
    public void startAniamtion(){
        if(animationTimer==null){
            currentImage=0;
            animationTimer=new Timer(delay,this);
            animationTimer.start();
        }else if(!animationTimer.isRunning()){
            animationTimer.restart();
        }
    }
    public void stopAnimation(){
        animationTimer.stop();
    }

    public static void main(String[] args) {
        AnimatorIcon animation=new AnimatorIcon();
        JFrame frame=new JFrame("动画图标");
        frame.getContentPane().add(animation);
        frame.setSize(200,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        animation.startAniamtion();
    }
}

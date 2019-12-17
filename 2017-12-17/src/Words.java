import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

public class Words extends JApplet implements  Runnable {
    private Image image;
    private Image image_1;
    private  Graphics gp;
    private Thread thread=null;
    private  MediaTracker tracker;
    private  int height,width;
    private  String text;
    private  Font font;
    public  void init() {
        this.setSize(300, 200);
        width = this.getWidth();
        height = this.getHeight();
        this.setBackground(Color.yellow);
        image = createImage(width, height);
        text = "welcom";
        String str = "天道酬勤";
        if (str != null) {
            text = str;
        }
        font = new Font("华文行楷", Font.BOLD, 50);
        tracker = new MediaTracker(this);
        tracker.addImage(image, 0);
        try {
            tracker.waitForID(0);
        } catch (InterruptedException e) {
        }
        image_1 = createImage(width, height);
        gp = image_1.getGraphics();
    }
        public void start(){
            if(thread==null){
                thread=new Thread(this);
                thread.start();
            }
        }
        public void paint(Graphics g){
            gp.drawImage(image_1,0,0,this);
        }

    @Override
    public void run() {
        int x=20;
        int y=height/2;
        int  R,G,B;
        gp.setFont(font);
        while (thread!=null){
            R=(int)(255*Math.random());
            G=(int)(255*Math.random());
            R=(int)(255*Math.random());
            try{
                thread.sleep(2000);
            }catch(InterruptedException ex){
            }
            gp.setColor(Color.blue);
            gp.fillRect(0,0,width,height);
            repaint();
            try{
                thread.sleep(60);
            }catch (InterruptedException e){
            }
        }
    }

}

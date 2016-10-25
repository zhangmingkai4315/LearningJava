package LearningJava.Ch7;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
/**
 * Created by mike on 16-10-25.
 */
public class SimpleFrameTest {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleFrame s =new SimpleFrame();
                s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//                单个屏幕的时候
//                Toolkit kit = Toolkit.getDefaultToolkit();
//                Dimension screen=kit.getScreenSize();
//                int screenW=screen.width;
//                int screenH=screen.height;
//                System.out.println("Height:"+screenH+" Width:"+screenW);


//                多个屏幕的时候获得第一个屏幕的大小尺寸
                GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice[] devices = g.getScreenDevices();
                int screenW=devices[0].getDisplayMode().getWidth();
                int screenH=devices[0].getDisplayMode().getHeight();
                s.setSize(screenW/2,screenH/2);

                s.setLocationByPlatform(true);
                s.setLocationRelativeTo(null); //居中显示
                s.setTitle("AwsomeJava");
//              加载图片
                URL iconURL=getClass().getResource("images/java.gif");
                Image img =new ImageIcon(iconURL).getImage();
                s.setIconImage(img);
                s.setVisible(true);
            }
        });
    }
}
class SimpleFrame extends JFrame{
    private static final int DEFAULT_WIDTH=800;
    private static final int DEFAULT_HEIGHT=600;
    public SimpleFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}


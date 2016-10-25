package LearningJava.Ch7;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by mike on 16-10-25.
 */

public class SimpleFrameWithText {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleFrame2 s =new SimpleFrame2();
                s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice[] devices = g.getScreenDevices();
                int screenW=devices[0].getDisplayMode().getWidth();
                int screenH=devices[0].getDisplayMode().getHeight();
                s.setSize(screenW/2,screenH/2);

                s.setLocationByPlatform(true);
                s.setLocationRelativeTo(null); //居中显示
                s.setTitle("AwsomeJava");


                URL iconURL=getClass().getResource("images/java.gif");
                Image img =new ImageIcon(iconURL).getImage();
                s.setIconImage(img);
                s.setVisible(true);
            }
        });
    }
}
class SimpleFrame2 extends JFrame{
    private static final int DEFAULT_WIDTH=800;
    private static final int DEFAULT_HEIGHT=600;

    public SimpleFrame2(){
//      将组件加入到图层中这里默认加到内容图层
        add(new MyComponent());
//      使用首选大小的组件
        pack();
    }
}

//创建一个自己的组件　继承自　JComponent

class MyComponent extends JComponent {
    //只要窗口需要绘制，就会调用该方法，不要人为调用，如果需要强制刷新使用repaint方法
    private static final int MESSAGE_X=75;
    private static final int MESSAGE_Y=100;

    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;

//    重载原来的paintComponent方法来绘制内容，
    public void paintComponent(Graphics g){
        g.drawString("Hello world!",MESSAGE_X,MESSAGE_Y);
    }
//    获得首选的组件大小
    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}

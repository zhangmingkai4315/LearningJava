package LearningJava.Ch8;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.net.URL;

/**
 * Created by mike on 16-10-25.
 */

public class SimpleFrameWithGraphic {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleFrame3 s =new SimpleFrame3();
                s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice[] devices = g.getScreenDevices();
                int screenW=devices[0].getDisplayMode().getWidth();
                int screenH=devices[0].getDisplayMode().getHeight();
                s.setSize(screenW/2,screenH/2);

                s.setLocationByPlatform(true);
                s.setLocationRelativeTo(null); //居中显示
                s.setTitle("AwsomeJava");
//                s.setBackground(new Color(107,106,104));

                URL iconURL=getClass().getResource("images/java.gif");
                Image img =new ImageIcon(iconURL).getImage();
                s.setIconImage(img);
                s.setBackground(Color.BLUE);
//                s.setOpacity(0.1F);?
                s.setVisible(true);
            }
        });
    }
}
class SimpleFrame3 extends JFrame{
    private static final int DEFAULT_WIDTH=800;
    private static final int DEFAULT_HEIGHT=600;

    public SimpleFrame3(){
//      将组件加入到图层中这里默认加到内容图层
        add(new MyComponent1());

//      使用首选大小的组件
        pack();
    }
}

//创建一个自己的组件　继承自　JComponent

class MyComponent1 extends JComponent {
    //只要窗口需要绘制，就会调用该方法，不要人为调用，如果需要强制刷新使用repaint方法
    private static final int MESSAGE_X=75;
    private static final int MESSAGE_Y=100;

    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;

    //    重载原来的paintComponent方法来绘制内容，
    public void paintComponent(Graphics g){
        Graphics2D g2=(Graphics2D) g;
        double leftX=100;
        double topX =100;
        double width=200;
        double height =150;

        Rectangle2D rect = new Rectangle2D.Double(leftX,topX,width,height);
        g2.draw(rect);
        Ellipse2D ellipse= new Ellipse2D.Double();
        ellipse.setFrame(rect);

        g2.draw(ellipse);

        g2.draw(new Line2D.Double(leftX,topX,leftX+width,topX+height));

        double centerX =rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = 150;

        Ellipse2D circle=new Ellipse2D.Double();

        circle.setFrameFromCenter(centerX,centerY,centerX+radius,centerY+radius);
        g2.draw(circle);
        g2.setPaint(Color.CYAN.brighter().brighter().brighter());
        g2.drawString("Error",100,100);
        g2.fill(rect);

    }
    //    获得首选的组件大小
    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}
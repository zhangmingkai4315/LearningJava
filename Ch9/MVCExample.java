package LearningJava.Ch9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mike on 16-10-25.
 */

public class MVCExample {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleFrame s =new SimpleFrame();
                s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice[] devices = g.getScreenDevices();
                int screenW=devices[0].getDisplayMode().getWidth();
                int screenH=devices[0].getDisplayMode().getHeight();
                s.setSize(screenW/2,screenH/2);
                s.setLocationByPlatform(true);
                s.setLocationRelativeTo(null); //居中显示
                s.setTitle("AwsomeJava");
                s.setVisible(true);
            }
        });
    }
}
class SimpleFrame extends JFrame{
    private static final int DEFAULT_WIDTH=800;
    private static final int DEFAULT_HEIGHT=600;

    private JPanel buttonPanel;
    public SimpleFrame(){

        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        JButton yellowButton = new JButton("yellow");
        JButton redButton = new JButton("red");
        JButton blackButton = new JButton("black");
        JButton othersButton1 = new JButton("othersButton");
        JButton othersButton2 = new JButton("othersButton");
        JButton othersButton3 = new JButton("othersButton");


        buttonPanel=new JPanel();
        add(buttonPanel);

        JPanel panel = new JPanel();
        panel.add(yellowButton);
        panel.add(blackButton);
        panel.add(redButton);

        add(panel,BorderLayout.SOUTH);

       SimpleFrame.ColorAction yellowAction = new ColorAction(Color.YELLOW);
       SimpleFrame.ColorAction redAction = new ColorAction(Color.RED);
       SimpleFrame.ColorAction blackAction = new ColorAction(Color.BLACK);

        yellowButton.addActionListener(yellowAction);
        redButton.addActionListener(redAction);
        blackButton.addActionListener(blackAction);
    }
    private class ColorAction implements ActionListener {
        private Color backgroundColor;
        public ColorAction(Color r){
            backgroundColor=r;
        }
        public void actionPerformed(ActionEvent e){
            buttonPanel.setBackground(backgroundColor);
        }
    }
}




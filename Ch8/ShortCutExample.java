package LearningJava.Ch8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mike on 16-10-25.
 */


public class ShortCutExample {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleFrame4 s =new SimpleFrame4();
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
class SimpleFrame4 extends JFrame{
    private static final int DEFAULT_WIDTH=800;
    private static final int DEFAULT_HEIGHT=600;

    private JPanel buttonPanel;
    public SimpleFrame4(){

        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);


        buttonPanel=new JPanel();

        add(buttonPanel);

        ColorAction yellowAction = new ColorAction("YELLOW",Color.YELLOW);
        ColorAction redAction = new ColorAction("RED",Color.RED);
        ColorAction blackAction = new ColorAction("BLACK",Color.BLACK);

        JButton yellowButton = new JButton(yellowAction);
        JButton redButton = new JButton(redAction);
        JButton blackButton = new JButton(blackAction);

        buttonPanel.add(yellowButton);
        buttonPanel.add(redButton);
        buttonPanel.add(blackButton);
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Y"),"panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl B"),"panel.black");
        imap.put(KeyStroke.getKeyStroke("ctrl R"),"panel.red");
        ActionMap amap =buttonPanel.getActionMap();
        amap.put("panel.yellow",yellowAction);
        amap.put("panel.black",blackAction);
        amap.put("panel.red",redAction);


    }
    private class ColorAction extends AbstractAction {
        private Color backgroundColor;
        public ColorAction(String name,Color r){
            backgroundColor=r;
            putValue(Action.NAME,name);
            putValue(Action.SHORT_DESCRIPTION,"set panel color to "+name.toLowerCase());
        }
        public void actionPerformed(ActionEvent e){
            buttonPanel.setBackground(backgroundColor);
        }
    }
}




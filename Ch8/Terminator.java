package LearningJava.Ch8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by mike on 16-10-25.
 */
public class Terminator {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final TerminatorFrame s =new TerminatorFrame();
                s.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice[] devices = g.getScreenDevices();
                int screenW=devices[0].getDisplayMode().getWidth();
                int screenH=devices[0].getDisplayMode().getHeight();
                s.setSize(screenW/2,screenH/2);
                s.setLocationByPlatform(true);
                s.setLocationRelativeTo(null); //居中显示
                s.setTitle("AwsomeJava");
                s.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent windowEvent) {
                            s.dispose();
                    }
                });
                s.setVisible(true);
            }
        });
    }
}

class TerminatorFrame extends JFrame{
    private static final int DEFAULT_WIDTH=800;
    private static final int DEFAULT_HEIGHT=600;
    public void Terminator(){

    }
}



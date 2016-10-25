package LearningJava.Ch8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mike on 16-10-25.
 */
public class ChangeView {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ChangeFeel s =new ChangeFeel();
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
class ChangeFeel extends JFrame{
    private static final int DEFAULT_WIDTH=800;
    private static final int DEFAULT_HEIGHT=600;
    private JPanel buttonPanel;
    public ChangeFeel(){
        buttonPanel = new JPanel();
        UIManager.LookAndFeelInfo[] infos=UIManager.getInstalledLookAndFeels();
        for(UIManager.LookAndFeelInfo info:infos){
            makeButton(info.getName(),info.getClassName());

        }
        add(buttonPanel);
        pack();
    }
    void makeButton(String name,final String platformName){
        JButton button = new JButton(name);
        buttonPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    UIManager.setLookAndFeel(platformName);
                    SwingUtilities.updateComponentTreeUI(ChangeFeel.this);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

}




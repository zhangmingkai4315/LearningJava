package LearningJava.Ch9;

/**
 * Created by mike on 16-10-25.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mike on 16-10-25.
 */

public class TextExamples {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TextFrame s =new TextFrame();
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

class TextFrame extends JFrame{
    private int MAX_LINE_NUMBER = 20;
    private int MAX_AREA_ROWS =8;
    private int MAX_AREA_COLUMS = 20;
    public TextFrame(){
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,2));
        JLabel userLabel = new JLabel("Username:",SwingConstants.RIGHT);
        JLabel passwordLabel = new JLabel("Password:",SwingConstants.RIGHT);
        final JTextField textField = new JTextField("Default input",MAX_LINE_NUMBER);
        final JPasswordField passwordField = new JPasswordField(MAX_LINE_NUMBER);

        final JTextArea words = new JTextArea(MAX_AREA_ROWS,MAX_AREA_COLUMS);

        JButton insetButton = new JButton("insert");
        insetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                words.append("User name:"+textField.getText()+"Password:"+new String(passwordField.getPassword())+"\n");

            }
        });
        northPanel.add(userLabel);
        northPanel.add(textField);
        northPanel.add(passwordLabel);
        northPanel.add(passwordField);
        add(northPanel,BorderLayout.NORTH);

        add(new JScrollPane(words),BorderLayout.CENTER);


        JPanel southPanel = new JPanel();
        southPanel.add(insetButton);
        add(southPanel,BorderLayout.SOUTH);


    }
}

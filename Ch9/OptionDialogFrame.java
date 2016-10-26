package LearningJava.Ch9;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mike on 16-10-26.
 */

public class OptionDialogFrame {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                OptionDialog s =new OptionDialog();
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

class ButtonPanel extends JPanel{
    private ButtonGroup group;
    public ButtonPanel(String title,String ...options){
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),title));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        group=new ButtonGroup();
        for(String s :options){
            JRadioButton b = new JRadioButton(s);
            b.setActionCommand(s);
            add(b);
            group.add(b);
            b.setSelected(s==options[0]);
        }
    }
    public String getSelection(){
        return group.getSelection().getActionCommand();
    }
}


class AboutDialog extends JDialog{
    public AboutDialog(JFrame owner){
        super(owner,"About Dialog Test",true);
        add(new JLabel("<html><h1>Version</h1>1.0</html>"));
        JPanel j =new JPanel();
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
            }
        });
        j.add(ok);
        add(j,BorderLayout.SOUTH);
        setSize(250,150);
    }
}



class OptionDialog extends JFrame{
    private ButtonPanel typePanel;
    private ButtonPanel messageTypePanel;
    private JDialog aboutDialog;
    public OptionDialog(){

        JMenuBar menuBar = new JMenuBar();
        JMenu infoMenu=new JMenu("Info");
        aboutDialog = new AboutDialog(this);
//       setMnemonic来完成菜单的快捷键设置．
        infoMenu.setMnemonic('I');
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                aboutDialog.setVisible(true);
            }
        });
        infoMenu.add(aboutItem);
        menuBar.add(infoMenu);
        setJMenuBar(menuBar);


        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(2,3));
        typePanel = new ButtonPanel("Type","Message","Confirm","Option","Input");
        messageTypePanel = new ButtonPanel("Message Type","ERROR_MESSAGE","INFORMATION_MESSAGE","PLAIN_MESSAGE","WARNING_MESSAGE");
        gridPanel.add(typePanel);
        gridPanel.add(messageTypePanel);
        JPanel showPanel = new JPanel();
        JButton showButton = new JButton("Show");
        showButton.addActionListener(new ShowAction());
        showPanel.add(showButton);


        add(gridPanel,BorderLayout.CENTER);
        add(showPanel,BorderLayout.SOUTH);
        pack();
    }
    public int getType(ButtonPanel panel){
        String s = panel.getSelection();
        System.out.println(s);
        try{
            return JOptionPane.class.getField(s).getInt(null);
        }catch (Exception e){
            return  -1;
        }
    }
    private class ShowAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(typePanel.getSelection().equals("Confirm")){
                JOptionPane.showConfirmDialog(OptionDialog.this,"Message","Title",getType(typePanel),getType(messageTypePanel));
            }else if(typePanel.getSelection().equals("Message")){
                JOptionPane.showConfirmDialog(OptionDialog.this,"Message","Title",getType(messageTypePanel));
            }
        }
    }
}
package LearningJava.Ch9;

import com.sun.org.apache.bcel.internal.generic.POP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by mike on 16-10-26.
 */

public class MenuExamples {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MenuFrame s =new MenuFrame();
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

class MenuFrame extends JFrame{
    public MenuFrame(){

        JMenuBar menuBar = new JMenuBar();
        JMenu editMenu=new JMenu("Edit");

//       setMnemonic来完成菜单的快捷键设置．
        editMenu.setMnemonic('E');
        JMenuItem pasteItem = new JMenuItem("Paste");
//      加速键只能用来设置菜单的项目，而不是菜单，所以不能放在edit上
        pasteItem.setAccelerator(KeyStroke.getKeyStroke("ctrl P"));


        pasteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.print("Paste");
            }
        });

        JMenuItem copyItem = new JMenuItem("Copy");
        copyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.print("Copy");
            }
        });
        editMenu.add(pasteItem);
        editMenu.add(copyItem);
        editMenu.addSeparator();
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        editMenu.add(exitItem);
        menuBar.add(editMenu);
        this.setJMenuBar(menuBar);

        addMouseListener(new PopClickListener());
    }
}

class PopupCustom extends JPopupMenu{
    JMenuItem item;
    public PopupCustom(){
        item = new JMenuItem("Click Me");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.print("Cut");
            }
        });
        add(item);
    }
}
class PopClickListener extends MouseAdapter{
    public void mousePressed(MouseEvent e){
        if(e.isPopupTrigger()){
            doPop(e);
        }
    }
    public void mouseReleased(MouseEvent e){
        if(e.isPopupTrigger()){
            doPop(e);
        }
    }

    public void doPop(MouseEvent e){
        PopupCustom menu = new PopupCustom();
        menu.show(e.getComponent(),e.getX(),e.getY());
    }
}
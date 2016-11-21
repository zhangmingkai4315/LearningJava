package LearningJava.Ch14;

/**
 * Created by zhangmingkai on 16/11/21.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bounce {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new BounceFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class BounceFrame extends JFrame{
    private BallComponent comp;
    public static final int STEPS=1000;
    public static final int DELAY =3;
    public BounceFrame(){
        setTitle("Bounce");
        comp = new BallComponent();
        add(comp,BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel,"start", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addBall();
            }
        });
        addButton(buttonPanel,"close",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(buttonPanel,BorderLayout.SOUTH);
        pack();

    }
    public void addButton(Container c,String title,ActionListener listener){
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }
    public void addBall(){
        Ball b= new Ball();
        comp.add(b);
        Runnable r = new BallRunnable(b,comp);
        Thread t = new Thread(r);
        t.start();
    }

}

class BallRunnable implements Runnable{
    private Ball ball;
    private Component component;
    public static final int STEPS=1000;
    public static final int DELAY =3;
    public BallRunnable(Ball b,Component com){
        ball=b;
        component = com;
    }
    public void run(){
        try {
            for(int i =0;i<STEPS;i++){
                ball.move(component.getBounds());
                component.paint(component.getGraphics());
                Thread.sleep(DELAY);
            }
        }catch (InterruptedException e){

        }
    }
}

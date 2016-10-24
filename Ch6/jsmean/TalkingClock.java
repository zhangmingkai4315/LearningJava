package LearningJava.Ch6.jsmean;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
/**
 * Created by mike on 16-10-24.
 */
public class TalkingClock {
    private int interval;
    private boolean beep;
    public TalkingClock(int interval,boolean beep){
        this.interval=interval;
        this.beep=beep;
    }
//    public class TimePriter2 implements ActionListener{
//        public void actionPerformed(ActionEvent event) {
//            Date now = new Date();
//            System.out.println("Hi now is :"+now.toString());
//            if (TalkingClock.this.beep) {
//                Toolkit.getDefaultToolkit().beep();
//            }
//        }
//    }
//    public void start(){
//        class TimePriter2 implements ActionListener{
//                public void actionPerformed(ActionEvent event) {
//                Date now = new Date();
//                System.out.println("Hi now is :"+now.toString());
//                if (TalkingClock.this.beep) {
//                    Toolkit.getDefaultToolkit().beep();
//                }
//            }
//        }
//        ActionListener listener=new TimePriter2();
//        javax.swing.Timer t =new Timer(interval,listener);
//        t.start();
//    }

    public void start(){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Date now = new Date();
                System.out.println("Hi now is :"+now.toString());
                System.out.println(new Object(){}.getClass().getEnclosingClass());
                if (TalkingClock.this.beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };
        javax.swing.Timer t =new Timer(interval,listener);
        t.start();
    }

}

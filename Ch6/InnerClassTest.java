package LearningJava.Ch6;

import LearningJava.Ch6.jsmean.TalkingClock;

import javax.swing.*;

/**
 * Created by mike on 16-10-24.
 */


public class InnerClassTest {
    public static void main(String[] args){

        TalkingClock t =new TalkingClock(1000,false);
        t.start();
//        TalkingClock.TimePriter2 listener = t.new TimePriter2();
//        javax.swing.Timer timer =new Timer(1000,listener);
//        timer.start();
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);

    }
}

package LearningJava.Ch6;

import LearningJava.Ch6.jsmean.Employee;
import LearningJava.Ch6.jsmean.TimePrinter;

import javax.annotation.processing.Completion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.*;

/**
 * Created by mike on 16-10-24.
 */
public class TimerTest {
    public static void main(String[] args){
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(5000,listener);
        t.start();
        JOptionPane.showMessageDialog(null,"Quit?");
        System.exit(0);
    }
}


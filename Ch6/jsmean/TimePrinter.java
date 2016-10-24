package LearningJava.Ch6.jsmean;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
/**
 * Created by mike on 16-10-24.
 */
public class TimePrinter implements ActionListener {
    public void actionPerformed(ActionEvent event){
        Date now = new Date();
        System.out.println("At time : "+now.toString());
        Toolkit.getDefaultToolkit().beep();
    }
}

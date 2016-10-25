package LearningJava.Ch9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mike on 16-10-25.
 */
public class Calculator {
        public static void main(String[] args){
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    CalculatorFrame s =new CalculatorFrame();
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

class CalculatorPanel extends JPanel{
    private JButton display;
    private JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;
    public CalculatorPanel(){
        setLayout(new BorderLayout());
        result =0;
        lastCommand="=";
        start = true;
        display=new JButton("0");
        display.setEnabled(false);
        add(display,BorderLayout.NORTH);
        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        panel = new JPanel();
        panel.setLayout(new GridLayout(4,4,20,20));
        addButton("7",insert);
        addButton("8",insert);
        addButton("9",insert);
        addButton("/",command);

        addButton("4",insert);
        addButton("5",insert);
        addButton("6",insert);
        addButton("*",command);

        addButton("1",insert);
        addButton("2",insert);
        addButton("3",insert);
        addButton("-",command);

        addButton("0",insert);
        addButton(".",insert);
        addButton("=",command);
        addButton("+",command);

        add(panel,BorderLayout.CENTER);
    }
    private void addButton(String label,ActionListener actionListener){
        JButton j =new JButton(label);
        j.addActionListener(actionListener);
        panel.add(j);
    }
    private class InsertAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String input = e.getActionCommand();
            if(start){
                display.setText("");
                start = false;
            }

            display.setText(display.getText()+ input);
        }
    }
    private class CommandAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if(start){
                if(command.equals("-")){
                    display.setText(command);
                    start=false;

                }else{
                    lastCommand =command;
                }
            }else{
                caculate(Double.parseDouble(display.getText()));
                lastCommand=command;
                start =true;
            }
        }
    }

    public  void caculate(double x){
        if(lastCommand.equals("+")) result +=x;
        else if(lastCommand.equals("-")) result -=x;
        else if(lastCommand.equals("*")) result *=x;
        else if(lastCommand.equals("/")) result /=x;
        else if(lastCommand.equals("=")) result =x;
        display.setText(""+result);
    }
}



class CalculatorFrame extends JFrame{
    public CalculatorFrame(){
        CalculatorPanel c=new CalculatorPanel();
        add(c);
    }
}
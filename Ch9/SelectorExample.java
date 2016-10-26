package LearningJava.Ch9;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mike on 16-10-26.
 */



public class SelectorExample {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SelectorFrame s =new SelectorFrame();
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

class SelectorFrame extends JFrame{
    private JCheckBox bold;
    private JCheckBox italic;
    private JLabel label;
    private int size=0;
    private final int FONTSZIE =20;
    private ButtonGroup group;
    private ButtonGroup groupBorder;
    private JPanel demoPanel;
    public SelectorFrame(){
        demoPanel =new JPanel();
        groupBorder =new ButtonGroup();
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int mode = 0;
                if (bold.isSelected()) mode += Font.BOLD;
                if (italic.isSelected()) mode += Font.ITALIC;
                label.setFont(new Font("Serif", mode, FONTSZIE));
            }
        };
        JPanel panel = new JPanel();
        bold = new JCheckBox("Bold");
        italic =new JCheckBox("Italic");
        label =new JLabel("Hello world!");
        italic.addActionListener(listener);
        bold.addActionListener(listener);


        panel.add(bold);
        panel.add(italic);

        final JComboBox<String> faceCombo=new JComboBox<String>();

        faceCombo.addItem("Serif");
        faceCombo.addItem("SansSerif");
        faceCombo.addItem("Monospaced");

        faceCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),Font.PLAIN,20));
            }
        });




        panel.add(faceCombo);
        panel.add(label);


        final JSlider slider = new JSlider(0,10,5);
        slider.setMajorTickSpacing(1);
        slider.setMinorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.addChangeListener(new SliderListener());
        panel.add(slider);




        add(panel,BorderLayout.NORTH);

//
//        addRadioButton("Low",BorderFactory.createLoweredBevelBorder());
//        addRadioButton("Raised",BorderFactory.createRaisedBevelBorder());
//        addRadioButton("Etched",BorderFactory.createEtchedBorder());
//
//        add(demoPanel);
//





        JPanel sizePanel = new JPanel();
        ButtonGroup groupButton=new ButtonGroup();
        final JRadioButton smallButton = new JRadioButton("Small",false);
        JRadioButton bigButton =new JRadioButton("Big",true);
        ActionListener listener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(smallButton.isSelected()) size =10;
                else size =20;
                label.setFont(new Font("Serif",Font.PLAIN,size));
            }
        };
        smallButton.addActionListener(listener1);
        bigButton.addActionListener(listener1);
        sizePanel.add(smallButton);
        sizePanel.add(bigButton);
        group =new ButtonGroup();
        group.add(smallButton);
        group.add(bigButton);

        add(sizePanel,BorderLayout.SOUTH);

        pack();




    }

    public void addRadioButton(String buttonName, final Border b){
        JRadioButton button =new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                demoPanel.setBorder(b);
            }
        });
        demoPanel.add(button);
        groupBorder.add(button);
    }



}
class SliderListener implements ChangeListener{
    public void stateChanged(ChangeEvent e){
        JSlider s = (JSlider) e.getSource();
        int value = s.getValue();
        System.out.println(value);
    }
}
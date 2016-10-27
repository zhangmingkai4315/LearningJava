package LearningJava.Ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.*;

/**
 * Created by zhangmingkai on 16/10/27.
 */
public class LoggingImageViewer {
    public static void main(String[] agrs){
        if(System.getProperty("java.util.logging.config.class")==null&&
                System.getProperty("java.util.logging.config.file")==null){
            try{
                Logger.getLogger("LearningJava.Ch11").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT=10;
                Handler handler =new FileHandler("%h/LoggingImageViewer.log",0,LOG_ROTATION_COUNT);
                Logger.getLogger("LearningJava.Ch11").addHandler(handler);
            }catch (IOException e){
                Logger.getLogger("LearningJava.Ch11").log(Level.SEVERE,"Can't create log file handler");
            }
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Handler windowHandler = new WindowHandler();
                windowHandler.setLevel(Level.ALL);
                Logger.getLogger("LearningJava.Ch11").addHandler(windowHandler);
                JFrame frame = new ImageViewerFrame();
                frame.setTitle("LoggerImageViewer");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Logger.getLogger("LearningJava.Ch11").fine("Showing frame");
                frame.setVisible(true);
            }
        });

    }

}

class ImageViewerFrame extends JFrame{
    private static final int DEFAULT_WIDTH =300;
    private static final int DEFAULT_HEIGHT=400;
    private JLabel jLabel;
    private static Logger logger = Logger.getLogger("LearningJava.Ch11");
    public ImageViewerFrame(){
        logger.entering("ImageViewerFrame","<init>");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener());
        JMenuItem closeItem = new JMenuItem("Close");
        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.fine("Exiting.");
                System.exit(0);
            }
        });
        menu.add(closeItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
        jLabel = new JLabel();
        this.add(jLabel);
        logger.exiting("ImageViewerFrame","<init>");
    }
    private class FileOpenListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            logger.entering("ImageViewerFrame.FileOpenListener","actionPerfomed",e);
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));
            chooser.setFileFilter(new javax.swing.filechooser.FileFilter(){
                public boolean accept(File f){
                    return f.getName().toLowerCase().endsWith(".gif")||f.isDirectory();
                }
                public String getDescription(){
                    return "Gif Images";
                }
            });

            int r = chooser.showOpenDialog(ImageViewerFrame.this);
            if(r == JFileChooser.APPROVE_OPTION){
                String name = chooser.getSelectedFile().getPath();
                logger.log(Level.FINE,"Reading file{0}",name);
                jLabel.setIcon(new ImageIcon(name));
            }
            else logger.fine("File open dialog canceled.");
            logger.exiting("ImageViewerFrame.FileOpenListener","actionPerformed");
        }
    }
}


class WindowHandler extends StreamHandler{
    private JFrame frame;
    public WindowHandler(){
        frame =new JFrame();
        final JTextArea outPut =new JTextArea();
        outPut.setEditable(false);
        frame.setSize(200,200);
        frame.add(new JScrollPane(outPut));
        frame.setFocusableWindowState(false);
        frame.setVisible(true);
        setOutputStream(new OutputStream(){
            public void write(int b){

            }
            public void write(byte[] n,int off,int len){
                outPut.append(new String(n,off,len));
            }
        });
    }
    public void publish(LogRecord record){
        if(!frame.isVisible()) return;
        super.publish(record);
        flush();
    }
}
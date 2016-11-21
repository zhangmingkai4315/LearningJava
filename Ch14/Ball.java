package LearningJava.Ch14;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by zhangmingkai on 16/11/21.
 */
public class Ball {
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;

    public void move(Rectangle bounds){
        x+=dx;y+=dy;
        if(x<bounds.getMinX()){
            x= bounds.getMinX();
            dx = -dx;
        }
        if(x+XSIZE>=bounds.getMaxX()){
            x= bounds.getMaxX()-XSIZE;
            dx = -dx;
        }
        if(y<bounds.getMinY()){
            y=bounds.getMinY();
            dy=-dy;
        }
        if(y+YSIZE>=bounds.getMaxY()){
            y=bounds.getMaxY()-YSIZE;
            dy = -dy;
        }

    }
    public Ellipse2D getSharp(){
        return  new Ellipse2D.Double(x,y,XSIZE,YSIZE);
    }

}



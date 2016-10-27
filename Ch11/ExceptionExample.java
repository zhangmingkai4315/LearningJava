package LearningJava.Ch11;

import sun.rmi.runtime.Log;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionExample{
    public static void main(String[] args){

//        double i=-1;
//        assert (i>=0):i;
//        if(i<0){
//            throw new IllegalArgumentException("i<0");
//        }
//        double x = Math.sqrt(i);
//        System.out.println(x);
//        Logger.getGlobal().setLevel(Level.OFF);
//        Logger.getGlobal().setLevel(Level.WARNING);
//        Logger.getGlobal().info("This is a log!");
//        Logger.getGlobal().severe("This is a bad log");
//        Logger.getGlobal().log(Level.WARNING,"Custom Waning Log");
//
//        double i=-1;
//        if(i<0){
//            IllegalArgumentException ex =new IllegalArgumentException("i<0");
//            Logger.getGlobal().throwing("LearningJava.Ch11","main",ex);
//            throw ex;
//        }

        Thread.dumpStack();

        Random generator = new Random(){
            public double nextDouble(){
                double result =super.nextDouble();
                Logger.getGlobal().info("nextDouble: "+result);
                return  result;
            }
        };
        generator.nextDouble();



    }
}
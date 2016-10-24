package LearningJava.Ch6.jsmean;

/**
 * Created by mike on 16-10-24.
 */

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.*;
/**
 * Created by mike on 16-10-24.
 */

public class Employee implements Comparable,Cloneable {
    private String name;
    private double salary;
    private Date hireDate;
    private static int nextId =0;
    private int id=getNextId();
    private static int getNextId(){
        int id=nextId;
        nextId++;
        return id;
    }
    public int compareTo(Object other){
        if(getClass()!=other.getClass()){
            throw new ClassCastException();
        }
        Employee o = (Employee)other;
        return Double.compare(this.salary,o.salary);
    }

    public Employee clone() throws CloneNotSupportedException{
        Employee cloned = (Employee) super.clone();
        cloned.hireDate =(Date) hireDate.clone();
        return  cloned;
    }


    public double getSalary(){
        return salary;
    }
    public String getName(){
        return name;
    }
    public Date getHireDate(){
        return hireDate;
    }
    public String getDescription(){
        return "["+this.getClass().getName()+"] "+this.getName()+", Salary:"+this.getSalary()+", Hireday:"+this.getHireDate().toString();
    }
    public Employee(){
        this.name="Default";
        this.hireDate=new GregorianCalendar(1970,0,1).getTime();
        this.salary=0;
    }
    public Employee(String name,double salary){
        this.name=name;
        this.hireDate=new GregorianCalendar(1970,0,1).getTime();
        this.salary=salary;
    }
    public Employee(String name,double salary,int year,int month,int day){
        this.name = name;
        this.salary = salary;
        this.hireDate =new GregorianCalendar(year,month-1,day).getTime();
    }
}

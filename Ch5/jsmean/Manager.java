package LearningJava.Ch5.jsmean;

/**
 * Created by mike on 16-10-24.
 */

import LearningJava.Ch5.jsmean.Employee;

public class Manager extends Employee {
    private double bonus;
    public void setBonus(double d){
        this.bonus=d;
    }
    public double getSalary(){
        return super.getSalary()+bonus;
    }
    public Manager(String name,double salary){
        super(name,salary);
        this.bonus=0;
    }
    public Manager(String name,double salary,int year,int month,int day) {
        super(name, salary, year, month, day);
        this.bonus = 0;
    }
    public Manager(String name,double salary,int year,int month,int day,double bonus) {
        super(name, salary, year, month, day);
        this.bonus = bonus;
    }
}
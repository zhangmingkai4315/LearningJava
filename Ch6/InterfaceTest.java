package LearningJava.Ch6;

import LearningJava.Ch6.jsmean.Employee;

import javax.annotation.processing.Completion;
import java.util.Arrays;
import java.util.Comparator;
/**
 * Created by mike on 16-10-24.
 */
public class InterfaceTest {

        public static void main(String[] args){
            try {
                System.out.println("Ch6 Examples--->");
                Employee[] staff = new Employee[4];
                staff[0] = new Employee("Mike",2000);
                staff[1] = new Employee("Alice",3000);
                staff[2] = new Employee("Katte", 2500);
                staff[3] = staff[2].clone(); //只有实施了Cloneable接口才能使用该方法，且设置为public访问
                if(staff[0] instanceof Comparable){
                    System.out.println("Employee object is a Comparable Object also.");
                }
                Arrays.sort(staff);
                for(Employee e:staff){
                    System.out.println(e.getDescription());
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }

//[LearningJava.Ch6.jsmean.Employee] Mike, Salary:2000.0, Hireday:Thu Jan 01 00:00:00 CST 1970
//[LearningJava.Ch6.jsmean.Employee] Katte, Salary:2500.0, Hireday:Thu Jan 01 00:00:00 CST 1970
//[LearningJava.Ch6.jsmean.Employee] Alice, Salary:3000.0, Hireday:Thu Jan 01 00:00:00 CST 1970


        }

}

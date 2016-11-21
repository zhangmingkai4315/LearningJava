package LearningJava.Ch13;



import java.util.*;

/**
 * Created by zhangmingkai on 16/10/30.
 */

class Employee{
    private String name;
    public Employee(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name ;
    }
    public String toString(){
        return "This is a employee: "+name;
    }
}

public class DataStructureExamples {
    public static void main(String[] args){
        long tStart = System.currentTimeMillis();
        LinkedList<Employee> ll_number = new LinkedList<Employee>();
        for(int i =0;i<1000000;i++){
            ll_number.add(new Employee("Mike"));
        }
        System.out.printf("The LinkedList size is %d and cost %.2f seconds\n",ll_number.size(),(System.currentTimeMillis()-tStart)/1000.00);

        tStart = System.currentTimeMillis();
        ArrayList<Employee> al_number = new ArrayList<>(1000000);
        for(int i =0;i<1000000;i++){
            al_number.add(new Employee("Mike"));
        }
//        System.out.printf("The LinkedList size is %d and cost %.2f seconds\n",ll_number.size(),(System.currentTimeMillis()-tStart)/1000.00);
//        The LinkedList size is 1000000 and cost 0.23 seconds
//        The LinkedList size is 1000000 and cost 0.09 seconds

//        Collection<String> c_s = new  Collection<String>{"hello","world"};

        Collection<String> cs=new LinkedList<String>();
        cs.add("Hello");
        cs.add("World");
        Iterator<String> is=cs.iterator();

        while(is.hasNext()==true){
            System.out.println(is.next());
        }

        List<String> ls=new LinkedList<>();

        ls.add("Bob");
        ls.add("Carl");
        ls.add("Alice");

        System.out.println(ls.contains("Alice"));
//        ListIterator<String> iterList1=ls.listIterator();
//
//        ListIterator<String> iterList2=ls.listIterator();
//
//        iterList1.remove();
//
//        System.out.println(iterList2.next());  //Exception in thread "main" java.lang.IllegalStateException



    }
}


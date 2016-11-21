package LearningJava.Ch12;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by zhangmingkai on 16/10/28.
 */
public class GenericClassExamples {
    public static void main(String[] agrs){
        String[] words = {"Mike","Alice","Bob","Akk","ddd"};
        Pair<String> mm= ArrayAlg.minmax(words);

        ArrayList<Pair<String>> arrayList = new ArrayList<>(10);
        arrayList.add(mm);
        for(Pair<String> s:arrayList){
            System.out.println(s);
        }

        System.out.println(mm);
        System.out.println(ArrayAlg.<String>getMiddle(words));
        System.out.println(mm.getClass().getName());

        Manager ceo = new Manager("Mike","CEO");
        Manager cfo = new Manager("Alice","CFO");
        Employee e1 = new Employee("Kala");
        Employee e2 = new Employee("Aco");

        Pair<Manager> m = new Pair<>(ceo,cfo);
        Pair<Employee> e = new Pair<>(e1,e2);
        doSomething(m);
        doSomething(e);
        doSomethingSuper(m);
        doSomethingSuper(e);
    }
    static void doSomething(Pair<? extends Employee> t){
        System.out.println(t.getFirst().toString()+"\n"+t.getSecond().toString());
        return;
    }
    static void doSomethingSuper(Pair<? super Manager> t){

        t.setFirst(new Manager("_Alice","NEWCEO"));
        t.setSecond(new Manager("_Mike","NEWCFO"));
        System.out.println(t.getFirst().toString()+"\n"+t.getSecond().toString());
        return;
    }


}



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
class Manager extends Employee{
    private String title;
    public Manager(String name,String title){
        super(name);
        this.title = title;
    }
    public String toString(){
        return "This is a manager: "+title+super.getName();
    }
}

class Pair<T>{
    private T first;
    private T second;
    public Pair(){
        first=null;
        second=null;
    }
    public Pair(T first,T second){
        this.first=first;
        this.second=second;
    }
    public T getFirst(){
        return this.first;
    }
    public T getSecond(){
        return this.second;
    }
    public void setFirst(T first){
        this.first=first;
    }
    public void setSecond(T second){
        this.second=second;
    }
    public String toString(){
        return "The first is "+this.first+"; The second is "+this.second;
    }
}
class ArrayAlg{
//    public static Pair<String> minmax(String[] a){
//        if(a == null ||a.length ==0) return  null;
//        String min = a[0];
//        String max = a[0];
//        for(int i =0 ;i < a.length;i++){
//            if(min.compareTo(a[i])>0) min =a[i];
//            if(max.compareTo(a[i])<0) max =a[i];
//        }
//        return new Pair<String>(min,max);
//    }
    public static <T extends Comparable&Serializable> Pair<T> minmax(T[] a){
        if(a == null ||a.length ==0) return  null;
        T min = a[0];
        T max = a[0];
        for(int i =0 ;i < a.length;i++){
            if(min.compareTo(a[i])>0) min =a[i];
            if(max.compareTo(a[i])<0) max =a[i];
        }
        return new Pair<T>(min,max);
    }

    public static <T> T getMiddle(T ...a){
        if(a.length==0) return null;
        if(a.length%2==0)
        return a[a.length/2];
        else return a[(a.length-1)/2];
    }
}

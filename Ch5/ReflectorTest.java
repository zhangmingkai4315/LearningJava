package LearningJava.Ch5;
/**
 * Created by mike on 16-10-24.
 */
import LearningJava.Ch5.jsmean.Employee;

import java.lang.reflect.*;


public class ReflectorTest {
    public static void printConstructor(Class cl){
        Constructor[] constructors = cl.getDeclaredConstructors();
        for(Constructor c : constructors){
            String name = c.getName();
            System.out.println(" ");
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.print(name + "(");
            Class[] params =c.getParameterTypes();
            for(int j = 0;j<params.length;j++){
                if(j>0) System.out.print(", ");
                System.out.print(params[j].getName());
            }
            System.out.println(");");
        }
    }
    public static void printFields(Class cl){
        Field[] fields = cl.getFields();
        for(Field c : fields){
            String name = c.getName();
            System.out.println(" ");
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.print(name + "(");
            System.out.println(");");
        }
    }
    public static void printMethod(Class cl){
        Method[] methods = cl.getDeclaredMethods();
        for(Method c : methods){
            String name = c.getName();
            System.out.println(" ");
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.print(name + "(");
            Class[] params =c.getParameterTypes();
            for(int j = 0;j<params.length;j++){
                if(j>0) System.out.print(", ");
                System.out.print(params[j].getName());
            }
            System.out.println(");");
        }
    }

    public static Object goodCopy(Object o,int newLength){
        Class cl = o.getClass();
        if(!cl.isArray()){
            return  null;
        }
        Class componentType =cl.getComponentType();
        int len = Array.getLength(o);
        Object newArray = Array.newInstance(componentType,newLength);
        System.arraycopy(o,0,newArray,0,Math.min(len,newLength));
        return newArray;
    }

    public static void main(String[] args){
        try {
            Employee e = new Employee("Mike",20000,1990,1,1);
            Class cl = e.getClass();
            Field name = cl.getDeclaredField("name");  //如果为private 则无法访问．
            name.setAccessible(true);
            Object v = name.get(e);
            System.out.println(v.toString());

            Employee[] eAarry={new Employee("Mike",20000,1990,1,1),new Employee("Mike2",30000,1990,1,1)};
//            Employee[] eXArray=(Employee[]) goodCopy(eAarry,100);
//            System.out.println(eXArray.length);
//            for(Employee x:eXArray){
//                x.getDescription();　　//这里如果是null则抛出异常
//            }

//          //动态的改变数组的长度
            int[] iList ={1,2,3,4,5};
            int[] exList =(int[])goodCopy(iList,1000);
            for(int x:exList){
                System.out.println(x);
            }
            Method m1 = Employee.class.getMethod("getName");
            String nameInvoke = (String)m1.invoke(e);
            System.out.println(nameInvoke);
        }catch (Exception ex){
            ex.printStackTrace();
        }




//        String name;
//        if(args.length>0) name =args[0];
//        else{
//            Scanner in = new Scanner(System.in);
//            System.out.println("Please enter the class name :");
//            name = in.next();
//        }
//        try {
//
//
//            Class cl = Class.forName(name);
//            Class superCl = cl.getSuperclass();
//            String modifiers = Modifier.toString(cl.getModifiers());
//            if(modifiers.length()>0){
//                System.out.println(modifiers+" ");
//            }
//            if(superCl !=null && superCl!=Object.class) {
//                System.out.println("Class "+name+" extends "+ superCl.getName());
//            }
//            printConstructor(cl);
//            printMethod(cl);
//            printFields(cl);
//        }catch (Exception eX){
//            eX.printStackTrace();
//        }

    }
}

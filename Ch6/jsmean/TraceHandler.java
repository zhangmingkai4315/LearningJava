package LearningJava.Ch6.jsmean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by mike on 16-10-24.
 */
public class TraceHandler implements InvocationHandler {
    private Object target;
    public TraceHandler(Object t){
        target = t ;
    }
    public Object invoke(Object proxy, Method m,Object[] args) throws Throwable{
        System.out.print(target);
        System.out.print("."+m.getName()+"(");
        if(args != null){
            for(int i =0;i<args.length;i++){
                System.out.print(args[i]);
                if(i<args.length-1) System.out.print(", ");
            }
        }
        System.out.println(")");
        return  m.invoke(target,args);
    }
}

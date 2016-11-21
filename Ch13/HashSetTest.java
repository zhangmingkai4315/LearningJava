package LearningJava.Ch13;
import java.util.*;
/**
 * Created by zhangmingkai on 16/11/13.
 */
public class HashSetTest {

    public static void main(String[] args){
        Set<String> words = new HashSet<>();
        Scanner in = new Scanner(System.in);
        long totalTime = 0;
        while (in.hasNext()){
            String word = in.next();
            long callTime = System.currentTimeMillis();
            words.add(word);
            callTime = System.currentTimeMillis()-callTime;
            totalTime+=callTime;
        }
        Iterator<String> iter = words.iterator();
        for (int i =0 ;i<20 &&iter.hasNext();i++){
            System.out.print(iter.next());
        }
        System.out.println("...");
        System.out.println(words.size()+" distrinct words" + totalTime+" milliseconds");

    }
}

package LearningJava.Ch13;

import java.util.*;

/**
 * Created by zhangmingkai on 16/11/13.
 */
public class TreeSetTest {

    public static void main(String[] args){


        Set<String> words = new TreeSet<>(new Comparator<String>() {
            public int compare(String a,String b){
                if(a.length()==b.length()) return 0;
                return a.length()>b.length()?1:-1;
            }
        });
        words.add("BLIc");
        words.add("D");
        words.add("ALI");
        for(String i: words){
            System.out.println(i);
        }
    }
}

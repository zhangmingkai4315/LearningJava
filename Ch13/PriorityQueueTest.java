package LearningJava.Ch13;

import java.util.*;

/**
 * Created by zhangmingkai on 16/11/13.
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<GregorianCalendar> sq = new PriorityQueue<>();
        sq.add(new GregorianCalendar(1908,Calendar.MARCH,9));
        sq.add(new GregorianCalendar(1948,Calendar.MARCH,9));
        sq.add(new GregorianCalendar(1938,Calendar.MARCH,9));

        for(GregorianCalendar g:sq){
            System.out.println(g.toString());
        }
    }
}

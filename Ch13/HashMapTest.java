package LearningJava.Ch13;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangmingkai on 16/11/15.
 */

enum Weekday {MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY};
public class HashMapTest {
    public static void main(String[] args){
        HashMap<String,Employee> hashMap = new HashMap<>();
        hashMap.put("123",new Employee("Mike"));
        hashMap.put("1234",new Employee("Mike2"));
        System.out.println(hashMap.size());
        Set<String> keys = hashMap.keySet();
        for(String s : keys){
            System.out.println(s);
        }

        for(Map.Entry<String,Employee> entry: hashMap.entrySet()){
            System.out.printf("Key : %s, Value= %s\n",entry.getKey(),entry.getValue());
        }
        EnumSet<Weekday> always = EnumSet.allOf(Weekday.class);
        EnumSet<Weekday> never = EnumSet.ran





    }
}

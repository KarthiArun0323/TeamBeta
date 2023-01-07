package collectionexercises;

import java.util.HashMap;
import java.util.Map;

public class MapExercise {
    public static void main(String[] args) {
        HashMap<Integer,String>hashMap=new HashMap<>();

        hashMap.put(03,"arun");
        hashMap.put(23,"karthi");
        hashMap.put(10,"amuthan");

        System.out.println(hashMap);

        for(Map.Entry<Integer,String> entry:hashMap.entrySet()){
            System.out.println(entry);
        }
    }
}

package collectionexercises;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetExercise {
    public static void main(String[] args) {

        Set<String> name=new LinkedHashSet<String>();
        name.add("arun");
        name.add("arun");
        name.add("karthi");
        for (String names : name){
            System.out.println(names);
        }
    }
}

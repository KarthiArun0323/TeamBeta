package collectionexercises;

import java.util.*;

public class ListExercise {
    public static void main(String[] args) {

        //1.declare arraylist
        ArrayList<Integer> num = new ArrayList<Integer>();
        ArrayList<String> lable = new ArrayList<String>();

        //add elements to arraylist
        num.add(56);
        num.add(78);
        num.add(90);
        lable.add("arun");
        lable.add("arun");
        lable.add("karthi");
        lable.add("amuthan");

        //read values from arraylist
        for (int n : num) {
            System.out.println(n);
        }
        for (String l : lable){
            System.out.println(l);
        }

       ArrayList m= new ArrayList();
       m.add("karun");
       m.add(323);
       for(Object obj: m){
           System.out.println(obj);
       }


    }
}

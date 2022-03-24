package Java_Extend.Java_Collections.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Set_Syntax {
    public static void main(String[] args) {

        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        hashSet.add("Nataly");
        hashSet.add("Kostya");
        hashSet.add("Nikolai");
        hashSet.add("Roman");
        hashSet.add("Iosif");

        for (String name: hashSet){
            System.out.println(name);
        }
        System.out.println();



        linkedHashSet.add("Nataly");
        linkedHashSet.add("Kostya");
        linkedHashSet.add("Nikolai");
        linkedHashSet.add("Roman");
        linkedHashSet.add("Iosif");

        for (String name: linkedHashSet){
            System.out.println(name);
        }
        System.out.println();




        treeSet.add("Nataly");
        treeSet.add("Kostya");
        treeSet.add("Nikolai");
        treeSet.add("Roman");
        treeSet.add("Iosif");

        for (String name: treeSet){
            System.out.println(name);
        }
        System.out.println();






    }





}

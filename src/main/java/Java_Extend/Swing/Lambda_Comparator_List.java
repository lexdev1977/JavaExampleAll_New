package Java_Extend.Swing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda_Comparator_List {
    public static void main(String[] args) {

        List<String> list01 = new ArrayList<>();

        Collections.addAll(list01, "Alex", "Annabel", "Jo", "Izi");

//        list01.sort(new Comparator<String>() {
//            @Override
//            public int compare( String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });

        list01.sort((s1, s2) -> s1.length() - s2.length());

//        list01.sort(Comparator.comparingInt(String::length));

        System.out.println(list01);




    }

}

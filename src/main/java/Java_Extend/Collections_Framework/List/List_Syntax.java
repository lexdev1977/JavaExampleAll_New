package Java_Extend.Collections_Framework.List;

import java.util.ArrayList;
import java.util.List;

public class List_Syntax {
    public static void main(String[] args) {

//      передача из List в ArrayList

        List<String> lis01 = List.of("1", "2", "4");
        List<String> arrList01 = new ArrayList<>(lis01);
        System.out.println(arrList01);


    }
}

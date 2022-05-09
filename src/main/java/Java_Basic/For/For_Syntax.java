package Java_Basic.For;

import java.util.ArrayList;
import java.util.List;

public class For_Syntax {
    public static void main(String[] args) {

//                             *** For Each ***

        List<String> textList = new ArrayList<>();
        textList.add("Text01");
        textList.add("Text02");
        textList.add("Text03");

//      первый вариант исполнения:
        for (
                String text : textList) {
            System.out.println(text);
        }

//      второй вариант исполнения:
        textList.forEach(n -> {
            System.out.println(n);
        });

    }







}

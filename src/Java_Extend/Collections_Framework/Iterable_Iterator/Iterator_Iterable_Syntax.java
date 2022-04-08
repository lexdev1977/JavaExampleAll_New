package Java_Extend.Collections_Framework.Iterable_Iterator;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Iterator_Iterable_Syntax {
    public static void main(String[] args) {


        //    Реализация Iterator

        TreeSet<String> set = new TreeSet<String>();
        Collections.addAll(set,"Первый", "Второй", "Третий", "Четвертый"); // сортирует по алфавиту

        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext())
        {
            String item = iterator.next();
            System.out.println(item);
        }

        System.out.println();

//        Реализация итератора, где был удален второй элемент

        LinkedList<String> linkedList01 = new LinkedList<>();

        linkedList01.add("Элемент 01");
        linkedList01.add("Элемент 02");
        linkedList01.add("Элемент 03");
        linkedList01.add("Элемент 04");
        linkedList01.add("Элемент 05");

        Iterator<String> iterator01 = linkedList01.iterator();
        int index = 0;
        while (iterator01.hasNext()){
            System.out.println(iterator01.next());  // сначала мы получаем элемент
            if (index == 1){                        // а потом удаляем если выполнено условие
                iterator01.remove();
                System.out.println("удаления элемента под индексом 1: (Элемент 02)");
            }
            index++;
        }
        System.out.println("после итерации и удаления элемента под индексом 1: " + linkedList01);



    }






}

package Java_Extend.Java_Collections.Set;

import java.util.*;

public class Set_Syntax {
    public static void main(String[] args) {


//      создание объектов множества Set

//      HashSet - не дает никаких гарантий относительно последовательности элементов при их итерации
        Set<String> hashSet = new HashSet<>();

//      LinkedHashSet - гарантирует, что порядок элементов во время итерации
//      совпадает с порядком их вставки в LinkedHashSet.
//      Повторная вставка элемента, который уже находится в LinkedHashSet, не меняет этот порядок.
        Set<String> linkedHashSet = new LinkedHashSet<>();

//      TreeSet - также гарантирует порядок элементов при повторении,
//      но он является порядком сортировки элементов.
//      Другими словами, порядок, в котором элементы должны быть отсортированы,
//      если вы использовали Collections.sort() для List или массива, содержащего эти элементы.
//      Этот порядок определяется либо их естественным порядком(если они реализуют Comparable),
//      либо конкретной реализацией Comparator.
        Set<String> treeSet = new TreeSet<>();

//      добавление элементов в множество метод .add

        hashSet.add("Nataly");
        hashSet.add("Kostya");
        hashSet.add("Nikolai");
        hashSet.add("Roman");
        hashSet.add("Iosif");
        hashSet.add("Iosif"); // при добавлении элемента с одинаковым именем, он просто игнорируется

        linkedHashSet.add("Nataly");
        linkedHashSet.add("Kostya");
        linkedHashSet.add("Nikolai");
        linkedHashSet.add("Roman");
        linkedHashSet.add("Iosif");

        treeSet.add("Nataly");
        treeSet.add("Kostya");
        treeSet.add("Nikolai");
        treeSet.add("Roman");
        treeSet.add("Iosif");

//      с помощью foreach  - перебор элементов набора

        for (String name: hashSet){
            System.out.println(name);
        }
        System.out.println();


        for (String name: linkedHashSet){
            System.out.println(name);
        }
        System.out.println();


        for (String name: treeSet){
            System.out.println(name);
        }
        System.out.println();

//      .contains - этот метод проверяет, содержит ли Set данный элемент (объект)
//       в set этот метод работает очень быстро, так как используется хеширование

        System.out.println("Содержит или нет объект Nataly - " + hashSet.contains("Nataly"));
        System.out.println("Содержит или нет объект Alex - " + hashSet.contains("Alex"));
        System.out.println();

//      .isEmpty - проверка пустой ли Set или нет
        System.out.println("Пустой или нет - " + hashSet.isEmpty());
        System.out.println();

//        .toString переопределен
        System.out.println("При вызове toString, выводит вот в таком виде - " + hashSet + "\n");

//       узнать разиер множества
        System.out.println("Размер - " + hashSet.size() + "\n");



//      Операции со множествами
        Set<Integer> set01 = new HashSet<>();
        Set<Integer> set02 = new HashSet<>();

        set01.add(1);   set02.add(4);
        set01.add(2);   set02.add(5);
        set01.add(3);   set02.add(6);
        set01.add(4);   set02.add(7);
        set01.add(5);   set02.add(8);

//        в конструктор можно передавать уже готовые множества
        Set <Integer> union = new HashSet<>(set01);
        Set <Integer> intersection = new HashSet<>(set01);
        Set <Integer> difference = new HashSet<>(set01);


//        union - объединение множеств (1,2,3) (2,3,4) = (1,2,3,4)

        System.out.println("Объединение union и set02: " + union +set02);
        union.addAll(set02);
        System.out.println("Результат: " + union +"\n");


//        intersection - пересечение множеств (1,2,3) (2,3,4) = (2,3)

        System.out.println("Пересечение intersection и set02: " + intersection +set02);
        intersection.retainAll(set02);
        System.out.println("Результат: " + intersection + "\n");


//        difference - разность множеств (1,2,3) (2,3,4) = (1)

        System.out.println("Разность difference и set02: " + difference +set02);
        difference.removeAll(set02);
        System.out.println("Результат: " + difference + "\n");


//        Как конвертировать в список
        Set setTest = new HashSet();
        setTest.add("Первый элемент");
        setTest.add("Второй элемент");
        List listTest = new ArrayList();
        listTest.addAll(setTest);
        System.out.println("Множество передали в список - " + listTest);










    }



}

package Java_Extend.Java_Collections.Map;

import java.util.*;

public class Map_Syntax {
    public static void main(String[] args) {


//                                   Общие принципы работы Map


//      HashMap - не созраняет порядок, LinkedHashMap - сохраняет порядок TreeHashMap - сортирует по ключу

        Map<Integer, String> hashmap01 = new HashMap<>(); // не сохраняется порядок добавления

        Map<Integer, String> linkedHashMap01 = new LinkedHashMap<>(); // сохраняется порядок добавления

        Map<Integer, String> treeMap01 = new TreeMap<>(); // сортировка по ключу (ествественный порядок)


//      Медот .testMap реализован в конце класса

        System.out.println("Hash");
        testMap(hashmap01);
        System.out.println();

        System.out.println("Linked");
        testMap(linkedHashMap01);
        System.out.println();

        System.out.println("Tree");
        testMap(treeMap01);
        System.out.println();



//                             Подробное рассмотрение на примере HashMap

//              главной особеностью HashMap - является то, что в нем не сохраняется порядок добавления
//              создание структуры данных Map HashMap
        Map<Integer, String> map01 = new HashMap<>();
        map01.put(1, "Один");
        map01.put(2, "Два");
        map01.put(3, "Пока еще не знаем");
        map01.put(4, "Какая то ерунда");


//              метод toString переопределен
        System.out.println(map01);
        System.out.println();


//              переписываем значение ключа три, т.к. невозможно хнанить два одинаковык ключа
        map01.put(3, "Упс все еще не знаем");
        System.out.println(map01);
        System.out.println();


//              Доступ к значениям в HashMap осуществляется по ключу, получить значение метод - .get
        System.out.println(map01.get(1));
        System.out.println(map01.get(10)); // вернется null если такого ключа нет
        System.out.println();


//              Удаление пары метод .remove
        map01.remove(4);
        System.out.println(map01);
        System.out.println();


//              Проверка наличия ключа и значения
        System.out.println(map01.containsKey(6));
        System.out.println(map01.containsValue("Два"));
        System.out.println();


//              Получение списка всех ключей и значений  .keySet   и   .values
        Set<Integer> keys = map01.keySet();    // Set (колекция) еще не проходил
        System.out.println("Ключи: " + keys);

        ArrayList<String> values = new ArrayList<>(map01.values());
        System.out.println("Значения: " + values);
        System.out.println(values.get(1));

        System.out.println(map01.keySet());
        System.out.println(map01.values());
        System.out.println();


//              проходимся по циклу, данные хранятся как пара Entry
        /*
                Интерфейс Map.Entry обозначает как раз пару “ключ-значение” внутри словаря.
                Метод entrySet() возвращает список всех пар в нашей HashMap
                (поскольку наша мапа состоит как раз из таких пар-Entry,
                то мы перебираем именно пары, а не отдельно ключи или значения).
         */

        for (Map.Entry<Integer, String> entry : map01.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        for (Map.Entry<Integer, String> entry : map01.entrySet()) {
            System.out.println(entry);
        }


        System.out.println();


//              Методы size() возвращает число элементов в словаре на текущий момент и clear() удаляет все элементы
        System.out.println("Размер нашего Мепа - " + map01.size());
//        map01.clear();                        // закоментируем чтоб не очищать
//        System.out.println(map01);
        System.out.println();


//              Для проверки того, есть ли в нашей HashMap хотя бы один элемент метод isEmpty()
        if (!map01.isEmpty()) {
            System.out.println("Мы проверили у нас есть элементы, содержимое - " + map01);

        }
        System.out.println();


//        Объединение двух мап в одну  nameMap01.putAll(nameMap02)

        Map<Integer, String> map02 = new HashMap<>();
        map02.put(3, "Три");
        map02.put(4, "Четыре");
        map02.put(5, "Пять");
        map02.put(6, "Шесть");

        map01.putAll(map02);
        System.out.println(map01);
        System.out.println();


//        Конвертация  Map в List

        Map <Integer, String> map05 = new HashMap<>();
        map05.put(1, "apple");
        map05.put(2, "aprocot");
        map05.put(3, "berry");

//      Передаем в ArrayList только значение ключа:
//      .keySet() - возвращает множество(Set) ключей;
        List <Integer> indexMap05 = new ArrayList<>(map05.keySet());

//      Передаем в ArrayList только коллекцию(Collection) значений:
//      .values() - возвращает коллекцию(Collection) значений;
        List <String> valueMap05 = new ArrayList<>(map05.values());

//      Передаем в ArrayList множество(Set) наборов “ключ-значение:
//      .entrySet() — возвращает множество(Set) наборов “ключ-значение”
        List <Map.Entry<Integer, String>> entryMap05 = new ArrayList<>(map05.entrySet());

        System.out.println("Передаем в ArrayList только значение ключа:");
        System.out.println(indexMap05);
        System.out.println("Передаем в ArrayList только коллекцию(Collection) значений:");
        System.out.println(valueMap05);
        System.out.println("Передаем в ArrayList множество(Set) наборов “ключ-значение:");
        System.out.println(entryMap05);

    }




//    создаем универсальный метод по добавлению элементов для всех видов Map

    public static void testMap(Map<Integer, String> testMap) {
        testMap.put(12, "Sharlot");
        testMap.put(20, "Anabell");
        testMap.put(15, "Basted");
        testMap.put(10, "Rika");
        testMap.put(1, "Linda");
        testMap.put(5, "Michele");

        for (Map.Entry<Integer, String> entry : testMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }


    }
}
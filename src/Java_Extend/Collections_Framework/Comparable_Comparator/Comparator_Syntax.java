package Java_Extend.Collections_Framework.Comparable_Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator_Syntax {
    public static void main(String[] args) {


//                                      ***Примеры Comparator***
//        - используется для упорядочивания объектов внутри определенного пользователем класса


//                               *Сортировка согласно естественного порядка

        List<String> animal = new ArrayList<>();

        Collections.addAll(animal, "Dog", "Cat", "Fox","Tiger","Hedgehog");

        Collections.sort(animal);
        System.out.println("Сортировка согласно естественного порядка - " + animal + "\n");





//        *Сортировка с использованием Comparator реализованного в отдельных классах NumbersSort и AnimalSorLength

        List<Integer> nubmers = new ArrayList<>();
        Collections.addAll(nubmers, 12,100,300,15,1000,1);

        Collections.sort(nubmers, new NumbersSort());
        System.out.println("Сортировка с использованием Comparator в обратном порядке - " + nubmers + "\n");

        Collections.sort(animal, new AnimalSorLength());
        System.out.println("Сортировка с использованием Comparator по длине слов - " + animal + "\n");





//                     *Вариант написания с анонимным классом (если мы не хотим создавать новый класс)
//                             !!! после прохождения Лямбда выражений, можно сократить

//      Создаем лист people объектов класса Person

        List<Person> people = new ArrayList<>();
        people.add(new Person(11, "Kat"));
        people.add(new Person(10, "Alex"));
        people.add(new Person(9, "Igor"));




        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getId() - o2.getId();

//      другая реализация переопределения по той же логике сортировки

//                if (o1.getId() >o2.getId()){
//                    return 1;
//                } else if (o1.getId()<o2.getId()){
//                    return -1;
//                } else return 0;
            }

        });


        System.out.print("Сортирока с использованием анонимного класса - " + people);



    }



//                              Создание класса Person с набором полей и метода .printPerson

    static class Person{
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void printPerson() {
            System.out.print(id + ": " + name + ",  ");
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

//                     Создание класса для сортировки с переопределенным методом из Comparator (на уменьшение)

    static class NumbersSort implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2){
                return -1;
            }else if (o1 < o2){
                return 1;
            }else return 0;
        }
    }

//                 Создание класса для сортировки с переопределенным методом из Comparator (по длине слова)

    static class AnimalSorLength implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            if (o1.length() > o2.length()){
                return 1;
            }else if (o1.length() < o2.length()){
                return -1;
            }else return 0;
        }
    }

//    }


}

package Java_Extend.Java_Collections.Comparable_Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator_Syntax {
    public static void main(String[] args) {


//      Создаем лист people объектов класса Person

        List<Person> people = new ArrayList<>();
        people.add(new Person(11, "Kat"));
        people.add(new Person(10, "Alex"));
        people.add(new Person(9, "Igor"));


//      Вызываем метод sort вспомогательного класса Collections
//      поместив туда наш лист people и анонимный класс с реализацией Comparator и переопределением compare

        Collections.sort(people, new Comparator<Person>() {  // после прохождения Лямбда выражений, можно сократить
            @Override

//      переопределение метода compare, возвращающий разность между ID двух объектов
            public int compare(Person o1, Person o2) {
                return o1.getId() - o2.getId();

//      другая реализация переопределения
//                if (o1.getId() >o2.getId()){
//                    return 1;
//                } else if (o1.getId()<o2.getId()){
//                    return -1;
//                } else return 0;
            }

        });

//      метод .printPerson создан для вывода информации об объекте
        people.get(0).printPerson();
        people.get(1).printPerson();
        people.get(2).printPerson();

        int i =0;
        for (Person pep: people){
            people.get(i++).printPerson();

        }


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
            System.out.println(id + " : " + name);
        }


    }



}

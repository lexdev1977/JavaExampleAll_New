package Java_Extend.Collections_Framework.Comparable_Comparator;

import java.util.*;

public class Comparable_Syntax {
    public static void main(String[] args) {

//                                   ***Интерфейс Comparable***
//    - интерфейс используется для сортировки объектов, с естественным упорядочением.
//    Чтобы наши объекты можно было сравнивать друг с другом и как-то сортировать,
//    класс должен имплементировать этот интерфейс и реализовать его единственный метод — compareTo():


//      создаем две коллекции класса - PersonCompar
        List<PersonCompar> peopleList = new ArrayList<>();
        Set<PersonCompar> peopleSet = new TreeSet<>();

//      добавляем в них элементы через метод - addElement
        addElement(peopleList);
        addElement(peopleSet);

//      вывод без сортировки
        System.out.println("\n" + "не сортированный List - " + peopleList + "\n");

//      проводим сортировку
        Collections.sort(peopleList);  // поместить Set в данную сортировку нельзя и бессмысленно
        System.out.println("сортированный List - " + peopleList + "\n");
        System.out.println("Set сразу требует реализации сортировки - " + peopleSet + "\n");


    }


//    метод для добавления объектов в наши колекции
    private static void addElement(Collection coll) {
        coll.add(new PersonCompar(4, "Mary"));
        coll.add(new PersonCompar(1, "Alex"));
        coll.add(new PersonCompar(3, "Igor"));
        coll.add(new PersonCompar(2, "Kat"));

    }


//                         *Создаем класс PersonCompar и имплиментируем интерфейс Comparable

    static class PersonCompar implements Comparable<PersonCompar> {
        private int id;
        private String name;

        public PersonCompar(int id, String name) {
            this.id = id;
            this.name = name;
        }


        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PersonCompar that = (PersonCompar) o;
            return id == that.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }


//      переопределяем метод для реализации своей сортировки
        @Override
        public int compareTo(PersonCompar o) {
            if (this.id > o.id) {
                return 1;
            } else if (this.id < o.id) {
                return -1;
            } else return 0;
        }

    }
}






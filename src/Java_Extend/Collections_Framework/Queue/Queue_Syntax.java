package Java_Extend.Collections_Framework.Queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Queue_Syntax {
    public static void main(String[] args) {


//      Простой пример очереди, добавляем через интерфейс Queue объекты в LinkedList
        Queue<Person> people = new LinkedList<>();

        Person person01 = new Person(1);
        Person person02 = new Person(2);
        Person person03 = new Person(3);
        Person person04 = new Person(4);
        Person person05 = new Person(5);

        people.add(person03);
        people.add(person02);
        people.add(person04);
        people.add(person01);

        for (Person person : people) {
            System.out.println(person);
        }

//      Создаем очередь с ограничением по количеству элементов
        Queue<Person> people02 = new ArrayBlockingQueue<>(3);

        try {
            people02.add(person02);
            people02.add(person01);
            people02.add(person03);
            people02.add(person04);

        } catch (IllegalStateException e) {
            System.out.println("\nПри добавлении объекта через add в очередь с ограничением," +
                    "которая уже полна выскочит исключение - IllegalStateException");
        }

        System.out.println("четвертый элемент не был добавлен, результат:" + people02);

        Queue<Person> people03 = new ArrayBlockingQueue<>(3);

        System.out.println("\nПри добавлении объекта через offer в очередь с ограничением," +
                "не добавленные объекты возращают false:");

        System.out.println(people03.offer(person02));
        System.out.println(people03.offer(person01));
        System.out.println(people03.offer(person03));
        System.out.println(people03.offer(person04));


//         в данном примере PriorityQueue - сортирует очередь в алфавитном порядке,
//         так как в String указана естественная сортировка

        Queue<String> queue = new PriorityQueue<String>();

        System.out.println("\nPriorityQueue - сортирует очередь (в данном примере по алфавиту): ");

        queue.offer("One");
        queue.offer("Two");
        queue.offer("Three");
        queue.offer("Four");
        queue.offer("Five");

        String current;

        while ((current = queue.poll()) != null) {
            System.out.println(current);
        }


//      В данном примере сортировка производится согласно Comparable заданного в классе Person
//      в конкретном случае по ID на увеличение
//      !!! важно иметь ввиду, что сортировка идет только для первого элемента,
//      остальные будут сортироваться по мере продвижения их к началу очереди, для ускорения процессов.

        Queue<Person> peopleSort = new PriorityQueue<>();

        peopleSort.offer(person02);
        peopleSort.offer(person03);
        peopleSort.offer(person04);
        peopleSort.offer(person05);
        peopleSort.offer(person01);

        System.out.println("\nСейчас 5 элементов в очереди, первый сортирован:");
        for (Person person : peopleSort) {
            System.out.println(person);
        }

        peopleSort.remove();


        System.out.println("\nУдалили один элемент Сейчас 4 элемента в очереди, первый сортирован:");

        for (Person person : peopleSort) {
            System.out.println(person);
        }

        peopleSort.remove(person05); // удаляет конкретный объект в очереди

        System.out.println("\nУдалили объект person5 Сейчас 3 элемента в очереди, первый сортирован:");

        for (Person person : peopleSort) {
            System.out.println(person);
        }

        peopleSort.remove();

        System.out.println("\nУдалили  еще один элемент Сейчас 2 элемента в очереди, первый сортирован:");

        for (Person person : peopleSort) {
            System.out.println(person);
        }



    }

//                     Класс Person созданный с установкой естественной сортировки

    static class Person implements Comparable<Person>{

        private int id;

        public Person(int id) {
            this.id = id;
        }


        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    '}';
        }

        public int getId() {
            return id;
        }

        @Override
        public int compareTo(Person o) {
            return this.id - o.id;

        }

    }
}



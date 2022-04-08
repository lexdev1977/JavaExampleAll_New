package Java_Extend.Collections_Framework.Queue;

public class Queue_General {
    /*

    *** Queue - очередь ***


     Очередью в Java считается все, что наследует интерфейс Queue,
     который в свою очередь расширяет Collection.
     Это значит, что с очередями можно работать, как с коллекциями.

     Queue (очередь) - это подинтерфейс of Collection, поэтому она обладает всеми функциями of Collection.
     В нем есть методы для доступа к первому элементу или его удаления,
     а также методы для вставки элемента в очередь. Если вы хотите получить доступ к определенному элементу,
     вы должны удалить все предшествующие ему элементы из очереди.

     Queue - это Collection, которая позволяет дублировать элементы, но не элементы null.

     Распространенный пример - очередь в баре. В то время как обслуживается только первый человек в очереди,
     новый человек будет вставлен где-то в очередь. Это может быть не последняя позиция,
     в зависимости от типа очереди и приоритета нового человека.


    Очереди в Java работают по двум принципам: FIFO и LIFO.

    FIFO — First In First Out, принцип обычной очереди (конечно, если нет тех, кому нужно “только спросить”),
    в котором первый элемент попадает в очередь и первым выходит из нее.

    LIFO — Last In First Out, принцип стека, в котором последний элемент, добавленный в очередь,
    первым выйдет из нее. Например, как с колодой карт:
    ты будешь брать все карты с верха по одной, чтобы дойти до конца.




    Иерархия Queue в Java выглядит следующим образом:


                                      (i) Iterable
                                            |
                                     (i) Collection
                                            |
                                        (i) Queue
                                            |          \
                                        (i) Deque     PriorityQueue (class)
                                       /         \
                                  LinkedList   ArrayDeque
                                   (class)      (class)


    Здесь видно, что у Queue есть 3 класса реализации: LinkedList, ArrayDeque и PriorityQueue.
    LinkedList и ArrayDeque наследует напрямую не от Queue, а от Deque.




    Deque — это интерфейс, который добавили в 6 версии Java.
    Он включает в себя ряд полезных для очередей методов
    и дает возможность очереди функционировать как двунаправленная очередь.
    То есть работать по принципу FIFO или LIFO.

    Одним из двух наследников Deque является ArrayDeque. Он поддерживает двустороннюю структуру данных очереди,
    что дает возможность вставлять и удалять элементы с обеих сторон.
    Также он — динамический массив, который может автоматически увеличивать свой размер.


                                ***Интерфейс Deque

    Интерфейс Deque появился в Java 6.
    Он расширяет Queue и описывает поведение двунаправленной очереди.
    Двунаправленная очередь может функционировать как стандартная очередь FIFO либо как стек LIFO.

    Методы интерфейса Deque:
    - void addFirst(Е obj)	Добавляет элемент obj в начало очереди
    - void addLast(Е obj)	Добавляет элемент obj в конец очереди
    - Е getFirst()	Возвращает первый элемент из очереди
    - Е getLast()	Возвращает последний элемент из очереди
    - boolean offerFirst(Е obj)	Добавляет элемент obj в начало очереди,
    и возвращает true если элемент добавлен, в противном случае вернет false
    - boolean offerLast(E obj)	Добавляет элемент obj в конец очереди,
    и возвращает true если элемент добавлен, в противном случае вернет false
    - Е рор()	Вытаскивает первый элемент из очереди и удаляет его
    - void push(Е obj)	Добавляет элемент obj в начало очереди
    - Е peekFirst()	Возвращает (но не удаляет) первый элемент из очереди
    - Е peekLast()	Возвращает (но не удаляет) последний элемент из очереди
    - Е pollFirst()	Возвращает и удаляет первый элемент из очереди, вернет null, если нет элементов
    - Е pollLast()	Возвращает и удаляет последний элемент из очереди, вернет null, если нет элементов
    - Е removeLast()	Возвращает и удаляет первый элемент очереди, создаст исключение, если нет элементов
    - Е removeFirst()	Возвращает и удаляет последний элемент очереди, создаст исключение, если нет элементов
    - boolean removeFirstOccurrence(Object obj)	Удаляет первое вхождение obj из очереди
    - boolean removeLastOccurrence(Object obj)	Удаляет последнее вхождение obj из очереди



    Есть еще класс PriorityQueue, прямой наследник Queue: принцип его работы отличается от наследников Dequeue.

    PriorityQueue — это очередь с приоритетом,
    которая по умолчанию размещает элементы согласно естественному порядку сортировки.
    Для сортировки здесь используется Comparable и Comparator.
    Принцип здесь такой же, как и с TreeSet или TreeMap — классов,
    которые следуют интерфейсу Comparable и имеют свой порядок сортировки.

            PriorityQueue<String> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(String::length));

            priorityQueue.add("Andrew");
            priorityQueue.add("John");
            priorityQueue.add("Rob");

            while (!priorityQueue.isEmpty()) {
               System.out.println(priorityQueue.remove());
            }


    Запустив этот пример в консоли, ты получишь:

        Rob
        John
        Andrew
    Так как мы работаем с очередями, а не обычными коллекциями,
    мы должны удалить элемент из списка. Используем эту конструкцию:

        while (!priorityQueue.isEmpty()) {
             System.out.println(priorityQueue.remove());
        }


                                    *** Методы Queue

    Кроме методов, унаследованных от Collection, Queue также имеет свои собственные методы:

        boolean add(E e);
        boolean offer(E e);

        E remove();
        E poll();

        E element();
        E peek();


                     Throws exception	    Returns special value
        Insert	     boolean add(E)	        boolean offer(E)
        Remove	     E remove()	            E poll()
        Examine	     E element()	        E peek()


                            * boolean add(E)* / boolean offer(E)

    - boolean add(E)	Вставляет элемент в Queue. Если больше нет места для вставки,
    этот метод создает исключение. Метод возвращает true, если вставка выполнена успешно.

    - boolean offer(E)	Вставляет элемент в Queue.
    Если в Queue больше нет пустого места или вставить не удалось, метод возвращает false.

    Когда элемент вставляется в Queue, его положение определяется типом Queue и приоритетом элемента.
    Вы не можете указать его положение.

    В зависимости от типа используемого Queue он может ограничивать количество элементов
    или автоматически увеличивать их размер.


                                * E remove()* / E poll()

    - E remove()	Возвращает первый элемент Queue и удаляет его из Queue.
    Этот метод создает исключение, если в Queue нет элементов.

    - E poll()	Возвращает первый элемент Queue и удаляет его из Queue.
    Этот метод возвращает null, если в Queue нет элементов.


                                * E element() * / E peek()

    - E element()	Возвращает первый элемент Queue, но не удаляет его из Queue.
    Этот метод создает исключение, если в Queue нет элементов.
    - E peek()	Возвращает первый элемент Queue, но не удаляет его из Queue.
    Этот метод возвращает null, если в Queue нет элементов.



    Примеры:

    LinkedList представляет собой традиционную очередь.
    Метод add/offer добавляют элемент в хвост этой очереди.

                                                                                                                   *//**
        LinkedListEx1.java

        package org.o7planning.queue.ex;

        import java.util.LinkedList;
        import java.util.Queue;

        public class LinkedListEx1 {

            public static void main(String[] args) {
            // Create Queue
            Queue<String> queue = new LinkedList<String>();

            queue.offer("One");
            queue.offer("Two");
            queue.offer("Three");
            queue.offer("Four");
            queue.offer("Five");

            String current;

                while((current = queue.poll())!= null) {
                        System.out.println(current);
                }
            }
         }

    На консоле:

        One
        Two
        Three
        Four
        Five

                                                                                                                    *//*
        * PriorityQueue

    PriorityQueue - это Queue, которая может автоматически сортировать элементы по их приоритетному порядку
    или по предоставленному Comparator. Это означает, что элемент, вставленный в PriorityQueue,
    может находиться не в последней позиции.

    !!! Важное замечание, сортировка распространяется только на первый элемент,
    тот к которому будем обращаться, остальные элементы если проитерироваться по всей очереди будут разбросаны.
    При удалении первого элемента из очереди его место займет,
    тот у которого приоритет выше,задан Comparable или Comparator


    Например, PriorityQueue<String> сортирует элементы в алфавитном порядке.
                                                                                                                   *//**
        PriorityQueueEx1.java

        package org.o7planning.queue.ex;

        import java.util.PriorityQueue;
        import java.util.Queue;

        public class PriorityQueueEx1 {

            public static void main(String[] args) {
            // Create Queue
            Queue<String> queue = new PriorityQueue<String>();

            queue.offer("One");
            queue.offer("Two");
            queue.offer("Three");
            queue.offer("Four");
            queue.offer("Five");

            String current;

                while((current = queue.poll())!= null) {
                    System.out.println(current);
                }
            }
        }

    На конслоь:

        Five
        Four
        One
        Three
        Two

     */


}

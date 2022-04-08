package Java_Extend.Multithreading;

public class BlockingQueue_General {

/*                         *** java.util.concurrent (Блокирующие очереди пакета concurrent) ***

    BlockingQueue - это подинтерфейс of Queue, который предоставляет дополнительные операции и полезен в ситуациях,
    когда очередь пуста или заполнена элементами.

    Methods inherited from interface java.util.Queue
*//**             element, peek, poll, remove                                                                       *//*

    Methods inherited from interface java.util.Collection
*//**            addAll, clear, containsAll, equals, hashCode, isEmpty, iterator,
            parallelStream, removeAll, removeIf, retainAll, size, spliterator, stream, toArray, toArray             *//*

    Methods inherited from interface java.lang.Iterable
*//**            forEach                                                                                            *//*


         Summary of BlockingQueue methods
                            Throws exception	    Special value   	Blocks	        Times out
*//**   Insert	            add(e)	                offer(e)	        put(e)	        offer(e, time, unit)
        Remove              remove()	            poll()	            take()	        poll(time, unit)
        Examine	            element()           	peek()	         not applicable	    not applicable
                                                                                                                    *//*

    Пакет java.util.concurrent включает классы для формирования блокирующих очередей с поддержкой многопоточности.
    Блокирующие очереди используются в тех случаях, когда нужно выполнить (проверить выполненение)
    какие-либо условия для продолжения потоками своей работы.
    Блокирующие очереди могут реализовывать интерфейсы
        - BlockingQueue
        - BlockingDeque
        - TransferQueue

    В пакете java.util.concurrent имеются следующие реализации блокирующих очередей :

    - ArrayBlockingQueue — очередь, реализующая классический кольцевой буфер;
    - LinkedBlockingQueue — односторонняя очередь на связанных узлах;
    - LinkedBlockingDeque — двунаправленная очередь на связанных узлах;
    - SynchronousQueue — блокирующую очередь без емкости
      (операция добавления одного потока находится в ожидании соответствующей операции удаления в другом потоке);
    - LinkedTransferQueue — реализация очереди на основе интерфейса TransferQueue;
    - DelayQueue — неограниченная блокирующая очередь, реализующая интерфейс Delayed;
    - PriorityBlockingQueue — реализация очереди на основе интерфейса PriorityQueue.


    Использование очередей пакета java.util.concurrent может стать решением проблем взаимных блокировок и «голодания».

    *Взаимная блокировка
    С использованием блокировок необходимо быть очень внимательным, чтобы не создать «взаимоблокировку»,
    которая хорошо известна разработчикам. Этот термин означает, что один из потоков ждет от другого
    освобождения заблокированного им ресурса, в то время как сам также заблокировал один из ресурсов,
    доступа к которому ждёт второй поток. В данном процессе могут участвовать два и более потоков.


                                    *Интерфейс BlockingQueue

    Интерфейс BlockingQueue определяет блокирующую очередь, наследующую свойства интерфейса Queue,
    в которой элементы хранятся в порядке «первый пришел, первый вышел» (FIFO – first in, first out).
    Реализация данного интерфейса обеспечивает блокировку потока в двух случаях :

    - при попытке получения элемента из пустой очереди;
    - при попытке размещения элемента в полной очереди.

    Когда поток пытается получить элемент из пустой очереди, то он переводится в состояние ожидания до тех пор,
    пока какой-либо другой поток не разместит элемент в очереди.
    Аналогично при попытке положить элемент в полную очередь;
    поток ставится в ожидание до тех пор, пока другой поток не заберет элемент из очереди и,
    таким образом, не освободит место в ней.
    Естественно, понятие "полная очередь" подразумевает ограничение размера очереди.

    BlockingQueue изящно решает проблему передачи собранных одним потоком элементов
    для обработки в другой поток без явных хлопот о проблемах синхронизации.

    Основные методы интерфейса BlockingQueue:

    Метод	                                    Описание
    boolean add(E e)	                        Немедленное добавление элемента в очередь, если это возможно;
                                                метод возвращает true при благополучном завершении операции,
                                                вызывает IllegalStateException, если очередь полная.
    boolean contains(Object o)	                Проверка наличия объекта в очереди;
                                                если объект найден в очереди метод вернет true.
    boolean offer(E e)	                        Немедленное размещение элемента в очереди при наличие свободного места;
                                                метод вернет true при успешном завершении операции,
                                                в противном случае вернет false.
    boolean offer                               Размещение элемента в очереди при наличии свободного места;
    (E e, long timeout, TimeUnit unit)	        при необходимости определенное ожидание времени,
                                                пока не освободиться место.
    E poll(long timeout, TimeUnit unit)	        Чтение и удаление элемента из очереди в
                                                течение определенного времени (таймаута).
    void put(E e)	                            Размещение элемента в очереди,
                                                ожидание при необходимости освобождения свободного места.
    int remainingCapacity()	                    Получения количества элементов, которое можно разместить в
                                                очереди без блокировки, либо Integer.MAX_VALUE
                                                при отсутствии внутреннего предела.
    boolean remove(Object o)	                Удаление объекта из очереди, если он в ней присутствует.
    E take()	                                Получение с удалением элемента из очереди,
                                                при необходимости ожидание пока элемент не станет доступным.


    BlockingQueue не признает нулевых элементов (null) и
    вызывает NullPointerException при попытке добавить или получить такой элемент.
    Нулевой элемент возвращает метод poll, если в течение таймаута не был размещен в очереди очередной элемент.

    Методы BlockingQueue можно разделить на 4 группы,
    по-разному реагирующие на невозможность выполнения операции в текущий момент и
    откладывающие их выполнение на время:
        - первые вызывают Exception,
        - вторые возвращают определенное значение (null или false),
        - третьи блокируют поток на неопределенное время до момента выполнения операции,
        - четвертые блокируют поток на определенное время.
    Эти методы представлены в следующей таблице:

    	        Вызывает        Exception	        Чтение значения	Блокировка	        Чтение с задержкой
    Insert	    add(e)	        offer(e)	        put(e)	                            offer(e, time, unit)
    Remove	    remove()	    poll()	            take()	                            poll(time, unit)
   Еxamine 	    element()	    peek()	            -	                                 -


    take()/poll(time,unit)
    Как мы знаем, методы remove(), element(), poll() и peek() интерфейса Queue возвращают элемент во главе очереди,
    который либо немедленно вызовет исключение, либо вернет значение null, если очередь не содержит никаких элементов.
    Такие операции недостаточно хороши в многопоточной среде,
    поэтому интерфейс BlockingQueue предоставляет новые методы take() и poll(time,unit).

    take(): Возвращает верхний элемент и удаляет его из очереди.
    Если очередь пуста, метод будет ждать, пока элемент не станет доступен в очереди.

    poll(timeout,unit): Возвращает головной элемент и удаляет его из очереди.
    Если очередь пуста, метод будет ждать, пока элемент будет доступен в течение указанного промежутка времени.
    Если время ожидания заканчивается без доступных элементов, метод вернет значение null.
    put(e)/offer(e,time,unit)

    Методы add(e) и offer(e) интерфейса Queue используются для добавления элемента в очередь.
    Они либо немедленно выдадут исключение, либо вернут значение false, если очередь заполнена.

    Интерфейс BlockingQueue предоставляет методы put(e) и offer(e,timeout,unit)
    для той же цели, но у них есть более специальные функции.

    put(e): Вставить элемент в очередь. Если очередь заполнена, этот метод будет ждать,
    пока не появится свободное место для вставки.

    offer(e,timeout,unit):  Вставить элемент в очередь. Если очередь заполнена, метод будет ждать,
    пока освободится место для вставки в течение указанного промежутка времени.
    Если тайм-аут заканчивается без свободного места,
    никаких действий предпринято не будет, и метод вернет значение false.

        Характеристики BlockingQueue:
    - BlockingQueue не принимает элементы null, если вы намеренно добавите элемент null в эту очередь,
        будет выдано исключение NullPointerException.
    - BlockingQueue может быть ограничена по емкости.
        Метод remainingCapacity() возвращает оставшуюся емкость этой очереди
        или Integer.MAX_VALUE, если емкость очереди не ограничена.
    - BlockingQueue обычно используется в приложениях типа Producer & Consumer (производитель и потребитель).
        BlockingQueue является потомком интерфейса Collection, поэтому также поддерживается метод remove(e).
        Однако такие методы работают неэффективно и только для случайного использования.
        Например, удалите дефектный товар из очереди.
    - BlockingQueue - это потокобезопасная очередь (thread-safe).
        Все методы очереди являются атомарными операциями (Atomic Operations).
        Однако методы, унаследованные от интерфейса Collection,
        такие как addAll, containsAll, retainAll и removeAll ,
        не обязательно являются атомарными операциями,
        это зависит от класса, реализующего интерфейс BockingQueue.
        Таким образом, возможно, например, вызов addAll(aCollection) может вызвать исключение,
        если другой поток одновременно добавляет элемент aCollection.
    - BlockingQueue не поддерживает такие методы, как "close" (закрыть) или  "shutdown" (завершение работы),
        например, когда Producer (производитель) хочет отправить сигнал о том,
        что в очередь больше не будут добавлены "продукты".
        Необходимость и использование этих функций, как правило, зависят от реализации.
        Решение может быть следующим: Конечный и специальный "продукт" добавляется в очередь в качестве сигнала,
        сообщающего Consumer (потребителю), что это последний продукт, добавляемый в очередь.



                            * Очередь ArrayBlockingQueue

    Класс блокирующей очереди ArrayBlockingQueue реализует классический ограниченного размера
    кольцевой буфер FIFO — «первым прибыл - первым убыл». Новые элементы вставляются в хвост очереди;
    операции извлечения отдают элемент из головы очереди. Создаваемая емкость очереди не может быть изменена.
        - Попытки вставить (put) элемент в полную очередь приведет к блокированию работы потока;
        - попытка извлечь (take) элемент из пустой очереди также блокирует поток.

    Класс ArrayBlockingQueue и его iterator реализуют все дополнительные методы Collection и Iterator.

    Конструкторы класса ArrayBlockingQueue
    - Первый конструктор создает очередь фиксированной емкости и с политикой доступа по умолчанию.
    - Второй конструктор — очередь с фиксированной емкостью и указанной политикой доступа.
    - Последний конструктор создает очередь с фиксированной емкостью,
      указанной политикой доступа и включает в очередь элементы.

        ArrayBlockingQueue(int capacity)
        ArrayBlockingQueue(int capacity, boolean fair)
        ArrayBlockingQueue(int capacity, boolean fair, Collection<? extends E> c)

    Метод toArray() возвращает массив элементов очереди типа Object[].

    Пример:                                                                                                        *//**

    import java.util.concurrent.*;

public class BlockingQueueExample
{
    private BlockingQueue<String> drop;

    private final String    DONE     = "done";
    private final String[]  messages = {
                            "Мама пошла готовить обед",
                            "Мама позвала к столу",
                            "Дети кушают молочную кашу",
                            "А что ест папа?"};
    public BlockingQueueExample()
    {
        drop = new ArrayBlockingQueue<String>(1, true);
        (new Thread(new Producer())).start();
        (new Thread(new Consumer())).start();
    }

    class Producer implements Runnable
    {
        public void run() {
            try {
                int cnt = 0;
                for (int i=0; i<messages.length; i++) {
                    drop.put(messages[i]);
                    if (++cnt < 3)
                        Thread.sleep(2000);
                }
                drop.put(DONE);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    class Consumer implements Runnable
    {
        public void run() {
            try {
                String msg = null;
                while (!((msg = drop.take()).equals(DONE)))
                    System.out.println(msg);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new BlockingQueueExample();
    }
}

                                                                                                                    */



}
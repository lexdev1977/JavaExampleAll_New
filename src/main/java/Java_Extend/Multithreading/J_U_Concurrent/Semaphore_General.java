package Java_Extend.Multithreading.J_U_Concurrent;

public class Semaphore_General {

/*
                                        *** Semaphore java.util.concurrent.

        конструкторы:
        - Semaphore(int permits)
        - Semaphore(int permits, boolean fair)

    	методы:
    	- .acquire()                  - получения разрешения на исполнение метода
        - .acquire(int permits)
        - .release()                  - освобождает метод
        - .release(int permits)
        - .availablePermit ()         - возвращает количество доступных на данный момент разрешений





    Семафор — это средство для синхронизации доступа к какому-то ресурсу.

    Его особенность заключается в том, что при создании механизма синхронизации он использует счетчик.

    Счетчик указывает нам, сколько потоков одновременно могут получать доступ к общему ресурсу.

    Семафоры в Java представлены классом Semaphore

    При создании объектов-семафоров мы можем использовать такие конструкторы:

        - Semaphore(int permits)
        - Semaphore(int permits, boolean fair)

    В конструктор мы передаем:
    int permits — начальное и максимальное значение счетчика.
    То есть то, сколько потоков одновременно могут иметь доступ к общему ресурсу;

    boolean fair — для установления порядка, в котором потоки будут получать доступ.
    Если fair = true, доступ предоставляется ожидающим потокам в том порядке,
    в котором они его запрашивали. Если же он равен false, порядок будет определять планировщик потоков.

    */
    /*

    Для управления доступом к ресурсу семафор использует счетчик, представляющий количество разрешений.
    Если значение счетчика больше нуля, то поток получает доступ к ресурсу, при этом счетчик уменьшается на единицу.
    После окончания работы с ресурсом поток освобождает семафор, и счетчик увеличивается на единицу.
    Если же счетчик равен нулю, то поток блокируется и ждет, пока не получит разрешение от семафора.

    Для получения разрешения у семафора надо вызвать метод acquire(), который имеет две формы:

        - void acquire() throws InterruptedException
        - void acquire(int permits) throws InterruptedException

    Для получения одного разрешения применяется первый вариант, а для получения нескольких разрешений - второй вариант.

    После вызова этого метода пока поток не получит разрешение, он блокируется.

    После окончания работы с ресурсом полученное ранее разрешение надо освободить с помощью метода release():

        - void release()
        - void release(int permits)

    Первый вариант метода освобождает одно разрешение, а второй вариант - количество разрешений, указанных в permits.

    Используем семафор в простом примере:
                                                                                                                   *//**
            import java.util.concurrent.Semaphore;

        public class Program {

        public static void main(String[] args) {

                Semaphore sem = new Semaphore(1); // 1 разрешение
                CommonResource res = new CommonResource();
                new Thread(new CountThread(res, sem, "CountThread 1")).start();
                new Thread(new CountThread(res, sem, "CountThread 2")).start();
                new Thread(new CountThread(res, sem, "CountThread 3")).start();
            }
        }
        class CommonResource{

            int x=0;
        }

        class CountThread implements Runnable{

            CommonResource res;
            Semaphore sem;
            String name;
            CountThread(CommonResource res, Semaphore sem, String name){
                this.res=res;
                this.sem=sem;
                this.name=name;
            }

            public void run(){

                try{
            System.out.println(name + " ожидает разрешение");
            sem.acquire();
            res.x=1;
            for (int i = 1; i < 5; i++){
                System.out.println(this.name + ": " + res.x);
                res.x++;
                Thread.sleep(100);
            }
        }
        catch(InterruptedException e){System.out.println(e.getMessage());}
        System.out.println(name + " освобождает разрешение");
        sem.release();
            }
        }                                                                                                           *//*

        Итак, здесь есть общий ресурс CommonResource с полем x, которое изменяется каждым потоком.
        Потоки представлены классом CountThread, который получает семафор и выполняет некоторые действия над ресурсом.
        В основном классе программы эти потоки запускаются. В итоге мы получим следующий вывод:

        CountThread 1 ожидает разрешение
        CountThread 2 ожидает разрешение
        CountThread 3 ожидает разрешение
        CountThread 1: 1
        CountThread 1: 2
        CountThread 1: 3
        CountThread 1: 4
        CountThread 1 освобождает разрешение
        CountThread 3: 1
        CountThread 3: 2
        CountThread 3: 3
        CountThread 3: 4
        CountThread 3 освобождает разрешение
        CountThread 2: 1
        CountThread 2: 2
        CountThread 2: 3
        CountThread 2: 4
        CountThread 2 освобождает разрешение








 */

}

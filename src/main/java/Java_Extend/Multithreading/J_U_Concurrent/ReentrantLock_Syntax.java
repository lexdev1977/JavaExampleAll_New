package Java_Extend.Multithreading.J_U_Concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock_Syntax {

    /*
                                    Аналог Synchronized

    - .lock() - ставит блокировку другим потокам
    - .unlock() - разблокирует доступ другим потокам


    Для управления доступом к общему ресурсу в качестве альтернативы оператору synchronized
    мы можем использовать блокировки. Функциональность блокировок заключена в пакете java.util.concurrent.locks.

    Вначале поток пытается получить доступ к общему ресурсу.
    Если он свободен, то на него накладывает блокировку.
    После завершения работы блокировка с общего ресурса снимается.
    Если же ресурс не свободен и на него уже наложена блокировка, то поток ожидает, пока эта блокировка не будет снята.

    Классы блокировок реализуют интерфейс Lock, который определяет следующие методы:

        - void lock(): ожидает, пока не будет получена блокировка

        - void lockInterruptibly() throws InterruptedException: ожидает,
        пока не будет получена блокировка, если поток не прерван

        - boolean tryLock(): пытается получить блокировку, если блокировка получена,
        то возвращает true. Если блокировка не получена, то возвращает false.
        В отличие от метода lock() не ожидает получения блокировки, если она недоступна

        - void unlock(): снимает блокировку

        - Condition newCondition(): возвращает объект Condition, который связан с текущей блокировкой

    Организация блокировки в общем случае довольно проста: для получения блокировки вызывается метод lock(),
    а после окончания работы с общими ресурсами вызывается метод unlock(), который снимает блокировку.

    Объект Condition позволяет управлять блокировкой.

    Как правило, для работы с блокировками используется класс ReentrantLock из пакета java.util.concurrent.locks.

    Пример:

     */


    public static void main(String[] args) throws InterruptedException {
        Task task01 = new Task();
        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {
                task01.firstThead();
            }
        });

        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                task01.secondThead();
            }
        });

        thread01.start();
        thread02.start();

        thread01.join();
        thread02.join();

        task01.showIndex();

    }


    static class Task{
        private int index;
        private Lock lock01 = new ReentrantLock();

        public void incremetn(){
            for (int i =0; i < 10000; i++){
                index++;
            }
        }

        public void firstThead(){
            lock01.lock();
            incremetn();
            lock01.unlock();
        }

        public  void secondThead(){
            lock01.lock();
            incremetn();
            lock01.unlock();
        }

        public void showIndex(){
            System.out.println("Общий индекс - " + index);
        }

    }






}

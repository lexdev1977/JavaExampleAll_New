package Java_Extend.Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock_Syntax {

    public static void main(String[] args) throws InterruptedException {


//                                   простой пример как может сработать DeadLock


//      блок запуска методов с возможностью DeadLock

        Resource resource = new Resource();

        Thread thread01 = new Thread(new Runnable() {  // создание первого потока
            @Override
            public void run() {
                resource.work01();
            }
        });

        Thread thread02 = new Thread(new Runnable() {  // создание второго потока
            @Override
            public void run() {
                resource.work02();
            }
        });

//        thread01.start();
//        thread02.start();
//
//        thread01.join();
//        thread02.join();



//      второй блок запуска методов с возможностью DeadLock

        ResourceWithLock resourceWithLock = new ResourceWithLock();

        Thread thread03 = new Thread(new Runnable() {
            @Override
            public void run() {
                resourceWithLock.work03();
            }
        });

        Thread thread04 = new Thread(new Runnable() {
            @Override
            public void run() {
                resourceWithLock.work04();
            }
        });

//        thread03.start();
//        thread04.start();
//
//        thread03.join();
//        thread04.join();



//     третий блок запуска методов с обходом  DeadLock

        Thread thread05 = new Thread(new Runnable() {
            @Override
            public void run() {
                resourceWithLock.work05();
            }
        });

        Thread thread06 = new Thread(new Runnable() {
            @Override
            public void run() {
                resourceWithLock.work06();
            }
        });

        thread05.start();
        thread06.start();

        thread05.join();
        thread06.join();


    }

//                         Классы с разной реализации с обходом и без


//    Класс с использованием synchronized

    static class Resource{
        private Object Lock01 = new Object();     // создание объектов для синхронизации
        private Object Lock02 = new Object();


        public void work01() {

/*
      Cоздание двух методов - каждый последовательно использует оба объекта для синхронизации,
      но в разном порядке, что может привести к захвату первого объекта первым методом,
      а вторым методом к захвату второго объекта.
      Для продолжения работы методов первому нужен второй объект синхронизации который захватил второй,
      а второму первый, который захватил первый метод. В этом случае произойдет DeadLock

 */
            synchronized (Lock01) {
                System.out.println("Работа в первой синхронизации");
                synchronized (Lock02) {
                }
                System.out.println("Work 01 - Повезло, что сообщение вышло и не было DeadLock");
            }
        }

        public void work02() {
            synchronized (Lock02) {
                synchronized (Lock01) {
                }
                System.out.println("Work 02 - Повезло, что сообщение вышло  и не было DeadLock");
            }
        }


    }

//    Класс с использованием ReentrantLock

    static class ResourceWithLock{
        private Lock lock03 = new ReentrantLock();
        private Lock lock04 = new ReentrantLock();

        private Lock lock05 = new ReentrantLock();
        private Lock lock06 = new ReentrantLock();



//    пример методов, которые могут быть заблокированны вызвав DeadLock
        public void work03() {

            lock03.lock();
            System.out.println("Если не использовать обход DeadLock то этот канал может быть заблокирован");

            lock04.lock();
            try {
                System.out.println("Work 3 Если в этом блоке выскочит исключение или ошибка, то в блоке Finally " +
                        "всеравно будет обработка, а следовательно произойдет unlock каналов");
                }finally {
                lock03.unlock();
                lock04.unlock();
            }
        }

        public void work04() {
            lock04.lock();
            lock03.lock();
            try {
                System.out.println("Work 4 Если в этом блоке выскочит исключение или ошибка, то в блоке Finally " +
                        "всеравно будет обработка, а следовательно произойдет unlock каналов");
            }finally {
                lock04.unlock();
                lock03.unlock();
            }
        }

//    пример методов с обходом DeadLock

        private void takeLocks(Lock lock01, Lock lock02){     // выносим Lock в отдельный метод проверки
            boolean firstLockTaken = false;                   // проверяем, свободны ли оба Lock или нет
            boolean secondLockTaken = false;                  // если оба свободны, то выходим из метода
            while (true) {                                    // если нет то освобождаем занятый Lock
                try {                                         // и в бесконечном цикле с минимальной задержкой
                    firstLockTaken = lock05.tryLock();        // ждем освобождения обоих каналов
                    secondLockTaken = lock06.tryLock();
                } finally {
                    if (firstLockTaken && secondLockTaken) {
                        return;
                    }
                    if (firstLockTaken) {
                        lock05.unlock();
                    }
                    if (secondLockTaken) {
                        lock06.unlock();
                    }
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        public void work05() {

            takeLocks(lock05, lock06);
            try {
                System.out.println("Work 5 с обходом DeadLock");
            }finally {
                lock05.unlock();
                lock06.unlock();
            }
        }


        public void work06() {

            takeLocks(lock06, lock05);
            try {
                System.out.println("Work 6 с обходом DeadLock");
            }finally {
                lock06.unlock();
                lock05.unlock();
            }
        }


    }

}

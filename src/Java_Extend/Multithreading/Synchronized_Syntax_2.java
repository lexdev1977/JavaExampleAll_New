package Java_Extend.Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Synchronized_Syntax_2 {


    public static void main(String[] args) throws InterruptedException {


        long before = System.currentTimeMillis();       // снимаем показатель текущего времени (до выполнения)

        Work start = new Work();                        // создадим объект класса Work, для запуска методов


        Thread thread01 = new Thread(new Runnable() {   // создадим первый поток и вызовем метод .addAll
            @Override
            public void run() {
                    start.addAll();
            }
        });

        Thread thread02 = new Thread(new Runnable() {   // создадим второй поток и вызовем метод .addAll
            @Override
            public void run() {
                    start.addAll();
            }
        });

        thread01.start();                               // запустим оба потока
        thread02.start();

        thread01.join();                                // приостановим главный поток
        thread02.join();                                // и дождемся выполнения двух наших потоков


        long after = System.currentTimeMillis();        // снимаем показатель текущего времени (после выполнения)

        System.out.println("Время выполнения: " + (after-before));

        start.infoAll();                                // выведем инфо о созданных двух списках точнее, их размеры


    }

    static class Work{
        Random random = new Random();                           // создаем переменную случайного числа

        private Object Lock01 = new Object();                   // создадим два объекта для синхронизации потоков
        private Object Lock02 = new Object();

        private List<Integer> list01 = new ArrayList();         // создаем два списка
        private List<Integer> list02 = new ArrayList();


        public void addRND01() {                               // метод по добавлению случайного числа в список 1
            synchronized (Lock01) {                            // он синхронизируется по объекту lock1
                try {                                          // также есть исключение на Thread.sleep
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list01.add(random.nextInt(100));
            }
        }

        public void addRND02() {                                   // метод по добавлению случайного числа в список 2...
            synchronized (Lock02) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list02.add(random.nextInt(100));
            }
        }


        public void addAll(){                                      // метод добавления случайных 1000 чисел в оба списка
            for (int i =0; i < 1000; i++){
               addRND01();
               addRND02();
            }
        }

        public void infoAll(){                                             // метод вывода информации о списках (размер)
            System.out.println("Размер первого листа: " + list01.size());
            System.out.println("Размер второго листа: " + list02.size());
        }
    }

    static void ss(){

    }


}

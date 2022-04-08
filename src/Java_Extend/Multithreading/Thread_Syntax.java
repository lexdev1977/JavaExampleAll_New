package Java_Extend.Multithreading;

public class Thread_Syntax {
    public static void main(String[] args) throws InterruptedException {   // имплеминтируем исключение для .sleep

/**
      * Запуск потоков:
      *
      * главный -> ждет 3 секунды
      * "главный старт" -> идет пока не закончится
      * "главный центр" + поток01(с задержкой в теле класса) + поток02 + поток04 + поток03(с задержкой в главном потоке)
      * "главный конец" + поток05(на основе потока 04) запускаются, только после завершения центральной части
 *
 *     !!!Все потоки будут выполняться параллельно, которые не успели закончить свою деятельность, но уже запущены
 *
*/


//                          ***  Thread - класс для создания нового потока
//      - .run() - создает тело потока
//      - .start() - запускает поток
//      - .sleep() - поток пристанавливает деятельность


//        Мы создали четыре класса наследующих класс многопоточности Thread

        System.out.println("Посплю три секунды на главном потоке");
        Thread.sleep(3000);   // главный поток засыпает на 3 секунды
        System.out.println("Ок, я проснулся, что делаем?");


//      создаем объекты на основе наших классов:
        MyThread01 potok01 = new MyThread01();
        MyThread02 potok02 = new MyThread02();
        MyThread03 potok03 = new MyThread03();
        MyThread04 potok04 = new MyThread04();
        MyThread04 potok05 = new MyThread04();   // этот объект создается на основе класса четвертого потока


/**                                        *** стартовая часть ***                                              */

        //      действия в главном будут идти до конца выполнения затем стартуют другие потоки в порядке очередности
        for(int i=0; i < 50; i++ ) {
            System.out.println("*** Главный поток стартовый: " + i + " ***");

        }


/**                               *** потоки 01, 02, 04, 03 (с задержкой) и центральная часть ***               */


        potok01.start();              // первый поток стартует вместе со всеми, но у него задержка на каждый цикл
        potok02.start();
        potok04.start();
        MyThread03.sleep(5000); // третий поток стартует позже всех, так как перед его стартом есть задержка
        potok03.start();


        //      действия в главном потоке здесь будут идти параллельно с потоками 1,2 и 4 (но первый поток с задержкой)
        //      и даже если успеет, то присоединится третий поток
        for(int i=0; i < 300; i++ ) {
            System.out.println("*** Главный поток центр: " + i + " ***");

        }


/**                               *** потоки 05 (на основе потока 04) и конечная часть ***                      */

        // этот поток стартуют, как только закончит работу "центральная часть" главного потока,
        // вместе с ним запустится и блок программы - "поток конец"
        // после запуска potok05, запустится еще одна реализация 4 потока,
        // так как он был создан на его классе
        potok05.start();


        //      действия в главном потоке здесь будут идти после выполнения центральной части главного потока
        for(int i=0; i < 1000; i++ ) {
            System.out.println("*** Главный поток конец: " + i + " ***");

        }





    }



//    создаем класс наследующий Thread, класс реализующий многопоточность
//    в методе run мы реализовали задержку на каждый цикл выполнения этого потока - MyTreads01
    static class MyThread01 extends Thread {

        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Первый поток: " + i);
            }
        }
    }


//    создаем второй класс наследующий Thread, класс реализующий многопоточность
    static class MyThread02 extends Thread {

        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Второй поток: " + i);
            }
        }
    }

//    создаем третий класс наследующий Thread, класс реализующий многопоточность
    static class MyThread03 extends Thread {

        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("Третий поток: " + i);
            }
        }
    }

//    создаем четвертый класс наследующий Thread, класс реализующий многопоточность
    static class MyThread04 extends Thread {

        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Четвертый и пятый поток: " + i);
            }
        }
    }






}

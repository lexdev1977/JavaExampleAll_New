package Java_Extend.Multithreading;

import java.util.Random;
import java.util.Scanner;
/*


                                Interrupt - прерывание потока

    Вызов этого метода устанавливает у потока статус, что он прерван.
    Сам метод возвращает true, если поток может быть прерван, в ином случае возвращается false.

    При этом сам вызов этого метода НЕ завершает поток, он только устанавливает статус:
    в частности, метод isInterrupted() класса Thread будет возвращать значение true

    В классе, который унаследован от Thread, мы можем получить статус текущего потока с помощью метода isInterrupted().
    И пока этот метод возвращает false, мы можем выполнять цикл.
    А после того, как будет вызван метод interrupt,
    isInterrupted() возвратит true, и соответственно произойдет выход из цикла.

    Если основная функциональность заключена в классе, который реализует интерфейс Runnable,
    то там можно проверять статус потока с помощью метода Thread.currentThread().isInterrupted():

    !!! Однако при получении статуса потока с помощью метода isInterrupted() следует учитывать,
    что если мы обрабатываем в цикле исключение InterruptedException в блоке catch,
    то при перехвате исключения статус потока автоматически сбрасывается,
    и после этого isInterrupted будет возвращать false.

    !!! Важно, при вызове .interrupt(), поток для которого он вызван
    в первую очередь обработает исключение InterruptedException и его блок catch,
    очередь же до проверки типа - if(Thread.currentThread().isInterrupted()) может не дойти

    !!!  Как вариант, в этом случае мы можем повторно прервать текущий поток
    опять же вызвав метод interrupt() и передать снова True в isInterrupted,                                                                             *//**

    Пример:

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    interrupt();
                }
 */





public class Interrupt_Syntax {

    public static void main(String[] args) throws InterruptedException {

        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                double sin = 0;
                for (int i =0; i < 1_000_000_000; i++){

                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Действие потока было остановлено на - " + i +
                                "  Цикле, последнее вычисление равно - " + sin);
                        break;
                    }
                    sin = Math.sin(random.nextDouble());

                }
            }
        });

//        System.out.println("Запускаем вычисление Синуса и ждем 3 секунды");
//        thread01.start();
//
//        Thread.sleep(3000);
//
//        thread01.interrupt();
//        thread01.join();
//
//        System.out.println("Все действия выполнены");
//
//        System.out.println("\n\n**************************************\n\n");






        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean status = true;
                Scanner scan = new Scanner(System.in);
                String scan2;

                for (int i =0; i<10000; i++){
                    System.out.println("Буду выводить числа, пока не поступит команда Interrupt");
                    if (!status){
                        scan2 = scan.nextLine();

                        if (scan2.equals("")){
                            System.out.println("Поздравляем, вы остановили программу!");
                            break;
                        }
                    }

                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        System.out.println("Можно остановить действие нажав ввод");
                        status = false;
                    }
                }
            }
        });
//
//        thread02.start();
//        Thread.sleep(5000);
//
//        thread02.interrupt();
//
//        thread02.join();
//
//        System.out.println("\n\n**************************************\n\n");





        Thread thread03 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0; i<10000; i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Поток был остановлен другим потоком, не Main");
                        break;
                    }
                    System.out.println("Идет выполнение программы в первом потоке...");
                }

            }
        });

        Thread thread04 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Вы можете остановить первый поток, нажав Enter");
                Scanner scan2 = new Scanner(System.in);
                String scan3;
                while (true){
                    scan3 = scan2.nextLine();
                    if (scan3.equals("")){
                        System.out.println("Попытка остановить первый поток");
                        thread03.interrupt();
                        break;
                    }
                }
                scan2.close();
            }
        });

//        thread03.start();
//        thread04.start();
//
//        thread03.join();
//        thread04.join();
//
//        System.out.println("Все три задания были выполнены");
//
//        System.out.println("\n\n**************************************\n\n");


/*
        Если в потоке не используются ключевые слова которые выбрасывают InterruptedException
        остановку потока можно произвести опросив состояние потока через isInterrupted -
        которое по умолчанию false
        реализовать можно в методе Run класса наследующего Thread


 */


        ThreadClass thread05 = new ThreadClass();

        thread05.start();
        System.out.println("Запуск программы\nЧерез 5 секунд будет вызов .interrupt и поток остановится " +
                "так как цикл завязан на !isInterrupted ");
        Thread.sleep(5000);

        thread05.interrupt();

        thread05.join();

    }

    static class ThreadClass extends Thread{

        public void run(){
            while (!isInterrupted()){
                System.out.println("Поток работает пока .isInterrupted - false");
                try {
                    Thread.sleep(1000);

                    System.out.println("Состояние isInterrupted на данный момент...... " + isInterrupted());
                } catch (InterruptedException e) {

                    System.out.println("Сработал вызов interrupt() состояние .isInterrupted  в блоке Catch - "
                            + isInterrupted() );

                    interrupt();                // вызываем в блоке catch повторно

                    System.out.println("после второго вызова interrupt()  в блоке Catch .isInterrupted - "
                            + isInterrupted() );

        /*  после срабатывания метода interrupt() и обработки InterruptedException в блоке catch
            состояние isInterrupted снова поменяется на false
            если в блоке снова вызвать interrupt(), то состояние isInterrupted поменяется на True
            цикл продолжится и тут же прервется в результате проверки !isInterrupted
            например это можно применить, чтоб использовать задержку в цикле Thread.sleep                            */


                }


                System.out.println("\n");

            }
        }

    }





}

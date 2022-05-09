package Java_Extend.Multithreading.J_U_Concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*                     *** CountDownLatch (  ) - останавливает работу потока по счетчику

       - CountDownLatch имя = new CountDownLatch(счетчик)  - синтаксис создание объекта
       - .await() - метод вызывающий остановку потока в котором он вызван (есть перегрузка с ожиданием по времени)
       - .countDown() - метод при вызове которого уменьшает счетчик на единицу
       - .getCount() - метод, который возвращает размер счетчика


       Мы можем заставить поток блокироваться до тех пор, пока другие потоки не выполнят заданную задачу.
       CountDownLatch имеет поле counter, которое вы можете уменьшить по мере необходимости.
       Затем мы можем использовать его для блокировки вызывающего потока до тех пор, пока он не будет отсчитан до нуля.

       Если бы мы выполняли некоторую параллельную обработку, мы могли бы создать экземпляр CountDownLatch
       с тем же значением для счетчика, что и количество потоков, с которыми мы хотим работать.
       Затем мы могли бы просто вызвать countdown() после завершения каждого потока, гарантируя,
       что зависимый поток, вызывающий await (), будет блокироваться до тех пор, пока рабочие потоки не будут завершены.




       Примеры:                                                                                                        */


public class CountDownLatch_Syntax {
    public static void main(String[] args) throws InterruptedException {



        //    Простой пример на одном потоке:

        CountDownLatch cdl02 = new CountDownLatch(10);

        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Выполняем работу дополнительного потока, осталось - " + cdl02.getCount());
                    cdl02.countDown();

                }
            }
        });

        System.out.println("Главный поток ждет работу доп потока, пока он не выполнит ее - "
                + cdl02.getCount() + " раз");

        thread01.start();

        cdl02.await();

        System.out.println("Мы продолжаем главный поток и переходим к работе второго примера\n\n\n");




//             Другой пример с 3 потоками и 10 заданиями

        CountDownLatch cdl = new CountDownLatch(6);   // создаем объект CountDownLatch и поставляем в него счетчик

        ExecutorService pool01 = Executors.newFixedThreadPool(3);  // создаем пул потоков - 3 потока в примере

        for (int i = 0; i < 10; i++){
            pool01.submit(new TestCDL(i, cdl));    // Поставляем нашему пулу 10 объектов для обработки
                                                   // каждый объект имплиментит Runnable
                                                   // также в каждом объекте есть объект нашего CountDownLatch
                                                   // с методом .await который останавливает работу потока
                                                   // и ждет уменьшение до нуля счетчика CountDownLatch.
                                                   // Как только счетчик стал нулем - стартует потоки, которые ждали
        }

        pool01.shutdown();

        for (int i = 0; i < 6; i++){        // запускаем цикл в каждом такте которого вызываем метод
            Thread.sleep(1000);       // .countDown - который уменьшает счетчик нашего CountDownLatch на единицу


            System.out.println("Работа главного потока, осталось - " + cdl.getCount() + " Циклов");
            cdl.countDown();
        }

    }

    static class TestCDL implements Runnable{

        private int id;
        private CountDownLatch CDLTest;

        public TestCDL(int id, CountDownLatch CDLTest) {
            this.id = id;
            this.CDLTest = CDLTest;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                CDLTest.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Work id: " + id + "  Proceeded...");

        }
    }










}

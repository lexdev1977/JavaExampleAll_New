package Java_Extend.Multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorService_Syntax {


//        *** ExecutorService -  исполняет асинхронный код в одном или нескольких потоках ***
//                                      (создание Пул потоков)
    public static void main(String[] args) throws InterruptedException {

        long a = System.currentTimeMillis();   // счетчик времени


//        создаем Пул потоков в нашем случае будет 2 потока
        ExecutorService executorService01 = Executors.newFixedThreadPool(2);

//        в данном блоке мы задаем работу для пула потоков, поставляем в метод .submit объект реализующий Runnable
        for (int i =0; i < 5; i++){
            executorService01.submit(new Work(i));
        }

//       прекращаем добавления новых заданий и приступаем к выполнению уже поставленных задач
        executorService01.shutdown();
        System.out.println("All tasks submitted");

//       прекращаем основной поток и ожидаем выполнение пула, можно поставлять и часы и дни
        executorService01.awaitTermination(1, TimeUnit.HOURS);

        System.out.println("All tasks completed");

        System.out.println("Прощло времени: " + (System.currentTimeMillis() - a));



    }


//    создаем класс который имплеминтирует интерфейс Runnable, для реализации многопоточности
//    и задаем в методе Run работу которую мы будем выполнять в потоке

    static class Work implements Runnable{
        int id;

        public Work(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Work " + id + " was completed");

        }
    }

}

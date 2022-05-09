package Java_Extend.Multithreading;

import java.util.Random;
import java.util.concurrent.*;

public class Callable_Syntax {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

 //   Пример реализации Callable

        Callable callable01 = new Callable() {
            @Override
            public Object call() throws Exception {
                return "Thread 01 with Callable";
            }
        };

        ExecutorService pool01 = Executors.newFixedThreadPool(1);
        pool01.submit(callable01);

        pool01.shutdown();





//   Пример реализации Callable через Лямбду

        Callable callable02 = () -> "Thread 02 with Callable";




        ExecutorService pool02 = Executors.newFixedThreadPool(1);
        Future<Integer> future01 = pool02.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {

                System.out.println("Starting");
                Thread.sleep(1000);
                System.out.println("Finished");

                Random rnd = new Random();
                int rndValue = rnd.nextInt(1,10);

                if (rndValue < 5){
                    throw new Exception("Число меньше пяти, поэтому исключение");
                }

                return rndValue;

            }
        });



        pool02.shutdown();

        try {
            System.out.println(future01.get());   // .get - дожидается окончание выполнения потока

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable ex = e.getCause();
//            int badRND = future01.get();
            System.out.println(ex.getMessage());

//            e.printStackTrace();
        }




    }







}

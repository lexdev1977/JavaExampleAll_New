package Java_Extend.Multithreading.J_U_Concurrent;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;




public class BlockingQueue_Produce_Consumer_Syntax {

//       создаем объект класса BlockingQueue (класс для формирования блокирующих очередей с поддержкой многопоточности)
    private static BlockingQueue<Integer> queue01 = new ArrayBlockingQueue<>(10);  // размер очереди 10


//       В методе main создаем и запускаем два потока которые выполняют методы produce() и consumer().
//       Один передает задачу, а другой ее исполняет.
//       В очереди происходит ожидание записи - если нет свободного места.
//       И ожидание считывания - если очередь пуста.

    public static void main(String[] args) throws InterruptedException {

        Thread threadProduce = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadConsumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadProduce.start();     // запуск потоков
        threadConsumer.start();

        threadProduce.join();      // ожидание исполнения потоков
        threadConsumer.join();

    }


//    метод записи в очередь случайного числа
    private static void produce() throws InterruptedException {
        Random random01 = new Random();
        Random random02 = new Random();
        while (true){
            if (random02.nextInt(400) == 2)  // Искусственное притормаживание записи в очередь - случайное
            queue01.put(random01.nextInt(101));
        }
    }

//    метод считывания и вывода числа из очереди
    private static void consumer() throws InterruptedException {
        while (true){
//            Thread.sleep(1);
            System.out.println(queue01.take());
            System.out.println("Queue size is: " + queue01.size());

        }

    }



}

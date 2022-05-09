package Java_Extend.Multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class Produce_Consume_Syntax {

    static final int MAX_SIZE = 10;
    static final Object LOOCK01 = new Object();
    static Queue<Integer> queue01 = new LinkedList<>();



    public static void main(String[] args) throws InterruptedException {

        ProduceConsumer samplePC = new ProduceConsumer();

        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    samplePC.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    samplePC.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread01.start();
        thread02.start();

        thread01.join();
        thread02.join();
    }




    static class ProduceConsumer{


        public void produce() throws InterruptedException {
            int value = 0;
            while (true){
                synchronized (LOOCK01){
                    Thread.sleep(100);            // если поставить задержку в блоке синхронизации
                    while (queue01.size() >= MAX_SIZE){          // тогда идет просто задержка действий всего канала
                        try {                                    // т.е. просто тормозится весь процесс
                            LOOCK01.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Добавил число - " + value);
                    queue01.offer(value++);
                    LOOCK01.notify();
                }


            }
        }

        public void consume() throws InterruptedException {
            while (true){
                synchronized (LOOCK01){

                    while (queue01.size() == 0){
                        try {
                            LOOCK01.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Я забрал число - " + queue01.poll());
                    System.out.println("Размер очереди - " + queue01.size());
                    LOOCK01.notify();
                    Thread.sleep(3000);
                }
                                             // если поставить задержку вне блока синхронизации и после.notify, тогда
            }                                // канал подает команду на разблокировку канала находящегося в ожидании
                                             // а сам выполняет задержку, тем самым дает возможность другому каналу
                                             // перехватить инициативу так как он находится уже не в блоке синхронизации
                                             // и не удерживает общий монитор
        }                                    // другими словами его действия выполняются реже



    }


}

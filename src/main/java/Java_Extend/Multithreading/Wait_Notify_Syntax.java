package Java_Extend.Multithreading;

import java.util.Scanner;

public class Wait_Notify_Syntax {
    public static void main(String[] args) throws InterruptedException {


/*      Принцип работы данного кода:
        Создаем два потока
        Создаем два метода одного класса
        Оба метода синхронизуются на объекте этого класса - this
        Один поток работает над одним методом и стартует раньше
        Второй поток над другим методом и стартует позже
        После выполнения части кода первый поток выполняет  -   wait();
        Тем самым освобождая монитор этого объекта для других потоков
        Монитор переходит второму потоку и он выполняет свой код до - notify();
        После он высвобождает случайный поток из ожидания
        !!! но продолжает удерживать монитор до тех пор, пока не закончится работа потока полностью.
 */


        TestWaitNotify testWN = new TestWaitNotify();

        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    testWN.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    testWN.produce();
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



    static class TestWaitNotify{
        Object synObject = new Object();   // создаем объект для синхронизации на нем


//      в данном блоке мы синхронизируемся на доп созданном объекте Object synObject,
//      в этом примере можно было обойтись и синхронизацией по this
//      !!! Важно помнить, что даже указав в synchronized объект на котором будем синхронизироваться,
//      но не указав явно wait() и notify(); они будут явно ссылаться на объект this
//      и если явно не указать объект выбросит исключение - "IllegalMonitorStateException"

        public void produce() throws InterruptedException {
            synchronized (synObject){      // при синхронизации на this - " synchronized (this) "
                System.out.println("Producer thread started...");

                synObject.wait();          // этот поток освобождает монитор для др. потоков
                                           // при синхронизации на this можно написать просто  wait();

                System.out.println("Producer thread resumed...");
            }

        }

        public void consume() throws InterruptedException {
            Thread.sleep(2000);
            Scanner scan = new Scanner(System.in);

            synchronized (synObject){
                System.out.println("Consumer thread started...");
                System.out.println("Waiting for return key pressed");
                scan.nextLine();
                synObject.notify();                                        // «размораживает» один случайный поток

                System.out.println("Работа потока consume после разморозки нити продолжается, пока все не закончит");

            }
        }

    }
}

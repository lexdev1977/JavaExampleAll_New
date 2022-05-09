package Java_Extend.Multithreading;

import java.util.Scanner;

public class Volatile_Syntax {
    public static void main(String[] args) {

//        volatile - ключевое слово (один поток пишет в переменную, а все другие читают)
//        Переменная всегда будет атомарно читаться и записываться. Даже если это 64-битные double или long.
//        Java-машина не будет помещать ее в кэш.
//        Так что ситуация, когда 10 потоков работают со своими локальными копиями исключена.

        Thread01 thread01 = new Thread01();
        thread01.start();

        Scanner systemCommand = new Scanner(System.in);
        systemCommand.nextLine();
        thread01.stopThread01();
        System.out.println("Первый поток был остановлен");


    }


    static class Thread01 extends Thread{

        private volatile boolean running = true;

        @Override
        public void run() {

            while (running){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Работает первый поток");
            }


        }

        public void stopThread01(){
            running = false;
        }
    }

}

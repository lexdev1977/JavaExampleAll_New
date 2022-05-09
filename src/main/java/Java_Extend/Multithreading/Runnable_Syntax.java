package Java_Extend.Multithreading;

public class Runnable_Syntax {
    public static void main(String[] args) throws InterruptedException {

//      Два варианта реализации интерфейса Runnable - интерфейс реализующий метод Run - для многопоточности

//      Первый - в качестве параметра мы задаем класс, который имплеминтирует интерфейс Runnable
        Thread thread01 = new Thread (new Runnable01());


//      Второй - в качестве параметра мы задаем сразу интерфейс Runnable с переопределением метода

        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {                               // здесь выполняется задержка перед стартом потока
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++){

                    try {                            // здесь выполняется задержка перед каждым циклом
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Идет поток thread02 со сразу переопределенным интерфейсом");
                }
            }
        });

        thread01.start();
        thread02.start();

        thread01.join();
        thread02.join();

//      Сокращенная версия при помощи лямбда выражения

        Thread thread03 = new Thread(() -> System.out.println("Thread 03 is Started"));


//     Сначала создаем объект интерфейса Runnable, а потом передаем его в поток

        Runnable runnable04 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 04 is started");
            }
        };

        Thread thread04 = new Thread(runnable04);

        thread03.start();
        thread04.start();

    }



//    Класс имплеминтирующий Runnable и реализующий метод Run

    static class Runnable01 implements Runnable{

        @Override
        public void run() {

            for (int i = 0; i < 10; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Идет поток интерфейса Runnable01");
            }

        }
    }
}

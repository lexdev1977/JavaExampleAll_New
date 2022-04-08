package Java_Extend.Multithreading;

public class Runnable_Syntax {
    public static void main(String[] args) {

//      Два варианта реализации интерфейса Runnable - интерфейс реализующий метод Run -для многопоточности

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
                for (int i = 0; i < 100; i++){

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


    }



    static class Runnable01 implements Runnable{

        @Override
        public void run() {

            for (int i = 0; i < 100; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Идет поток интерфейса Runnable01");
            }

        }
    }
}

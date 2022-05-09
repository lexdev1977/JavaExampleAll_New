package Java_Extend.Multithreading;

public class Synchronized_Join_Syntax {


//      - метод Join - в текущем потоке ожидает тот поток к которому применен данный метод

//      - Synchronized - ключевое слово которое запрещает потокам одновременный доступ к методу


//            *** Синтаксис synchronized как ключевое слово для метода, предполагая This) ***

    private int counter;

    public static void main(String[] args) throws InterruptedException {

        Synchronized_Join_Syntax test = new Synchronized_Join_Syntax();
        test.doWork();


    }

//    если мы явно не указывали объект, то мы синхронизируемся на объекте который вызывается this (в нашем случае test)
    public synchronized void counterIncrement(){          // создаем метод с ключевым словом synchronized,
        counter++;                                       // чтоб ограничить обращение к телу метода только одним потоком

    }

/**    по другому можно было записать как synchronized блок, явно указывая к какому объекту он принадлежит:
    public  void counterIncrement(){
        synchronized (this){
            counter++;
        }
    }
*/


    public void doWork() throws InterruptedException {

        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0; i < 10000; i++){
                    counterIncrement();
                }
            }
        });

        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0; i < 10000; i++){
                    counterIncrement();
                }
            }
        });

        thread01.start();       // запускаем первый поток
        thread02.start();       // запускаем второй поток

        thread01.join();        // ждем завершения выполнения первого потока
        thread02.join();        // ждем завершения выполнения второго потока


        System.out.println(counter);

    }




}

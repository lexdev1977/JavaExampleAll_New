package Java_Extend.Multithreading.J_U_Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Semaphore_Syntax {
    public static void main(String[] args) throws InterruptedException {


//                простой пример, где главный поток, берет три разрешения, на использование ресурса

        System.out.println("\nпростой пример, где главный поток, берет три разрешения, на использование ресурса:\n");

        Semaphore semaphore01 = new Semaphore(3);

        semaphore01.acquire();  // получение разрешения для потока, чтоб взаимодействовать с ресурсом
        semaphore01.acquire();
        semaphore01.acquire();

        System.out.println("All permits have bean acquired");  // все разрешения использованы

//      при попытке получить еще одно разрешение, программа остановится в этом месте, т.к. команда .release()
//        не будет выполнена
//        semaphore01.acquire();
//        System.out.println("Can't reach here...");  // эта строка не будет выполнена

        semaphore01.release();  // освобождаем ресурс

        System.out.println(semaphore01.availablePermits());  // возвращает количество доступных разрешений





        System.out.println("\n\nВторой пример: \n");

        /**     * Создаем определенное количество потоков обращающихся к ресурсу Connection
                * запускаем одновременно в работу согласно цикла 100 потоков
                * в классе Connection добавляем Semaphore на 10 разрешений
                * оборачиваем doWork c Semaphore try и finally для того, что выполнить .release в любом случае


         */

        ExecutorService executorService01 = Executors.newFixedThreadPool(100);

        Connection connection = Connection.getConnection();
        System.out.println("Готовим потоки к работе");

        for (int i = 0; i < 100; i++){
            executorService01.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.semaphoreWork();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });

        }

        executorService01.shutdown();
        executorService01.awaitTermination(1, TimeUnit.HOURS);

        System.out.println("Вся работа выполнена");
        System.out.println("В работе - " + connection.getConnectionCount());

    }



    }

//   данный патер класса называется  - Singletone

    class Connection {
        private static Connection connection = new Connection();
        private int connectionCount;
        private Semaphore semaphore = new Semaphore(10);

        private Connection(){           // запрещаем из вне (другим пользователям) создавать объекты данного класса

        }

        public static Connection getConnection(){
            return connection;

        }

        public int getConnectionCount() {
            return connectionCount;
        }

        public void semaphoreWork() throws InterruptedException {

            semaphore.acquire();                    // добавляем "try finally" для того
            try {                                   // чтоб в любом случае выполнить semaphore.release();
                doWork();                           // даже в случае ошибок, вернуть разрешение
            } finally {
                semaphore.release();
            }
        }


        private void doWork() throws InterruptedException {
            synchronized (this){
                connectionCount++;
//                Thread.sleep(3000);
                System.out.println("Количество потоков готовых к работе - " + connectionCount);

            }


            Thread.sleep(5000);
            System.out.println("Идет выполнение работы...");

            synchronized (this){
                System.out.println("Количество потоков еще не выполнивших работу - " + connectionCount);
                connectionCount--;
            }

        }




    }

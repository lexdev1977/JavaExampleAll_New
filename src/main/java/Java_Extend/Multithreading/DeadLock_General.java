package Java_Extend.Multithreading;

public class DeadLock_General {
    /*


                                        DeadLock (Взаимная блокировка)


    Используя синхронизацию для поточной безопасности (thread safety), в случае неверного порядка синхронизации,
    мы можем вызвать взаимную блокировки. Так же, мы используем пулы потоков и семафоры,
    для ограничения потребления ресурсов, при этом ошибка в таком дизайне может привести к взаимной блокировке,
    вследствие недостатка ресурсов.

    Взаимная блокировка – это ситуация в которой, два или более процесса занимая некоторые ресурсы,
    пытаются заполучить некоторые другие ресурсы, занятые другими процессами и ни один из процессов
    не может занять необходимый им ресурс, и соответственно освободить занимаемый.

    Как происходит блокировка:

        - Два потока работают с общими ресурсами.

        - Поток 1 захватывает Ресурс 1 и начинает операции с ним.

        - Поток 2 последовательно захватывает Ресурс 2 и Ресурс 1.

        - Поток 2 не получает доступа к Ресурсу 1 и в ступоре ждёт, когда тот освободится.

        - Поток 1 не завершил работу с Ресурсом 1, но пытается захватить Ресурс 2 и тоже впадает в ступор.

        Пример:                                                                                                    *//**

        public class DeadlockTest {
        public static void main(String[] args) {
        final String res1 = "my sample text";
        final String res2 = "some other text";

        // Пусть поток P1 навесит замок на ресурс res1, а затем на res2
        Thread P1 = new Thread() {
            public void run() {
                synchronized (res1) {
                System.out.println("Поток 1 навесил замок на Ресурс 1");
                try { Thread.sleep(100);} catch (Exception e) {}

                synchronized (res2) {
                System.out.println("Поток 1 навесил замок на Ресурс 2");
                }
              }
            }
        }

        // Поток P2 последовательно пытается запереть доступ к res2 и res1
        Thread P2 = new Thread() {
            public void run() {
            synchronized (res2) {
                System.out.println("Поток 2 навесил замок на Ресурс 2");
                try { Thread.sleep(100);} catch (Exception e) {}
                synchronized (res1) {
                System.out.println("Поток 2 навесил замок на Ресурс 1");
                }
              }
            }
        }

        P1.start();
        P2.start();

         }
        }
                                                                                                                    *//*






     */

}

package Java_Extend.SimpleProject;

import java.util.Random;

public class DeadLock_Thread_Synchronized {
    public static void main(String[] args) throws InterruptedException {

        Runner run01 = new Runner();

        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {
                run01.firstThread();
            }
        });

        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                run01.secondThread();
            }
        });

        Thread thread03 = new Thread(new Runnable() {
            @Override
            public void run() {
                run01.thirdThread();
            }
        });

        Thread thread04 = new Thread(new Runnable() {
            @Override
            public void run() {
                run01.fourthThread();
            }
        });

        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();

        thread01.join();
        thread02.join();
        thread03.join();
        thread04.join();


        run01.finished();

    }


    static class Runner{
        private Account account01 = new Account();
        private Account account02 = new Account();

        public void firstThread(){
            Random rnd = new Random();
            synchronized (account01) {
                synchronized (account02) {
                    for (int i = 0; i < 100000; i++) {
                        Account.transfer(account01, account02, 100);
                    }
                }
            }
        }

        public void secondThread(){
            Random rnd = new Random();
            synchronized (account01) {
                synchronized (account02) {
                    for (int i = 0; i < 80000; i++) {
                        Account.transfer(account02, account01, 100);
                    }
                }
            }
        }

        public void thirdThread(){
            synchronized (account02) {
                for (int i = 0; i < 100000; i++) {
                    account02.setBallance();
                }
            }
        }

        public void fourthThread(){
            synchronized (account01) {
                for (int i = 0; i < 100000; i++) {
                    account01.setBallance();
                }
            }
        }

        public void finished(){
            System.out.println(account01.getBalance());
            System.out.println(account02.getBalance());
            System.out.println("Total balance: " + (account01.getBalance()+account02.getBalance()));
        }


    }


    static class Account{
        private int ballance = 10000000;

        public void deposite(int amount){
            ballance += amount;
        }

        public void withdraw(int amount){
            ballance -= amount;
        }

        public int getBalance(){
            return ballance;
        }

        public void setBallance() {
            this.ballance = ballance + 100;
        }

        public static void transfer(Account acc1, Account acc2, int amount){
            acc1.withdraw(amount);
            acc2.deposite(amount);

        }

    }

}

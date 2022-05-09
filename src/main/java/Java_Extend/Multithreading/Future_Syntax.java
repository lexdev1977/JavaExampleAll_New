package Java_Extend.Multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Future_Syntax {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Callable callable = () -> "Something work";

        FutureTask<String> future01 = new FutureTask<>(callable);

        new Thread(future01).start();

        System.out.println(future01.get());



    }

}

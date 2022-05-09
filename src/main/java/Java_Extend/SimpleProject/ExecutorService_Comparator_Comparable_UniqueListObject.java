package Java_Extend.SimpleProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorService_Comparator_Comparable_UniqueListObject {
    public static void main(String[] args) throws InterruptedException {


/**        Задача кода:
        - Создать 10 потоков через пул потоков
        - Создать 20 объектов класса Work посредством 10 потоков с разными значениями полей Index (цикл от 1 до 20)
        - Записать объекты Work в ArrayList
        - Вывести на консоль полученный ArrayList переназначив toString()
        - Отсортировать по возрастанию значений полей Index

                                                                                                                      */
        ExecutorService executorService = Executors.newFixedThreadPool(10);


        List<Work> listObjectWork = new ArrayList<>();
        for (int i = 1; i <= 20; i++){

            int a = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    listObjectWork.add(new Work(a));

                }
            });

        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);

        System.out.println(listObjectWork);

/*          Вариант сортировки через анонимный класс и Comparator

            Collections.sort(listObjectWork, new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                return o1.getIndex() - o2.getIndex();
            }
        });                                                                                                        */

//         Вариант сортировки через Comparable
        Collections.sort(listObjectWork);

        System.out.println(listObjectWork);

    }


//      Класс  Work с имплиментированным Comparable и переназначенным toString()

    static class Work implements Comparable<Work>{
        private int index;

        public Work(int index) {
            this.index = index;

        }

        @Override
        public String toString() {
            return String.valueOf(index);    // преобразует значение Int в значение String
        }

        @Override
        public int compareTo(Work o) {
            return this.index - o.index;
        }
    }

}



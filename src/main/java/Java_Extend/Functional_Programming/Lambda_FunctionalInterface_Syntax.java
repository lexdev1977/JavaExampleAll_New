package Java_Extend.Functional_Programming;

import java.util.*;
import java.util.function.*;

public class Lambda_FunctionalInterface_Syntax {
    /*

    В JDK 8 вместе с самой функциональностью лямбда-выражений
    также было добавлено некоторое количество встроенных функциональных интерфейсов,
    которые мы можем использовать в различных ситуациях и в различные API в рамках JDK 8.
    В частности, ряд далее рассматриваемых интерфейсов широко применяется в Stream API
    - новом прикладном интерфейсе для работы с данными. Рассмотрим основные из этих интерфейсов:

    Predicate<T>

    Consumer<T>

    Function<T,R>

    Supplier<T>

    UnaryOperator<T>

    BinaryOperator<T>


                                                                                                                    */

// Примеры встроенных функциональных интерфейсов на примере класса Integer и собственного класса AnyClass

    public static void main(String[] args) {

//      создадим объект класса AnyClass, с полем index и передадим в конструктор некоторое значение

        AnyClass anyObject = new AnyClass(5);



                                                                                                                     /**
                                            *** Predicate <T>

        Функциональный интерфейс Predicate<T> проверяет соблюдение некоторого условия.
        Если оно соблюдается, то возвращается значение true.
        В качестве параметра лямбда-выражение принимает объект типа T:

        public interface Predicate<T> {
        boolean test(T t);
        }

                                                                                                                      */
        Predicate<Integer> isPositive = x -> x > 0;                                    // лямбда
        Predicate<AnyClass> testPredicate = a -> a.index > 0;                          // лямбда

        System.out.println("Predicate<Integer> - сравнение: " +    isPositive.test(5)      ); // true
        System.out.println("Predicate<Integer> - сравнение: " +    isPositive.test(-7)     ); // false

        System.out.println("Predicate<AnyClass> - сравнение: " +   testPredicate.test(anyObject)    ); // true



                                                                                                                     /**
                                          *** BinaryOperator<T>

        (разновидность Function, в которых входные и выходные обобщенные параметры должны совпадать)

        BinaryOperator<T> принимает в качестве параметра два объекта типа T,
        выполняет над ними бинарную операцию и возвращает ее результат также в виде объекта типа T:

        public interface BinaryOperator<T> {
            T apply(T t1, T t2);
        }
                                                                                                                      */

        BinaryOperator<Integer> multiply = (x, y) -> x*y;

        System.out.println("BinaryOperator<Integer> - бинарная операция: " + multiply.apply(3, 5)); // 15
        System.out.println("BinaryOperator<Integer> - бинарная операция: " + multiply.apply(10, -2)); // -20




                                                                                                                     /**
                                           *** UnaryOperator<T>

        UnaryOperator<T> принимает в качестве параметра объект типа T,
        выполняет над ними операции и возвращает результат операций в виде объекта типа T:

        public interface UnaryOperator<T> {
            T apply(T t);                                                                                             */

        UnaryOperator<Integer> square = x -> x*x;

        System.out.println(square.apply(5)); // 25




                                                                                                                     /**
                                            *** Function<T,R>
                                                                                                                      *
        Функциональный интерфейс Function<T,R> представляет функцию перехода от объекта типа T к объекту типа R:

        public interface Function<T, R> {
            R apply(T t);
        }                                                                                                             */

        Function<Integer, String> convert = x-> String.valueOf(x) + " долларов";
        System.out.println(convert.apply(5)); // 5 долларов



                                                                                                                     /**
                                           *** Consumer<T>
                                                                                                                      *
        Consumer<T> выполняет некоторое действие над объектом типа T, при этом ничего не возвращая:

        public interface Consumer<T> {
            void accept(T t);
        }                                                                                                             */

        Consumer<Integer> printer = x-> System.out.printf("%d долларов \n", x);
        printer.accept(600); // 600 долларов


                                                                                                                     /**
                                        *** Supplier<T>
                                                                                                                      *
        Supplier<T> не принимает никаких аргументов, но должен возвращать объект типа T:


        public interface Supplier<T> {
            T get();

        }                                                                                                             */

        Supplier<User> userFactory = ()->{

            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name = in.nextLine();
            return new User(name);
        };

        User user1 = userFactory.get();
        User user2 = userFactory.get();

        System.out.println("Имя user1: " + user1.getName());
        System.out.println("Имя user2: " + user2.getName());
                                                                                                                      /*
        Консольный вывод:

        Введите имя:
        Том
        Введите имя:
        Сэм
        Имя user1: Том
        Имя user2: Сэм                                                                                                */


    }


    static class User{

        private String name;
        String getName(){
            return name;
        }

        User(String n){
            this.name=n;
        }
    }


    static class AnyClass{
        private int index;

        public AnyClass(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }


    }

}





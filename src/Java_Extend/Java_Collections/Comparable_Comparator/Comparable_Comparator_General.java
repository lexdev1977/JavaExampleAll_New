package Java_Extend.Java_Collections.Comparable_Comparator;

public class Comparable_Comparator_General {


    /*

    Интерфейс Java Comparator используется для упорядочивания объектов внутри определенного пользователем класса.
    Этот интерфейс доступен в пакете java.util и включает в себя два важных метода,
    известных как сравнение (Object obj1, Object obj2) и equals (Элемент Object).

    Методы интерфейса Java Comparator
    Есть два метода компараторов в Java, а именно:

        Методы	                                Описание
        compare(Object obj1,Object obj 2)   	Сравнивает первый объект с другим
        equals(Object obj)	                    Сравнивает текущий объект с заданным объектом obj


    Интерфейс Comparable - для того, что была возможность сравнивать и сортировать объекты одного класса между собой.

    С английского языка это переводится как «сравнимый».
    Чтобы наши объекты можно было сравнивать друг с другом и как-то сортировать,
    класс должен имплементировать этот интерфейс и реализовать его единственный метод — compareTo():


                                ***Сравнение Comparator и Comparable

                        Comparator	                                             Comparable
    Компаратор используется для сортировки атрибутов        Интерфейс используется для сортировки объектов
    различных объектов.	                                    с естественным упорядочением.

    Интерфейс компаратора сравнивает два различных          Сравнивает this ссылку с указанным объектом
    предоставленных объекта класса.

    Компаратор присутствует в java.пакет util.	            Находится в java.lang package.

    Компаратор не влияет на исходный класс	                Влияет на исходный класс, т. е.
                                                            фактический класс модифицируется.

    Компаратор предоставляет метод compare(),               Предоставляет метод compareTo() для сортировки элементов.
    equals() для сортировки элементов.




       public class Car implements Comparable<Car> {

       private int manufactureYear;
       private String model;
       private int maxSpeed;

       public Car(int manufactureYear, String model, int maxSpeed) {
           this.manufactureYear = manufactureYear;
           this.model = model;
           this.maxSpeed = maxSpeed;
       }

       @Override
       public int compareTo(Car o) {
           return 0;
       }

       //...геттеры, сеттеры, toString()


       Обрати внимание: мы указали интерфейс Comparable<Car>, а не просто Comparable.
       Это типизированный интерфейс, то есть, требует указания конкретного класса, с которым он связан.

       В принципе, <Car> можно из интерфейса и убрать, но тогда он по умолчанию сравнивает объекты Object.
       Вместо метода compareTo(Car o) у нас в классе будет:

        @Override
           public int compareTo(Object o) {
               return 0;
           }

    Нам, конечно, гораздо проще работать с Car.

    Внутри метода compareTo() мы реализуем логику сравнения машин.
    Допустим, нам нужно отсортировать их по году выпуска.

    Наверное, ты обратил внимание, что метод compareTo() возвращает значение int, а не boolean.

    Пусть тебя это не удивляет. Дело в том, что сравнение двух объектов дает нам 3 возможных варианта:
        а < b
        a > b
        a == b.


    У boolean же есть всего 2 значения — true и false, что неудобно для сравнения объектов.

    С int все намного проще. Если возвращаемое значение > 0, значит a > b.
    Если результат compareTo < 0, значит а < b.
    Ну а если результат == 0, значит два объекта равны: a == b.

    Научить наш класс сортировать машины по году выпуска — проще простого:

            @Override
        public int compareTo(Car o) {
           return this.getManufactureYear() - o.getManufactureYear();
            }

           Что здесь происходит?

    Мы берем один объект машины (this), год выпуска этой машины и вычитаем из него год выпуска другой машины (той, с которой сравниваем объект).
    Если год выпуска первой машины больше, метод вернет int > 0.
    А значит, машина this > машины о.

    Если наоборот — год выпуска второй машины (о) больше, значит метод вернет отрицательное число,
    а следовательно, о > this.

    Ну а если они равны, метод вернет 0.

    Такого простого механизма уже достаточно, чтобы сортировать коллекции объектов Car! Больше ничего делать не нужно.

    Вот, пожалуйста:

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.List;

        public class Main {

           public static void main(String[] args) {

               List<Car> cars = new ArrayList<>();

               Car ferrari = new Car(1990, "Ferrari 360 Spider", 310);
               Car lambo = new Car(2012, "Lamborghini Gallardo", 290);
               Car bugatti = new Car(2010, "Bugatti Veyron", 350);

               cars.add(ferrari);
               cars.add(bugatti);
               cars.add(lambo);

               //тут раньше была ошибка
               Collections.sort(cars);
               System.out.println(cars);
           }
        }

    Вывод в консоль:

        [Car{manufactureYear=1990, model='Ferrari 360 Spider', maxSpeed=310},
        Car{manufactureYear=2010, model='Bugatti Veyron', maxSpeed=350},
        Car{manufactureYear=2012, model='Lamborghini Gallardo', maxSpeed=290}]


        В каких случаях надо использовать Comparable?

    Реализованный в Comparable метод сравнения называют «natural ordering» — естественной сортировкой.
    Это потому, что в методе compareTo() ты описываешь наиболее распространенный способ сравнения,
    который будет использоваться для объектов этого класса в твоей программе.

    Natural Ordering уже присутствует в Java. Например, Java знает,
    что строки чаще всего сортируют по алфавиту, а числа — по возрастанию их значения.
    Поэтому если вызвать на списке чисел или строк метод sort(), так они и будут отсортированы.


    Если в нашей программе машины в большинстве случаев будут сравниваться и сортироваться по году выпуска,
    значит, стоит определить для них натуральную сортировку с помощью интерфейса Comparable<Car> и метода compareTo().

    Но что, если нам этого недостаточно?

    Давай представим, что наша программа не так проста.

    В большинстве случаев натуральная сортировка машин (мы установили ее по году выпуска) нас устраивает.

    Но иногда среди наших клиентов попадаются любители быстрой езды.
    Если мы готовим для них каталог автомобилей на выбор, их нужно упорядочить по максимальной скорости.

    К примеру, такая сортировка нам нужна в 15% случаев.
    Этого явно недостаточно, чтобы установить натуральную сортировку для Car по скорости вместо года выпуска.

    Но и игнорировать 15% клиентов мы не можем. Что же нам делать?

    Здесь нам приходит на помощь другой интерфейс — Comparator. Так же, как и Comparable, он типизированный.

    А в чем же разница?

    Comparable делает наши объекты «сравнимыми» и создает для них наиболее естественный порядок сортировки,
    который будет использоваться в большинстве случаев.

    Comparator — это отдельный класс-«сравниватель» (перевод немного корявый, но зато понятный).

    Если нам нужно реализовать какую-то специфическую сортировку,
    нам необязательно лезть в класс Car и менять логику compareTo().

    Вместо этого мы можем создать отдельный класс-comparator
    в нашей программе и научить его делать нужную нам сортировку!


            import java.util.Comparator;

        public class MaxSpeedCarComparator implements Comparator<Car> {

           @Override
           public int compare(Car o1, Car o2) {
               return o1.getMaxSpeed() - o2.getMaxSpeed();
           }
        }

        Как видишь, наш Comparator довольно прост.

    Всего один метод compare() — это метод интерфейса Comparator, который обязательно нужно реализовать.
    Он принимает на вход два объекта Car и привычным нам образом (вычитанием)
    сравнивает их максимальную скорость. Как и compareTo(), он возвращает число int, принцип сравнения тот же.


    Как же нам пользоваться этим?

    Очень просто:

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Comparator;
        import java.util.List;

        public class Main {

           public static void main(String[] args) {

               List<Car> cars = new ArrayList<>();

              Car ferrari = new Car(1990, "Ferrari 360 Spider", 310);
               Car lambo = new Car(2012, "Lamborghini Gallardo", 290);
              Car bugatti = new Car(2010, "Bugatti Veyron", 350);

               cars.add(ferrari);
               cars.add(bugatti);
               cars.add(lambo);

               Comparator speedComparator = new MaxSpeedCarComparator();
               Collections.sort(cars, speedComparator);

               System.out.println(cars);
           }
        }

        Вывод в консоль:

        [Car{manufactureYear=2012, model='Lamborghini Gallardo', maxSpeed=290},
        Car{manufactureYear=1990, model='Ferrari 360 Spider', maxSpeed=310},
        Car{manufactureYear=2010, model='Bugatti Veyron', maxSpeed=350}]

    Мы просто создаем объект-компаратор и передаем его в метод Collections.sort()
    вместе со списком,который надо отсортировать.

    Получив на вход компаратор, метод sort() не будет использовать естественную сортировку,
    определенную в методе compareTo() класса Car.
    Вместо этого он применит алгоритм сортировки из переданного ему компаратора.

    Какие плюсы нам это дает?

    Во-первых, совместимость с написанным кодом. Мы создали новый, специфический метод сортировки,
    и при этом сохранили действующий, который будет использоваться в большинстве случаев.

    Мы вообще не трогали класс Car.
    Он как был Comparable, так и остался:

        public class Car implements Comparable<Car> {

           private int manufactureYear;
           private String model;
           private int maxSpeed;

           public Car(int manufactureYear, String model, int maxSpeed) {
               this.manufactureYear = manufactureYear;
               this.model = model;
               this.maxSpeed = maxSpeed;
           }

           @Override
           public int compareTo(Car o) {
               return this.getManufactureYear() - o.getManufactureYear();
           }

           //...геттеры, сеттеры, toString()

        }

    Во-вторых, гибкость. Мы можем добавлять сколько угодно сортировок.


















     */


}

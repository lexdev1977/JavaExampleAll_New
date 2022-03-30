package Java_Extend.Java_Collections.Collections;

public class Collections_General {
    /*

                         ***Вспомогательный класс Collections***

    Разработчики Java для удобства работы с массивами написали целый класс-помощник — Arrays.

    Для коллекций они сделали то же самое. В Java есть класс java.util.Collections,
    у которого очень много методов, полезных при работе с коллекциями.

    Ниже приведем только самые интересные из них:

    addAll(colls, e1, e2, e3, ..)       Добавляет в коллекцию colls элементы e1, e2, e3,...
    fill(list, obj)                     Заменяет в переданном списке все элементы на obj
    nCopies(n, obj)                     Возвращает список, состоящий из n копий объекта obj
    replaceAll(list, oldVal, newVal)    Заменяет в списке list все значения oldVal на newVal
    copy(dest, src)                     Копирует все элементы из списка src в список dest
    reverse(list)                       Разворачивает список задом наперед
    sort(list)                          Сортирует список в порядке возрастания
    rotate(list, n)                     Циклично сдвигает элементы списка list на n элементов
    shuffle(list)                       Случайно перемешивает элементы списка
    min(colls)                          Находит минимальный элемент коллекции colls
    max(colls)                          Находит максимальный элемент коллекции colls
    frequency(colls, obj)               Определяет, сколько раз элемент obj встречается в коллекции colls
    binarySearch(list, key)             Ищет элемент key в отсортированном списке, возвращает индекс.
    disjoint(colls1, colls2)            Возвращает true, если у коллекций нет общих элементов


    Важно!!!
    Многие из этих методов работают не с классами ArrayList, HashSet и HashMap,
    а с их интерфейсами: Collection<T>, List<T>, Map<K, V>.

    Это не проблема: если метод принимает List<T>, в него всегда можно передать ArrayList<Integer>,
    но вот в обратную сторону присваивание не работает.


                            *Создание и изменение коллекций

    *Метод Collections.addAll(Collection<T> colls, T e1, T e2, T e3, ...)

    Метод addAll() добавляет в коллекцию colls элементы e1, e2, e3, ...
    Количество переданных элементов может быть любым.
        +Метод Collections.addAll принимает на входе объект Collection и массив.
    Вместо массива также можно указать элементы через запятую.

    Код:
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1, 2, 3, 4, 5);

        for (int i: list)
        System.out.println(i);

   Вывод на экран:
        1
        2
        3
        4
        5


                        *Метод Collections.fill(List<T> list, T obj)

    Метод fill() заменяет все элементы коллекции list на элемент obj.

    Код:
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        Collections.fill(list, 10);

        for (int i: list)
        System.out.println(i);

    Вывод на экран:
        10
        10
        10


                            *Метод Collections.nCopies (int n, T obj)

    Метод nCopies() возвращает список из n копий элементов obj.
    Список можно назвать фиктивным (реального массива внутри нет),
    поэтому изменять его нельзя! Можно использовать только для чтения.

    Код
        List<String> fake = Collections.nCopies(5, "Привет");
    Создаем неизменяемый список из 5 элементов Привет

        ArrayList<String> list = new ArrayList<String>(fake);
    Создаем реальный список list, заполняем его значениями из списка fake.

        for(String s: list)
        System.out.println(s);



    Выводим на экран:
        Привет
        Привет
        Привет
        Привет
        Привет


                *Метод Collections.replaceAll (List<T> list, T oldValue, T newValue)

    Метод replaceAll() заменяет все элементы коллекции list, равные oldValue, на элемент newValue.

    Код:
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);

        Collections.replaceAll(list, 2, 20);

        for (int i: list)
        System.out.println(i);

    Вывод на экран:
        1
        20
        3
        20


                        *Метод Collections.copy (List<T> dest, List<T> src)

    Метод copy() копирует все элементы коллекции src в коллекцию dest.

    Если изначально коллекция dest длиннее чем коллекция src,
    то оставшиеся элементы в коллекции dest останутся нетронутыми.

    Важно:
    Коллекция dest должна иметь длину не меньше, чем длина коллекции src
    (иначе кинется исключение IndexOutOfBoundsException).

    Код:
        ArrayList<Integer> srcList = new ArrayList<Integer>();
        Collections.addAll(srcList, 99, 98, 97);

        ArrayList<Integer> destList = new ArrayList<Integer>();
        Collections.addAll(destList, 1, 2, 3, 4, 5, 6, 7);

        Collections.copy(destList, srcList);

        for (int i: destList)
        System.out.println(i);

    Вывод на экран:
        99
        98
        97
        4
        5
        6
        7



                             *Порядок элементов

                    *Метод Collections.reverse(List<T> list)

    Метод reverse() меняет порядок переданных в него элементов списка на обратный.

    Код:
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1, 2, 3, 4, 5);

        Collections.reverse(list);

        for (int i: list)
        System.out.println(i);

    Вывод на экран:
        5
        4
        3
        2
        1


                        *Метод Collections.sort(List<T> list)

    Метод sort() сортирует переданный в него список по возрастанию.

    Код:
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 11, 2, 23, 4, 15);

        Collections.sort(list);

        for (int i: list)
        System.out.println(i);

    Вывод на экран:
        2
        4
        11
        15
        23

                    *Метод Collections.rotate(List<T> list, int distance)

    Метод rotate() циклическим образом сдвигает переданные в него элементы на distance позиций вперед.

    Код:
    ArrayList<Integer> list = new ArrayList<Integer>();
    Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    Collections.rotate(list, 3); // сдвинуть на 3 позиции

    for (int i: list)
        System.out.println(i);

    Вывод на экран:
        7
        8
        9
        1
        2
        3
        4
        5
        6


                            *Метод Collections.shuffle(List<T> list)

    Метод shuffle() случайным образом перемешивает все элементы переданного списка. Результат каждый раз разный.

    Код:
    ArrayList<Integer> list = new ArrayList<Integer>();
    Collections.addAll(list, 1, 2, 3, 4, 5);

    Collections.shuffle(list); // перемешиваем

    for (int i: list)
    System.out.println(i);

    Вывод на экран:
        5
        2
        4
        3
        1



                                    *Поиск элементов в коллекциях

                            *Метод Collections.min(Collection<T> colls)

    Метод min() возвращает минимальный элемент коллекции.

    Код:
    ArrayList<Integer> list = new ArrayList<Integer>();
    Collections.addAll(list, 11, 2, 23, 4, 15);

    int min = Collections.min(list);

    System.out.println(min);

    Вывод на экран:
        2


                        *Метод Collections.max(Collection<T> colls)

    Метод max() возвращает максимальный элемент коллекции.

    Код:
    ArrayList<Integer> list = new ArrayList<Integer>();
    Collections.addAll(list, 11, 2, 23, 4, 15);

    int max = Collections.max(list);

    System.out.println(max);

    Вывод на экран:
        23


                    *Метод Collections.frequency(Collection<T> colls, T obj)

    Метод frequency() подсчитывает, сколько раз в коллекции colls встречается элемент obj

    Код:
    ArrayList<Integer> list = new ArrayList<Integer>();
    Collections.addAll(list, 11, 2, 23, 4, 15, 4, 2, 4);

    int count = Collections.frequency(list, 4);

    System.out.println(count);

    Вывод на экран:
        3


                    *Метод Collections.binarySearch(Collection<T> colls, T obj)

    Метод binarySearch() ищет элемент obj в коллекции colls. Возвращает номер найденного элемента. Если элемент не найден, возвращает отрицательное число.

    Важно:
    Перед вызовом метода binarySearch() коллекцию нужно отсортировать (Collections.sort()).
    Код:
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 11, 2, 23, 5, 15, 4, 2, 4);

        Collections.sort(list);  // 2, 2, 4, 4, 5, 11, 15, 23

        int index = Collections.binarySearch(list, 5);    // 4
        System.out.println(index);

        int index2 = Collections.binarySearch(list, 15);  // 6
        System.out.println(index2);

        int index3 = Collections.binarySearch(list, 16);  // нет
        System.out.println(index3);

    Вывод на экран:
        4
        6
       -8

                    *Метод Collections.disjoint(Collection<T> coll1, Collection<T> coll2)

    Метод disjoint() возвращает true, если у переданных коллекций нет одинаковых элементов.

    Код:
    ArrayList<Integer> list = new ArrayList<Integer>();
    Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7);

    ArrayList<Integer> list2 = new ArrayList<Integer>();
    Collections.addAll(list2, 99, 98, 97);

    boolean isDifferent = Collections.disjoint(list, list2);
    System.out.println(isDifferent);

    Вывод на экран:
    true


     */



}

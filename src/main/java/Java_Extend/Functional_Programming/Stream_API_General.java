package Java_Extend.Functional_Programming;

public class Stream_API_General {

    /*
    Stream API — это новый способ работать со структурами данных в функциональном стиле.
    Stream (поток) API (описание способов, которыми одна компьютерная программа
    может взаимодействовать с другой программой) — это по своей сути поток данных.
    Сам термин "поток" довольно размыт в программировании в целом и в Java в частности.

    С появлением Java 8 Stream API позволило программистам писать существенно короче то,
    что раньше занимало много строк кода, а именно — упростить работу с наборами данных,
    в частности, упростить операции фильтрации, сортировки и другие манипуляции с данными.
    Если у вас промежуточных операций нет, часто можно и нужно обойтись без стрима,
    иначе код будет сложнее чем без потока.


    C чего, собственно, начать? С создания экземпляра Stream, который опирается на нужную нам коллекцию,
    массив или метод их и откуда соответственно будут браться данные:
                                                                                                                   *//**
        List<String> list = new ArrayList<String>();
           list.add("One");
           list.add("Two");
           list.add("Three");
           list.add("Four");
           list.add("Five");
           list.add("Six");
           list.add("Seven");
           list.add("Eight");
           list.add("Nine");
           list.add("Ten");
           Stream stream = list.stream();
                                                                                                                    *//*

    Как говорилось выше, Stream API позволяет сократить количество строк кода.

    Пример c потоком:                                                                                              *//**

        IntStream.of(50, 60, 70, 80, 90, 100, 110, 120).filter(x -> x < 90).map(x -> x + 10)
        .limit(3).forEach(System.out::print);

        Пример без потока:

        int[] arr = {50, 60, 70, 80, 90, 100, 110, 120
            int count = 0;
            for (int x : arr) {
                if (x >= 90) continue;
                x += 10;
                count++;
                if (count > 3) break;
                System.out.print(x);
            }
                                                                                                                    *//*

                Возможные способы создания Stream:

                - Пустой стрим: Stream.empty()
                - Стрим из List: list.stream()
                - Стрим из Map: map.entrySet().stream()
                - Стрим из массива: Arrays.stream(array)
                - Стрим из указанных элементов: Stream.of("1", "2", "3")


    Далее, есть такое понятие как операторы (по сути методы класса Stream)

    Операторы можно разделить на две группы:
            - Промежуточные (“intermediate”, ещё называют “lazy”) — обрабатывают поступающие элементы и возвращают стрим.
            Промежуточных операторов в цепочке обработки элементов может быть много.
            - Терминальные (“terminal”, ещё называют “eager”) — обрабатывают элементы и завершают работу стрима,
            так что терминальный оператор в цепочке может быть только один.

            Пример:
                                                                                                                   *//**
        1.List<String> list = new ArrayList<String>();
        2.list.add("One");
        …
        11.list.add("Ten");
        12.Stream stream = list.stream();
        13.stream.filter(x-> x.toString().length() == 3).forEach(System.out::println);
                                                                                                                    *//*

        Что здесь происходит:

        1 — создаём список list;
        2-11 — заполняем его тестовыми данными;
        12 — создаём обьект Stream;
        13 — метод filter (фильтр) — промежуточный оператор, x приравнивается к одному элементу коллекции
        для перебора (как при for each) и после -> мы указываем как фильтруется наша коллекция
        и так как это промежуточный оператор, отфильтрованная коллекция идёт дальше в метод forEach,
        который в свою очередь является терминальным (конечным) аналогом перебора for each
        (Выражение System.out::println сокращенно от: x-> System.out.println(x)),
        которое в свою очередь проходит по всем элементам переданной ему коллекции и выводит её).


        Важные моменты:
        Обработка не начнётся до тех пор, пока не будет вызван терминальный оператор. list.stream().filter(s -> s > 5)
        (не возьмёт ни единого элемента из списка);
        Экземпляр, стрима нельзя использовать более одного раза.

        Поэтому каждый раз новый:
                                                                                                                   *//**
        list.stream().filter(x-> x.toString().length() == 3).forEach(System.out::println);
        list.stream().forEach(x -> System.out.println(x));
                                                                                                                    *//*
        промежуточных операторов вызванных на одном стриме может быть множество,
        в то время терминальный оператор только один:
                                                                                                                   *//**
        stream.filter(x-> x.toString().length() == 3).map(x -> x + "
        - the length of the letters is three").forEach(x -> System.out.println(x));
                                                                                                                    *//*
                         Далее давайте рассмотрим некоторые промежуточные операторы:

        - filter(Predicate predicate) фильтрует стрим, пропуская только те элементы, что проходят по условию
        (Predicate встроенный функциональный интерфейс, добавленный в Java SE 8 в пакет java.util.function.
        Проверяет значение на “true” и “false”);

        - map(Function mapper) даёт возможность создать функию с помощью которой мы будем изменять каждый элемент
        и пропускать его дальше (Функциональный интерфейс Function<T,R>
        представляет функцию перехода от объекта типа T к объекту типа R)

        - flatMap(Function<T, Stream<R>> mapper) — как и в случае с map, служат для преобразования в примитивный стрим.
        При работе например с массивом стримов (массивов, списков и так далее)
        преобразует их в один стрим (массив,список и так далее

        [stream1,stream2,stream3,stream4] => stream:

                                                                                                                   *//**
        String[] array = {"Java", "Ruuuuussshhh"};
        Stream<String> streamOfArray = Arrays.stream(array);
        streamOfArray.map(s->s.split("")) //Преобразование слова в массив букв
                .flatMap(Arrays::stream).distinct() //выравнивает каждый сгенерированный поток в один поток
                .collect(Collectors.toList()).forEach(System.out::println);
                                                                                                                    *//*
        В то время когда map преобразует в список потоков (точнее <Stream> потоков)
        [stream1,stream2,stream3,stream4] =>Stream.of(stream1,stream2,stream3,stream4):
                                                                                                                   *//**
        String[] array = {"Java", "Ruuuuussshhh"};
        Stream<String> streamOfArray = Arrays.stream(array);
        streamOfArray.map(s->s.split("")) //Преобразование слова в массив букв
                .map(Arrays::stream).distinct() //Сделать массив в отдельный поток
                .collect(Collectors.toList()).forEach(System.out::println);
                                                                                                                    *//*

        Ещё одно отличие в сравнении с map, можно преобразовать один элемент в ноль, один или множество других.

        Для того, чтобы один элемент преобразовать в ноль элементов, нужно вернуть null, либо пустой стрим.
        Чтобы преобразовать в один элемент, нужно вернуть стрим из одного элемента, например, через Stream.of(x).
        Для возвращения нескольких элементов, можно любыми способами создать стрим с этими элементами.

        Тот же метод flatMap, но для Double, Integer и Long:
        flatMapToDouble(Function mapper)
        flatMapToInt(Function mapper)
        flatMapToLong(Function mapper)

        И ещё пример для сравнения, flatMap:

                                                                                                                   *//**
        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x))
                .forEach(System.out::print);// 010120012
                                                                                                                    *//*
        IntStream.range(0,x) – выдаёт на поток элементов с 0 (включительно) по x (не включительно);

        map:                                                                                                       *//**
        Stream.of(2, 3, 0, 1, 3)
                .map(x -> IntStream.range(0, x))
                .forEach(System.out::print);//перечень стримов(потоков);
                                                                                                                    *//*

        limit(long maxSize) – ограничивает стрим по количеству элементов:                                          *//**
        stream.limit(5).forEach(x -> System.out.println(x));


        skip(long n) – пропускаем n элементов:                                                                     *//**
        stream.skip(3).forEach(x -> System.out.println(x));
                                                                                                                    *//*

        sorted()
        sorted(Comparator comparator) – сортирует стрим (сортировка как у TreeMap):                                *//**
        stream.sorted().forEach(x -> System.out.println(x));
                                                                                                                    *//*

        distinct() — проверяет стрим на уникальность элементов(убирает повторы элементов);

        dropWhile(Predicate predicate) — пропускает элементы которые удовлетворяют условию
        (появился в 9 java, Функциональный интерфейс Predicate<T> проверяет соблюдение некоторого условия.
        Если оно соблюдается, то возвращается значение true.
        В качестве параметра лямбда-выражение принимает объект типа T:
                                                                                                                   *//**
        Predicate<Integer> isPositive = x -> x > 0;
               System.out.println(isPositive.test(3)); // true
               System.out.println(isPositive.test(-9)); // false
                                                                                                                    *//*

                                        Терминальные операторы:


        forEach(Consumer action) – аналог for each (Consumer<T> выполняет некоторое действие над объектом типа T,
        при этом ничего не возвращая);

        count() – возвращает количество элементов стрима:

        System.out.println(stream.count());

        collect(Collector collector) – метод собирает все элементы в список, множество или другую коллекцию,
        сгруппировывает элементы по какому-нибудь критерию, объединяет всё в строку и т.д.:
                                                                                                                   *//**
        List<String> list = Stream.of(“One”, “Two”, “Three”).collect(Collectors.toList());
                                                                                                                    *//*

        collect(Supplier supplier, BiConsumer accumulator, BiConsumer combiner) — тот же, что и collect(collector),
        только параметры разбиты для удобства (supplier поставляет новые объекты (контейнеры), например new ArrayList(),
        accumulator добавляет элемент в контейнер, combiner объединяет части стрима воедино);

        reduce(T identity, BinaryOperator accumulator) — преобразовывает все элементы стрима в один объект
        (посчитать сумму всех элементов, либо найти минимальный элемент), cперва берётся объект identity
        и первый элемент стрима, применяется функция accumulator и identity становится её результатом.
        Затем всё продолжается для остальных элементов.
                                                                                                                   *//**
        int sum = Stream.of(1, 2, 3, 4, 5).reduce(10, (acc, x) -> acc + x);// = 25
                                                                                                                    *//*

        reduce(BinaryOperator accumulator) — такой же метод как и выше но отсутсвует начальный identity,
        им служит первый элемент стрима

        Optional min(Comparator comparator)
        Optional max(Comparator comparator) ищет минимальный/максимальный элемент,
        основываясь на переданном компараторе;

        findFirst() – вытаскивает первый элемент стрима:                                                           *//**
        Stream.of(1, 2, 3, 4, 9).findFirst();                                                                       *//*

        allMatch(Predicate predicate) — возвращает true, если все элементы стрима удовлетворяют условию.
        Если встречается какой-либо элемент, для которого результат вызова функции-предиката будет false,
        то оператор перестаёт просматривать элементы и возвращает false:                                           *//**
        Stream.of(1, 2, 3, 4, 9).allMatch(x -> x <= 7);//false                                                      *//*

        anyMatch(Predicate predicate) — вернет true,
        если хотя бы один элемент стрима удовлетворяет условию predicate:                                          *//**
        Stream.of(1, 2, 3, 4, 9).anyMatch(x -> x >= 7);//true                                                       *//*

        noneMatch(Predicate predicate) — вернёт true, если, пройдя все элементы стрима,
        ни один не удовлетворил условию predicate:                                                                 *//**
        Stream.of(1, 2, 3, 4, 9).noneMatch(x -> x >= 7);//false                                                     *//*


        И хотелось бы напоследок просмотреть некоторые методы Collectors:
        toList() — собирает элементы в List:                                                                       *//**
        List<Integer> list = Stream.of(99, 2, 3).collect(Collectors.toList());                                      *//*

        toSet() — cобирает элементы в множество:                                                                   *//**
        Set<Integer> set = Stream.of(99, 2, 3).collect(Collectors.toSet());                                         *//*

        counting() — Подсчитывает количество элементов:                                                            *//**
        Long count = Stream.of("1", "2", "3", "4").collect(Collectors.counting());                                  *//*

        joining()
        joining(CharSequence delimiter)
        joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)
         — cобирает элементы в одну строку. Дополнительно можно указать разделитель,
         а также префикс и суффикс для всей последовательности:
                                                                                                                   *//**
        String a = Stream.of("s", "u" ,"p", "e", "r").collect(Collectors.joining());
               System.out.println(a); // super

               String b = Stream.of("s", "u", "p", "e", "r").collect(Collectors.joining("-"));
               System.out.println(b); // s-u-p-e-r

               String c = Stream.of("s", "u", "p", "e", "r").collect(Collectors.joining(" -> ", "[ ", " ]"));
               System.out.println(c);  // [ s -> u -> p -> e -> r ]
                                                                                                                    *//*
        summingInt(ToIntFunction mapper)
        summingLong(ToLongFunction mapper)
        summingDouble(ToDoubleFunction mapper) — коллектор,
        который преобразовывает объекты в int/long/double и подсчитывает сумму.









     */
}

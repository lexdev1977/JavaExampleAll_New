package Java_Extend.Collections_Framework.List;

public class List_General {

    /*

                                       Список (list)


    Списки в Java реализуют интерфейс List, который, в свою очередь, расширяет интерфейс Collection.
    Список позволяет хранить любые значения, в том числе повторяющиеся.
    Итерация (обход) списка происходит в порядке добавления элементов.
    Т.е. элемент, добавленный первым, при итерации также будет первым.


        List<String> list = new ArrayList<>();
        list.add("яблоко");
        list.add("ананас");
        list.add("яблоко");
        System.out.println(list); // На экране увидим: [яблоко, ананас, яблоко]


    Две наиболее частые реализации интерфейса List - это ArrayList и LinkedList.

    Класс ArrayList построен на базе массива.
    Это означает, что доступ по индексу (порядковому номеру элемента) происходит очень быстро.
    А добавление элементов в середину списка в общем случае довольно затратно,
    т.к. нужно будет подвинуть вправо каждый элемент, который идёт после добавляемого.
    С удалением такая же штука. Кроме того, массив, лежащий в основе этой структуры данных,
    имеет конечное количество свободных ячеек и если их перестанет хватать,
    придётся создать новый массив большего размера, перенеся в него все элементы из исходного.
    Но всё это скрыто внутри реализации ArrayList.

    Класс LinkedList представляет собой цепочку элементов,
    в которой каждый элемент имеет ссылку на предыдущий элемент и на следующий.
    Также имеется ссылка на начало и на конец списка,
    что позволяет быстро получать доступ к первому и к последнему элементу.
    При этом для доступа по индексу требуется пройтись последовательно по всей цепочке,
    поэтому время доступа по индексу прямо пропорционально размеру списка.
    Однако сам процесс добавления и удаления элементов весьма прост: нужно всего лишь изменить пару ссылок.

    Казалось бы, у каждой реализации списка свои плюсы и минусы,
    однако в последних версиях Java ArrayList был достаточно хорошо оптимизирован
    и на практике можно всё время выбирать его без ущерба для производительности в любых задачах.






     */

}

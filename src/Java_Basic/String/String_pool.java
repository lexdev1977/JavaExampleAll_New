package Java_Basic.String;

public class String_pool {

/*

        String pool (пулом строк) - специальной областью памяти для хранения строк

        Пул строк — область для хранения всех строковых значений, которые создаются в программе.

        Для чего он был создан? Строки занимают огромную часть от всех объектов.
        В любой большой программе создается очень много строк.
        С целью экономии памяти и нужен String Pool — туда помещается строка с нужным тебе текстом,
        и в дальнейшем вновь созданные ссылки ссылаются на одну и ту же область памяти,
        нет нужды каждый раз выделять дополнительную память.

        Каждый раз, когда ты пишешь String  = “........”, программа проверяет,
        есть ли строка с таким текстом в пуле строк.
        Если есть — новая создана не будет.
        И новая ссылка будет указывать на тот же адрес в пуле строк, где эта строка хранится.

        Пример:

            String s1 = "Привет!";
            String s2 = "Привет";

        ссылка s2 указывает ровно туда же, куда и s1.
        Первая команда создала в пуле строк новую строку с нужным нам текстом,
        а когда дело дошло до второй — она просто сослалась на ту же область памяти, что и s1.

        !!! но:

        String s1 = "Привет";
        String s2 = new String("Привет");

        Эти две строки были созданы по-разному.
        Одна — с помощью оператора new, а вторая без него.
        Именно в этом кроется причина.
        Оператор new при создании объекта принудительно выделяет для него новую область в памяти.
        И строка, созданная с помощью new, не попадает в String Pool:
        она становится отдельным объектом, даже если ее текст полностью совпадает с такой же строкой из String Pool’a.

        И каждый раз при создании нового объекта через new в памяти будет выделяться новая область,
        даже если текст внутри новых строк будет одинаковым!





 */


}
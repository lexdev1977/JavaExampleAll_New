package Java_Extend.Collections_Framework.Stack;

import java.util.Stack;

public class Stack_Syntax {
    public static void main(String[] args) {

//    Примеры работы Stack

        Stack<String> textStack = new Stack<>();

//      добавляет элемент на верх стека
        textStack.push("Text 01");
        textStack.push("Text 02");
        textStack.push("Text 03");
        textStack.push("Text 04");
        textStack.push("Text 05");

        System.out.println("\n" + "Создали и добавили элементы в стек: " + textStack + "\n");

//      возвращает значение верхнего элемента стека не удаляя его
        System.out.println("проверим значение верхушки стека: " + textStack.peek());
        System.out.println("еще раз проверим значение верхушки стека: " + textStack.peek() + "\n");

//      добавляет элемент после указанного в индексе
        System.out.println("Добавили еще один элемент после второго элемента стека:");
        textStack.add(2,"Text 02a");

        System.out.println(textStack + "\n");

//      добавляет и возвращает boolean
        System.out.println("добавили еще элемент через add в верхушку и вернули: " + textStack.add("Text 06") + "\n");

        System.out.println(textStack  + "\n");

//      возвращает значение верхнего элемента стека удаляя его
        System.out.println("Вернули и удалили верхнее значение: " + textStack.pop());
        System.out.println("Еще раз вернули и удалили верхнее значение: " +textStack.pop()  + "\n");
        System.out.println();


        System.out.println(textStack);
        System.out.println("Поиск элемента Text 02 в стеке и вывод его номера в очереди от верхушки: " +
                textStack.search("Text 02") + "  Если будет не найден то выдаст: -1");

//      Очистка стека
//          textStack.clear();


        //      пример работы цикла пока в стеке есть элементы

        System.out.println("Пример работы цикла пока еще есть хоть один элемент");

        while (!textStack.isEmpty()){
            System.out.println("из стека ушел: " + textStack.pop());
        }
        System.out.println("\n" + "Сейчас стек пуст: " + textStack.empty());

    }


}

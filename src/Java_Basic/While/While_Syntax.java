package Java_Basic.While;

public class While_Syntax {
    public static void main(String[] args) {

//        Циклы – операторы многократного выполнения действий

//        Цикл с предусловием

        int a = 0;
        while (a < 5) {     // (логическое выражение)
            System.out.println("Тело цикла с предусловием, периодически выполняемые оператор(ы)");
            a++;
        }


        System.out.println();
//        Цикл с постусловием
//        Два основных отличия от предыдущего вида цикла:
//        тело цикла как минимум выполняется один раз и логическое условие проверяется после выполнения тела цикла.

        int b = 0;
        do {
            System.out.println("Тело цикла  с постусловием, периодически выполняемые оператор(ы)" +
                    "несмотря ни на что тело выполнится один раз");
            b++;
        } while (b > 5);


        System.out.println();
//          Continue - прекращает выполнение тела текущего цикла и
//          осуществляет переход к логическому выражению оператора while.
//          Если вычисленное выражение будет истинно – выполнение цикла будет продолжено.

        int[] h = {1, 0, 3, 0, 0, 3, 3, 0, 3, 3};
        int c = 0;
        while (c < 10) {
            if (h[c] != 3) {    // если число в массиве не является тройкой, то не печатая продолжаем цикл
                c++;
                continue;
            }
            System.out.println(h[c]);
            c++;
        }


        System.out.println();
//        Бесконечный цикл и выход из него break

        int f =0;
        while(true) {
            System.out.println(f + " - Идет бесконечный цикл");
            if (f == 10){
                System.out.println(f + " - При f = 10, выходип по команде break");
                break;
            }
            f++;
        }


        System.out.println();
//        Вложенные циклы

        int n = 0;
        while (n < 2) {     // первй цикл
            System.out.println("Внешний цикл запущен - " + n);
            int g =0;
            while (g < 3){  // второй цикл
                System.out.println("Внутренний цикл запущен - " + g);
                g++;
            }
            n++;
        }

    }

}

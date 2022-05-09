package Java_Extend.Other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegEx_Syntax {

    public static void main(String[] args) {

//                                  примеры с методом .matches

        String a = "12345";
        System.out.println(a.matches(""));  // сравнивает строку на которой вызван, со строкой в аргументе

//        в строковых литералах, которые описывают регулярное выражение,
//        и используют символ «\» (например, для метасимволов) его нужно удваивать,
//        чтобы компилятор байт-кода Java не интерпретировал его по-своему.

        a = "12345";
        System.out.println(a.matches("\\d{5}"));  //  \d - одна цифра  \d{количество цифр}
//                                                          \d{2,} - два или более  \{2, 4} - от двух до четырех

        a = "1";
        String b = "";
        System.out.println(a.matches("\\d+"));  //  \d+ + - один или более
        System.out.println(b.matches("\\d*"));  //  \d* * - ноль или более

        a = "-12345";
        b = "12345";
        String c = "+12345";
        System.out.println(a.matches("-\\d+"));
        System.out.println(a.matches("-?\\d+"));        // ? - ноль или один символ до

        System.out.println(c.matches("(-|\\+)?\\d+"));  // (x|y|z) или x или y или z
        System.out.println(b.matches("(-|\\+)?\\d+"));  // \\+ - из метасимвола в литеру
        System.out.println(a.matches("(-|\\+)?\\d+"));  // все три выражения подходят под общий критерий сравнения

        System.out.println("*******************************************************\n");


        a = "g12345";
        System.out.println(a.matches("[a-zA-Z]\\d+"));
        // [abc] - (a|b|c), [0-9] - \\d     [a-ZA-z] - охватывает англ. буквы.

        a = "fwrff111133331fg12345";
        System.out.println(a.matches("[a-zA-Z31]+\\d+"));

        a = "Hello";
        System.out.println(a.matches("[^abc]*"));  // [^asd] - ни один из перечисленных

        String url = "http://www.google.com";
        System.out.println(url.matches("http://www\\..+"));
        // \\. - точка а не спец символ, . - любой символ, .+ - любые символы

        String url2 = "http://www.yandex.ru";

        System.out.println(url.matches("http://www\\..+\\.(com|ru)"));
        System.out.println(url2.matches("http://www\\..+\\.(com|ru)"));

        a = "_";
        System.out.println(a.matches("\\w"));  // \w - буквенно-цифровой символ или знак подчёркивания

        System.out.println("*******************************************************\n");


//                                      примеры с методом .split

        String word01 = "Hello there hey";
        String word02 = "Hello.there.hey";
        String arrayWord[] = word01.split(" ");     // разделяет строку по символу и помещает в массив
        String arrayWord2[] = word02.split("\\.");
        System.out.println(Arrays.toString(arrayWord));
        System.out.println(Arrays.toString(arrayWord2));

        word01 = "Hello1234there6789hey";
        String arrayWord3[] = word01.split("\\d+");     // разделяет строку по символу и помещает в массив
        System.out.println(Arrays.toString(arrayWord3));


//                                      примеры с методом .replace, replaceAll, replaceFirst

        word01 = "Hello there hey";
        String word03 = word01.replace(" ", "-");  // заменяет одни символы на другие
        System.out.println(word03);

        word01 = "Hello1234there1234hey";
        String word04 = word01.replaceAll("\\d+", "--"); // принимает на вход регулярные выражения
        System.out.println(word04);

        word01 = "Hello there hey";
        String word05 = word01.replaceFirst(" ", "--"); // заменяет только первое соответствие
        System.out.println(word05);



















    }




}

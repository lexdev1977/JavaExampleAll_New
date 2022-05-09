package Java_Extend.Other;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx_Pattern_Matches_Syntax {
    public static void main(String[] args) {

        /* пример: в котором, мы создаем определенный Паттерн.
           Затем с помощью объекта Matcher в который мы помещаем наш паттерн
           итерируемся по списку совпадений и помещаем данные в наш лист
         */


        String tex01 = "Этот текст пример для примера работы Pattern и Matches. Задача будет состоят в том, чтоб" +
                "отыскать все емаилы встречающиеся в тексте. Вот первый емаил - alex@google.com. А вот вам" +
                "пожалуйста и второй емаили - lex@yandex.ru. Сейчас у нас в тексте два емаила, давайте их отыщем!";

        Pattern email = Pattern.compile("\\w+@(google|yandex)\\.(com|ru)"); // создаем определенный паттерн

        Matcher matcher = email.matcher(tex01);   // создаем объект для поиска по шаблону Pattern

        List<String> emailList = new ArrayList<>();
        List<String> hostList = new ArrayList<>();
        List<String> zoneList = new ArrayList<>();

        while (matcher.find()){                  // метод find возвращает true если очередное совпадение найдено

            emailList.add(matcher.group());      // добавляем в наши листы через метод .group строки у которых
            hostList.add(matcher.group(1));      // найдены совпадения
            zoneList.add(matcher.group(2));      // в качестве аргумента цифра скобок из паттерна
        }
        System.out.println(emailList);           // [alex@google.com, lex@yandex.ru]
        System.out.println(hostList);            // [google, yandex]
        System.out.println(zoneList);            // [com, ru]














    }





}

package Java_Basic.String;

public class String_Replace_Syntax {
    public static void main(String[] args) {

        /*
        Java string replace

        У объекта типа String есть четыре вариации метода замены — replace:

        - replace(char, char);
        - replace(CharSequence, CharSequence);
        - replaceFirst(String, String);
        - replaceAll(String, String).

         */



        // replace(char, char); заменяем один символ на другой

        String text01 = "Привет;всем;программистам";
        String text02 = text01.replace(';', ' ' );
        System.out.println(text02);


        // replace(harSequence, CharSequence); Заменяет каждую подстроку строки, которая соответствует указанной
        // последовательности символов, на последовательности символов замены.

        String text03 = "Какой то текст, в котором нужно заменить вот это";
        String text04 = text03.replace("вот это", "*******");
        System.out.println(text04);



        //replaceFirst(String, String);
        // заменяет первую подстроку, которая соответствует указанному регулярному выражению, замещающей строкой.
        // заменяет только первую последовательность

        String text05 = "Какой то текст в котором две почты эта mail@google.com и эта mail@yandex.ru";
        String text06 = text05.replaceFirst("\\w+@google\\.(com|ru)", "*******");
        System.out.println(text06);

        //replaceAll(String, String)
        // заменяет все последовательности с использованием регулярных выражений
        String text07 = "Какой то текст в котором две почты эта mail@google.com и эта mail@yandex.ru";
        String text08 = text07.replaceAll("\\w+@(google|yandex)\\.(com|ru)", "*******");
        System.out.println(text08);














    }



}
